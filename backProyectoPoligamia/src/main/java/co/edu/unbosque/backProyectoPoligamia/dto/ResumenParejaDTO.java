package co.edu.unbosque.backProyectoPoligamia.dto;

public class ResumenParejaDTO {


	private Integer idPersona;
	private String nombreCompleto;
	private double cupoCredito;

	public ResumenParejaDTO() {
	}

	public ResumenParejaDTO(Integer idPersona, String nombreCompleto, double cupoCredito) {
		this.idPersona = idPersona;
		this.nombreCompleto = nombreCompleto;
		this.cupoCredito = cupoCredito;
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

	public double getCupoCredito() {
		return cupoCredito;
	}

	public void setCupoCredito(double cupoCredito) {
		this.cupoCredito = cupoCredito;
	}
}
