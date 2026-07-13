package co.edu.unbosque.backProyectoPoligamia.dto;

public class RestriccionIdDTO {

	private Integer idRestriccion;
	private Integer idPareja;

	public RestriccionIdDTO() {

	}

	public RestriccionIdDTO(Integer idRestriccion, Integer idPareja) {
		super();
		this.idRestriccion = idRestriccion;
		this.idPareja = idPareja;
	}

	public Integer getIdRestriccion() {
		return idRestriccion;
	}

	public void setIdRestriccion(Integer idRestriccion) {
		this.idRestriccion = idRestriccion;
	}

	public Integer getIdPareja() {
		return idPareja;
	}

	public void setIdPareja(Integer idPareja) {
		this.idPareja = idPareja;
	}

}