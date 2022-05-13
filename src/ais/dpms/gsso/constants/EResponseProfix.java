package ais.dpms.gsso.constants;

public enum EResponseProfix {
	UNKNOWN_REQUEST("unknownRequest"),
	WS_AUTHEN_ONETIMEPASSWORD_RESPONSE("authenOneTimePWResponse"),
	WS_AUTHEN_ONETIMEPASSWORD_ID_RESPONSE("authenOneTimePWwithIDResponse"),
	WS_CREATE_ONETIMEPASSWORD_RESPONSE("createOneTimePWResponse"),
	WS_GENERATE_ONETIMEPASSWORD_RESPONSE("generateOneTimePWResponse"),
	WS_CONFIRM_ONETIMEPASSWORD_RESPONSE("confirmOneTimePWResponse"),
	WS_CONFIRM_ONETIMEPASSWORD_ID_RESPONSE("confirmOneTimePWwithIDResponse"),
	;
	String prefix;

	EResponseProfix(String prefix) {
		this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}
	
	
}
