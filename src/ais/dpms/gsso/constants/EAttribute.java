package ais.dpms.gsso.constants;

public enum EAttribute {
	METHOD("method"),
	URL("url"),
	TYPE("type"),
	CTYPE("ctype"),
	NAME("name"),
	VAL("val"),
	ECODE("ecode"),
	ORIG("orig"),
	OID("oid"),
	DESC("desc"),
	TIMEOUT("timeout"),
	;
	
	String attribute;
	
	private EAttribute(String attr) {
		attribute = attr;
	}

	public String getAttribute() {
		return attribute;
	}
	
}
