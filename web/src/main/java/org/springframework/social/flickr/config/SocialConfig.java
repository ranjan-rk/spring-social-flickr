package org.springframework.social.flickr.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.flickr.SimpleSignInAdapter;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.connect.FlickrConnectionFactory;

@Configuration

public class SocialConfig {

	
    @Inject
    private DataSource dataSource;

    @Inject
    private Environment environment;
    
    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FlickrConnectionFactory(
            environment.getProperty("clientId"),
            environment.getProperty("clientSecret")));
        return registry;
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        /*
        if (authentication == null) {
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
        }
        */
        ConnectionRepository cr=null;
        try{
        	cr = usersConnectionRepository().createConnectionRepository("hemant");
        }catch(Exception e){
        	System.out.println(e.toString());
        }
        return cr;
    }

    @Bean
    public UsersConnectionRepository usersConnectionRepository() {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), 
        		Encryptors.noOpText());
    }
    
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public Flickr flickr() {
	    return connectionRepository().getPrimaryConnection(Flickr.class).getApi();
	}


	/*@Bean
    public ConnectController connectController() {
		ConnectController controller = new ConnectController(
	            connectionFactoryLocator(), connectionRepository());
        return controller;
    }*/
	
	@Bean
	public ProviderSignInController providerSignInController() {
		ProviderSignInController psc= new ProviderSignInController(connectionFactoryLocator(), usersConnectionRepository(),
				new SimpleSignInAdapter());
		return psc;
	}

}
