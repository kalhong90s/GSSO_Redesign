package ais.dpms.gsso.message.imessage;

import ec02.data.interfaces.IMessageBuilder;
import ec02.exception.BuilderParserException;
import phoebe.eqx.icarus.json.JsonHandler;

public class IMessage implements IMessageBuilder{
	private String bodyMsg;
	
	@Override
	public String buildMessage() throws BuilderParserException {
		// TODO Auto-generated method stub
		if(bodyMsg == null) bodyMsg = "";
		return bodyMsg;
	}
	
	public IMessage(){
		if(bodyMsg == null) bodyMsg = "";
	}
	
	public IMessage(Object object){
		setBodyMsg(object);
	}
	
	public IMessage(String message){
		setBodyMsg(message);
	}

	public void setBodyMsg(Object object) {
		try {
			if(object == null) return;
			bodyMsg = JsonHandler.getStringJsonFromObject(object);
		} catch (Exception e) {
			
		}
	}
	
	public void setBodyMsg(String message) {
		if(message == null) return;
		bodyMsg = message;
	}
}