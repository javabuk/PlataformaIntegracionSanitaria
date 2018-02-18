package org.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PSI_PRUEBAS_OBR database table.
 * 
 */
@Embeddable
public class PsiPruebasObrPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long idsolicitud;

	private long idpeticion;

	public PsiPruebasObrPK() {
	}
	public long getIdsolicitud() {
		return this.idsolicitud;
	}
	public void setIdsolicitud(long idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public long getIdpeticion() {
		return this.idpeticion;
	}
	public void setIdpeticion(long idpeticion) {
		this.idpeticion = idpeticion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PsiPruebasObrPK)) {
			return false;
		}
		PsiPruebasObrPK castOther = (PsiPruebasObrPK)other;
		return 
			(this.idsolicitud == castOther.idsolicitud)
			&& (this.idpeticion == castOther.idpeticion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idsolicitud ^ (this.idsolicitud >>> 32)));
		hash = hash * prime + ((int) (this.idpeticion ^ (this.idpeticion >>> 32)));
		
		return hash;
	}
}