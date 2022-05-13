package ais.dpms.gsso.message.builder;

import java.util.HashMap;
import java.util.Map;

import ais.dpms.gsso.constants.EGSSOCommand;
import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.message.imessage.IMessage;
import ec02.data.enums.EEquinoxRawData.CTypeHTTP;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.externalib.cauldron.eqx.log.DetailLog.Output;

public class GSSOSoapResponse {
	
	private static Map<String, String> getAttribute(GSSOInstance gssoInstance){
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("method", gssoInstance.getInitialMethod());
		return attribute;
	}
	
	public static Output sendHttpResponse(GSSOInstance gssoInstance, Transmitter transmitter, EGSSOCommand command, String object) {
//		String xml = "";
//		if(object instanceof String){
//			xml = MessageUtils.createXmlStringFromObject(object.getClass(), object);
//		}else {
//			
//		}
		IMessage iMessage = new IMessage();
		iMessage.setBodyMsg(object);
		return GSSOResponseBuilder.sendResponse(gssoInstance, transmitter, command, iMessage, CTypeHTTP.TEXT_XML, getAttribute(gssoInstance), object);
	}
}
