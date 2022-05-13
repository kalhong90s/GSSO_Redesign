package ais.dpms.gsso.constants;

public enum ECommand {
	GetGupCommon("GetGupCommon"),
	;
	String command;
	
	ECommand(String command) {
		// TODO Auto-generated constructor stub
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
	
}
