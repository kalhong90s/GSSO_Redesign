package ais.dpms.gsso.interfaces;

import ais.dpms.gsso.adaptor.GSSOAdaptor;
import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.instances.UserInstance;
import ec02.af.abstracts.AbstractAF;
import phoebe.eqx.icarus.applicationinterface.ApplicationState;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.eqx.icarus.instance.ApplicationInstance;
import phoebe.eqx.icarus.userbean.IncomingMessage;
import phoebe.eqx.icarus.utility.Assistance;

public interface AppState extends ApplicationState{
	@Override
	default void handleNormalEvent(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			IncomingMessage incomingMessage, Transmitter transmitter, Assistance assistance, Object userData) {
		// TODO Auto-generated method stub
		GSSOAdaptor.initInstance(applicationInstance, incomingMessage, transmitter, assistance, userData);
		handleNormal(abstractAF, applicationInstance, transmitter, assistance, incomingMessage, (GSSOInstance) applicationInstance.getUserInstance(), (UserInstance) userData);
	}
	
	@Override
	default void handleAbortEvent(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			IncomingMessage incomingMessage, Transmitter transmitter, Assistance assistance, Object userData) {
		// TODO Auto-generated method stub
		GSSOAdaptor.initInstance(applicationInstance, incomingMessage, transmitter, assistance, userData);
		handleEquinoxAbort(abstractAF, applicationInstance, transmitter, assistance, incomingMessage, (GSSOInstance) applicationInstance.getUserInstance(), (UserInstance) userData);
	}
	
	@Override
	default void handleAgedEvent(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			IncomingMessage incomingMessage, Transmitter transmitter, Assistance assistance, Object userData) {
		// TODO Auto-generated method stub
		GSSOAdaptor.initInstance(applicationInstance, incomingMessage, transmitter, assistance, userData);
		handleEquinoxAged(abstractAF, applicationInstance, transmitter, assistance, incomingMessage, (GSSOInstance) applicationInstance.getUserInstance(), (UserInstance) userData);
	}
	
	@Override
	default void handleErrorEvent(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			IncomingMessage incomingMessage, Transmitter transmitter, Assistance assistance, Object userData) {
		// TODO Auto-generated method stub
		GSSOAdaptor.initInstance(applicationInstance, incomingMessage, transmitter, assistance, userData);
		handleEquinoxError(abstractAF, applicationInstance, transmitter, assistance, incomingMessage, (GSSOInstance) applicationInstance.getUserInstance(), (UserInstance) userData);
	}
	
	@Override
	default void handleRejectEvent(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			IncomingMessage incomingMessage, Transmitter transmitter, Assistance assistance, Object userData) {
		// TODO Auto-generated method stub
		GSSOAdaptor.initInstance( applicationInstance, incomingMessage, transmitter, assistance, userData);
		handleEquinoxReject(abstractAF, applicationInstance, transmitter, assistance, incomingMessage, (GSSOInstance) applicationInstance.getUserInstance(), (UserInstance) userData);
	}
	
	@Override
	default void handleShutdownEvent(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			IncomingMessage incomingMessage, Transmitter transmitter, Assistance assistance, Object userData) {
		// TODO Auto-generated method stub
		GSSOAdaptor.initInstance(applicationInstance, incomingMessage, transmitter, assistance, userData);
		handleEquinoxShutdown(abstractAF, applicationInstance, transmitter, assistance, incomingMessage, (GSSOInstance) applicationInstance.getUserInstance(), (UserInstance) userData);
	}
	
	@Override
	default void handleTimeoutEvent(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			IncomingMessage incomingMessage, Transmitter transmitter, Assistance assistance, Object userData) {
		// TODO Auto-generated method stub
		GSSOAdaptor.initInstance(applicationInstance, incomingMessage, transmitter, assistance, userData);
		handleEquinoxTimeout(abstractAF, applicationInstance, transmitter, assistance, incomingMessage, (GSSOInstance) applicationInstance.getUserInstance(), (UserInstance) userData);
	}
	
	@Override
	default void handleUnknownEvent(AbstractAF abstractAF, ApplicationInstance applicationInstance,
			IncomingMessage incomingMessage, Transmitter transmitter, Assistance assistance, Object userData) {
		// TODO Auto-generated method stub
		GSSOAdaptor.initInstance(applicationInstance, incomingMessage, transmitter, assistance, userData);
		handleEquinoxUnknown(abstractAF, applicationInstance, transmitter, assistance, incomingMessage, (GSSOInstance) applicationInstance.getUserInstance(), (UserInstance) userData);
	}

	public void handleNormal(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns);
	public void handleEquinoxError(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns);
	public void handleEquinoxReject(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns);
	public void handleEquinoxAbort(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns);
	public void handleEquinoxTimeout(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns);
	public void handleEquinoxAged(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns);
	public void handleEquinoxShutdown(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns);
	public void handleEquinoxUnknown(AbstractAF abstractAF, ApplicationInstance applicationInstance, Transmitter transmitter, Assistance assistance, IncomingMessage incomingMessage, GSSOInstance gssoInstance, UserInstance userIns);
}
