package ais.dpms.gsso.state.sendonetimepassword;

import ais.dpms.gsso.constants.ECommand;
import ais.dpms.gsso.constants.ENode;
import ais.dpms.gsso.constants.EStat;
import ais.dpms.gsso.constants.EState;
import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.instances.UserInstance;
import ais.dpms.gsso.interfaces.AppState;
import ais.dpms.gsso.manager.log.LogManager;
import ais.dpms.gsso.manager.statistic.Statistic;
import ais.dpms.gsso.message.builder.SDFBuilder;
import ais.dpms.gsso.message.command.SendOneTimePasswordRequest;
import ais.dpms.gsso.message.groupbean.SendOneTimePW;
import ec02.af.abstracts.AbstractAF;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.eqx.icarus.instance.ApplicationInstance;
import phoebe.eqx.icarus.userbean.IncomingMessage;
import phoebe.eqx.icarus.utility.Assistance;
import phoebe.externalib.cauldron.eqx.log.DetailLog.Output;

public class SendOneTimePW_Get_GupCommon implements AppState{

	@Override
	public void handleNormal(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter,
			Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns) {
		// TODO Auto-generated method stub
		//LogManager.raiseSummaryLog(applicationInstance.getCommonLog());
		SendOneTimePasswordRequest oneTimePasswordRequest = new SendOneTimePasswordRequest();
		oneTimePasswordRequest.setSendOneTimePW(new SendOneTimePW());
		oneTimePasswordRequest.getSendOneTimePW().setAccountType("A");
		oneTimePasswordRequest.getSendOneTimePW().setMsisdn("BBB");
		LogManager.setDetailLogInput(gssoInstance, applicationInstance, incomingMessage, EState.SENDONETIMEPW_GET_GUPCOMMON, oneTimePasswordRequest);
		
		Output output = SDFBuilder.sendGetGupCommon(gssoInstance, transmitter, EState.SENDONETIMEPW_GET_GUPCOMMON, ECommand.GetGupCommon, "msisdn", "66878665432");
		LogManager.setDetailLogOutput(gssoInstance, applicationInstance, output, EState.SENDONETIMEPW_GET_GUPCOMMON, "/sdsd/sdddds/ffd");
		Statistic.increaseStatistic(assistance, EStat.Test);
		
		Output output2 = SDFBuilder.sendGetGupCommon(gssoInstance, transmitter, EState.SENDONETIMEPW_GET_GUPCOMMON, ECommand.GetGupCommon, "msisdn", "66878665432");
		LogManager.setDetailLogOutput(gssoInstance, applicationInstance, output2, EState.SENDONETIMEPW_GET_GUPCOMMON, "sds/sdsd/ss");
		Statistic.increaseStatistic(assistance, EStat.Test);
		
		
		LogManager.setSummaryLogError(applicationInstance, ENode.SDF, ECommand.GetGupCommon, "50000", "System Error");
		LogManager.setSummaryLogResult(applicationInstance, "20000", "Success");
		LogManager.raiseSummaryLog(applicationInstance.getCommonLog());
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
