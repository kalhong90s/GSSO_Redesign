package ais.dpms.gsso.state.unknown;

import java.util.Map;

import ais.dpms.gsso.constants.EConfig;
import ais.dpms.gsso.constants.EGSSOCommand;
import ais.dpms.gsso.constants.EResponseProfix;
import ais.dpms.gsso.constants.EResultJson;
import ais.dpms.gsso.constants.EResultSoap;
import ais.dpms.gsso.constants.EState;
import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.instances.UserInstance;
import ais.dpms.gsso.interfaces.AppState;
import ais.dpms.gsso.manager.log.LogManager;
import ais.dpms.gsso.message.builder.GSSOJsonResponse;
import ais.dpms.gsso.message.builder.GSSOSoapResponse;
import ais.dpms.gsso.utils.Generator;
import ec02.af.abstracts.AbstractAF;
import ec02.af.utils.AFLog;
import ec02.data.enums.EEquinoxRawData.CTypeHTTP;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.eqx.icarus.configuration.Config;
import phoebe.eqx.icarus.instance.ApplicationInstance;
import phoebe.eqx.icarus.userbean.IncomingMessage;
import phoebe.eqx.icarus.utility.Assistance;
import phoebe.externalib.cauldron.eqx.log.DetailLog.Output;

public class Unknown_Idle implements AppState{

	@Override
	public void handleNormal(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter,
			Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns) {
		// TODO Auto-generated method stub
		AFLog.d("****************** Unknown_Idle ***************");
		LogManager.setSummaryLogIdel(gssoInstance, applicationInstance, incomingMessage, "");
		
		String orderRef = Generator.generateOrderReference(Config.getWarmConfigAsString(EConfig.APPLICATION_NODE_NAME.getConfigName()), gssoInstance.getListOrderReference());
		String rootMsg = EResponseProfix.UNKNOWN_REQUEST.getPrefix();
		
		if(CTypeHTTP.TEXT_PLAIN.getCType().equals(incomingMessage.getCType())) {
			LogManager.setDetailLogInputIdle(gssoInstance, applicationInstance, incomingMessage, "", incomingMessage.getRawDataAttribute("url"), EState.UNKNOWN_IDLE);
			
			String code = EResultJson.WRONG_INPUT_PARAMETER.getCode();
			String desc = EResultJson.WRONG_INPUT_PARAMETER.getDescription();
			
			Map<String, Map<String, String>> body = Unknown_Utility.createJsonOut(code, desc, orderRef, rootMsg);
			Output output = GSSOJsonResponse.sendHttpResponse(gssoInstance, transmitter, EGSSOCommand.UNKNOWN, body);
			LogManager.setDetailLogOutput(gssoInstance, applicationInstance, output, EState.END, body);
			LogManager.setSummaryLogResult(applicationInstance, code, desc);
			LogManager.raiseSummaryLog(applicationInstance.getCommonLog());
		}else {
			LogManager.setDetailLogInputIdle(gssoInstance, applicationInstance, incomingMessage, "", "Unknown", EState.UNKNOWN_IDLE);
			
			String code = EResultSoap.WS_WRONG_INPUT_PARAMETER.getCode();
			String desc = EResultSoap.WS_WRONG_INPUT_PARAMETER.getDescription();
			
			String soap = Unknown_Utility.createSoapOut(code, desc, rootMsg, orderRef);
			Output output = GSSOSoapResponse.sendHttpResponse(gssoInstance, transmitter, EGSSOCommand.UNKNOWN, soap.toString());
			LogManager.setDetailLogOutput(gssoInstance, applicationInstance, output, EState.END, soap);
			LogManager.setSummaryLogResult(applicationInstance, code, desc);
			LogManager.raiseSummaryLog(applicationInstance.getCommonLog());
		}
	}

	@Override
	public void handleEquinoxError(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance,
			UserInstance userIns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEquinoxReject(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance,
			UserInstance userIns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEquinoxAbort(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance,
			UserInstance userIns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEquinoxTimeout(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance,
			UserInstance userIns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEquinoxAged(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance,
			UserInstance userIns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEquinoxShutdown(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance,
			UserInstance userIns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEquinoxUnknown(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance,
			UserInstance userIns) {
		// TODO Auto-generated method stub
		
	}

}
