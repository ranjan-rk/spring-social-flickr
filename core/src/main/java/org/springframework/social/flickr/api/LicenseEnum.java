package org.springframework.social.flickr.api;

public enum LicenseEnum {
	AllRightsReserved("0"),
	Attribution("4"),
	 AttributionNoDerivs("6"),
	 AttributionNonCommercialNoDerivs("3"),
	 AttributionNonCommercial("2"),
	 AttributionNonCommercialShareAlike("1"),
	 AttributionShareAlike("5"),
	 Noknowncopyrightrestrictions("7"),	 
	 UnitedStatesGovernmentWork("8");
	private String license; 
	LicenseEnum(String license){
		this.license = license ;
	}
	
	
	public String getLicense(){
		return license;
	}
}
