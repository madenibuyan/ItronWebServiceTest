package com.test.itron.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ipayMsg")
public class IpayMessage {
	
//	public IpayMessage (String cClient, String cTerm, String cSeqNum, String cTime){
//		client = cClient;
//		term = cTerm;
//		seqNum = cSeqNum;
//		time = cTime;
//	}

	
	private String client;
	
	private String term;
	
	private String seqNum;
	
	private String time;
	private IpayElecMsg elecMsg;
	
	@XmlAttribute(namespace = "ipay", name = "client")
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	@XmlAttribute(namespace = "1")
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	@XmlAttribute(namespace = "2")
	public String getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}
	@XmlAttribute(namespace = "2015-12-14 10:57:00 +0200")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public IpayElecMsg getElecMsg() {
		return elecMsg;
	}
	public void setElecMsg(IpayElecMsg elecMsg) {
		this.elecMsg = elecMsg;
	}
}
