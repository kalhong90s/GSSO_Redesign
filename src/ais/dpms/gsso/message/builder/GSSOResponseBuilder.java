package ais.dpms.gsso.message.builder;

import java.util.Map;

import ais.dpms.gsso.constants.EAttribute;
import ais.dpms.gsso.constants.EGSSOCommand;
import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.message.imessage.IMessage;
import ais.dpms.gsso.utils.Validator;
import ec02.data.enums.EEquinoxRawData.CTypeHTTP;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.eqx.icarus.enums.EType;
import phoebe.externalib.cauldron.eqx.log.DetailLog.Output;

public class GSSOResponseBuilder {
	/*public static Output sendResponse(AAFInstance aafInstance, MyAppInstance myAppInstance, EAAFCommand aafCommand, IMessage iMessage, CTypeHTTP ctype, Map<String, String> optionalAttribute, Object response, String resultCode, String developerMessage){
		return getMessage(aafInstance, myAppInstance, aafCommand, iMessage, ctype, optionalAttribute, response, resultCode, developerMessage, null);
	}
	
	public static Output sendResponse(AAFInstance aafInstance, MyAppInstance myAppInstance, EAAFCommand aafCommand, IMessage iMessage, CTypeHTTP ctype, Map<String, String> optionalAttribute, Object response, String resultCode, String developerMessage, String errorMessage){
		return getMessage(aafInstance, myAppInstance, aafCommand, iMessage, ctype, optionalAttribute, response, resultCode, developerMessage, errorMessage);
	}*/
	
	public static Output sendResponse(GSSOInstance gssoInstance, Transmitter transmitter, EGSSOCommand command, IMessage iMessage, CTypeHTTP ctype, Map<String, String> optionalAttribute, Object response) {
		if(iMessage == null) iMessage = new IMessage();
		try {
			//aafInstance.getCommonLogManager().getCommonLog().getSummaryLog().setResultCode(resultCode);
			//aafInstance.getCommonLogManager().getCommonLog().getSummaryLog().setResultDescription(developerMessage);
			String invoke = gssoInstance.getInitialInvoke();
			Output output = transmitter.sendHTTPResponseMessage(command.getCommandName(), iMessage, ctype, invoke, gssoInstance.getInitialOrigObj().getServiceName(), gssoInstance.getInitialOrigObj().getInstanceNumber(), optionalAttribute);
			output = createOutput(gssoInstance, output, optionalAttribute, command, response);
			return output;
		} catch (Exception e) {
		}
		return null;
	}
	
	private static Output createOutput(GSSOInstance gssoInstance, Output output, Map<String, String> optionalAttribute, EGSSOCommand command, Object response) {
		String rawData = Validator.validateString(output.getRawData()) ? output.getRawData() : optionalAttribute.get(EAttribute.VAL.getAttribute());
		output = new Output(output.getInvoke(), rawData, gssoInstance.getInitialOrigObj().getServiceName(), command.getCommandName(), EType.RESPONSE.getType());
		/*DetailLogData detailLogData = new DetailLogData();
		detailLogData.setData(response);
		if(Validator.validateString(errorMessage)){
			detailLogData.setError(errorMessage);
		}
		output.setData(detailLogData);*/
		return output;
	}
}
