package ais.dpms.gsso.message.builder;

import java.util.HashMap;
import java.util.Map;

import ais.dpms.gsso.constants.EGSSOCommand;
import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.message.imessage.IMessage;
import ec02.data.enums.EEquinoxRawData.CTypeHTTP;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.eqx.icarus.json.JsonHandler;
import phoebe.externalib.cauldron.eqx.log.DetailLog.Output;

public class GSSOJsonResponse {
	private static Map<String, String> getAttribute(GSSOInstance gssoInstance, CTypeHTTP typeHTTP, Object answerObject){
		Map<String, String> attribute = new HashMap<String, String>();
		if(CTypeHTTP.TEXT_PLAIN.getCType().equals(typeHTTP.getCType())) {
			attribute.put("val", JsonHandler.getStringJsonFromObject(answerObject));
			attribute.put("method", gssoInstance.getInitialMethod());
		}
		return attribute;
	}
	
	public static Output sendHttpResponse(GSSOInstance gssoInstance, Transmitter transmitter, EGSSOCommand command, Object response) {
		return GSSOResponseBuilder.sendResponse(gssoInstance, transmitter, command, new IMessage(), CTypeHTTP.TEXT_PLAIN, getAttribute(gssoInstance, CTypeHTTP.TEXT_PLAIN, response), response);
	}
	
}
