package ais.dpms.gsso.constants;

public enum EResultJson {
	
	WRONG_INPUT_PARAMETER("2006", "WRONG_INPUT_PARAMETER"),
	;
	
	String code;
	String description;
	
	EResultJson(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	
}
