package ais.dpms.gsso.constants;

public enum EName {
	DIAMETER("DIAMETER"),
	HTTP("HTTP"),
	HTTPS("HTTPS"),
	LDAP("LDAP"),
	FILECONTROL("FILECONTROL"),
	E01("E01"),
	DB("db");
	
	private String name;
	
	EName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
