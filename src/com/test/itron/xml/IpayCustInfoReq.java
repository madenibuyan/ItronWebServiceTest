package com.test.itron.xml;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "custInfoReq")
public class IpayCustInfoReq {

	private String ref;
	private String meter;
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getMeter() {
		return meter;
	}
	public void setMeter(String meter) {
		this.meter = meter;
	}
	
}
