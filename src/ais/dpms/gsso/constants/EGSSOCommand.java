package ais.dpms.gsso.constants;

public enum EGSSOCommand {
	//format --> method, url, soap, commandName, idle
	UNKNOWN(null, null, null, "UNKNOWN", EState.UNKNOWN_IDLE),
	SENDONETIMEPW(EMethod.POST, "/api/v1/gsso/sendOneTimePW.json", "sendOneTimePW", "sendOneTimePW", EState.SENDONETIMEPW_IDLE),
	;

	private EMethod method;
	private String url;
	private String soap;
	private String commandName;
	private EState idleState;

	EGSSOCommand(EMethod method, String url, String soap, String commandName, EState idleState) {
		this.method = method;
		this.url = url;
		this.soap = soap;
        this.commandName = commandName;
        this.idleState = idleState;
    }
	
    public String getCommandName() {
        return this.commandName;
    }
    
    public EState getIdleState() {
    	return this.idleState;
    }

	public EMethod getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getSoap() {
		return soap;
	}
	
}
