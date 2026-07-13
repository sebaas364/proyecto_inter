package co.edu.unbosque.backProyectoPoligamia.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESTRICCION")
public class Restriccion {
	
	@EmbeddedId
	private RestriccionId id;

	@OneToOne
	@MapsId("idPareja")
	@JoinColumn(name = "Pareja_id_persona")
	private Pareja pareja;

	@Column(name = "dia", nullable = false)
	private Date dia;

	@Column(name = "Hora_i", nullable = false)
	private Time horaInicio;

	@Column(name = "Hora_f", nullable = false)
	private Time horaFin;

	@Column(name = "estado", nullable = false)
	private String estado;

	public Restriccion() {

	}

	public Restriccion(RestriccionId id, Pareja pareja, Date dia, Time horaInicio, Time horaFin, String estado) {
		super();
		this.id = id;
		this.pareja = pareja;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.estado = estado;
	}

	public RestriccionId getId() {
		return id;
	}

	public void setId(RestriccionId id) {
		this.id = id;
	}

	public Pareja getPareja() {
		return pareja;
	}

	public void setPareja(Pareja pareja) {
		this.pareja = pareja;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}