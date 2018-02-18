package org.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PSI_SOLICITUDES_SOL database table.
 * 
 */
@Entity
@Table(name="PSI_SOLICITUDES_SOL")
@NamedQuery(name="PsiSolicitudesSol.findAll", query="SELECT p FROM PsiSolicitudesSol p")
public class PsiSolicitudesSol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATETIME")
	private Date creationDatetime;

	@Column(name="MESSAGE_CODE")
	private String messageCode;

	@Column(name="MESSAGE_CONTROL_ID")
	private String messageControlId;

	@Temporal(TemporalType.DATE)
	@Column(name="MESSAGE_DATETIME")
	private Date messageDatetime;

	@Column(name="MESSAGE_TYPE")
	private String messageType;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFICATION_DATETIME")
	private Date modificationDatetime;

	@Column(name="PATIENT_ACC_ASS_AUTH_NAMESPID")
	private String patientAccAssAuthNamespid;

	@Column(name="PATIENT_ACC_ASS_AUTH_UNIVID")
	private String patientAccAssAuthUnivid;

	@Column(name="PATIENT_ACC_ASS_AUTH_UNIVIDTYP")
	private String patientAccAssAuthUnividtyp;

	@Column(name="PATIENT_ACC_ID_TYPE_CODE")
	private String patientAccIdTypeCode;

	@Column(name="PATIENT_ACC_NUMBER_ID_NUMBER")
	private String patientAccNumberIdNumber;

	@Column(name="PATIENT_ADDRESS_CITY")
	private String patientAddressCity;

	@Column(name="PATIENT_ADDRESS_COUNTRY")
	private String patientAddressCountry;

	@Column(name="PATIENT_ADDRESS_CP")
	private String patientAddressCp;

	@Column(name="PATIENT_ADDRESS_PROV")
	private String patientAddressProv;

	@Column(name="PATIENT_ADDRESS_STREET")
	private String patientAddressStreet;

	@Temporal(TemporalType.DATE)
	@Column(name="PATIENT_BIRTH_DATE")
	private Date patientBirthDate;

	@Column(name="PATIENT_MOTHER_SURNAME")
	private String patientMotherSurname;

	@Column(name="PATIENT_NAME")
	private String patientName;

	@Column(name="PATIENT_PHONE_NUMBER_1")
	private String patientPhoneNumber1;

	@Column(name="PATIENT_PHONE_NUMBER_2")
	private String patientPhoneNumber2;

	@Column(name="PATIENT_SEX")
	private String patientSex;

	@Column(name="PATIENT_SURNAME")
	private String patientSurname;

	@Column(name="RECEIVING_APPLICATION")
	private String receivingApplication;

	@Column(name="RECEIVING_ORGANIZATION")
	private String receivingOrganization;

	@Column(name="SENDING_APPLICATION")
	private String sendingApplication;

	@Column(name="SENDING_ORGANIZATION")
	private String sendingOrganization;

	@Column(name="TRIGGER_EVENT")
	private String triggerEvent;

	@Column(name="VERSION_ID")
	private String versionId;

	public PsiSolicitudesSol() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreationDatetime() {
		return this.creationDatetime;
	}

	public void setCreationDatetime(Date creationDatetime) {
		this.creationDatetime = creationDatetime;
	}

	public String getMessageCode() {
		return this.messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageControlId() {
		return this.messageControlId;
	}

	public void setMessageControlId(String messageControlId) {
		this.messageControlId = messageControlId;
	}

	public Date getMessageDatetime() {
		return this.messageDatetime;
	}

	public void setMessageDatetime(Date messageDatetime) {
		this.messageDatetime = messageDatetime;
	}

	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public Date getModificationDatetime() {
		return this.modificationDatetime;
	}

	public void setModificationDatetime(Date modificationDatetime) {
		this.modificationDatetime = modificationDatetime;
	}

	public String getPatientAccAssAuthNamespid() {
		return this.patientAccAssAuthNamespid;
	}

	public void setPatientAccAssAuthNamespid(String patientAccAssAuthNamespid) {
		this.patientAccAssAuthNamespid = patientAccAssAuthNamespid;
	}

	public String getPatientAccAssAuthUnivid() {
		return this.patientAccAssAuthUnivid;
	}

	public void setPatientAccAssAuthUnivid(String patientAccAssAuthUnivid) {
		this.patientAccAssAuthUnivid = patientAccAssAuthUnivid;
	}

	public String getPatientAccAssAuthUnividtyp() {
		return this.patientAccAssAuthUnividtyp;
	}

	public void setPatientAccAssAuthUnividtyp(String patientAccAssAuthUnividtyp) {
		this.patientAccAssAuthUnividtyp = patientAccAssAuthUnividtyp;
	}

	public String getPatientAccIdTypeCode() {
		return this.patientAccIdTypeCode;
	}

	public void setPatientAccIdTypeCode(String patientAccIdTypeCode) {
		this.patientAccIdTypeCode = patientAccIdTypeCode;
	}

	public String getPatientAccNumberIdNumber() {
		return this.patientAccNumberIdNumber;
	}

	public void setPatientAccNumberIdNumber(String patientAccNumberIdNumber) {
		this.patientAccNumberIdNumber = patientAccNumberIdNumber;
	}

	public String getPatientAddressCity() {
		return this.patientAddressCity;
	}

	public void setPatientAddressCity(String patientAddressCity) {
		this.patientAddressCity = patientAddressCity;
	}

	public String getPatientAddressCountry() {
		return this.patientAddressCountry;
	}

	public void setPatientAddressCountry(String patientAddressCountry) {
		this.patientAddressCountry = patientAddressCountry;
	}

	public String getPatientAddressCp() {
		return this.patientAddressCp;
	}

	public void setPatientAddressCp(String patientAddressCp) {
		this.patientAddressCp = patientAddressCp;
	}

	public String getPatientAddressProv() {
		return this.patientAddressProv;
	}

	public void setPatientAddressProv(String patientAddressProv) {
		this.patientAddressProv = patientAddressProv;
	}

	public String getPatientAddressStreet() {
		return this.patientAddressStreet;
	}

	public void setPatientAddressStreet(String patientAddressStreet) {
		this.patientAddressStreet = patientAddressStreet;
	}

	public Date getPatientBirthDate() {
		return this.patientBirthDate;
	}

	public void setPatientBirthDate(Date patientBirthDate) {
		this.patientBirthDate = patientBirthDate;
	}

	public String getPatientMotherSurname() {
		return this.patientMotherSurname;
	}

	public void setPatientMotherSurname(String patientMotherSurname) {
		this.patientMotherSurname = patientMotherSurname;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientPhoneNumber1() {
		return this.patientPhoneNumber1;
	}

	public void setPatientPhoneNumber1(String patientPhoneNumber1) {
		this.patientPhoneNumber1 = patientPhoneNumber1;
	}

	public String getPatientPhoneNumber2() {
		return this.patientPhoneNumber2;
	}

	public void setPatientPhoneNumber2(String patientPhoneNumber2) {
		this.patientPhoneNumber2 = patientPhoneNumber2;
	}

	public String getPatientSex() {
		return this.patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	public String getPatientSurname() {
		return this.patientSurname;
	}

	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}

	public String getReceivingApplication() {
		return this.receivingApplication;
	}

	public void setReceivingApplication(String receivingApplication) {
		this.receivingApplication = receivingApplication;
	}

	public String getReceivingOrganization() {
		return this.receivingOrganization;
	}

	public void setReceivingOrganization(String receivingOrganization) {
		this.receivingOrganization = receivingOrganization;
	}

	public String getSendingApplication() {
		return this.sendingApplication;
	}

	public void setSendingApplication(String sendingApplication) {
		this.sendingApplication = sendingApplication;
	}

	public String getSendingOrganization() {
		return this.sendingOrganization;
	}

	public void setSendingOrganization(String sendingOrganization) {
		this.sendingOrganization = sendingOrganization;
	}

	public String getTriggerEvent() {
		return this.triggerEvent;
	}

	public void setTriggerEvent(String triggerEvent) {
		this.triggerEvent = triggerEvent;
	}

	public String getVersionId() {
		return this.versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

}