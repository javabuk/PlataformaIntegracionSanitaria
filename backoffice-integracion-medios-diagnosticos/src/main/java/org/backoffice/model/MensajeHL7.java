package org.backoffice.model;

public class MensajeHL7 {

	private String mensaje;
	private String sistemaOrigen;
	private String sistemaDestino;
	// Datos paciente
	private String numeroTarjeta;
	private String sistemaTarjeta;
	private String dni;
	private String apellido1;
	private String apellido2;
	private String nombre;
	private String fechaNacimiento;
	private String genero;
	// Datos episodio
	private String tipoIngreso;
	private String nombreMedicoResponsable;
	private String apellido1MedicoResponsable;
	private String apellido2MedicoResponsable;
	private String codigoMedicoResponsable;
	private String sistemaMedicoResponsable;
	private String servicio;
	// Datos garante
	private String codigoGarante;
	private String sistemaGarante;
	private String descripcionGarante;
	// Datos peticion
	private String idPeticionarioPrueba;
	private String sistemaPeticionarioPrueba;
	private String idPeticionarioPeticion;
	private String sistemaPeticionarioPeticion;
	private String fechaPeticion;
	private String nombreMedicoPeticion;
	private String apellido1MedicoPeticion;
	private String apellido2MedicoPeticion;
	private String codigoMedicoPeticion;
	private String sistemaMedicoPeticion;
	private String servicioPeticion;
	private String descripcionServicioPeticion;
	private String codigoCentroPeticion;
	private String descripcionCentroPeticion;
	private String sistemaCentroPeticion;
	// Datos prioridad peticion
	private String codigoPrioridadPeticion;
	private String descripcionPrioridadPeticion;
	private String sistemaPrioridadPeticion;
	// Datos prueba
	private String codigoPrueba;
	private String descripcionPrueba;
	private String sistemaPrueba;

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getSistemaTarjeta() {
		return sistemaTarjeta;
	}

