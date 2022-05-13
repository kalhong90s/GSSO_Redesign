package ais.dpms.gsso.message.groupbean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import phoebe.externalib.cauldron.eqx.log.LogDetailData;

@XmlRootElement(name = "sendOneTimePW")
@XmlAccessorType(XmlAccessType.FIELD)
public class SendOneTimePW {
	
	@LogDetailData
    private String msisdn;
	@LogDetailData
	private String otpChannel;
	@LogDetailData
    private String service;
	@LogDetailData
    private String accountType;
	@LogDetailData
    private String lifeTimeoutMins;
	@LogDetailData
    private String waitDR;
	@LogDetailData
    private String otpDigit;
	@LogDetailData
    private String refDigit;
	@LogDetailData
	private String emailAddr;
	@LogDetailData
	private String serviceKey;
	@LogDetailData
	private String sessionId;
	@LogDetailData
	private String refId;
    
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getOtpChannel() {
		return otpChannel;
	}
	public void setOtpChannel(String otpChannel) {
		this.otpChannel = otpChannel;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getLifeTimeoutMins() {
		return lifeTimeoutMins;
	}
	public void setLifeTimeoutMins(String lifeTimeoutMins) {
		this.lifeTimeoutMins = lifeTimeoutMins;
	}
	public String getWaitDR() {
		return waitDR;
	}
	public void setWaitDR(String waitDR) {
		this.waitDR = waitDR;
	}
	public String getOtpDigit() {
		return otpDigit;
	}
	public void setOtpDigit(String otpDigit) {
		this.otpDigit = otpDigit;
	}
	public String getRefDigit() {
		return refDigit;
	}
	public void setRefDigit(String refDigit) {
		this.refDigit = refDigit;
	}
    
}
