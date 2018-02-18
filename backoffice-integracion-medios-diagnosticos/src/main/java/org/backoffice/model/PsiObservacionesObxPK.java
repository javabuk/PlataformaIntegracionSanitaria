package org.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PSI_OBSERVACIONES_OBX database table.
 * 
 */
@Embeddable
public class PsiObservacionesObxPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long idsolicitud;

	private long idpeticion;

	private long idobservacion;

	public PsiObservacionesObxPK() {
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
	public long getIdobservacion() {
		return this.idobservacion;
	}
	public void setIdobservacion(long idobservacion) {
		this.idobservacion = idobservacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PsiObservacionesObxPK)) {
			return false;
		}
		PsiObservacionesObxPK castOther = (PsiObservacionesObxPK)other;
		return 
			(this.idsolicitud == castOther.idsolicitud)
			&& (this.idpeticion == castOther.idpeticion)
			&& (this.idobservacion == castOther.idobservacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idsolicitud ^ (this.idsolicitud >>> 32)));
		hash = hash * prime + ((int) (this.idpeticion ^ (this.idpeticion >>> 32)));
		hash = hash * prime + ((int) (this.idobservacion ^ (this.idobservacion >>> 32)));
		
		return hash;
	}
}