	public void setSistemaTarjeta(String sistemaTarjeta) {
		this.sistemaTarjeta = sistemaTarjeta;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipoIngreso() {
		return tipoIngreso;
	}

	public void setTipoIngreso(String tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}

	public String getNombreMedicoResponsable() {
		return nombreMedicoResponsable;
	}

	public void setNombreMedicoResponsable(String nombreMedicoResponsable) {
		this.nombreMedicoResponsable = nombreMedicoResponsable;
	}

	public String getApellido1MedicoResponsable() {
		return apellido1MedicoResponsable;
	}

	public void setApellido1MedicoResponsable(String apellido1MedicoResponsable) {
		this.apellido1MedicoResponsable = apellido1MedicoResponsable;
	}

	public String getApellido2MedicoResponsable() {
		return apellido2MedicoResponsable;
	}

	public void setApellido2MedicoResponsable(String apellido2MedicoResponsable) {
		this.apellido2MedicoResponsable = apellido2MedicoResponsable;
	}

	public String getCodigoMedicoResponsable() {
		return codigoMedicoResponsable;
	}

	public void setCodigoMedicoResponsable(String codigoMedicoResponsable) {
		this.codigoMedicoResponsable = codigoMedicoResponsable;
	}

	public String getSistemaMedicoResponsable() {
		return sistemaMedicoResponsable;
	}

	public void setSistemaMedicoResponsable(String sistemaMedicoResponsable) {
		this.sistemaMedicoResponsable = sistemaMedicoResponsable;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getCodigoGarante() {
		return codigoGarante;
	}

	public void setCodigoGarante(String codigoGarante) {
		this.codigoGarante = codigoGarante;
	}

	public String getSistemaGarante() {
		return sistemaGarante;
	}

	public void setSistemaGarante(String sistemaGarante) {
		this.sistemaGarante = sistemaGarante;
	}

	public String getDescripcionGarante() {
		return descripcionGarante;
	}

	public void setDescripcionGarante(String descripcionGarante) {
		this.descripcionGarante = descripcionGarante;
	}

	public String getIdPeticionarioPrueba() {
		return idPeticionarioPrueba;
	}

	public void setIdPeticionarioPrueba(String idPeticionarioPrueba) {
		this.idPeticionarioPrueba = idPeticionarioPrueba;
	}

	public String getSistemaPeticionarioPrueba() {
		return sistemaPeticionarioPrueba;
	}

	public void setSistemaPeticionarioPrueba(String sistemaPeticionarioPrueba) {
		this.sistemaPeticionarioPrueba = sistemaPeticionarioPrueba;
	}

	public String getIdPeticionarioPeticion() {
		return idPeticionarioPeticion;
	}

	public void setIdPeticionarioPeticion(String idPeticionarioPeticion) {
		this.idPeticionarioPeticion = idPeticionarioPeticion;
	}

	public String getSistemaPeticionarioPeticion() {
		return sistemaPeticionarioPeticion;
	}

	public void setSistemaPeticionarioPeticion(String sistemaPeticionarioPeticion) {
		this.sistemaPeticionarioPeticion = sistemaPeticionarioPeticion;
	}

	public String getFechaPeticion() {
		return fechaPeticion;
	}

	public void setFechaPeticion(String fechaPeticion) {
		this.fechaPeticion = fechaPeticion;
	}

	public String getNombreMedicoPeticion() {
		return nombreMedicoPeticion;
	}

	public void setNombreMedicoPeticion(String nombreMedicoPeticion) {
		this.nombreMedicoPeticion = nombreMedicoPeticion;
	}

	public String getApellido1MedicoPeticion() {
		return apellido1MedicoPeticion;
	}

	public void setApellido1MedicoPeticion(String apellido1MedicoPeticion) {
		this.apellido1MedicoPeticion = apellido1MedicoPeticion;
	}

	public String getApellido2MedicoPeticion() {
		return apellido2MedicoPeticion;
	}

	public void setApellido2MedicoPeticion(String apellido2MedicoPeticion) {
		this.apellido2MedicoPeticion = apellido2MedicoPeticion;
	}

	public String getCodigoMedicoPeticion() {
		return codigoMedicoPeticion;
	}

	public void setCodigoMedicoPeticion(String codigoMedicoPeticion) {
		this.codigoMedicoPeticion = codigoMedicoPeticion;
	}

	public String getSistemaMedicoPeticion() {
		return sistemaMedicoPeticion;
	}

	public void setSistemaMedicoPeticion(String sistemaMedicoPeticion) {
		this.sistemaMedicoPeticion = sistemaMedicoPeticion;
	}

	public String getServicioPeticion() {
		return servicioPeticion;
	}

	public void setServicioPeticion(String servicioPeticion) {
		this.servicioPeticion = servicioPeticion;
	}

	public String getCodigoCentroPeticion() {
		return codigoCentroPeticion;
	}

	public void setCodigoCentroPeticion(String codigoCentroPeticion) {
		this.codigoCentroPeticion = codigoCentroPeticion;
	}

	public String getDescripcionCentroPeticion() {
		return descripcionCentroPeticion;
	}

	public void setDescripcionCentroPeticion(String descripcionCentroPeticion) {
		this.descripcionCentroPeticion = descripcionCentroPeticion;
	}

	public String getSistemaCentroPeticion() {
		return sistemaCentroPeticion;
	}

	public void setSistemaCentroPeticion(String sistemaCentroPeticion) {
		this.sistemaCentroPeticion = sistemaCentroPeticion;
	}

	public String getCodigoPrioridadPeticion() {
		return codigoPrioridadPeticion;
	}

	public void setCodigoPrioridadPeticion(String codigoPrioridadPeticion) {
		this.codigoPrioridadPeticion = codigoPrioridadPeticion;
	}

	public String getDescripcionPrioridadPeticion() {
		return descripcionPrioridadPeticion;
	}

	public void setDescripcionPrioridadPeticion(String descripcionPrioridadPeticion) {
		this.descripcionPrioridadPeticion = descripcionPrioridadPeticion;
	}

	public String getSistemaPrioridadPeticion() {
		return sistemaPrioridadPeticion;
	}

	public void setSistemaPrioridadPeticion(String sistemaPrioridadPeticion) {
		this.sistemaPrioridadPeticion = sistemaPrioridadPeticion;
	}

	public String getCodigoPrueba() {
		return codigoPrueba;
	}

	public void setCodigoPrueba(String codigoPrueba) {
		this.codigoPrueba = codigoPrueba;
	}

	public String getDescripcionPrueba() {
		return descripcionPrueba;
	}

	public void setDescripcionPrueba(String descripcionPrueba) {
		this.descripcionPrueba = descripcionPrueba;
	}

	public String getSistemaPrueba() {
		return sistemaPrueba;
	}

	public void setSistemaPrueba(String sistemaPrueba) {
		this.sistemaPrueba = sistemaPrueba;
	}

	public String getSistemaOrigen() {
		return sistemaOrigen;
	}

	public void setSistemaOrigen(String sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}

	public String getSistemaDestino() {
		return sistemaDestino;
	}

	public void setSistemaDestino(String sistemaDestino) {
		this.sistemaDestino = sistemaDestino;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDescripcionServicioPeticion() {
		return descripcionServicioPeticion;
	}

	public void setDescripcionServicioPeticion(String descripcionServicioPeticion) {
		this.descripcionServicioPeticion = descripcionServicioPeticion;
	}

}
