package ais.dpms.gsso.message.parser;

import ais.dpms.gsso.constants.EGSSOCommand;
import ais.dpms.gsso.message.command.SendOneTimePasswordRequest;
import ais.dpms.gsso.utils.Coder;
import ais.dpms.gsso.utils.MessageUtils;
import ec02.data.enums.EEquinoxRawData.CTypeHTTP;
import phoebe.eqx.icarus.json.JsonHandler;
import phoebe.eqx.icarus.userbean.IncomingMessage;

public class Parser {
	public static SendOneTimePasswordRequest parserSendOneTimePasswordRequest(IncomingMessage incomingMessage){
		try {
			String incommingRawData = Coder.decodeEscapeCharacters(incomingMessage.getRawDataMessage());
			//object = Class.forName(instanceClass.getCanonicalName()).newInstance();
			if(incomingMessage.getCType() != null && CTypeHTTP.TEXT_XML.getCType().equals(incomingMessage.getCType())){
				//parser XML
				//String soapIncoming = "<sendOneTimePWRequest><sendOneTimePW><msisdn>66626099131</msisdn><emailAddr>gsso@corp.ais900dev.org</emailAddr><otpChannel>all</otpChannel><service>MYAIS</service><accountType>all</accountType><addTimeoutMins>15</addTimeoutMins><waitDR>false</waitDR><otpDigit>4</otpDigit></sendOneTimePW></sendOneTimePW>";
				String soap = EGSSOCommand.SENDONETIMEPW.getSoap();
				String prefix = "<sendOneTimePWRequest><sendOneTimePW>";
				String subfix = "</sendOneTimePW></sendOneTimePWRequest>";
				incommingRawData = incommingRawData.substring(incommingRawData.indexOf(soap + ">") + soap.length() + 1);
				incommingRawData = incommingRawData.substring(0, incommingRawData.indexOf(soap + ">"));
				incommingRawData = incommingRawData.substring(0, incommingRawData.lastIndexOf("<"));
				String soapMsg = prefix + incommingRawData.trim() + subfix;
				
				SendOneTimePasswordRequest sendOneTimePW = (SendOneTimePasswordRequest) MessageUtils.createObjectFromXmlString(soapMsg.trim(), SendOneTimePasswordRequest.class);
				return sendOneTimePW;
				
//				String prefix = "<sendOneTimePWRequest><sendOneTimePW>";
//				String subfix = "</sendOneTimePW></sendOneTimePWRequest>";
//				String msisdn = MessageUtils.findXmlValue("msisdn", incommingRawData);
//				String emailAddr = MessageUtils.findXmlValue("emailAddr", incommingRawData);
//				String otpChannel = MessageUtils.findXmlValue("otpChannel", incommingRawData);
//				String service = MessageUtils.findXmlValue("service", incommingRawData);
//				String accountType = MessageUtils.findXmlValue("accountType", incommingRawData);
//				String addTimeoutMins = MessageUtils.findXmlValue("addTimeoutMins", incommingRawData);
//				String waitDR = MessageUtils.findXmlValue("waitDR", incommingRawData);
//				String otpDigit = MessageUtils.findXmlValue("otpDigit", incommingRawData);
//				String refDigit = MessageUtils.findXmlValue("refDigit", incommingRawData);
//				String sessionId = MessageUtils.findXmlValue("sessionId", incommingRawData);
//				String refId = MessageUtils.findXmlValue("refId", incommingRawData);
//				String soapIncoming = prefix + msisdn + emailAddr + otpChannel + service + accountType + addTimeoutMins + waitDR
//						+ otpDigit + refDigit + sessionId + refId + subfix;
//			
//				SendOneTimePasswordRequest sendOneTimePW = (SendOneTimePasswordRequest) MessageUtils.createObjectFromXmlString(soapIncoming.trim(), SendOneTimePasswordRequest.class);
//				return sendOneTimePW;
			}else{
				//parser plain
				SendOneTimePasswordRequest oneTimePasswordRequest = (SendOneTimePasswordRequest) JsonHandler.getObjectFromJsonString(incommingRawData, SendOneTimePasswordRequest.class);
				return oneTimePasswordRequest;
			}
		} catch (Exception e) {
		}
		return null;
	}
}
