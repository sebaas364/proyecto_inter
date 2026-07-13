package co.edu.unbosque.backProyectoPoligamia.dto;

public class ClienteParejaDTO {

	private ClienteParejaIdDTO id;
	private ClienteDTO cliente;
	private ParejaDTO pareja;

	public ClienteParejaDTO() {

	}

	public ClienteParejaDTO(ClienteParejaIdDTO id, ClienteDTO cliente, ParejaDTO pareja) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.pareja = pareja;
	}

	public ClienteParejaIdDTO getId() {
		return id;
	}

	public void setId(ClienteParejaIdDTO id) {
		this.id = id;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public ParejaDTO getPareja() {
		return pareja;
	}

	public void setPareja(ParejaDTO pareja) {
		this.pareja = pareja;
	}

}