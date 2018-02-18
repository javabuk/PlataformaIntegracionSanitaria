package org.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PSI_PATIENTID_PID database table.
 * 
 */
@Entity
@Table(name="PSI_PATIENTID_PID")
@NamedQuery(name="PsiPatientidPid.findAll", query="SELECT p FROM PsiPatientidPid p")
public class PsiPatientidPid implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PsiPatientidPidPK id;

	@Column(name="IDENTIFIER_TYPE_CODE")
	private String identifierTypeCode;

	private String typeid;

	public PsiPatientidPid() {
	}

	public PsiPatientidPidPK getId() {
		return this.id;
	}

	public void setId(PsiPatientidPidPK id) {
		this.id = id;
	}

	public String getIdentifierTypeCode() {
		return this.identifierTypeCode;
	}

	public void setIdentifierTypeCode(String identifierTypeCode) {
		this.identifierTypeCode = identifierTypeCode;
	}

	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

}