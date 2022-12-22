package com.test.itron.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class IpayVendReqDOM {

public DOMSource writeIPayXML(){
		
		DOMSource source = null;
		
		try{
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			//root element
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement("ipayMsg");
			document.appendChild(rootElement);
			
			//(root element)ipayMsg attributes
			rootElement.setAttribute("client", "00001");
			rootElement.setAttribute("term", "00001");
			rootElement.setAttribute("seqNum", "0");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss +/-hhmm");
//			Date d = sdf.parse("2015-12-14 10:57:00 +0200"); //"2015-12-14 10:57:00 +0200"
//			System.out.println(d);
			rootElement.setAttribute("time", "2016-01-11 10:57:00 +0200");
			
			//elecMsg element
			Element elecMsgElement = document.createElement("elecMsg");
			rootElement.appendChild(elecMsgElement);
			
			//elecMsg attribute
			elecMsgElement.setAttribute("ver", "2.44");
			
			//customer info request element
			Element vendReqElement = document.createElement("vendReq");
			elecMsgElement.appendChild(vendReqElement);
			
			//element under vend request
			Element refElement = document.createElement("ref");
			refElement.appendChild(document.createTextNode("53610580006"));
			vendReqElement.appendChild(refElement);
			
			Element amtElement = document.createElement("amt");
			amtElement.appendChild(document.createTextNode("1000"));
			vendReqElement.appendChild(amtElement);
			amtElement.setAttribute("cur", "NGN");
			
			Element tokenElement = document.createElement("numTokens");
			tokenElement.appendChild(document.createTextNode("1"));
			vendReqElement.appendChild(tokenElement);
			
			Element meterElement = document.createElement("meter");
			meterElement.appendChild(document.createTextNode("90037438383"));
			vendReqElement.appendChild(meterElement);
			
			Element payTypeElement = document.createElement("payType");
			payTypeElement.appendChild(document.createTextNode("cash"));
			vendReqElement.appendChild(payTypeElement);
			
			//write the content into an xml DocSource
			source = new DOMSource(document);
			
			} catch(ParserConfigurationException pce){
				pce.getMessage();
//			} catch(ParseException pe){
//				pe.getMessage();
			}
		return source;
	}
}
