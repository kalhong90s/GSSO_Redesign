package ais.dpms.gsso.message.command;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import ais.dpms.gsso.message.groupbean.SendOneTimePW;
import phoebe.externalib.cauldron.eqx.log.LogDetailData;

@XmlRootElement(name = "sendOneTimePWRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class SendOneTimePasswordRequest {
	
	@LogDetailData
	private SendOneTimePW sendOneTimePW;

	public SendOneTimePW getSendOneTimePW() {
		return sendOneTimePW;
	}

	public void setSendOneTimePW(SendOneTimePW sendOneTimePW) {
		this.sendOneTimePW = sendOneTimePW;
	}
	
}
