package ais.dpms.gsso.message.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class InstanceContext {

//	private static JAXBContext accessReqContext;

	// AccessReg CONTEXT
//	public static synchronized void initAccessText() throws JAXBException {
//		if (accessReqContext == null)
//			accessReqContext = JAXBContext.newInstance(ResponseXML.class);
//	}

	public static JAXBContext getAccessReqContext(Class<?> instanceClass)  throws JAXBException{
//		if (accessReqContext == null)
//			accessReqContext = JAXBContext.newInstance(instanceClass);
//		return accessReqContext = JAXBContext.newInstance(instanceClass);
		return JAXBContext.newInstance(instanceClass);
	}

}
