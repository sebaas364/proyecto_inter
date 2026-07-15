package co.edu.unbosque.backProyectoPoligamia.dto;

public class GastoCupoDTO {

	private Integer idPersona;
	private double cupoCredito;
	private double gastoAcumulado;
	private double cupoDisponible;

	public GastoCupoDTO() {
	}

	public GastoCupoDTO(Integer idPersona, double cupoCredito, double gastoAcumulado, double cupoDisponible) {
		this.idPersona = idPersona;
		this.cupoCredito = cupoCredito;
		this.gastoAcumulado = gastoAcumulado;
		this.cupoDisponible = cupoDisponible;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public double getCupoCredito() {
		return cupoCredito;
	}

	public void setCupoCredito(double cupoCredito) {
		this.cupoCredito = cupoCredito;
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
}