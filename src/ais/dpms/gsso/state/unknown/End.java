package ais.dpms.gsso.state.unknown;

import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.instances.UserInstance;
import ais.dpms.gsso.interfaces.AppState;
import ec02.af.abstracts.AbstractAF;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.eqx.icarus.instance.ApplicationInstance;
import phoebe.eqx.icarus.userbean.IncomingMessage;
import phoebe.eqx.icarus.utility.Assistance;

public class End implements AppState{

	@Override
	public void handleNormal(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter,
			Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns) {
		// TODO Auto-generated method stub
		
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
