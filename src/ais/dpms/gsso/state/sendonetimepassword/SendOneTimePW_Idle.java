package ais.dpms.gsso.state.sendonetimepassword;

import ais.dpms.gsso.constants.ECommand;
import ais.dpms.gsso.constants.EStat;
import ais.dpms.gsso.constants.EState;
import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.instances.UserInstance;
import ais.dpms.gsso.interfaces.AppState;
import ais.dpms.gsso.manager.log.LogManager;
import ais.dpms.gsso.manager.statistic.Statistic;
import ais.dpms.gsso.message.builder.SDFBuilder;
import ais.dpms.gsso.message.command.SendOneTimePasswordRequest;
import ais.dpms.gsso.message.parser.Parser;
import ec02.af.abstracts.AbstractAF;
import ec02.af.utils.AFLog;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.eqx.icarus.instance.ApplicationInstance;
import phoebe.eqx.icarus.userbean.IncomingMessage;
import phoebe.eqx.icarus.utility.Assistance;
import phoebe.externalib.cauldron.eqx.log.DetailLog.Output;

public class SendOneTimePW_Idle implements AppState{

	@Override
	public void handleNormal(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter,
			Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns) {
		// TODO Auto-generated method stub
		AFLog.d("****************** SendOneTimePW_Idle ***************");
		SendOneTimePasswordRequest object = Parser.parserSendOneTimePasswordRequest(incomingMessage);
		
		LogManager.setDetailLogInputIdle(gssoInstance, applicationInstance, incomingMessage, "identityFFF", object, EState.SENDONETIMEPW_IDLE);
		LogManager.setSummaryLogIdel(gssoInstance, applicationInstance, incomingMessage, "identityFFF");
		
		Output output = SDFBuilder.sendGetGupCommon(gssoInstance, transmitter, EState.SENDONETIMEPW_GET_GUPCOMMON, ECommand.GetGupCommon, "msisdn", "66878665432");
		LogManager.setDetailLogOutput(gssoInstance, applicationInstance, output, EState.SENDONETIMEPW_GET_GUPCOMMON, object);
		Statistic.increaseStatistic(assistance, EStat.Test);
		
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
