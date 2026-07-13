package co.edu.unbosque.backProyectoPoligamia.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RestriccionId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Id_restriccion")
	private Integer idRestriccion;

	@Column(name = "Pareja_id_persona")
	private Integer idPareja;

	public RestriccionId() {

	}

	public RestriccionId(Integer idRestriccion, Integer idPareja) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RestriccionId)) return false;
		RestriccionId that = (RestriccionId) o;
		return Objects.equals(idRestriccion, that.idRestriccion) &&
				Objects.equals(idPareja, that.idPareja);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRestriccion, idPareja);
	}
}