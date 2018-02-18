package org.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PSI_PRUEBAS_OBR database table.
 * 
 */
@Entity
@Table(name="PSI_PRUEBAS_OBR")
@NamedQuery(name="PsiPruebasObr.findAll", query="SELECT p FROM PsiPruebasObr p")
public class PsiPruebasObr implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PsiPruebasObrPK id;

	@Column(name="COLLECTOR_ID_NAMESPACE")
	private String collectorIdNamespace;

	@Column(name="COLLECTOR_ID_NUMBER")
	private String collectorIdNumber;

	@Column(name="COLLECTOR_ID_UNIVERSAL")
	private String collectorIdUniversal;

	@Column(name="COLLECTOR_ID_UNIVERSAL_TYPE")
	private String collectorIdUniversalType;

	@Column(name="COLLECTOR_MOTHER_SURNAME")
	private String collectorMotherSurname;

	@Column(name="COLLECTOR_NAME")
	private String collectorName;

	@Column(name="COLLECTOR_SURNAME")
	private String collectorSurname;

	@Column(name="DANGER_CODE_CODING_SYSTEM")
	private String dangerCodeCodingSystem;

	@Column(name="DANGER_CODE_ID")
	private String dangerCodeId;

	@Column(name="DANGER_CODE_TEXT")
	private String dangerCodeText;

	@Temporal(TemporalType.DATE)
	private Date enddatetime;

	@Column(name="FILLER_FIELD_1")
	private String fillerField1;

	@Column(name="FILLER_FIELD_2")
	private String fillerField2;

	@Column(name="FILLER_ORDER_NUMBER")
	private String fillerOrderNumber;

	@Column(name="FILLER_ORDER_SYSTEM")
	private String fillerOrderSystem;

	@Column(name="ID_OBR")
	private String idObr;

	@Temporal(TemporalType.DATE)
	@Column(name="INTERPRETER_END_TIME")
	private Date interpreterEndTime;

	@Column(name="INTERPRETER_ID")
	private String interpreterId;

	@Column(name="INTERPRETER_MOTHER_SURNAME")
	private String interpreterMotherSurname;

	@Column(name="INTERPRETER_NAME")
	private String interpreterName;

	@Column(name="INTERPRETER_NAMESPACE_ID")
	private String interpreterNamespaceId;

	@Column(name="INTERPRETER_SURNAME")
	private String interpreterSurname;

	@Temporal(TemporalType.DATE)
	@Column(name="OBSERVATION_DATETIME")
	private Date observationDatetime;

	@Column(name="ORD_PROV_ID_NAMESPACE")
	private String ordProvIdNamespace;

	@Column(name="ORD_PROV_ID_NUMBER")
	private String ordProvIdNumber;

	@Column(name="ORD_PROV_ID_UNIVERSAL")
	private String ordProvIdUniversal;

	@Column(name="ORD_PROV_ID_UNIVERSAL_TYPE")
	private String ordProvIdUniversalType;

	@Column(name="ORD_PROV_MOTHER_SURNAME")
	private String ordProvMotherSurname;

	@Column(name="ORD_PROV_NAME")
	private String ordProvName;

	@Column(name="ORD_PROV_SURNAME")
	private String ordProvSurname;

	@Column(name="ORDER_CALLBACK_PHONE_NUMBER")
	private String orderCallbackPhoneNumber;

	@Column(name="PARENT_FILLER_ID")
	private String parentFillerId;

	@Column(name="PARENT_FILLER_NAMESPACE")
	private String parentFillerNamespace;

	@Column(name="PARENT_FILLER_UNIV_ID")
	private String parentFillerUnivId;

	@Column(name="PARENT_FILLER_UNIV_TYPE_ID")
	private String parentFillerUnivTypeId;

	@Column(name="PARENT_OBSERVATION_CODING_SYS")
	private String parentObservationCodingSys;

	@Column(name="PARENT_OBSERVATION_ID")
	private String parentObservationId;

	@Column(name="PARENT_OBSERVATION_SUBID")
	private String parentObservationSubid;

	@Column(name="PARENT_OBSERVATION_TEXT")
	private String parentObservationText;

	@Column(name="PARENT_OBSERVATION_VALUE")
	private String parentObservationValue;

	@Column(name="PARENT_PLACER_ID")
	private String parentPlacerId;

	@Column(name="PARENT_PLACER_NAMESPACE")
	private String parentPlacerNamespace;

	@Column(name="PARENT_PLACER_UNIV_ID")
	private String parentPlacerUnivId;

	@Column(name="PARENT_PLACER_UNIV_TYPE_ID")
	private String parentPlacerUnivTypeId;

	@Column(name="PLACER_FIELD_1")
	private String placerField1;

	@Column(name="PLACER_FIELD_2")
	private String placerField2;

	@Column(name="PLACER_ORDER_NUMBER")
	private String placerOrderNumber;

	@Column(name="PLACER_ORDER_SYSTEM")
	private String placerOrderSystem;

	@Column(name="PPAL_RESULT_INTERP_ID_NAMESP")
	private String ppalResultInterpIdNamesp;

	@Column(name="PPAL_RESULT_INTERP_ID_NUMBER")
	private String ppalResultInterpIdNumber;

	@Column(name="PPAL_RESULT_INTERP_ID_UNIV")
	private String ppalResultInterpIdUniv;

	@Column(name="PPAL_RESULT_INTERP_ID_UNIV_TYP")
	private String ppalResultInterpIdUnivTyp;

	@Column(name="PPAL_RESULT_INTERP_MOT_SURNAME")
	private String ppalResultInterpMotSurname;

	@Column(name="PPAL_RESULT_INTERP_NAME")
	private String ppalResultInterpName;

	@Column(name="PPAL_RESULT_INTERP_SURNAME")
	private String ppalResultInterpSurname;

	private String priority;

	@Column(name="QUANTITY_TIMING")
	private String quantityTiming;

	@Column(name="REASON_STUDY_CODING_SYSTEM")
	private String reasonStudyCodingSystem;

	@Column(name="REASON_STUDY_ID")
	private String reasonStudyId;

	@Column(name="REASON_STUDY_TEXT")
	private String reasonStudyText;

	@Column(name="RELEVANT_CLINICAL_INFORMATION")
	private String relevantClinicalInformation;

	@Temporal(TemporalType.DATE)
	@Column(name="REQUESTED_DATETIME")
	private Date requestedDatetime;

	@Column(name="RESULT_STATUS")
	private String resultStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="RESULTS_CHANGE_STATE_DATETIME")
	private Date resultsChangeStateDatetime;

	@Temporal(TemporalType.DATE)
	@Column(name="SCHEDULED_DATETIME")
	private Date scheduledDatetime;

	@Column(name="SPECIMEN_ACTION_CODE")
	private String specimenActionCode;

	@Temporal(TemporalType.DATE)
	@Column(name="TECHNICIAN_END_TIME")
	private Date technicianEndTime;

	@Column(name="TECHNICIAN_ID")
	private String technicianId;

	@Column(name="TECHNICIAN_MOTHER_SURNAME")
	private String technicianMotherSurname;

	@Column(name="TECHNICIAN_NAME")
	private String technicianName;

	@Column(name="TECHNICIAN_NAMESPACE_ID")
	private String technicianNamespaceId;

	@Column(name="TECHNICIAN_SURNAME")
	private String technicianSurname;

	@Column(name="TRANSPORTATION_MODE")
	private String transportationMode;

	@Column(name="UNIVERSAL_SERVICE_IDENTIFIER")
	private String universalServiceIdentifier;

	@Column(name="UNIVERSAL_SERVICE_NAME_COD_SYS")
	private String universalServiceNameCodSys;

	@Column(name="UNIVERSAL_SERVICE_TEXT")
	private String universalServiceText;

	public PsiPruebasObr() {
	}

	public PsiPruebasObrPK getId() {
		return this.id;
	}

	public void setId(PsiPruebasObrPK id) {
		this.id = id;
	}

	public String getCollectorIdNamespace() {
		return this.collectorIdNamespace;
	}

	public void setCollectorIdNamespace(String collectorIdNamespace) {
		this.collectorIdNamespace = collectorIdNamespace;
	}

	public String getCollectorIdNumber() {
		return this.collectorIdNumber;
	}

	public void setCollectorIdNumber(String collectorIdNumber) {
		this.collectorIdNumber = collectorIdNumber;
	}

	public String getCollectorIdUniversal() {
		return this.collectorIdUniversal;
	}

	public void setCollectorIdUniversal(String collectorIdUniversal) {
		this.collectorIdUniversal = collectorIdUniversal;
	}

	public String getCollectorIdUniversalType() {
		return this.collectorIdUniversalType;
	}

	public void setCollectorIdUniversalType(String collectorIdUniversalType) {
		this.collectorIdUniversalType = collectorIdUniversalType;
	}

	public String getCollectorMotherSurname() {
		return this.collectorMotherSurname;
	}

	public void setCollectorMotherSurname(String collectorMotherSurname) {
		this.collectorMotherSurname = collectorMotherSurname;
	}

	public String getCollectorName() {
		return this.collectorName;
	}

	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}

	public String getCollectorSurname() {
		return this.collectorSurname;
	}

	public void setCollectorSurname(String collectorSurname) {
		this.collectorSurname = collectorSurname;
	}

	public String getDangerCodeCodingSystem() {
		return this.dangerCodeCodingSystem;
	}

	public void setDangerCodeCodingSystem(String dangerCodeCodingSystem) {
		this.dangerCodeCodingSystem = dangerCodeCodingSystem;
	}

	public String getDangerCodeId() {
		return this.dangerCodeId;
	}

	public void setDangerCodeId(String dangerCodeId) {
		this.dangerCodeId = dangerCodeId;
	}

	public String getDangerCodeText() {
		return this.dangerCodeText;
	}

	public void setDangerCodeText(String dangerCodeText) {
		this.dangerCodeText = dangerCodeText;
	}

	public Date getEnddatetime() {
		return this.enddatetime;
	}

	public void setEnddatetime(Date enddatetime) {
		this.enddatetime = enddatetime;
	}

	public String getFillerField1() {
		return this.fillerField1;
	}

	public void setFillerField1(String fillerField1) {
		this.fillerField1 = fillerField1;
	}

	public String getFillerField2() {
		return this.fillerField2;
	}

	public void setFillerField2(String fillerField2) {
		this.fillerField2 = fillerField2;
	}

	public String getFillerOrderNumber() {
		return this.fillerOrderNumber;
	}

	public void setFillerOrderNumber(String fillerOrderNumber) {
		this.fillerOrderNumber = fillerOrderNumber;
	}

	public String getFillerOrderSystem() {
		return this.fillerOrderSystem;
	}

	public void setFillerOrderSystem(String fillerOrderSystem) {
		this.fillerOrderSystem = fillerOrderSystem;
	}

	public String getIdObr() {
		return this.idObr;
	}

	public void setIdObr(String idObr) {
		this.idObr = idObr;
	}

	public Date getInterpreterEndTime() {
		return this.interpreterEndTime;
	}

	public void setInterpreterEndTime(Date interpreterEndTime) {
		this.interpreterEndTime = interpreterEndTime;
	}

	public String getInterpreterId() {
		return this.interpreterId;
	}

	public void setInterpreterId(String interpreterId) {
		this.interpreterId = interpreterId;
	}

	public String getInterpreterMotherSurname() {
		return this.interpreterMotherSurname;
	}

	public void setInterpreterMotherSurname(String interpreterMotherSurname) {
		this.interpreterMotherSurname = interpreterMotherSurname;
	}

	public String getInterpreterName() {
		return this.interpreterName;
	}

	public void setInterpreterName(String interpreterName) {
		this.interpreterName = interpreterName;
	}

	public String getInterpreterNamespaceId() {
		return this.interpreterNamespaceId;
	}

	public void setInterpreterNamespaceId(String interpreterNamespaceId) {
		this.interpreterNamespaceId = interpreterNamespaceId;
	}

	public String getInterpreterSurname() {
		return this.interpreterSurname;
	}

	public void setInterpreterSurname(String interpreterSurname) {
		this.interpreterSurname = interpreterSurname;
	}

	public Date getObservationDatetime() {
		return this.observationDatetime;
	}

	public void setObservationDatetime(Date observationDatetime) {
		this.observationDatetime = observationDatetime;
	}

	public String getOrdProvIdNamespace() {
		return this.ordProvIdNamespace;
	}

	public void setOrdProvIdNamespace(String ordProvIdNamespace) {
		this.ordProvIdNamespace = ordProvIdNamespace;
	}

	public String getOrdProvIdNumber() {
		return this.ordProvIdNumber;
	}

	public void setOrdProvIdNumber(String ordProvIdNumber) {
		this.ordProvIdNumber = ordProvIdNumber;
	}

	public String getOrdProvIdUniversal() {
		return this.ordProvIdUniversal;
	}

	public void setOrdProvIdUniversal(String ordProvIdUniversal) {
		this.ordProvIdUniversal = ordProvIdUniversal;
	}

	public String getOrdProvIdUniversalType() {
		return this.ordProvIdUniversalType;
	}

	public void setOrdProvIdUniversalType(String ordProvIdUniversalType) {
		this.ordProvIdUniversalType = ordProvIdUniversalType;
	}

	public String getOrdProvMotherSurname() {
		return this.ordProvMotherSurname;
	}

	public void setOrdProvMotherSurname(String ordProvMotherSurname) {
		this.ordProvMotherSurname = ordProvMotherSurname;
	}

	public String getOrdProvName() {
		return this.ordProvName;
	}

	public void setOrdProvName(String ordProvName) {
		this.ordProvName = ordProvName;
	}

	public String getOrdProvSurname() {
		return this.ordProvSurname;
	}

	public void setOrdProvSurname(String ordProvSurname) {
		this.ordProvSurname = ordProvSurname;
	}

	public String getOrderCallbackPhoneNumber() {
		return this.orderCallbackPhoneNumber;
	}

	public void setOrderCallbackPhoneNumber(String orderCallbackPhoneNumber) {
		this.orderCallbackPhoneNumber = orderCallbackPhoneNumber;
	}

	public String getParentFillerId() {
		return this.parentFillerId;
	}

	public void setParentFillerId(String parentFillerId) {
		this.parentFillerId = parentFillerId;
	}

	public String getParentFillerNamespace() {
		return this.parentFillerNamespace;
	}

	public void setParentFillerNamespace(String parentFillerNamespace) {
		this.parentFillerNamespace = parentFillerNamespace;
	}

	public String getParentFillerUnivId() {
		return this.parentFillerUnivId;
	}

	public void setParentFillerUnivId(String parentFillerUnivId) {
		this.parentFillerUnivId = parentFillerUnivId;
	}

	public String getParentFillerUnivTypeId() {
		return this.parentFillerUnivTypeId;
	}

	public void setParentFillerUnivTypeId(String parentFillerUnivTypeId) {
		this.parentFillerUnivTypeId = parentFillerUnivTypeId;
	}

	public String getParentObservationCodingSys() {
		return this.parentObservationCodingSys;
	}

	public void setParentObservationCodingSys(String parentObservationCodingSys) {
		this.parentObservationCodingSys = parentObservationCodingSys;
	}

	public String getParentObservationId() {
		return this.parentObservationId;
	}

	public void setParentObservationId(String parentObservationId) {
		this.parentObservationId = parentObservationId;
	}

	public String getParentObservationSubid() {
		return this.parentObservationSubid;
	}

	public void setParentObservationSubid(String parentObservationSubid) {
		this.parentObservationSubid = parentObservationSubid;
	}

	public String getParentObservationText() {
		return this.parentObservationText;
	}

	public void setParentObservationText(String parentObservationText) {
		this.parentObservationText = parentObservationText;
	}

	public String getParentObservationValue() {
		return this.parentObservationValue;
	}

	public void setParentObservationValue(String parentObservationValue) {
		this.parentObservationValue = parentObservationValue;
	}

	public String getParentPlacerId() {
		return this.parentPlacerId;
	}

	public void setParentPlacerId(String parentPlacerId) {
		this.parentPlacerId = parentPlacerId;
	}

	public String getParentPlacerNamespace() {
		return this.parentPlacerNamespace;
	}

	public void setParentPlacerNamespace(String parentPlacerNamespace) {
		this.parentPlacerNamespace = parentPlacerNamespace;
	}

	public String getParentPlacerUnivId() {
		return this.parentPlacerUnivId;
	}

	public void setParentPlacerUnivId(String parentPlacerUnivId) {
		this.parentPlacerUnivId = parentPlacerUnivId;
	}

	public String getParentPlacerUnivTypeId() {
		return this.parentPlacerUnivTypeId;
	}

	public void setParentPlacerUnivTypeId(String parentPlacerUnivTypeId) {
		this.parentPlacerUnivTypeId = parentPlacerUnivTypeId;
	}

	public String getPlacerField1() {
		return this.placerField1;
	}

	public void setPlacerField1(String placerField1) {
		this.placerField1 = placerField1;
	}

	public String getPlacerField2() {
		return this.placerField2;
	}

	public void setPlacerField2(String placerField2) {
		this.placerField2 = placerField2;
	}

	public String getPlacerOrderNumber() {
		return this.placerOrderNumber;
	}

	public void setPlacerOrderNumber(String placerOrderNumber) {
		this.placerOrderNumber = placerOrderNumber;
	}

	public String getPlacerOrderSystem() {
		return this.placerOrderSystem;
	}

	public void setPlacerOrderSystem(String placerOrderSystem) {
		this.placerOrderSystem = placerOrderSystem;
	}

	public String getPpalResultInterpIdNamesp() {
		return this.ppalResultInterpIdNamesp;
	}

	public void setPpalResultInterpIdNamesp(String ppalResultInterpIdNamesp) {
		this.ppalResultInterpIdNamesp = ppalResultInterpIdNamesp;
	}

	public String getPpalResultInterpIdNumber() {
		return this.ppalResultInterpIdNumber;
	}

	public void setPpalResultInterpIdNumber(String ppalResultInterpIdNumber) {
		this.ppalResultInterpIdNumber = ppalResultInterpIdNumber;
	}

	public String getPpalResultInterpIdUniv() {
		return this.ppalResultInterpIdUniv;
	}

	public void setPpalResultInterpIdUniv(String ppalResultInterpIdUniv) {
		this.ppalResultInterpIdUniv = ppalResultInterpIdUniv;
	}

	public String getPpalResultInterpIdUnivTyp() {
		return this.ppalResultInterpIdUnivTyp;
	}

	public void setPpalResultInterpIdUnivTyp(String ppalResultInterpIdUnivTyp) {
		this.ppalResultInterpIdUnivTyp = ppalResultInterpIdUnivTyp;
	}

	public String getPpalResultInterpMotSurname() {
		return this.ppalResultInterpMotSurname;
	}

	public void setPpalResultInterpMotSurname(String ppalResultInterpMotSurname) {
		this.ppalResultInterpMotSurname = ppalResultInterpMotSurname;
	}

	public String getPpalResultInterpName() {
		return this.ppalResultInterpName;
	}

	public void setPpalResultInterpName(String ppalResultInterpName) {
		this.ppalResultInterpName = ppalResultInterpName;
	}

	public String getPpalResultInterpSurname() {
		return this.ppalResultInterpSurname;
	}

	public void setPpalResultInterpSurname(String ppalResultInterpSurname) {
		this.ppalResultInterpSurname = ppalResultInterpSurname;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getQuantityTiming() {
		return this.quantityTiming;
	}

	public void setQuantityTiming(String quantityTiming) {
		this.quantityTiming = quantityTiming;
	}

	public String getReasonStudyCodingSystem() {
		return this.reasonStudyCodingSystem;
	}

	public void setReasonStudyCodingSystem(String reasonStudyCodingSystem) {
		this.reasonStudyCodingSystem = reasonStudyCodingSystem;
	}

	public String getReasonStudyId() {
		return this.reasonStudyId;
	}

	public void setReasonStudyId(String reasonStudyId) {
		this.reasonStudyId = reasonStudyId;
	}

	public String getReasonStudyText() {
		return this.reasonStudyText;
	}

	public void setReasonStudyText(String reasonStudyText) {
		this.reasonStudyText = reasonStudyText;
	}

	public String getRelevantClinicalInformation() {
		return this.relevantClinicalInformation;
	}

	public void setRelevantClinicalInformation(String relevantClinicalInformation) {
		this.relevantClinicalInformation = relevantClinicalInformation;
	}

	public Date getRequestedDatetime() {
		return this.requestedDatetime;
	}

	public void setRequestedDatetime(Date requestedDatetime) {
		this.requestedDatetime = requestedDatetime;
	}

	public String getResultStatus() {
		return this.resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Date getResultsChangeStateDatetime() {
		return this.resultsChangeStateDatetime;
	}

	public void setResultsChangeStateDatetime(Date resultsChangeStateDatetime) {
		this.resultsChangeStateDatetime = resultsChangeStateDatetime;
	}

	public Date getScheduledDatetime() {
		return this.scheduledDatetime;
	}

	public void setScheduledDatetime(Date scheduledDatetime) {
		this.scheduledDatetime = scheduledDatetime;
	}

	public String getSpecimenActionCode() {
		return this.specimenActionCode;
	}

	public void setSpecimenActionCode(String specimenActionCode) {
		this.specimenActionCode = specimenActionCode;
	}

	public Date getTechnicianEndTime() {
		return this.technicianEndTime;
	}

	public void setTechnicianEndTime(Date technicianEndTime) {
		this.technicianEndTime = technicianEndTime;
	}

	public String getTechnicianId() {
		return this.technicianId;
	}

	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}

	public String getTechnicianMotherSurname() {
		return this.technicianMotherSurname;
	}

	public void setTechnicianMotherSurname(String technicianMotherSurname) {
		this.technicianMotherSurname = technicianMotherSurname;
	}

	public String getTechnicianName() {
		return this.technicianName;
	}

	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}

	public String getTechnicianNamespaceId() {
		return this.technicianNamespaceId;
	}

	public void setTechnicianNamespaceId(String technicianNamespaceId) {
		this.technicianNamespaceId = technicianNamespaceId;
	}

	public String getTechnicianSurname() {
		return this.technicianSurname;
	}

	public void setTechnicianSurname(String technicianSurname) {
		this.technicianSurname = technicianSurname;
	}

	public String getTransportationMode() {
		return this.transportationMode;
	}

	public void setTransportationMode(String transportationMode) {
		this.transportationMode = transportationMode;
	}

	public String getUniversalServiceIdentifier() {
		return this.universalServiceIdentifier;
	}

	public void setUniversalServiceIdentifier(String universalServiceIdentifier) {
		this.universalServiceIdentifier = universalServiceIdentifier;
	}

	public String getUniversalServiceNameCodSys() {
		return this.universalServiceNameCodSys;
	}

	public void setUniversalServiceNameCodSys(String universalServiceNameCodSys) {
		this.universalServiceNameCodSys = universalServiceNameCodSys;
	}

	public String getUniversalServiceText() {
		return this.universalServiceText;
	}

	public void setUniversalServiceText(String universalServiceText) {
		this.universalServiceText = universalServiceText;
	}

}