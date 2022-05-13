package ais.dpms.gsso.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import ais.dpms.gsso.message.groupbean.Resource;
import ais.dpms.gsso.message.jaxb.InstanceContext;
import ais.dpms.gsso.message.jaxb.JAXBHandler;
import ec02.af.utils.AFLog;

public class MessageUtils {
	public static String createXmlStringFromObject(Class<?> instanceClass, Object object) {
		try {
			
			String xml = JAXBHandler.composeMessage(InstanceContext.getAccessReqContext(instanceClass), object);
			if (xml != null) {
	            xml = xml.replaceFirst("<\\?xml.+\\?>", "").trim();
	        }
			return xml.trim();
		} catch (JAXBException e) {
		}
		return "";
	}
	
	public static Object createObjectFromXmlString(String xmlString, Class<?> instanceClass) {
		try {
			Object object = Class.forName(instanceClass.getCanonicalName()).newInstance();
			object = JAXBHandler.createInstance(InstanceContext.getAccessReqContext(instanceClass), xmlString.trim(), instanceClass);
			return object;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static int indexOfStartWord(Pattern pattern, String message) {
		Matcher matcher = pattern.matcher(message);
		return matcher.find() ? matcher.start() : -1;
	}

	public static int indexOfEndWord(Pattern pattern, String message) {
		Matcher matcher = pattern.matcher(message);
		return matcher.find() ? matcher.end() : -1;
	}
	
	private static String repleceLifeTimeoutMins(final String findWord, final String message) {
		/* if 'addTimeoutMins' Convert To 'lifeTimeoutMins' */
		if (findWord.equals("addTimeoutMins")) {
			return "<lifeTimeoutMins>" + message + "</lifeTimeoutMins>";
		}
		else {
			return "<" + findWord + ">" + message + "</" + findWord + ">";
		}
	}
	
	public static String findXmlValue(final String findWord, final String message) {

		String soapIncoming;
		try {
			soapIncoming = message.substring(indexOfEndWord(Pattern.compile("<" + findWord), message),
					indexOfStartWord(Pattern.compile("</" + findWord + ">"), message));
			soapIncoming = soapIncoming.substring(soapIncoming.indexOf(">") + 1);

			soapIncoming = repleceLifeTimeoutMins(findWord, soapIncoming);

			return soapIncoming;
		}
		catch (Exception e) {}
		
		try {
			soapIncoming = message.substring(indexOfEndWord(Pattern.compile("<.*:" + findWord + " "), message),
					indexOfStartWord(Pattern.compile("</.*:" + findWord + ">"), message));
			soapIncoming = soapIncoming.substring(soapIncoming.indexOf(">") + 1);

			soapIncoming = repleceLifeTimeoutMins(findWord, soapIncoming);
			
			return soapIncoming;
		}
		catch (Exception e) {}
		
		try {
			soapIncoming = message.substring(indexOfEndWord(Pattern.compile("(<([a-z]|[A-Z])+:"+findWord+">)"), message),
					indexOfStartWord(Pattern.compile("</.*:" + findWord + ">"), message));

			soapIncoming = repleceLifeTimeoutMins(findWord, soapIncoming);

			return soapIncoming;
		}
		catch (Exception e) {
			return "";
		}
	}
	
	public static Resource getResource(String strResourceName){
		try{
			if(Validator.validateString(strResourceName)){
				
				String[] arrayStrSplit = strResourceName.split("\\.", -1);
				if(arrayStrSplit != null){
					Resource resourceObj = new Resource();
					if(arrayStrSplit.length > 0){
						resourceObj.setGroup(arrayStrSplit[0]);
					}
					if(arrayStrSplit.length > 1){
						resourceObj.setPotocal(arrayStrSplit[1]);
					}
					if(arrayStrSplit.length > 2){
						resourceObj.setService(arrayStrSplit[2]);
					}
					if(arrayStrSplit.length > 3){
						resourceObj.setInstance(arrayStrSplit[3]);
					}
					return resourceObj;
				}
			}
		}catch (Exception e) {
		}
		AFLog.d("cannot get resource name!!!");		
		return null;
	}
}
