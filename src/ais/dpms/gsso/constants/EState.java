package ais.dpms.gsso.constants;

import ais.dpms.gsso.state.unknown.*;
import ais.dpms.gsso.state.sendonetimepassword.*;

public enum EState {
	END("End", End.class),
	UNKNOWN_IDLE("Unknown_Idle", Unknown_Idle.class),
	SENDONETIMEPW_IDLE("SendOneTimePW_Idle", SendOneTimePW_Idle.class),
	SENDONETIMEPW_GET_GUPCOMMON("SendOneTimePW_Get_GupCommon", SendOneTimePW_Get_GupCommon.class),
	;
	
	private String state;
	private Class<?> instanceClass;

	EState(String state, Class<?> instanceClass) {
		this.state = state;
		this.instanceClass = instanceClass;
	}

	public String getStateName() {
		return state;
	}

	public Class<?> getInstanceClass() {
		return instanceClass;
	}
}
