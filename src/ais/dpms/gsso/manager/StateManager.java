package ais.dpms.gsso.manager;

import static java.lang.Class.forName;

import ais.dpms.gsso.constants.EAttribute;
import ais.dpms.gsso.constants.EGSSOCommand;
import ais.dpms.gsso.constants.EName;
import ais.dpms.gsso.constants.EState;
import ais.dpms.gsso.state.unknown.Unknown_Idle;
import ec02.af.utils.AFLog;
import ec02.data.enums.EEquinoxRawData.CTypeHTTP;
import ec02.data.interfaces.EquinoxRawData;
import phoebe.eqx.icarus.applicationinterface.ApplicationState;
import phoebe.eqx.icarus.enums.EType;

public class StateManager {
	public static ApplicationState getState(String stateName) {
        try {
            for (EState eState : EState.values()) {
                if (eState.getStateName().equals(stateName)) {
                    Object instance = forName(eState.getInstanceClass().getCanonicalName()).newInstance();
                    return (ApplicationState) instance;
                }
            }
        } catch (Exception e) {
            AFLog.e("Get State : ERROR");
        }
        return new Unknown_Idle();
    }
	
	public static EGSSOCommand getCommand(EquinoxRawData rawData) {
		EGSSOCommand command = EGSSOCommand.UNKNOWN;
		try{
			String type = rawData.getRawDataAttribute(EAttribute.TYPE.getAttribute());
	        String ctype = rawData.getRawDataAttribute(EAttribute.CTYPE.getAttribute());
	        String name = rawData.getRawDataAttribute(EAttribute.NAME.getAttribute());
	        String url = rawData.getRawDataAttribute(EAttribute.URL.getAttribute());
	        String method = rawData.getRawDataAttribute(EAttribute.METHOD.getAttribute());
	        String rawDataMessage = rawData.getRawDataMessage();
	        
	        AFLog.d("name = " + name);
	        AFLog.d("type = " + type);
	        AFLog.d("ctype = " + ctype);
	        AFLog.d("url = " + url);
	        AFLog.d("method = " + method);
	        
	        if (EName.DIAMETER.getName().equalsIgnoreCase(name)) {
	            if (EType.REQUEST.getType().equalsIgnoreCase(type)) {
	            	//
	            } else if (EType.RESPONSE.getType().equalsIgnoreCase(type)) {
	            	//
	            }
	        } else if (EName.HTTP.getName().equalsIgnoreCase(name)) {
	            if (EType.REQUEST.getType().equalsIgnoreCase(type)) {
	                if(CTypeHTTP.TEXT_XML.getCType().equalsIgnoreCase(ctype)){
	                	for (EGSSOCommand eCommand : EGSSOCommand.values()) {
                            if (eCommand == null || eCommand.getUrl() == null || eCommand.getMethod() == null)
                                continue;
                            
                            if (rawDataMessage.contains("</"+eCommand.getSoap()+">") || rawDataMessage.contains(":" + eCommand.getSoap() + ">")) {
    	        				command = eCommand;
    	        			}
	                	}
//	                	for(EAAFCommand eAAFCommand : EAAFCommand.values()){
//	                		if(eAAFCommand == null){
//	                			continue;
//	                		}
//	                		boolean isAAFUrl = eAAFCommand.getEUrl() != null && url.contains(eAAFCommand.getEUrl().getUrl());
//	                		boolean methodPass = eAAFCommand.getMethod() != null && method.equalsIgnoreCase(eAAFCommand.getMethod().getMethodName());
//	                		if(isAAFUrl && methodPass){
//	                			boolean isCorrectUrlFormat = validateUrl(url, eAAFCommand.getEUrl(), eAAFCommand.getMethod());
//	                			if(isCorrectUrlFormat){
//	                				command = eAAFCommand;
//	                			}
//	                			break;
//	                		}
//	                	}
	                }else if(CTypeHTTP.TEXT_PLAIN.getCType().equalsIgnoreCase(ctype)){
	                	//text pain
	                	for (EGSSOCommand eCommand : EGSSOCommand.values()) {
                            if (eCommand == null || eCommand.getUrl() == null || eCommand.getMethod() == null)
                                continue;
                            boolean isReq = url.equals(eCommand.getUrl()) && method.equalsIgnoreCase(eCommand.getMethod().getMethod());
                            if (isReq) {
                                command = eCommand;
                                break;
                            }
                        }
	                }
	            }else if (EType.RESPONSE.getType().equalsIgnoreCase(type)) {
	            	//
	            }
	        } else if (EName.E01.getName().equalsIgnoreCase(name)) {
	            if (EType.REQUEST.getType().equalsIgnoreCase(type)) {
	            	//
	            } else if (EType.RESPONSE.getType().equalsIgnoreCase(type)) {
	            	//
	            }
	        }
		}catch (Exception e) {
			// TODO: handle exception
		}
        return command;
    }
	
	/*private static boolean validateUrl(String url, EUrl eUrl, EHttpMethod method){
		
		if(eUrl != null && url != null && method != null){
			try {
				if(method.equals(EHttpMethod.POST) || method.equals(EHttpMethod.PUT)){
					if(url.endsWith(eUrl.getUrl()) && url.endsWith(".json")){
						//Ver1
						return true;
					}else if(url.contains(eUrl.getUrl() + "/") && url.endsWith(".json")){
						//Ver2,3
						return true;
					}else if(url.contains(eUrl.getUrl() + ".json") && url.endsWith(".json")){
						//Ver2,3
						return true;
					}else if(url.contains(eUrl.getUrl() + "/.json") && url.endsWith(".json")){
						//Ver2,3
						return true;
					}
				}else if(method.equals(EHttpMethod.GET) || method.equals(EHttpMethod.DELETE)){
					if(url.endsWith(eUrl.getUrl()) || url.endsWith(eUrl.getUrl() + "?")){
						//Ver1
						return true;
					}else if(url.contains(eUrl.getUrl() + "?")){
						//Ver1
						return true;
					}else if(url.contains(eUrl.getUrl()) || url.contains(eUrl.getUrl() + "/")){
						//Ver1
						String[] splitUrl = url.split(eUrl.getUrl());
						if(splitUrl != null && splitUrl.length > 0){
							if(splitUrl[splitUrl.length-1].startsWith("?") || (url.startsWith(splitUrl[splitUrl.length-1] + eUrl.getUrl())) && (splitUrl[splitUrl.length-1] + eUrl.getUrl()).endsWith(".json")){
								return true;
							}
						}
						
						if(url.endsWith(eUrl.getUrl() + ".json") || url.endsWith(eUrl.getUrl() + ".json?")){
							//Ver2,3
							return true;
						}else if(url.endsWith(eUrl.getUrl() + "/.json") || url.endsWith(eUrl.getUrl() + "/.json?")){
							//Ver2,3
							return true;
						}else{
							splitUrl = url.split("\\?");
							if(splitUrl != null && splitUrl.length > 0){
								if(splitUrl[0].endsWith(".json") && (splitUrl[0].contains(eUrl.getUrl() + ".json") || splitUrl[0].contains(eUrl.getUrl() + "/"))){
									return true;
								}
							}
						}
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return false;
	}*/
}
