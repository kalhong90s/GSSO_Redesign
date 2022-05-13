package ais.dpms.gsso.main;

import java.util.List;

import ais.dpms.gsso.adaptor.GSSOAdaptor;
import ec02.af.abstracts.AbstractAF;
import ec02.af.exception.ActionProcessException;
import ec02.af.utils.AFLog;
import ec02.data.interfaces.ECDialogue;
import ec02.data.interfaces.EquinoxPropertiesAF;
import ec02.data.interfaces.EquinoxRawData;
import ec02.data.interfaces.InstanceData;
import ec02.data.interfaces.StdCDRData;
import ec02.data.interfaces.StdEDRFactory;
import phoebe.eqx.icarus.control.Blackbox;

public class GSSOMain extends AbstractAF{
	
	public static Blackbox blackBoxMaster;
	
	private Blackbox createBlackbox() {
		if(blackBoxMaster == null) {
			GSSOAdaptor gssoAdaptor = new GSSOAdaptor();
			blackBoxMaster = new Blackbox(gssoAdaptor);
		}
		return blackBoxMaster;
	}

	@Override
	public ECDialogue actionProcess(EquinoxPropertiesAF abstractAF, List<EquinoxRawData> eqxRawDataList, InstanceData instance)
			throws ActionProcessException {
		// TODO Auto-generated method stub
		Blackbox blackbox = createBlackbox();
		return blackbox.getOutput(this, eqxRawDataList, instance);
	}

	@Override
	public StdCDRData initializedCallDetailRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StdEDRFactory initializedEventDetailRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyAFConfiguration(String configFile) {
		// TODO Auto-generated method stub
		Blackbox blackbox = createBlackbox();
		boolean verifyConfig = blackbox.verifyAFConfiguration(this, configFile);
		AFLog.d("---------- " + verifyConfig);
		return verifyConfig;
	}

}
