package co.edu.unbosque.backProyectoPoligamia.dto;

public class ClienteParejaIdDTO {

	private Integer idCliente;
	private Integer idPareja;

	public ClienteParejaIdDTO() {

	}

	public ClienteParejaIdDTO(Integer idCliente, Integer idPareja) {
		super();
		this.idCliente = idCliente;
		this.idPareja = idPareja;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdPareja() {
		return idPareja;
	}

	public void setIdPareja(Integer idPareja) {
		this.idPareja = idPareja;
	}

}