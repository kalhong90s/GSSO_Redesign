package ais.dpms.gsso.instances;

import java.util.ArrayList;

import ais.dpms.gsso.constants.EAttribute;
import ec02.af.utils.AFLog;
import phoebe.eqx.icarus.instance.ApplicationInstance;
import phoebe.eqx.icarus.userbean.IncomingMessage;
import phoebe.eqx.icarus.userbean.Orig;

public class GSSOInstance {

	//private UserInstance userInstance;

    private String initialSessionId;
    private Orig initialOrigObj;
    private String initialInvoke;
    private String initialMethod;
    private String identity; //for detaillog
    
    private ArrayList<String> listOrderReference;
    
	public GSSOInstance(ApplicationInstance applicationInstance, IncomingMessage incomingMessage) {
        //this.userInstance = userInstance;

        initialSessionId = applicationInstance.getSessionId();
        initialInvoke = incomingMessage.getMessageInstance().getInitialInvoke();
        //setCommand(incomingMessage.getCommandNameForFramework());
        if (initialOrigObj == null) {
            initialOrigObj = incomingMessage.getMessageInstance().getInitialOrigObject();
        }
        if (initialInvoke.equals(incomingMessage.getInvoke())) {
            initialMethod = incomingMessage.getRawDataAttribute(EAttribute.METHOD.getAttribute());
        }
        AFLog.d("Create new GSSO Instance Session : " + initialSessionId);
        
        listOrderReference = new ArrayList<>();
    }

	public String getInitialSessionId() {
		return initialSessionId;
	}

	public Orig getInitialOrigObj() {
		return initialOrigObj;
	}

	public String getInitialInvoke() {
		return initialInvoke;
	}

	public String getInitialMethod() {
		return initialMethod;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public ArrayList<String> getListOrderReference() {
		return listOrderReference;
	}

	public void setListOrderReference(ArrayList<String> listOrderReference) {
		this.listOrderReference = listOrderReference;
	}

    /*public void init(UserInstance userInstance) {
        this.userInstance = userInstance;
    }*/
	
}
