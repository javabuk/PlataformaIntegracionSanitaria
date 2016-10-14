package org.servicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.model.v25.segment.PID;
import ca.uhn.hl7v2.parser.Escaping;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.ParserConfiguration;

@Service
public class GeneracionHL7ServiceImpl implements GeneracionHL7Service {

	private final static Logger slf4jLogger = LoggerFactory.getLogger(GeneracionHL7ServiceImpl.class);
	
	@Override
	public String convertirMensajeOML(String sistemaOrigen, String sistemaDestino, String texto) {
		 try {
				// TODO Auto-generated method stub
				ADT_A01 adt = new ADT_A01();
				adt.initQuickstart("ADT", "A01", "P");

				
				// Populate the MSH Segment
				MSH mshSegment = adt.getMSH();
				
				mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue(sistemaOrigen);
				mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue(sistemaDestino);
				mshSegment.getMsh7_DateTimeOfMessage().getTs1_Time().setValue("20160627122000");
				//mshSegment.getSendingApplication().getNamespaceID().setValue("TestSendingSystem");
				//mshSegment.getSequenceNumber().setValue("123");
				
				
				
				// Populate the PID Segment
				PID pid = adt.getPID();
				pid.getPatientName(0).getFamilyName().getSurname().setValue("Doe");
				pid.getPatientName(0).getGivenName().setValue("John");
				//pid.getPatientIdentifierList(0).getID().setValue("123456");
				// Now, let's encode the message and look at the output
				HapiContext context = new DefaultHapiContext();
				//ParserConfiguration config = new ParserConfiguration();
				ParserConfiguration config = context.getParserConfiguration();
				Escaping escape = config.getEscaping();
				Parser parser = context.getPipeParser();
				String encodedMessage = parser.encode(adt);
				texto = encodedMessage;
				
				slf4jLogger.info(encodedMessage);
				slf4jLogger.info(replaceNewlines(encodedMessage));
				// Next, let's use the XML parser to encode as XML
				parser = context.getXMLParser();
				encodedMessage = parser.encode(adt);
				//texto = encodedMessage;
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		
		
		//texto = texto + " " + texto.toUpperCase();
		return texto;
	}
	
	private String replaceNewlines(String input) {
	    return input.replaceAll("\\r", "\n");
	}

}
