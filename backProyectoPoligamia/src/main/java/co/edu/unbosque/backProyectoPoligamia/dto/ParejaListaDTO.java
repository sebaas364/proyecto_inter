package co.edu.unbosque.backProyectoPoligamia.dto;

public class ParejaListaDTO {

	private Integer idPersona;
	private String nombreCompleto;
	private String cedula;
	private String telefono;
	private double cupoAsignado;
	private double gastoAcumulado;
	private double cupoDisponible;
	private String estadoCupo;
	private boolean cercaDelLimite;
	private boolean tieneRestriccion;
	private boolean sobrecupoHabilitado;

	public ParejaListaDTO() {
	}

	public ParejaListaDTO(Integer idPersona, String nombreCompleto, String cedula, String telefono,
			double cupoAsignado, double gastoAcumulado, double cupoDisponible, String estadoCupo,
			boolean cercaDelLimite, boolean tieneRestriccion, boolean sobrecupoHabilitado) {
		this.idPersona = idPersona;
		this.nombreCompleto = nombreCompleto;
		this.cedula = cedula;
		this.telefono = telefono;
		this.cupoAsignado = cupoAsignado;
		this.gastoAcumulado = gastoAcumulado;
		this.cupoDisponible = cupoDisponible;
		this.estadoCupo = estadoCupo;
		this.cercaDelLimite = cercaDelLimite;
		this.tieneRestriccion = tieneRestriccion;
		this.sobrecupoHabilitado = sobrecupoHabilitado;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public double getCupoAsignado() {
		return cupoAsignado;
	}

	public void setCupoAsignado(double cupoAsignado) {
		this.cupoAsignado = cupoAsignado;
	}

	public double getGastoAcumulado() {
		return gastoAcumulado;
	}

	public void setGastoAcumulado(double gastoAcumulado) {
		this.gastoAcumulado = gastoAcumulado;
	}

	public double getCupoDisponible() {
		return cupoDisponible;
	}

	public void setCupoDisponible(double cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}

	public String getEstadoCupo() {
		return estadoCupo;
	}

	public void setEstadoCupo(String estadoCupo) {
		this.estadoCupo = estadoCupo;
	}

	public boolean isCercaDelLimite() {
		return cercaDelLimite;
	}

	public void setCercaDelLimite(boolean cercaDelLimite) {
		this.cercaDelLimite = cercaDelLimite;
	}

	public boolean isTieneRestriccion() {
		return tieneRestriccion;
	}

	public void setTieneRestriccion(boolean tieneRestriccion) {
		this.tieneRestriccion = tieneRestriccion;
	}

	public boolean isSobrecupoHabilitado() {
		return sobrecupoHabilitado;
	}

	public void setSobrecupoHabilitado(boolean sobrecupoHabilitado) {
		this.sobrecupoHabilitado = sobrecupoHabilitado;
	}

}