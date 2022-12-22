package com.test.soapws;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

import com.test.itron.dom.IpayMessageDOM;
import com.test.itron.dom.IpayVendReqDOM;
import com.test.itron.xml.IpayCustInfoReq;
import com.test.itron.xml.IpayElecMsg;
import com.test.itron.xml.IpayMessage;

public class itronWSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket client = new Socket("41.204.194.188", 8983);
			
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			
//			IpayMessageDOM messageDOM = new IpayMessageDOM();
//			DOMSource source = messageDOM.writeIPayXML();
			IpayVendReqDOM vendDOM = new IpayVendReqDOM();
			DOMSource source = vendDOM.writeIPayXML();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter stringWriter = new StringWriter();
			transformer.transform(source, new StreamResult(stringWriter));
		
			MsgVLI vli = new MsgVLI();
			String stringMsg = stringWriter.toString();
			System.out.println(stringMsg);
			byte[] msgByte = stringMsg.getBytes();
			byte[] msg = vli.wrap(msgByte);
					
			out.write(msg);
			
			System.out.println("data sent");
			InputStream inFromServer = client.getInputStream();
			
			DataInputStream in = new DataInputStream(inFromServer);
			byte[] returned = vli.unWrap(inFromServer);
			String responseString = new String(returned);
			System.out.println(responseString);
			
			inFromServer.close();
			in.close();
			client.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException transConExp) {
			transConExp.printStackTrace();
			transConExp.getMessage();
		} catch (TransformerException transExp) {
			transExp.printStackTrace();
			transExp.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
