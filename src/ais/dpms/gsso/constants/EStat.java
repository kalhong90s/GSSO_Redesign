package ais.dpms.gsso.constants;

public enum EStat {
	Test("Test"),
	;
	String stat;
	EStat(String stat) {
		// TODO Auto-generated constructor stub
		this.stat = stat;
	}
	public String getStat() {
		return stat;
	}
}
