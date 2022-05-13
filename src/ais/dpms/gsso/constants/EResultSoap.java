package ais.dpms.gsso.constants;

public enum EResultSoap {
	WS_WRONG_INPUT_PARAMETER("043","WRONG_INPUT_PARAMETER"),
	;
	String code;
	String description;
	
	EResultSoap(String code, String description) {
		// TODO Auto-generated constructor stub
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
