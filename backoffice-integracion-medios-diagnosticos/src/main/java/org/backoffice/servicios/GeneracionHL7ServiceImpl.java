package org.backoffice.servicios;

import java.io.IOException;

import org.backoffice.model.MensajeHL7;
import org.backoffice.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v25.datatype.ST;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.OMG_O19;
import ca.uhn.hl7v2.model.v25.message.OML_O21;
import ca.uhn.hl7v2.model.v25.message.QBP_Q11;
import ca.uhn.hl7v2.model.v25.segment.GT1;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.model.v25.segment.OBR;
import ca.uhn.hl7v2.model.v25.segment.ORC;
import ca.uhn.hl7v2.model.v25.segment.PID;
import ca.uhn.hl7v2.model.v25.segment.PV1;
import ca.uhn.hl7v2.model.v25.segment.QPD;
import ca.uhn.hl7v2.model.v25.segment.TQ1;
import ca.uhn.hl7v2.parser.Escaping;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.ParserConfiguration;

@Service
public class GeneracionHL7ServiceImpl implements GeneracionHL7Service {

	private final static Logger slf4jLogger = LoggerFactory.getLogger(GeneracionHL7ServiceImpl.class);

	public String convertirMensajeOML(String sistemaOrigen, String sistemaDestino, String texto) {
		try {
			// TODO Auto-generated method stub
			ADT_A01 adt = new ADT_A01();
			adt.initQuickstart("ADT", "A01", "P");

			// Populate the MSH Segment
			MSH mshSegment = adt.getMSH();
			mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue(sistemaOrigen);
			mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue(sistemaDestino);
			mshSegment.getMsh7_DateTimeOfMessage().getTs1_Time().setValue(Util.obtenerFechaActual());
			mshSegment.getMsh10_MessageControlID().setValue(Util.obtenerCorrelativo());
			mshSegment.getMsh11_ProcessingID().getPt1_ProcessingID().setValue("P");
			mshSegment.getMsh12_VersionID().getVid1_VersionID().setValue("2.5");

			// mshSegment.getSendingApplication().getNamespaceID().setValue("TestSendingSystem");
			// mshSegment.getSequenceNumber().setValue("123");

			// Populate the PID Segment
			PID pid = adt.getPID();
			pid.getPatientName(0).getFamilyName().getSurname().setValue("Doe");
			pid.getPatientName(0).getGivenName().setValue("John");
			// pid.getPatientIdentifierList(0).getID().setValue("123456");
			// Now, let's encode the message and look at the output
			HapiContext context = new DefaultHapiContext();
			// ParserConfiguration config = new ParserConfiguration();
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
			// texto = encodedMessage;
		} catch (Exception e) {
			// TODO: handle exception
		}

		// texto = texto + " " + texto.toUpperCase();
		return texto;
	}

	private String replaceNewlines(String input) {
		return input.replaceAll("\\r", "\n");
	}

	public String convertirMensajeOML(MensajeHL7 mensajeHL7) {
		String texto = "";
		try {
			// TODO Auto-generated method stub
			OML_O21 adt = new OML_O21();
			// ADT_A01 adt = new ADT_A01();
			adt.initQuickstart("OML", "O21", "P");
			// Segmento MSH
			MSH mshSegment = adt.getMSH();
			mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaDestino());
			mshSegment.getMsh7_DateTimeOfMessage().getTs1_Time().setValue(Util.obtenerFechaActual());
			mshSegment.getMsh10_MessageControlID().setValue(Util.obtenerCorrelativo());
			mshSegment.getMsh11_ProcessingID().getPt1_ProcessingID().setValue("P");
			mshSegment.getMsh12_VersionID().getVid1_VersionID().setValue("2.5");
			// Segmento PID
			PID pid = adt.getPATIENT().getPID();
			pid.getPid1_SetIDPID().setValue("1");
			pid.getPatientIdentifierList(0).getCx1_IDNumber().setValue(mensajeHL7.getNumeroTarjeta());
			// pid.getPatientIdentifierList(0).getCx4_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaTarjeta());
			pid.getPatientIdentifierList(0).getCx4_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());
			pid.getPatientIdentifierList(0).getCx5_IdentifierTypeCode().setValue("NUMTARJETA");

