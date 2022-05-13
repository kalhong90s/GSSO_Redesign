package ais.dpms.gsso.message.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBHandler {

	// IMPORT MESSAGE TO INSTANCE [ UNMARSHALLING ]
	public static Object createInstance(JAXBContext context, String message,
			Class<?> instanceClass) throws JAXBException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		Object instance = null;
		Unmarshaller unmarshaller;
		unmarshaller = context.createUnmarshaller();
		instance = Class.forName(instanceClass.getCanonicalName()).newInstance();
		instance = (Object) unmarshaller.unmarshal(new StringReader(message.trim()));
		return instance;
	}

	// EXPORT INSTANCE TO MESSAGE [ MARSHALLING ]
	public static String composeMessage(JAXBContext context, Object instance) throws JAXBException{
		StringWriter writer = new StringWriter();
		Marshaller marshaller;
		marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(instance, writer);
		return writer.toString();
	}

}
