package ais.dpms.gsso.adaptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ais.dpms.gsso.constants.EGSSOCommand;
import ais.dpms.gsso.constants.EConfig;
import ais.dpms.gsso.constants.EState;
import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.instances.UserInstance;
import ais.dpms.gsso.manager.StateManager;
import ec02.af.abstracts.AbstractAF;
import ec02.af.interfaces.IAFState;
import ec02.af.utils.AFLog;
import ec02.data.interfaces.EquinoxRawData;
import ec02.data.interfaces.GlobalData;
import phoebe.eqx.icarus.applicationinterface.ApplicationState;
import phoebe.eqx.icarus.applicationinterface.ObserverInput;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.eqx.icarus.configuration.Config;
import phoebe.eqx.icarus.configuration.EConfigType;
import phoebe.eqx.icarus.enums.EApplicationInfo;
import phoebe.eqx.icarus.instance.ApplicationInstance;
import phoebe.eqx.icarus.userbean.ConfigurationUnit;
import phoebe.eqx.icarus.userbean.IncomingMessage;
import phoebe.eqx.icarus.utility.Assistance;

public class GSSOAdaptor implements ObserverInput{

	@Override
	public Map<EApplicationInfo, String> getApplicationInfo() {
		// TODO Auto-generated method stub
		Map<EApplicationInfo, String> applicationInfo = new HashMap<>();
		try {
			applicationInfo.put(EApplicationInfo.APPLICATION_NAME, Config.getWarmConfigAsString(EConfig.APPLICATION_NAME.getConfigName()));
			applicationInfo.put(EApplicationInfo.COMMONLOG_DETAIL_LOG_ENABLE, String.valueOf(Config.getWarmConfigAsBoolean(EConfig.COMMONLOG_DETAIL_LOG_ENABLE.getConfigName())));
			applicationInfo.put(EApplicationInfo.COMMONLOG_DETAIL_LOG_NAME, Config.getWarmConfigAsString(EConfig.DETAIL_LOG_NAME.getConfigName()));
			applicationInfo.put(EApplicationInfo.COMMONLOG_SUMMARY_LOG_ENABLE, String.valueOf(Config.getWarmConfigAsBoolean(EConfig.COMMONLOG_SUMMARY_LOG_ENABLE.getConfigName())));
			applicationInfo.put(EApplicationInfo.COMMONLOG_SUMMARY_LOG_NAME, Config.getWarmConfigAsString(EConfig.SUMMARY_LOG_NAME.getConfigName()));
			applicationInfo.put(EApplicationInfo.COMMONLOG_NODE_NAME, Config.getWarmConfigAsString(EConfig.APPLICATION_NAME.getConfigName()));
			AFLog.d("Define App Success!!!!!");
		} catch (Exception e) {
			// TODO: handle exception
			AFLog.d("Define App Fail!!!!!");
		}
		return applicationInfo;
	}

	@Override
	public Map<String, ApplicationState> defineStateList() {
		// TODO Auto-generated method stub
		//define all state
		Map<String, ApplicationState> applicationStateMap = new HashMap<>();
        try {
            for (EState eState : EState.values()) {
                applicationStateMap.put(eState.getStateName(), StateManager.getState(eState.getStateName()));
            }
            AFLog.d("Define State List : SUCCESS");
        } catch (Exception e) {
            AFLog.e("Define State List : ERROR ->" + e.getStackTrace()[0]);
        }
        return applicationStateMap;
	}

	@Override
	public Map<String, IAFState> defineLegacyStateList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> defineCommandList() {
		// TODO Auto-generated method stub
		Map<String, String> commandListMap = new HashMap<>();
        try {
            for (EGSSOCommand eCommand : EGSSOCommand.values()) {
                commandListMap.put(eCommand.getCommandName(), eCommand.getIdleState().getStateName());
            }
            AFLog.d("Define Command List : SUCCESS");
        } catch (Exception e) {
            AFLog.e("Define Command List : ERROR ->" + e.getStackTrace()[0]);
        }
        return commandListMap;
	}

	@Override
	public Map<String, String> defineLegacyCommandList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIncomingCommandName(EquinoxRawData rawData) {
		// TODO Auto-generated method stub
		return StateManager.getCommand(rawData).getCommandName();
	}

	@Override
	public Object preProcessing(AbstractAF af, Assistance assistance, List<EquinoxRawData> incomingRawDatas,
			GlobalData globalData, long startTime) {
		// TODO Auto-generated method stub
		return new UserInstance();
	}

	@Override
	public void postProcessing(AbstractAF af, Assistance assistance, long stopTime, long usedTime, Object userData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ConfigurationUnit> verifyAndLoadConfiguration() {
		// TODO Auto-generated method stub
		List<ConfigurationUnit> configurationList = new ArrayList<>();
		try{
			for (EConfig config : EConfig.values()) {
	            String configurationName = config.getConfigName();
	            boolean isMandatory = config.isMandatory();
	            boolean isMultiple = config.isMultiple();
	            String pattern = config.getRegExFormat();
	            
	            configurationList.add(new ConfigurationUnit(EConfigType.WARM, configurationName, isMandatory, isMultiple, pattern));
			}
			AFLog.d("Verify And Load Config Success!!!!!");
		}catch (Exception e) {
			AFLog.d("Verify And Load Config Fail!!!!!");
		}
		return configurationList;
	}

	@Override
	public boolean validateConfigurationCaseByCase(Map<String, List<String>> warmConfig,
			Map<String, Map<String, String>> coldConfig) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static void initInstance(ApplicationInstance applicationInstance, IncomingMessage incomingMessage,
			Transmitter transmitter, Assistance assistance, Object userData) {
		try {
			GSSOInstance gssoInstance = (GSSOInstance) applicationInstance.getUserInstance();
			if (gssoInstance == null) {
//				gssoInstance = new GSSOInstance(applicationInstance, incomingMessage, (UserInstance) userData);
				gssoInstance = new GSSOInstance(applicationInstance, incomingMessage);
				applicationInstance.setUserInstance(gssoInstance, GSSOInstance.class);
			} else {
				//gssoInstance.init((UserInstance) userData);
			}
		} catch (Exception e) {
			AFLog.e("initInstance ERROR ->" + e.getStackTrace()[0]);
		}
	}
}