			pid.getPatientIdentifierList(1).getCx1_IDNumber().setValue(mensajeHL7.getDni());
			pid.getPatientIdentifierList(1).getCx4_AssigningAuthority().getHd1_NamespaceID().setValue("DNI");
			pid.getPatientIdentifierList(1).getCx5_IdentifierTypeCode().setValue("MI");

			pid.getPatientName(0).getXpn1_FamilyName().getSurname().setValue(mensajeHL7.getApellido1());
			pid.getPatientName(0).getXpn2_GivenName().setValue(mensajeHL7.getNombre());
			pid.getPid6_MotherSMaidenName(0).getXpn1_FamilyName().getFn1_Surname().setValue(mensajeHL7.getApellido2());

			pid.getPid7_DateTimeOfBirth().getTs1_Time().setValue(mensajeHL7.getFechaNacimiento());
			pid.getPid8_AdministrativeSex().setValue(mensajeHL7.getGenero());
			// Segmento PV1
			PV1 pv1 = adt.getPATIENT().getPATIENT_VISIT().getPV1();
			pv1.getSetIDPV1().setValue("1");
			pv1.getPv12_PatientClass().setValue(mensajeHL7.getTipoIngreso());

			pv1.getPv17_AttendingDoctor(0).getXcn1_IDNumber().setValue(mensajeHL7.getCodigoMedicoResponsable());
			pv1.getPv17_AttendingDoctor(0).getXcn2_FamilyName().getFn1_Surname()
					.setValue(mensajeHL7.getApellido1MedicoResponsable());
			pv1.getPv17_AttendingDoctor(0).getXcn3_GivenName().setValue(mensajeHL7.getNombreMedicoResponsable());
			pv1.getPv17_AttendingDoctor(0).getXcn4_SecondAndFurtherGivenNamesOrInitialsThereof()
					.setValue(mensajeHL7.getApellido2MedicoResponsable());
			// pv1.getPv17_AttendingDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			pv1.getPv17_AttendingDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());

