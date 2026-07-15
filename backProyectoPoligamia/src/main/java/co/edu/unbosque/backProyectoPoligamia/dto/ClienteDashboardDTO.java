package co.edu.unbosque.backProyectoPoligamia.dto;

import java.util.List;

public class ClienteDashboardDTO {

	private Integer idPersona;
	private String nombreCompleto;
	private double cupoTotalCredito;
	private double cupoAsignado;
	private double gastoTotal;
	private double cupoDisponibleTotal;
	private List<ResumenParejaDTO> parejas;

	public ClienteDashboardDTO() {
	}

	public ClienteDashboardDTO(Integer idPersona, String nombreCompleto, double cupoTotalCredito,
			double cupoAsignado, double gastoTotal, double cupoDisponibleTotal, List<ResumenParejaDTO> parejas) {
		this.idPersona = idPersona;
		this.nombreCompleto = nombreCompleto;
		this.cupoTotalCredito = cupoTotalCredito;
		this.cupoAsignado = cupoAsignado;
		this.gastoTotal = gastoTotal;
		this.cupoDisponibleTotal = cupoDisponibleTotal;
		this.parejas = parejas;
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

	public double getCupoTotalCredito() {
		return cupoTotalCredito;
	}

	public void setCupoTotalCredito(double cupoTotalCredito) {
		this.cupoTotalCredito = cupoTotalCredito;
	}

	public double getCupoAsignado() {
		return cupoAsignado;
	}

	public void setCupoAsignado(double cupoAsignado) {
		this.cupoAsignado = cupoAsignado;
	}

	public List<ResumenParejaDTO> getParejas() {
		return parejas;
	}

	public void setParejas(List<ResumenParejaDTO> parejas) {
		this.parejas = parejas;
	}
	
	public double getGastoTotal() {
		return gastoTotal;
	}

	public void setGastoTotal(double gastoTotal) {
		this.gastoTotal = gastoTotal;
	}

	public double getCupoDisponibleTotal() {
		return cupoDisponibleTotal;
	}

	public void setCupoDisponibleTotal(double cupoDisponibleTotal) {
		this.cupoDisponibleTotal = cupoDisponibleTotal;
	}
}