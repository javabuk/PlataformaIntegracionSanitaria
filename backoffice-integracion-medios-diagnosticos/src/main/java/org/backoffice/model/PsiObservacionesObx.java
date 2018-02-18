package org.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PSI_OBSERVACIONES_OBX database table.
 * 
 */
@Entity
@Table(name="PSI_OBSERVACIONES_OBX")
@NamedQuery(name="PsiObservacionesObx.findAll", query="SELECT p FROM PsiObservacionesObx p")
public class PsiObservacionesObx implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PsiObservacionesObxPK id;

	@Column(name="ABNORMAL_FLAGS")
	private String abnormalFlags;

	@Column(name="OBSERVATION_CODING_SYSTEM")
	private String observationCodingSystem;

	@Temporal(TemporalType.DATE)
	@Column(name="OBSERVATION_DATETIME")
	private Date observationDatetime;

	@Column(name="OBSERVATION_IDENTIFIER")
	private String observationIdentifier;

	@Column(name="OBSERVATION_RESULT_STATUS")
	private String observationResultStatus;

	@Column(name="OBSERVATION_SUBID")
	private String observationSubid;

	@Column(name="OBSERVATION_TEXT")
	private String observationText;

	@Temporal(TemporalType.DATE)
	@Column(name="OBX5_DATETIME")
	private Date obx5Datetime;

	@Column(name="OBX5_NAMESPACE_ID")
	private String obx5NamespaceId;

	@Column(name="OBX5_UNIVERSAL_ID")
	private String obx5UniversalId;

	@Column(name="OBX5_UNIVERSAL_ID_TYPE")
	private String obx5UniversalIdType;

	@Column(name="PRODUCERS_ID")
	private String producersId;

	@Column(name="PRODUCERS_ID_COD_SYS")
	private String producersIdCodSys;

	@Column(name="PRODUCERS_ID_TEXT")
	private String producersIdText;

	@Column(name="REFERENCES_RANGE")
	private String referencesRange;

	@Column(name="RESP_OBSERVER_ID_NAMESP")
	private String respObserverIdNamesp;

	@Column(name="RESP_OBSERVER_ID_NUMBER")
	private String respObserverIdNumber;

	@Column(name="RESP_OBSERVER_ID_UNIV")
	private String respObserverIdUniv;

	@Column(name="RESP_OBSERVER_ID_UNIV_TYP")
	private String respObserverIdUnivTyp;

	@Column(name="RESP_OBSERVER_MOT_SURNAME")
	private String respObserverMotSurname;

	@Column(name="RESP_OBSERVER_NAME")
	private String respObserverName;

	@Column(name="RESP_OBSERVER_SURNAME")
	private String respObserverSurname;

	@Column(name="UNITS_CODING_SYSTEM")
	private String unitsCodingSystem;

	@Column(name="UNITS_ID")
	private String unitsId;

	@Column(name="UNITS_TEXT")
	private String unitsText;

	@Column(name="VALUE_TYPE")
	private String valueType;

	public PsiObservacionesObx() {
	}

	public PsiObservacionesObxPK getId() {
		return this.id;
	}

	public void setId(PsiObservacionesObxPK id) {
		this.id = id;
	}

	public String getAbnormalFlags() {
		return this.abnormalFlags;
	}

	public void setAbnormalFlags(String abnormalFlags) {
		this.abnormalFlags = abnormalFlags;
	}

	public String getObservationCodingSystem() {
		return this.observationCodingSystem;
	}

	public void setObservationCodingSystem(String observationCodingSystem) {
		this.observationCodingSystem = observationCodingSystem;
	}

	public Date getObservationDatetime() {
		return this.observationDatetime;
	}

	public void setObservationDatetime(Date observationDatetime) {
		this.observationDatetime = observationDatetime;
	}

	public String getObservationIdentifier() {
		return this.observationIdentifier;
	}

	public void setObservationIdentifier(String observationIdentifier) {
		this.observationIdentifier = observationIdentifier;
	}

	public String getObservationResultStatus() {
		return this.observationResultStatus;
	}

	public void setObservationResultStatus(String observationResultStatus) {
		this.observationResultStatus = observationResultStatus;
	}

	public String getObservationSubid() {
		return this.observationSubid;
	}

	public void setObservationSubid(String observationSubid) {
		this.observationSubid = observationSubid;
	}

	public String getObservationText() {
		return this.observationText;
	}

	public void setObservationText(String observationText) {
		this.observationText = observationText;
	}

	public Date getObx5Datetime() {
		return this.obx5Datetime;
	}

	public void setObx5Datetime(Date obx5Datetime) {
		this.obx5Datetime = obx5Datetime;
	}

	public String getObx5NamespaceId() {
		return this.obx5NamespaceId;
	}

	public void setObx5NamespaceId(String obx5NamespaceId) {
		this.obx5NamespaceId = obx5NamespaceId;
	}

	public String getObx5UniversalId() {
		return this.obx5UniversalId;
	}

	public void setObx5UniversalId(String obx5UniversalId) {
		this.obx5UniversalId = obx5UniversalId;
	}

	public String getObx5UniversalIdType() {
		return this.obx5UniversalIdType;
	}

	public void setObx5UniversalIdType(String obx5UniversalIdType) {
		this.obx5UniversalIdType = obx5UniversalIdType;
	}

	public String getProducersId() {
		return this.producersId;
	}

	public void setProducersId(String producersId) {
		this.producersId = producersId;
	}

	public String getProducersIdCodSys() {
		return this.producersIdCodSys;
	}

	public void setProducersIdCodSys(String producersIdCodSys) {
		this.producersIdCodSys = producersIdCodSys;
	}

	public String getProducersIdText() {
		return this.producersIdText;
	}

	public void setProducersIdText(String producersIdText) {
		this.producersIdText = producersIdText;
	}

	public String getReferencesRange() {
		return this.referencesRange;
	}

	public void setReferencesRange(String referencesRange) {
		this.referencesRange = referencesRange;
	}

	public String getRespObserverIdNamesp() {
		return this.respObserverIdNamesp;
	}

	public void setRespObserverIdNamesp(String respObserverIdNamesp) {
		this.respObserverIdNamesp = respObserverIdNamesp;
	}

	public String getRespObserverIdNumber() {
		return this.respObserverIdNumber;
	}

	public void setRespObserverIdNumber(String respObserverIdNumber) {
		this.respObserverIdNumber = respObserverIdNumber;
	}

	public String getRespObserverIdUniv() {
		return this.respObserverIdUniv;
	}

	public void setRespObserverIdUniv(String respObserverIdUniv) {
		this.respObserverIdUniv = respObserverIdUniv;
	}

	public String getRespObserverIdUnivTyp() {
		return this.respObserverIdUnivTyp;
	}

	public void setRespObserverIdUnivTyp(String respObserverIdUnivTyp) {
		this.respObserverIdUnivTyp = respObserverIdUnivTyp;
	}

	public String getRespObserverMotSurname() {
		return this.respObserverMotSurname;
	}

	public void setRespObserverMotSurname(String respObserverMotSurname) {
		this.respObserverMotSurname = respObserverMotSurname;
	}

	public String getRespObserverName() {
		return this.respObserverName;
	}

	public void setRespObserverName(String respObserverName) {
		this.respObserverName = respObserverName;
	}

	public String getRespObserverSurname() {
		return this.respObserverSurname;
	}

	public void setRespObserverSurname(String respObserverSurname) {
		this.respObserverSurname = respObserverSurname;
	}

	public String getUnitsCodingSystem() {
		return this.unitsCodingSystem;
	}

	public void setUnitsCodingSystem(String unitsCodingSystem) {
		this.unitsCodingSystem = unitsCodingSystem;
	}

	public String getUnitsId() {
		return this.unitsId;
	}

	public void setUnitsId(String unitsId) {
		this.unitsId = unitsId;
	}

	public String getUnitsText() {
		return this.unitsText;
	}

	public void setUnitsText(String unitsText) {
		this.unitsText = unitsText;
	}

	public String getValueType() {
		return this.valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

}