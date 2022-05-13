package ais.dpms.gsso.state.unknown;

import java.util.HashMap;
import java.util.Map;

public class Unknown_Utility {

	public static Map<String, Map<String, String>> createJsonOut(String code, String desc, String orderRef, String rootMsg) {
		Map<String, Map<String, String>> body = new HashMap<String, Map<String,String>>();
		Map<String, String> val = new HashMap<String, String>();
		val.put("code", code);
		val.put("description", desc);
		val.put("isSuccess", "false");
		val.put("orderRef", orderRef);
		body.put(rootMsg, val);
		return body;
	}
	public static String createSoapOut(String resCode, String resDes, String rootElement, String orderRef) {

		StringBuilder soapOutBuilder = new StringBuilder();
		String link = "ws.sso.gsso";
		soapOutBuilder.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		soapOutBuilder.append("<S:Body>");
		
//		String[] possibleValue = new String[] {EResponseProfix.WS_AUTHEN_ONETIMEPASSWORD_RESPONSE.getPrefix(), 
//				EResponseProfix.WS_AUTHEN_ONETIMEPASSWORD_ID_RESPONSE.getPrefix(), 
//				EResponseProfix.WS_CREATE_ONETIMEPASSWORD_RESPONSE.getPrefix(), 
//				EResponseProfix.WS_GENERATE_ONETIMEPASSWORD_RESPONSE.getPrefix(), 
//				EResponseProfix.WS_CONFIRM_ONETIMEPASSWORD_RESPONSE.getPrefix(), 
//				EResponseProfix.WS_CONFIRM_ONETIMEPASSWORD_ID_RESPONSE.getPrefix(), };
//		if (Arrays.asList(possibleValue).contains(rootElement) && isWS) {
//			link = "ws.gsso";
//		} else {
//			link = "ws.sso.gsso";
//		}
		soapOutBuilder.append("<ns2:" + rootElement + " xmlns:ns2=\"http://" + link + "/\">");
		soapOutBuilder.append("<return>");
//		if (isConfirmWithPasskey) {
//			soapOutBuilder.append(
//					"<return xsi:type=\"ns2:gssoSsoResponsePassKey\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
//		} else {
//			soapOutBuilder.append("<return>");
//		}

		soapOutBuilder.append("<code>" + resCode + "</code>");
		soapOutBuilder.append("<description>" + resDes + "</description>");

		/* Response for only sso command */
		if (link.equals("ws.sso.gsso")) {
			soapOutBuilder.append("<isSuccess>false</isSuccess>");
			soapOutBuilder.append("<operName/>");
		}
		/* ws command */
		else {
			soapOutBuilder.append("<isSuccess>false</isSuccess>");
		}
		soapOutBuilder.append("<orderRef>" + orderRef + "</orderRef>");
		soapOutBuilder.append("<pwd/>");
		soapOutBuilder.append("<transactionID/>");
//		if (isConfirmWithPasskey || isConfirm) {
//			if (StringUtils.isNoneEmpty(transactionID))
//				soapOutBuilder.append("<transactionID>" + transactionID + "</transactionID>");
//			else
//				soapOutBuilder.append("<transactionID/>");
//		} else {
//			soapOutBuilder.append("<transactionID/>");
//		}
//		if (isConfirmWithPasskey) {
//			soapOutBuilder.append("<passKey/>");
//		}
		soapOutBuilder.append("</return>");
		soapOutBuilder.append("</ns2:" + rootElement + ">");
		soapOutBuilder.append("</S:Body>");
		soapOutBuilder.append("</S:Envelope>");

		return soapOutBuilder.toString();
	}
}
