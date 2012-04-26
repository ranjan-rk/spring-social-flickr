package org.springframework.social.flickr.api.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class FlickrObjectMapper extends ObjectMapper{

	protected Object _unwrapAndDeserialize(JsonParser jp, JavaType rootType,
            DeserializationContext ctxt, JsonDeserializer<Object> deser)
        throws IOException, JsonParseException, JsonMappingException
    {
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.setDeserializationConfig(ctxt.getConfig());
	    mapper.disable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);
	    jp.setCodec(mapper);
        JsonNode tree = jp.readValueAsTree();
		JsonNode statNode = tree.get("stat");
		String status  = statNode.getTextValue();
		if(!"ok".equals(status)){
			JsonNode msgNode = tree.get("message");
			String errorMsg = msgNode.getTextValue();
			JsonNode codeNode = tree.get("code");
			String errorCode = codeNode.getTextValue();
			//Based on error Code send diffrent type of exceptions.
			throw new FlickrException(errorMsg);
		}
		
		jp = jp.getCodec().treeAsTokens(tree);
		
		
		
		jp.nextToken();
		
        SerializedString rootName = _deserializerProvider.findExpectedRootName(ctxt.getConfig(), rootType);
        if (jp.getCurrentToken() != JsonToken.START_OBJECT) {
            throw JsonMappingException.from(jp, "Current token not START_OBJECT (needed to unwrap root name '"
                    +rootName+"'), but "+jp.getCurrentToken());
        }
        if (jp.nextToken() != JsonToken.FIELD_NAME) {
            throw JsonMappingException.from(jp, "Current token not FIELD_NAME (to contain expected root name '"
                    +rootName+"'), but "+jp.getCurrentToken());
        }
        String actualName = jp.getCurrentName();
        
        /*Following is done for response object in case of POST method */
        if("stat".equals(actualName)){
        	return null;
        }
        /*This check can removed completely if required 
        if (!rootName.getValue().equalsIgnoreCase(actualName)) {
            throw JsonMappingException.from(jp, "Root name '"+actualName+"' does not match expected ('"+rootName
                    +"') for type "+rootType);
        }*/
        // ok, then move to value itself....
        jp.nextToken();
        
        Object result = deser.deserialize(jp, ctxt);
        // Ignoring stat field and its value.
        jp.nextToken();
        jp.nextToken();
         
        if (jp.nextToken() != JsonToken.END_OBJECT) {
            throw JsonMappingException.from(jp, "Current token not END_OBJECT (to match wrapper object with root name '"
                    +rootName+"'), but "+jp.getCurrentToken());
        }
        return result;
        //return null;
    }
}
