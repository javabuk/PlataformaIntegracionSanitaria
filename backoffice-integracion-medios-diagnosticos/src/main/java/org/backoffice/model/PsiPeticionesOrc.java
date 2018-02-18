package org.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PSI_PETICIONES_ORC database table.
 * 
 */
@Entity
@Table(name="PSI_PETICIONES_ORC")
@NamedQuery(name="PsiPeticionesOrc.findAll", query="SELECT p FROM PsiPeticionesOrc p")
public class PsiPeticionesOrc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PsiPeticionesOrcPK id;

	@Column(name="CALL_BACK_NUMBER")
	private String callBackNumber;

	@Column(name="CANCEL_REASON_CODE")
	private String cancelReasonCode;

	@Column(name="CANCEL_REASON_SYS")
	private String cancelReasonSys;

	@Column(name="CANCEL_REASON_TEXT")
	private String cancelReasonText;

	@Column(name="CONDITION_TEXT")
	private String conditionText;

	private String conjunction;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE_TIME")
	private Date endDateTime;

	@Column(name="ENTER_LOCAT_BED")
	private String enterLocatBed;

	@Column(name="ENTER_LOCAT_FAC_NAMESPACEID")
	private String enterLocatFacNamespaceid;

	@Column(name="ENTER_LOCAT_FAC_UNIVERSALID")
	private String enterLocatFacUniversalid;

	@Column(name="ENTER_LOCAT_FAC_UNIVIDTYPE")
	private String enterLocatFacUnividtype;

	@Column(name="ENTER_LOCAT_POINTOFCARE")
	private String enterLocatPointofcare;

	@Column(name="ENTER_LOCAT_ROOM")
	private String enterLocatRoom;

	@Column(name="ENTERED_BY")
	private String enteredBy;

	@Column(name="ENTERED_BY_FAMILYNAME")
	private String enteredByFamilyname;

	@Column(name="ENTERED_BY_GIVENNAME")
	private String enteredByGivenname;

	@Column(name="ENTERED_BY_MOTHERSURNAME")
	private String enteredByMothersurname;

	@Column(name="ENTERING_ORGANIZATION_COD_SYS")
	private String enteringOrganizationCodSys;

	@Column(name="ENTERING_ORGANIZATION_ID")
	private String enteringOrganizationId;

	@Column(name="ENTERING_ORGANIZATION_TEXT")
	private String enteringOrganizationText;

	@Column(name="EXPLICIT_TIME")
	private String explicitTime;

	@Temporal(TemporalType.DATE)
	@Column(name="FILLER_EXPECTABLE_AVAILABILITY")
	private Date fillerExpectableAvailability;

	@Column(name="FILLER_ORDER_NUMBER")
	private String fillerOrderNumber;

	@Column(name="FILLER_ORDER_SYSTEM")
	private String fillerOrderSystem;

	@Column(name="ID_TQ1")
	private String idTq1;

	@Column(name="OCC_DURATION")
	private String occDuration;

	@Column(name="OCC_DURATION_UNITS_CODSYSTEM")
	private String occDurationUnitsCodsystem;

	@Column(name="OCC_DURATION_UNITS_ID")
	private String occDurationUnitsId;

	@Column(name="OCC_DURATION_UNITS_TEXT")
	private String occDurationUnitsText;

	@Column(name="ORD_PROV_ID_NUMBER")
	private String ordProvIdNumber;

	@Column(name="ORD_PROV_MOTHER_SURNAME")
	private String ordProvMotherSurname;

	@Column(name="ORD_PROV_NAME")
	private String ordProvName;

	@Column(name="ORD_PROV_NAMESPACE_ID")
	private String ordProvNamespaceId;

	@Column(name="ORD_PROV_SURNAME")
	private String ordProvSurname;

	@Column(name="ORDER_CONTROL")
	private String orderControl;

	@Column(name="ORDER_CONTROL_CODE_REASON")
	private String orderControlCodeReason;

	@Column(name="ORDER_CONTROL_CODE_REASON_ID")
	private String orderControlCodeReasonId;

	@Column(name="ORDER_STATUS")
	private String orderStatus;

	@Column(name="ORDER_STATUS_MOD_COD_SYS")
	private String orderStatusModCodSys;

	@Column(name="ORDER_STATUS_MOD_ID")
	private String orderStatusModId;

	@Column(name="ORDER_STATUS_MOD_TEXT")
	private String orderStatusModText;

	@Column(name="ORDER_TYPE_CODING_SYSTEM")
	private String orderTypeCodingSystem;

	@Column(name="ORDER_TYPE_ID")
	private String orderTypeId;

	@Column(name="ORDER_TYPE_TEXT")
	private String orderTypeText;

	@Column(name="ORDERING_FACILITY_IDENTIFIER")
	private String orderingFacilityIdentifier;

	@Column(name="ORDERING_FACILITY_NAME")
	private String orderingFacilityName;

	@Column(name="ORDERING_FACILITY_NAMESPACE_ID")
	private String orderingFacilityNamespaceId;

	@Column(name="PLACER_GROUP_NUMBER_ID")
	private String placerGroupNumberId;

	@Column(name="PLACER_GROUP_NUMBER_NAMESPACE")
	private String placerGroupNumberNamespace;

	@Column(name="PLACER_ORDER_NUMBER")
	private String placerOrderNumber;

	@Column(name="PLACER_ORDER_SYSTEM")
	private String placerOrderSystem;

	@Column(name="PRIORITY_IDENTIFIER")
	private String priorityIdentifier;

	@Column(name="PRIORITY_NAMESPACE")
	private String priorityNamespace;

	@Column(name="PRIORITY_TEXT")
	private String priorityText;

	private String quantity;

	@Column(name="QUANTITY_TIMING")
	private String quantityTiming;

	@Column(name="QUANTITY_UNITS_CODING_SYSTEM")
	private String quantityUnitsCodingSystem;

	@Column(name="QUANTITY_UNITS_ID")
	private String quantityUnitsId;

	@Column(name="QUANTITY_UNITS_TEXT")
	private String quantityUnitsText;

	@Column(name="RELATIVE_TIME")
	private String relativeTime;

	@Column(name="RELATIVE_TIME_UNITS_CODSYSTEM")
	private String relativeTimeUnitsCodsystem;

	@Column(name="RELATIVE_TIME_UNITS_ID")
	private String relativeTimeUnitsId;

	@Column(name="RELATIVE_TIME_UNITS_TEXT")
	private String relativeTimeUnitsText;

	@Column(name="SERVICE_DURATION")
	private String serviceDuration;

	@Column(name="SERVICE_DURATION_UNITS_CODSYS")
	private String serviceDurationUnitsCodsys;

	@Column(name="SERVICE_DURATION_UNITS_ID")
	private String serviceDurationUnitsId;

	@Column(name="SERVICE_DURATION_UNITS_TEXT")
	private String serviceDurationUnitsText;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE_TIME")
	private Date startDateTime;

	@Column(name="TEXT_INSTRUCTION")
	private String textInstruction;

	@Column(name="TOTAL_OCCURRENCES")
	private String totalOccurrences;

	@Temporal(TemporalType.DATE)
	@Column(name="TRANSACTION_DATETIME")
	private Date transactionDatetime;

	public PsiPeticionesOrc() {
	}

	public PsiPeticionesOrcPK getId() {
		return this.id;
	}

	public void setId(PsiPeticionesOrcPK id) {
		this.id = id;
	}

	public String getCallBackNumber() {
		return this.callBackNumber;
	}

	public void setCallBackNumber(String callBackNumber) {
		this.callBackNumber = callBackNumber;
	}

	public String getCancelReasonCode() {
		return this.cancelReasonCode;
	}

	public void setCancelReasonCode(String cancelReasonCode) {
		this.cancelReasonCode = cancelReasonCode;
	}

	public String getCancelReasonSys() {
		return this.cancelReasonSys;
	}

	public void setCancelReasonSys(String cancelReasonSys) {
		this.cancelReasonSys = cancelReasonSys;
	}

	public String getCancelReasonText() {
		return this.cancelReasonText;
	}

	public void setCancelReasonText(String cancelReasonText) {
		this.cancelReasonText = cancelReasonText;
	}

	public String getConditionText() {
		return this.conditionText;
	}

	public void setConditionText(String conditionText) {
		this.conditionText = conditionText;
	}

	public String getConjunction() {
		return this.conjunction;
	}

	public void setConjunction(String conjunction) {
		this.conjunction = conjunction;
	}

	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getEnterLocatBed() {
		return this.enterLocatBed;
	}

	public void setEnterLocatBed(String enterLocatBed) {
		this.enterLocatBed = enterLocatBed;
	}

	public String getEnterLocatFacNamespaceid() {
		return this.enterLocatFacNamespaceid;
	}

	public void setEnterLocatFacNamespaceid(String enterLocatFacNamespaceid) {
		this.enterLocatFacNamespaceid = enterLocatFacNamespaceid;
	}

	public String getEnterLocatFacUniversalid() {
		return this.enterLocatFacUniversalid;
	}

	public void setEnterLocatFacUniversalid(String enterLocatFacUniversalid) {
		this.enterLocatFacUniversalid = enterLocatFacUniversalid;
	}

	public String getEnterLocatFacUnividtype() {
		return this.enterLocatFacUnividtype;
	}

	public void setEnterLocatFacUnividtype(String enterLocatFacUnividtype) {
		this.enterLocatFacUnividtype = enterLocatFacUnividtype;
	}

	public String getEnterLocatPointofcare() {
		return this.enterLocatPointofcare;
	}

	public void setEnterLocatPointofcare(String enterLocatPointofcare) {
		this.enterLocatPointofcare = enterLocatPointofcare;
	}

	public String getEnterLocatRoom() {
		return this.enterLocatRoom;
	}

	public void setEnterLocatRoom(String enterLocatRoom) {
		this.enterLocatRoom = enterLocatRoom;
	}

	public String getEnteredBy() {
		return this.enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public String getEnteredByFamilyname() {
		return this.enteredByFamilyname;
	}

	public void setEnteredByFamilyname(String enteredByFamilyname) {
		this.enteredByFamilyname = enteredByFamilyname;
	}

	public String getEnteredByGivenname() {
		return this.enteredByGivenname;
	}

	public void setEnteredByGivenname(String enteredByGivenname) {
		this.enteredByGivenname = enteredByGivenname;
	}

	public String getEnteredByMothersurname() {
		return this.enteredByMothersurname;
	}

	public void setEnteredByMothersurname(String enteredByMothersurname) {
		this.enteredByMothersurname = enteredByMothersurname;
	}

	public String getEnteringOrganizationCodSys() {
		return this.enteringOrganizationCodSys;
	}

	public void setEnteringOrganizationCodSys(String enteringOrganizationCodSys) {
		this.enteringOrganizationCodSys = enteringOrganizationCodSys;
	}

	public String getEnteringOrganizationId() {
		return this.enteringOrganizationId;
	}

	public void setEnteringOrganizationId(String enteringOrganizationId) {
		this.enteringOrganizationId = enteringOrganizationId;
	}

	public String getEnteringOrganizationText() {
		return this.enteringOrganizationText;
	}

	public void setEnteringOrganizationText(String enteringOrganizationText) {
		this.enteringOrganizationText = enteringOrganizationText;
	}

	public String getExplicitTime() {
		return this.explicitTime;
	}

	public void setExplicitTime(String explicitTime) {
		this.explicitTime = explicitTime;
	}

	public Date getFillerExpectableAvailability() {
		return this.fillerExpectableAvailability;
	}

	public void setFillerExpectableAvailability(Date fillerExpectableAvailability) {
		this.fillerExpectableAvailability = fillerExpectableAvailability;
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

	public String getIdTq1() {
		return this.idTq1;
	}

	public void setIdTq1(String idTq1) {
		this.idTq1 = idTq1;
	}

	public String getOccDuration() {
		return this.occDuration;
	}

	public void setOccDuration(String occDuration) {
		this.occDuration = occDuration;
	}

	public String getOccDurationUnitsCodsystem() {
		return this.occDurationUnitsCodsystem;
	}

	public void setOccDurationUnitsCodsystem(String occDurationUnitsCodsystem) {
		this.occDurationUnitsCodsystem = occDurationUnitsCodsystem;
	}

	public String getOccDurationUnitsId() {
		return this.occDurationUnitsId;
	}

	public void setOccDurationUnitsId(String occDurationUnitsId) {
		this.occDurationUnitsId = occDurationUnitsId;
	}

	public String getOccDurationUnitsText() {
		return this.occDurationUnitsText;
	}

	public void setOccDurationUnitsText(String occDurationUnitsText) {
		this.occDurationUnitsText = occDurationUnitsText;
	}

	public String getOrdProvIdNumber() {
		return this.ordProvIdNumber;
	}

	public void setOrdProvIdNumber(String ordProvIdNumber) {
		this.ordProvIdNumber = ordProvIdNumber;
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

	public String getOrdProvNamespaceId() {
		return this.ordProvNamespaceId;
	}

	public void setOrdProvNamespaceId(String ordProvNamespaceId) {
		this.ordProvNamespaceId = ordProvNamespaceId;
	}

	public String getOrdProvSurname() {
		return this.ordProvSurname;
	}

	public void setOrdProvSurname(String ordProvSurname) {
		this.ordProvSurname = ordProvSurname;
	}

	public String getOrderControl() {
		return this.orderControl;
	}

	public void setOrderControl(String orderControl) {
		this.orderControl = orderControl;
	}

	public String getOrderControlCodeReason() {
		return this.orderControlCodeReason;
	}

	public void setOrderControlCodeReason(String orderControlCodeReason) {
		this.orderControlCodeReason = orderControlCodeReason;
	}

	public String getOrderControlCodeReasonId() {
		return this.orderControlCodeReasonId;
	}

	public void setOrderControlCodeReasonId(String orderControlCodeReasonId) {
		this.orderControlCodeReasonId = orderControlCodeReasonId;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusModCodSys() {
		return this.orderStatusModCodSys;
	}

	public void setOrderStatusModCodSys(String orderStatusModCodSys) {
		this.orderStatusModCodSys = orderStatusModCodSys;
	}

	public String getOrderStatusModId() {
		return this.orderStatusModId;
	}

	public void setOrderStatusModId(String orderStatusModId) {
		this.orderStatusModId = orderStatusModId;
	}

	public String getOrderStatusModText() {
		return this.orderStatusModText;
	}

	public void setOrderStatusModText(String orderStatusModText) {
		this.orderStatusModText = orderStatusModText;
	}

	public String getOrderTypeCodingSystem() {
		return this.orderTypeCodingSystem;
	}

	public void setOrderTypeCodingSystem(String orderTypeCodingSystem) {
		this.orderTypeCodingSystem = orderTypeCodingSystem;
	}

	public String getOrderTypeId() {
		return this.orderTypeId;
	}

	public void setOrderTypeId(String orderTypeId) {
		this.orderTypeId = orderTypeId;
	}

	public String getOrderTypeText() {
		return this.orderTypeText;
	}

	public void setOrderTypeText(String orderTypeText) {
		this.orderTypeText = orderTypeText;
	}

	public String getOrderingFacilityIdentifier() {
		return this.orderingFacilityIdentifier;
	}

	public void setOrderingFacilityIdentifier(String orderingFacilityIdentifier) {
		this.orderingFacilityIdentifier = orderingFacilityIdentifier;
	}

	public String getOrderingFacilityName() {
		return this.orderingFacilityName;
	}

	public void setOrderingFacilityName(String orderingFacilityName) {
		this.orderingFacilityName = orderingFacilityName;
	}

	public String getOrderingFacilityNamespaceId() {
		return this.orderingFacilityNamespaceId;
	}

	public void setOrderingFacilityNamespaceId(String orderingFacilityNamespaceId) {
		this.orderingFacilityNamespaceId = orderingFacilityNamespaceId;
	}

	public String getPlacerGroupNumberId() {
		return this.placerGroupNumberId;
	}

	public void setPlacerGroupNumberId(String placerGroupNumberId) {
		this.placerGroupNumberId = placerGroupNumberId;
	}

	public String getPlacerGroupNumberNamespace() {
		return this.placerGroupNumberNamespace;
	}

	public void setPlacerGroupNumberNamespace(String placerGroupNumberNamespace) {
		this.placerGroupNumberNamespace = placerGroupNumberNamespace;
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

	public String getPriorityIdentifier() {
		return this.priorityIdentifier;
	}

	public void setPriorityIdentifier(String priorityIdentifier) {
		this.priorityIdentifier = priorityIdentifier;
	}

	public String getPriorityNamespace() {
		return this.priorityNamespace;
	}

	public void setPriorityNamespace(String priorityNamespace) {
		this.priorityNamespace = priorityNamespace;
	}

	public String getPriorityText() {
		return this.priorityText;
	}

	public void setPriorityText(String priorityText) {
		this.priorityText = priorityText;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getQuantityTiming() {
		return this.quantityTiming;
	}

	public void setQuantityTiming(String quantityTiming) {
		this.quantityTiming = quantityTiming;
	}

	public String getQuantityUnitsCodingSystem() {
		return this.quantityUnitsCodingSystem;
	}

	public void setQuantityUnitsCodingSystem(String quantityUnitsCodingSystem) {
		this.quantityUnitsCodingSystem = quantityUnitsCodingSystem;
	}

	public String getQuantityUnitsId() {
		return this.quantityUnitsId;
	}

	public void setQuantityUnitsId(String quantityUnitsId) {
		this.quantityUnitsId = quantityUnitsId;
	}

	public String getQuantityUnitsText() {
		return this.quantityUnitsText;
	}

	public void setQuantityUnitsText(String quantityUnitsText) {
		this.quantityUnitsText = quantityUnitsText;
	}

	public String getRelativeTime() {
		return this.relativeTime;
	}

	public void setRelativeTime(String relativeTime) {
		this.relativeTime = relativeTime;
	}

	public String getRelativeTimeUnitsCodsystem() {
		return this.relativeTimeUnitsCodsystem;
	}

	public void setRelativeTimeUnitsCodsystem(String relativeTimeUnitsCodsystem) {
		this.relativeTimeUnitsCodsystem = relativeTimeUnitsCodsystem;
	}

	public String getRelativeTimeUnitsId() {
		return this.relativeTimeUnitsId;
	}

	public void setRelativeTimeUnitsId(String relativeTimeUnitsId) {
		this.relativeTimeUnitsId = relativeTimeUnitsId;
	}

	public String getRelativeTimeUnitsText() {
		return this.relativeTimeUnitsText;
	}

	public void setRelativeTimeUnitsText(String relativeTimeUnitsText) {
		this.relativeTimeUnitsText = relativeTimeUnitsText;
	}

	public String getServiceDuration() {
		return this.serviceDuration;
	}

	public void setServiceDuration(String serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public String getServiceDurationUnitsCodsys() {
		return this.serviceDurationUnitsCodsys;
	}

	public void setServiceDurationUnitsCodsys(String serviceDurationUnitsCodsys) {
		this.serviceDurationUnitsCodsys = serviceDurationUnitsCodsys;
	}

	public String getServiceDurationUnitsId() {
		return this.serviceDurationUnitsId;
	}

	public void setServiceDurationUnitsId(String serviceDurationUnitsId) {
		this.serviceDurationUnitsId = serviceDurationUnitsId;
	}

	public String getServiceDurationUnitsText() {
		return this.serviceDurationUnitsText;
	}

	public void setServiceDurationUnitsText(String serviceDurationUnitsText) {
		this.serviceDurationUnitsText = serviceDurationUnitsText;
	}

	public Date getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getTextInstruction() {
		return this.textInstruction;
	}

	public void setTextInstruction(String textInstruction) {
		this.textInstruction = textInstruction;
	}

	public String getTotalOccurrences() {
		return this.totalOccurrences;
	}

	public void setTotalOccurrences(String totalOccurrences) {
		this.totalOccurrences = totalOccurrences;
	}

	public Date getTransactionDatetime() {
		return this.transactionDatetime;
	}

	public void setTransactionDatetime(Date transactionDatetime) {
		this.transactionDatetime = transactionDatetime;
	}

}