package org.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PSI_PATIENTID_PID database table.
 * 
 */
@Embeddable
public class PsiPatientidPidPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long idsolicitud;

	@Column(name="IDENTIFICATOR_NUMBER")
	private String identificatorNumber;

	@Column(name="ASSIGNING_AUTHORITY")
	private String assigningAuthority;

	public PsiPatientidPidPK() {
	}
	public long getIdsolicitud() {
		return this.idsolicitud;
	}
	public void setIdsolicitud(long idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public String getIdentificatorNumber() {
		return this.identificatorNumber;
	}
	public void setIdentificatorNumber(String identificatorNumber) {
		this.identificatorNumber = identificatorNumber;
	}
	public String getAssigningAuthority() {
		return this.assigningAuthority;
	}
	public void setAssigningAuthority(String assigningAuthority) {
		this.assigningAuthority = assigningAuthority;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PsiPatientidPidPK)) {
			return false;
		}
		PsiPatientidPidPK castOther = (PsiPatientidPidPK)other;
		return 
			(this.idsolicitud == castOther.idsolicitud)
			&& this.identificatorNumber.equals(castOther.identificatorNumber)
			&& this.assigningAuthority.equals(castOther.assigningAuthority);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idsolicitud ^ (this.idsolicitud >>> 32)));
		hash = hash * prime + this.identificatorNumber.hashCode();
		hash = hash * prime + this.assigningAuthority.hashCode();
		
		return hash;
	}
}