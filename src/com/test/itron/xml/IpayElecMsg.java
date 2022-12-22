package com.test.itron.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "elecMsg")
public class IpayElecMsg {

	
	private String ver;
	private IpayCustInfoReq custInfoReq;
	private IpayVendReq vendReq;
	@XmlAttribute(namespace = "2.44")
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public IpayCustInfoReq getCustInfoReq() {
		return custInfoReq;
	}
	public void setCustInfoReq(IpayCustInfoReq custInfoReq) {
		this.custInfoReq = custInfoReq;
	}
	public IpayVendReq getVendReq() {
		return vendReq;
	}
	public void setVendReq(IpayVendReq vendReq) {
		this.vendReq = vendReq;
	}
}
