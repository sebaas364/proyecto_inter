package co.edu.unbosque.backProyectoPoligamia.dto;

import java.util.List;

public class ClienteDTO extends PersonaDTO {

	private double cupoTotalCredito;
	private List<ClienteParejaDTO> clienteParejas;

	public ClienteDTO() {

	}

	public ClienteDTO(double cupoTotalCredito, List<ClienteParejaDTO> clienteParejas) {
		super();
		this.cupoTotalCredito = cupoTotalCredito;
		this.clienteParejas = clienteParejas;
	}

	public ClienteDTO(Integer idPersona, String cedula, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, String contrasenia, String telefono,
			String viaDireccion, String numeroDireccion, String complementoDireccion, double cupoTotalCredito,
			List<ClienteParejaDTO> clienteParejas) {
		super(idPersona, cedula, primerNombre, segundoNombre, primerApellido, segundoApellido, contrasenia,
				telefono, viaDireccion, numeroDireccion, complementoDireccion);
		this.cupoTotalCredito = cupoTotalCredito;
		this.clienteParejas = clienteParejas;
	}

	public double getCupoTotalCredito() {
		return cupoTotalCredito;
	}

	public void setCupoTotalCredito(double cupoTotalCredito) {
		this.cupoTotalCredito = cupoTotalCredito;
	}

	public List<ClienteParejaDTO> getClienteParejas() {
		return clienteParejas;
	}

	public void setClienteParejas(List<ClienteParejaDTO> clienteParejas) {
		this.clienteParejas = clienteParejas;
	}

}