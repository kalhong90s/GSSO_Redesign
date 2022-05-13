package ais.dpms.gsso.message.builder;

import java.util.HashMap;
import java.util.Map;

import ais.dpms.gsso.constants.ECommand;
import ais.dpms.gsso.constants.EConfig;
import ais.dpms.gsso.constants.EMethod;
import ais.dpms.gsso.constants.EState;
import ais.dpms.gsso.instances.GSSOInstance;
import ais.dpms.gsso.message.groupbean.Resource;
import ais.dpms.gsso.message.imessage.IMessage;
import ais.dpms.gsso.utils.Generator;
import ais.dpms.gsso.utils.MessageUtils;
import ec02.data.enums.EEquinoxRawData.CTypeHTTP;
import phoebe.eqx.icarus.communication.Transmitter;
import phoebe.eqx.icarus.configuration.Config;
import phoebe.externalib.cauldron.eqx.log.DetailLog.Output;

public class SDFBuilder {
	
	private static int timeout = Config.getWarmConfigAsInt(EConfig.SDF_TIMEOUT.getConfigName());
	private static Resource resource = MessageUtils.getResource(Config.getWarmConfigAsString(EConfig.RESOURCE_NAME_SDF.getConfigName()));
	
	public static Output sendGetGupCommon(GSSOInstance gssoInstance, Transmitter transmitter, EState state, ECommand command, String keyName, String keyValue) {
		try {
			String invoke = Generator.generateInvoke(gssoInstance.getInitialSessionId(), command.toString());
			String url = "/v1/subscriber/" + keyName + "/" + keyValue + ".json?scope=sub";
			Map<String, String> attribute = new HashMap<>();
			attribute.put("url", url);
			attribute.put("method", EMethod.GET.getMethod());
			attribute.put("val", "");
			Output output = transmitter.sendHTTPRequestMessage(state.getStateName(), timeout, command.toString(), new IMessage(), CTypeHTTP.TEXT_PLAIN, invoke, resource.getService(), resource.getInstance(), attribute);
			return output;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return null;
	}
}