			pv1.getPv18_ReferringDoctor(0).getXcn1_IDNumber().setValue(mensajeHL7.getCodigoMedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn2_FamilyName().getFn1_Surname()
					.setValue(mensajeHL7.getApellido1MedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn3_GivenName().setValue(mensajeHL7.getNombreMedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn4_SecondAndFurtherGivenNamesOrInitialsThereof()
					.setValue(mensajeHL7.getApellido2MedicoResponsable());
			// pv1.getPv18_ReferringDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaMedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());

			pv1.getPv110_HospitalService().setValue(mensajeHL7.getServicio());
			// Segmento GT1
			GT1 gt1 = adt.getPATIENT().getGT1();
			gt1.getGt11_SetIDGT1().setValue("1");
			gt1.getGt12_GuarantorNumber(0).getCx1_IDNumber().setValue(mensajeHL7.getCodigoGarante());
			// gt1.getGt12_GuarantorNumber(0).getCx4_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaGarante());
			gt1.getGt12_GuarantorNumber(0).getCx4_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());
			gt1.getGt13_GuarantorName(0).getXpn2_GivenName().setValue(mensajeHL7.getDescripcionGarante());
			gt1.getGt110_GuarantorType().setValue("GUARANTOR");
			// Segmento ORC
			ORC orc = adt.getORDER(0).getORC();
			orc.getOrc1_OrderControl().setValue("NW");
			orc.getOrc2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue(mensajeHL7.getIdPeticionarioPrueba());
			// orc.getOrc2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaPeticionarioPrueba());
			orc.getOrc2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			orc.getOrc3_FillerOrderNumber().getEi1_EntityIdentifier().setValue(mensajeHL7.getIdPeticionarioPeticion());
			// orc.getOrc3_FillerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaPeticionarioPeticion());
			orc.getOrc3_FillerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			orc.getOrc9_DateTimeOfTransaction().getTs1_Time().setValue(mensajeHL7.getFechaPeticion());
			orc.getOrc12_OrderingProvider(0).getXcn1_IDNumber().setValue(mensajeHL7.getCodigoMedicoPeticion());
			orc.getOrc12_OrderingProvider(0).getXcn2_FamilyName().getFn1_Surname()
					.setValue(mensajeHL7.getApellido1MedicoPeticion());
			orc.getOrc12_OrderingProvider(0).getXcn3_GivenName().setValue(mensajeHL7.getNombreMedicoPeticion());
			orc.getOrc12_OrderingProvider(0).getXcn4_SecondAndFurtherGivenNamesOrInitialsThereof()
					.setValue(mensajeHL7.getApellido2MedicoPeticion());
			// orc.getOrc12_OrderingProvider(0).getXcn9_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaMedicoPeticion());
			orc.getOrc12_OrderingProvider(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());
			orc.getOrc17_EnteringOrganization().getCe1_Identifier().setValue(mensajeHL7.getServicioPeticion());
			orc.getOrc17_EnteringOrganization().getCe2_Text().setValue(mensajeHL7.getDescripcionServicioPeticion());
			orc.getOrc17_EnteringOrganization().getCe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaOrigen());

			orc.getOrc21_OrderingFacilityName(0).getXon1_OrganizationName()
					.setValue(mensajeHL7.getDescripcionCentroPeticion());
			// orc.getOrc21_OrderingFacilityName(0).getXon6_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaCentroPeticion());
			orc.getOrc21_OrderingFacilityName(0).getXon6_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());
			orc.getOrc21_OrderingFacilityName(0).getXon10_OrganizationIdentifier()
					.setValue(mensajeHL7.getCodigoCentroPeticion());
			// Segmento TQ1
			TQ1 tq1 = adt.getORDER(0).getTIMING(0).getTQ1();
			tq1.getSetIDTQ1().setValue("1");
			tq1.getTq19_Priority(0).getCwe1_Identifier().setValue(mensajeHL7.getCodigoPrioridadPeticion());
			tq1.getTq19_Priority(0).getCwe2_Text().setValue(mensajeHL7.getDescripcionPrioridadPeticion());
			// tq1.getTq19_Priority(0).getCwe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaPrioridadPeticion());
			tq1.getTq19_Priority(0).getCwe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaOrigen());
			// Segmento OBR
			OBR obr = adt.getORDER(0).getOBSERVATION_REQUEST().getOBR();
			obr.getSetIDOBR().setValue("1");
			obr.getObr2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue(mensajeHL7.getIdPeticionarioPrueba());
			// obr.getObr2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaPeticionarioPrueba());
			obr.getObr2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			obr.getObr4_UniversalServiceIdentifier().getCe1_Identifier().setValue(mensajeHL7.getCodigoPrueba());
			obr.getObr4_UniversalServiceIdentifier().getCe2_Text().setValue(mensajeHL7.getDescripcionPrueba());
			// obr.getObr4_UniversalServiceIdentifier().getCe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaPrueba());
			obr.getObr4_UniversalServiceIdentifier().getCe3_NameOfCodingSystem()
					.setValue(mensajeHL7.getSistemaOrigen());

			obr.getObr16_OrderingProvider(0).getXcn1_IDNumber().setValue(mensajeHL7.getCodigoMedicoPeticion());
			obr.getObr16_OrderingProvider(0).getXcn2_FamilyName().getFn1_Surname()
					.setValue(mensajeHL7.getApellido1MedicoPeticion());
			obr.getObr16_OrderingProvider(0).getXcn3_GivenName().setValue(mensajeHL7.getNombreMedicoPeticion());
			obr.getObr16_OrderingProvider(0).getXcn4_SecondAndFurtherGivenNamesOrInitialsThereof()
					.setValue(mensajeHL7.getApellido2MedicoPeticion());
			obr.getObr16_OrderingProvider(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());

			HapiContext context = new DefaultHapiContext();
			// ParserConfiguration config = new ParserConfiguration();
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
			// texto = encodedMessage;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return texto;
	}

	
	public String convertirMensajeOMLIMQ(MensajeHL7 mensajeHL7) {
		String texto = "";
		try {
			// TODO Auto-generated method stub
			OML_O21 adt = new OML_O21();
			// ADT_A01 adt = new ADT_A01();
			adt.initQuickstart("OML", "O21", "P");
			// Segmento MSH
			MSH mshSegment = adt.getMSH();
			mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaDestino());
			mshSegment.getMsh7_DateTimeOfMessage().getTs1_Time().setValue(Util.obtenerFechaActual());
			mshSegment.getMsh10_MessageControlID().setValue(Util.obtenerCorrelativo());
			mshSegment.getMsh11_ProcessingID().getPt1_ProcessingID().setValue("P");
			mshSegment.getMsh12_VersionID().getVid1_VersionID().setValue("2.5");
			// Segmento PID
			PID pid = adt.getPATIENT().getPID();
			pid.getPid1_SetIDPID().setValue("1");
			pid.getPatientIdentifierList(0).getCx1_IDNumber().setValue(mensajeHL7.getNumeroTarjeta());
			// pid.getPatientIdentifierList(0).getCx4_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaTarjeta());
			pid.getPatientIdentifierList(0).getCx4_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getCodigoGarante());
			pid.getPatientIdentifierList(0).getCx5_IdentifierTypeCode().setValue("NUMTARJETA");

			pid.getPatientIdentifierList(1).getCx1_IDNumber().setValue(mensajeHL7.getDni());
			pid.getPatientIdentifierList(1).getCx4_AssigningAuthority().getHd1_NamespaceID().setValue("DNI");
			pid.getPatientIdentifierList(1).getCx5_IdentifierTypeCode().setValue("MI");

			pid.getPatientName(0).getXpn1_FamilyName().getSurname().setValue(mensajeHL7.getApellido1());
			pid.getPatientName(0).getXpn2_GivenName().setValue(mensajeHL7.getNombre());
			pid.getPid6_MotherSMaidenName(0).getXpn1_FamilyName().getFn1_Surname().setValue(mensajeHL7.getApellido2());

			pid.getPid7_DateTimeOfBirth().getTs1_Time().setValue(mensajeHL7.getFechaNacimiento());
			pid.getPid8_AdministrativeSex().setValue("M");
			// Segmento PV1
			PV1 pv1 = adt.getPATIENT().getPATIENT_VISIT().getPV1();
			pv1.getSetIDPV1().setValue("1");
			pv1.getPv12_PatientClass().setValue(mensajeHL7.getTipoIngreso());

			pv1.getPv114_AdmitSource().setValue("1");
			
			pv1.getPv17_AttendingDoctor(0).getXcn1_IDNumber().setValue(mensajeHL7.getCodigoMedicoResponsable());
			pv1.getPv17_AttendingDoctor(0).getXcn2_FamilyName().getFn1_Surname()
					.setValue(mensajeHL7.getApellido1MedicoResponsable());
			pv1.getPv17_AttendingDoctor(0).getXcn3_GivenName().setValue(mensajeHL7.getNombreMedicoResponsable());
			pv1.getPv17_AttendingDoctor(0).getXcn4_SecondAndFurtherGivenNamesOrInitialsThereof()
					.setValue(mensajeHL7.getApellido2MedicoResponsable());
			// pv1.getPv17_AttendingDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			pv1.getPv17_AttendingDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());

			pv1.getPv18_ReferringDoctor(0).getXcn1_IDNumber().setValue(mensajeHL7.getCodigoMedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn2_FamilyName().getFn1_Surname()
					.setValue(mensajeHL7.getApellido1MedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn3_GivenName().setValue(mensajeHL7.getNombreMedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn4_SecondAndFurtherGivenNamesOrInitialsThereof()
					.setValue(mensajeHL7.getApellido2MedicoResponsable());
			// pv1.getPv18_ReferringDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaMedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());

			pv1.getPv110_HospitalService().setValue(mensajeHL7.getServicio());
			// Segmento GT1
			GT1 gt1 = adt.getPATIENT().getGT1();
			gt1.getGt11_SetIDGT1().setValue("1");
			gt1.getGt12_GuarantorNumber(0).getCx1_IDNumber().setValue(mensajeHL7.getCodigoGarante());
			// gt1.getGt12_GuarantorNumber(0).getCx4_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaGarante());
			gt1.getGt12_GuarantorNumber(0).getCx4_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());
			gt1.getGt13_GuarantorName(0).getXpn2_GivenName().setValue(mensajeHL7.getDescripcionGarante());
			gt1.getGt110_GuarantorType().setValue("GUARANTOR");
			
			
			int idPeticionarioPrueba = Integer.parseInt(mensajeHL7.getIdPeticionarioPrueba());
			int idPeticionarioPeticion = Integer.parseInt(mensajeHL7.getIdPeticionarioPeticion());
			
			if(mensajeHL7.getPruebasLaboratorio() !=null && mensajeHL7.getPruebasLaboratorio().length>0){
				String [] codigosDescripion = mensajeHL7.getPruebasLaboratorio();
				for (int i = 0; i < codigosDescripion.length; i++) {
					String codigoDescripcion = codigosDescripion[i];
					if(codigoDescripcion.contains("-")){
						String [] valoresPruebas = codigoDescripcion.split("-");
						
						// Segmento ORC
						ORC orc = adt.getORDER(i).getORC();
						orc.getOrc1_OrderControl().setValue("NW");
						orc.getOrc2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue(Integer.toString(idPeticionarioPrueba));
						// orc.getOrc2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaPeticionarioPrueba());
						orc.getOrc2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
						
						orc.getOrc4_PlacerGroupNumber().getEi1_EntityIdentifier().setValue(Integer.toString(idPeticionarioPeticion));
						// orc.getOrc3_FillerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaPeticionarioPeticion());
						orc.getOrc4_PlacerGroupNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
						//orc.getOrc9_DateTimeOfTransaction().getTs1_Time().setValue(mensajeHL7.getFechaPeticion());
						orc.getOrc9_DateTimeOfTransaction().getTs1_Time().setValue(Util.obtenerFechaActual());

						orc.getOrc12_OrderingProvider(0).getXcn1_IDNumber().setValue("10431");
						orc.getOrc12_OrderingProvider(0).getXcn2_FamilyName().getFn1_Surname()
						.setValue("VILLANUEVA");
						orc.getOrc12_OrderingProvider(0).getXcn3_GivenName().setValue("MARTA");
						orc.getOrc12_OrderingProvider(0).getXcn4_SecondAndFurtherGivenNamesOrInitialsThereof()
						.setValue("VIELBA");
						// orc.getOrc12_OrderingProvider(0).getXcn9_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaMedicoPeticion());
						orc.getOrc12_OrderingProvider(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
						.setValue(mensajeHL7.getSistemaOrigen());
						orc.getOrc17_EnteringOrganization().getCe1_Identifier().setValue(mensajeHL7.getServicioPeticion());
						orc.getOrc17_EnteringOrganization().getCe2_Text().setValue(mensajeHL7.getDescripcionServicioPeticion());
						orc.getOrc17_EnteringOrganization().getCe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaOrigen());
						
						orc.getOrc21_OrderingFacilityName(0).getXon1_OrganizationName()
						.setValue("CENTRO COLON");
						// orc.getOrc21_OrderingFacilityName(0).getXon6_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaCentroPeticion());
						orc.getOrc21_OrderingFacilityName(0).getXon6_AssigningAuthority().getHd1_NamespaceID()
						.setValue(mensajeHL7.getSistemaOrigen());
						orc.getOrc21_OrderingFacilityName(0).getXon10_OrganizationIdentifier()
						.setValue("0606");
						// Segmento TQ1
						TQ1 tq1 = adt.getORDER(i).getTIMING(0).getTQ1();
						tq1.getSetIDTQ1().setValue("1");
						tq1.getTq19_Priority(0).getCwe1_Identifier().setValue("R");
						tq1.getTq19_Priority(0).getCwe2_Text().setValue("NORMAL");
						// tq1.getTq19_Priority(0).getCwe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaPrioridadPeticion());
						tq1.getTq19_Priority(0).getCwe3_NameOfCodingSystem().setValue("HL70485");
						// Segmento OBR
						OBR obr = adt.getORDER(i).getOBSERVATION_REQUEST().getOBR();
						obr.getSetIDOBR().setValue("1");
						obr.getObr2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue(Integer.toString(idPeticionarioPrueba));
						// obr.getObr2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaPeticionarioPrueba());
						obr.getObr2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
						obr.getObr4_UniversalServiceIdentifier().getCe1_Identifier().setValue(valoresPruebas[0]);
						obr.getObr4_UniversalServiceIdentifier().getCe2_Text().setValue(valoresPruebas[1]);
						// obr.getObr4_UniversalServiceIdentifier().getCe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaPrueba());
						obr.getObr4_UniversalServiceIdentifier().getCe3_NameOfCodingSystem()
						.setValue(mensajeHL7.getSistemaOrigen());
						
						obr.getObr16_OrderingProvider(0).getXcn1_IDNumber().setValue("10431");
						obr.getObr16_OrderingProvider(0).getXcn2_FamilyName().getFn1_Surname()
						.setValue("VILLANUEVA");
						obr.getObr16_OrderingProvider(0).getXcn3_GivenName().setValue("MARTA");
						obr.getObr16_OrderingProvider(0).getXcn4_SecondAndFurtherGivenNamesOrInitialsThereof()
						.setValue("VIELBA");
						obr.getObr16_OrderingProvider(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
						.setValue(mensajeHL7.getSistemaOrigen());
						
						idPeticionarioPrueba++;
						//idPeticionarioPeticion++;
					}
				}
			}
			
			
			
			

			HapiContext context = new DefaultHapiContext();
			// ParserConfiguration config = new ParserConfiguration();
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
			// texto = encodedMessage;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return texto;
	}
	
	public String convertirMensajeOMG(MensajeHL7 mensajeHL7) {
		String texto = "";
		try {
			// TODO Auto-generated method stub
			OMG_O19 adt = new OMG_O19();
			// ADT_A01 adt = new ADT_A01();
			adt.initQuickstart("OMG", "O19", "P");
			// Segmento MSH
			MSH mshSegment = adt.getMSH();
			mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaDestino());
			mshSegment.getMsh7_DateTimeOfMessage().getTs1_Time().setValue(Util.obtenerFechaActual());
			mshSegment.getMsh10_MessageControlID().setValue(Util.obtenerCorrelativo());
			mshSegment.getMsh11_ProcessingID().getPt1_ProcessingID().setValue("P");
			mshSegment.getMsh12_VersionID().getVid1_VersionID().setValue("2.5");
			// Segmento PID
			PID pid = adt.getPATIENT().getPID();
			pid.getPid1_SetIDPID().setValue("1");
			pid.getPatientIdentifierList(0).getCx1_IDNumber().setValue(mensajeHL7.getNumeroTarjeta());
			// pid.getPatientIdentifierList(0).getCx4_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaTarjeta());
			pid.getPatientIdentifierList(0).getCx4_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());
			pid.getPatientIdentifierList(0).getCx5_IdentifierTypeCode().setValue("NUMTARJETA");

			pid.getPatientIdentifierList(1).getCx1_IDNumber().setValue(mensajeHL7.getDni());
			pid.getPatientIdentifierList(1).getCx4_AssigningAuthority().getHd1_NamespaceID().setValue("DNI");
			pid.getPatientIdentifierList(1).getCx5_IdentifierTypeCode().setValue("MI");

			pid.getPatientName(0).getXpn1_FamilyName().getSurname().setValue(mensajeHL7.getApellido1());
			pid.getPatientName(0).getXpn2_GivenName().setValue(mensajeHL7.getNombre());
			pid.getPid6_MotherSMaidenName(0).getXpn1_FamilyName().getFn1_Surname().setValue(mensajeHL7.getApellido2());

			pid.getPid7_DateTimeOfBirth().getTs1_Time().setValue(mensajeHL7.getFechaNacimiento());
			pid.getPid8_AdministrativeSex().setValue(mensajeHL7.getGenero());
			// Segmento PV1
			PV1 pv1 = adt.getPATIENT().getPATIENT_VISIT().getPV1();
			pv1.getPv12_PatientClass().setValue(mensajeHL7.getTipoIngreso());

			pv1.getPv17_AttendingDoctor(0).getXcn1_IDNumber().setValue(mensajeHL7.getCodigoMedicoResponsable());
			pv1.getPv17_AttendingDoctor(0).getXcn2_FamilyName().getFn1_Surname()
					.setValue(mensajeHL7.getApellido1MedicoResponsable());
			pv1.getPv17_AttendingDoctor(0).getXcn3_GivenName().setValue(mensajeHL7.getApellido2MedicoResponsable());
			// pv1.getPv17_AttendingDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaMedicoResponsable());
			pv1.getPv17_AttendingDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());

			pv1.getPv18_ReferringDoctor(0).getXcn1_IDNumber().setValue(mensajeHL7.getCodigoMedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn2_FamilyName().getFn1_Surname()
					.setValue(mensajeHL7.getApellido1MedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn3_GivenName().setValue(mensajeHL7.getApellido2MedicoResponsable());
			// pv1.getPv18_ReferringDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaMedicoResponsable());
			pv1.getPv18_ReferringDoctor(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());

			pv1.getPv110_HospitalService().setValue(mensajeHL7.getServicio());
			// Segmento GT1
			GT1 gt1 = adt.getPATIENT().getGT1();
			gt1.getGt12_GuarantorNumber(0).getCx1_IDNumber().setValue(mensajeHL7.getCodigoGarante());
			// gt1.getGt12_GuarantorNumber(0).getCx4_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaGarante());
			gt1.getGt12_GuarantorNumber(0).getCx4_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());
			gt1.getGt13_GuarantorName(0).getXpn2_GivenName().setValue(mensajeHL7.getDescripcionGarante());
			gt1.getGt110_GuarantorType().setValue("GUARANTOR");
			// Segmento ORC
			ORC orc = adt.getORDER(0).getORC();
			orc.getOrc1_OrderControl().setValue("NW");
			orc.getOrc2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue(mensajeHL7.getIdPeticionarioPrueba());
			// orc.getOrc2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaPeticionarioPrueba());
			orc.getOrc2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			orc.getOrc3_FillerOrderNumber().getEi1_EntityIdentifier().setValue(mensajeHL7.getIdPeticionarioPeticion());
			// orc.getOrc3_FillerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaPeticionarioPeticion());
			orc.getOrc3_FillerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			orc.getOrc9_DateTimeOfTransaction().getTs1_Time().setValue(mensajeHL7.getFechaPeticion());
			orc.getOrc12_OrderingProvider(0).getXcn1_IDNumber().setValue(mensajeHL7.getCodigoMedicoPeticion());
			orc.getOrc12_OrderingProvider(0).getXcn2_FamilyName().getFn1_Surname()
					.setValue(mensajeHL7.getApellido1MedicoPeticion());
			orc.getOrc12_OrderingProvider(0).getXcn3_GivenName().setValue(mensajeHL7.getApellido2MedicoPeticion());
			// orc.getOrc12_OrderingProvider(0).getXcn9_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaMedicoPeticion());
			orc.getOrc12_OrderingProvider(0).getXcn9_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());
			orc.getOrc17_EnteringOrganization().getCe1_Identifier().setValue(mensajeHL7.getServicioPeticion());
			orc.getOrc21_OrderingFacilityName(0).getXon1_OrganizationName()
					.setValue(mensajeHL7.getDescripcionCentroPeticion());
			// orc.getOrc21_OrderingFacilityName(0).getXon6_AssigningAuthority().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaCentroPeticion());
			orc.getOrc21_OrderingFacilityName(0).getXon6_AssigningAuthority().getHd1_NamespaceID()
					.setValue(mensajeHL7.getSistemaOrigen());
			orc.getOrc21_OrderingFacilityName(0).getXon10_OrganizationIdentifier()
					.setValue(mensajeHL7.getCodigoCentroPeticion());
			// Segmento TQ1
			TQ1 tq1 = adt.getORDER(0).getTIMING(0).getTQ1();
			tq1.getTq19_Priority(0).getCwe1_Identifier().setValue(mensajeHL7.getCodigoPrioridadPeticion());
			tq1.getTq19_Priority(0).getCwe2_Text().setValue(mensajeHL7.getDescripcionPrioridadPeticion());
			// tq1.getTq19_Priority(0).getCwe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaPrioridadPeticion());
			tq1.getTq19_Priority(0).getCwe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaOrigen());
			// Segmento OBR
			OBR obr = adt.getORDER(0).getOBR();
			obr.getObr2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue(mensajeHL7.getIdPeticionarioPrueba());
			// obr.getObr2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaPeticionarioPrueba());
			obr.getObr2_PlacerOrderNumber().getEi2_NamespaceID().setValue(mensajeHL7.getSistemaOrigen());
			obr.getObr4_UniversalServiceIdentifier().getCe1_Identifier().setValue(mensajeHL7.getCodigoPrueba());
			obr.getObr4_UniversalServiceIdentifier().getCe2_Text().setValue(mensajeHL7.getDescripcionPrueba());
			// obr.getObr4_UniversalServiceIdentifier().getCe3_NameOfCodingSystem().setValue(mensajeHL7.getSistemaPrueba());
			obr.getObr4_UniversalServiceIdentifier().getCe3_NameOfCodingSystem()
					.setValue(mensajeHL7.getSistemaOrigen());

			HapiContext context = new DefaultHapiContext();
			// ParserConfiguration config = new ParserConfiguration();
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
			// texto = encodedMessage;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return texto;
	}

	public String generarConsultaPorDNI(MensajeHL7 mensajeHL7) {
		String texto = "";

		try {
			QBP_Q11 mensajeConsulta = new QBP_Q11();
			mensajeConsulta.initQuickstart("OML", "O21", "P");

			MSH mshSegment = mensajeConsulta.getMSH();
			mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue(mensajeHL7.getSistemaDestino());
			mshSegment.getMsh7_DateTimeOfMessage().getTs1_Time().setValue(Util.obtenerFechaActual());
			mshSegment.getMsh10_MessageControlID().setValue(Util.obtenerCorrelativo());
			mshSegment.getMsh11_ProcessingID().getPt1_ProcessingID().setValue("P");
			mshSegment.getMsh12_VersionID().getVid1_VersionID().setValue("2.5");

			QPD segmentoQPD = mensajeConsulta.getQPD();
			segmentoQPD.getQpd1_MessageQueryName().getCe1_Identifier().setValue("Z21");
			segmentoQPD.getQpd2_QueryTag().setValue("QP2");
			ST tipoST = new ST(mensajeConsulta);
			tipoST.setValue(String.format("%s\\S\\DNI||||%s", mensajeHL7.getDni(), mensajeHL7.getFechaNacimiento()));
			segmentoQPD.getQpd3_UserParametersInsuccessivefields().setData(tipoST);

			HapiContext context = new DefaultHapiContext();
			// ParserConfiguration config = new ParserConfiguration();
			ParserConfiguration config = context.getParserConfiguration();
			Escaping escape = config.getEscaping();
			Parser parser = context.getPipeParser();
			String encodedMessage = parser.encode(mensajeConsulta);
			String textoProcesado = encodedMessage;

			String textoReprocesado = textoProcesado.replace("\\E", "");
			texto = textoReprocesado.replace("\\F", "");

		} catch (DataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return texto;
	}

}
