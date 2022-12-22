package com.test.itron.xml;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vendReq")
public class IpayVendReq {
	
//	public IpayVendReq(String currency){
//		cur = currency;
//	}

	private String ref;
	private String amt;
	private String numTokens;
	private String meter;
	private String payType;
	
	private String cur;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getNumTokens() {
		return numTokens;
	}

	public void setNumTokens(String numTokens) {
		this.numTokens = numTokens;
	}

	public String getMeter() {
		return meter;
	}

	public void setMeter(String meter) {
		this.meter = meter;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getCur() {
		return cur;
	}

	public void setCur(String cur) {
		this.cur = cur;
	}
}
