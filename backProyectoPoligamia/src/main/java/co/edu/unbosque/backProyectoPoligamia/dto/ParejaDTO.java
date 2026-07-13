package co.edu.unbosque.backProyectoPoligamia.dto;

import java.util.List;

public class ParejaDTO extends PersonaDTO {

	private double cupoCredito;
	private String estado;
	private List<ClienteParejaDTO> clienteParejas;
	private RestriccionDTO restriccion;

	public ParejaDTO() {

	}

	public ParejaDTO(double cupoCredito, String estado, List<ClienteParejaDTO> clienteParejas,
			RestriccionDTO restriccion) {
		super();
		this.cupoCredito = cupoCredito;
		this.estado = estado;
		this.clienteParejas = clienteParejas;
		this.restriccion = restriccion;
	}

	public ParejaDTO(Integer idPersona, String cedula, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, String contrasenia, String telefono,
			String viaDireccion, String numeroDireccion, String complementoDireccion, double cupoCredito,
			String estado, List<ClienteParejaDTO> clienteParejas, RestriccionDTO restriccion) {
		super(idPersona, cedula, primerNombre, segundoNombre, primerApellido, segundoApellido, contrasenia,
				telefono, viaDireccion, numeroDireccion, complementoDireccion);
		this.cupoCredito = cupoCredito;
		this.estado = estado;
		this.clienteParejas = clienteParejas;
		this.restriccion = restriccion;
	}

	public double getCupoCredito() {
		return cupoCredito;
	}

	public void setCupoCredito(double cupoCredito) {
		this.cupoCredito = cupoCredito;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ClienteParejaDTO> getClienteParejas() {
		return clienteParejas;
	}

	public void setClienteParejas(List<ClienteParejaDTO> clienteParejas) {
		this.clienteParejas = clienteParejas;
	}

	public RestriccionDTO getRestriccion() {
		return restriccion;
	}

	public void setRestriccion(RestriccionDTO restriccion) {
		this.restriccion = restriccion;
	}

}