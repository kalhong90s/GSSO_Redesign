package ais.dpms.gsso.constants;

public enum EMethod {
	POST("POST"),
	GET("GET"),
	PUT("PUT"),
	DELETE("DELETE"),
	;
	
	String method;
	private EMethod(String method) {
		// TODO Auto-generated constructor stub
		this.method = method;
	}
	public String getMethod() {
		return method;
	}
	
}
