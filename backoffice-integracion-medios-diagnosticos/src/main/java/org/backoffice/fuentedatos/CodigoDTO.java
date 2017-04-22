package org.backoffice.fuentedatos;

public class CodigoDTO {
	
	private String codigo;
	private String descripcion;
	private String sistema;
	private String tipo;
	
	
	public CodigoDTO() {
	}
	
	public CodigoDTO(String codigo, String descripcion, String sistema, String tipo) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.sistema = sistema;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Codigo [codigo=" + codigo + ", descripcion=" + descripcion + ", sistema=" + sistema + ", tipo= "+tipo+"]";
	}
	
	 @Override
	 public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
	    return result;
	 }

	 @Override
	 public boolean equals(Object obj) {
		 if (!(obj instanceof CodigoDTO))
			 return false;

	     CodigoDTO codigoComparador = (CodigoDTO) obj;
	     return codigoComparador.codigo.equals(codigo) ;
	 }
}
