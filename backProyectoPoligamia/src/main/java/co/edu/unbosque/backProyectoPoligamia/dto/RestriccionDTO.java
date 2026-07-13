package co.edu.unbosque.backProyectoPoligamia.dto;

import java.sql.Date;
import java.sql.Time;

public class RestriccionDTO {

	private RestriccionIdDTO id;
	private ParejaDTO pareja;
	private Date dia;
	private Time horaInicio;
	private Time horaFin;
	private String estado;

	public RestriccionDTO() {

	}

	public RestriccionDTO(RestriccionIdDTO id, ParejaDTO pareja, Date dia, Time horaInicio, Time horaFin,
			String estado) {
		super();
		this.id = id;
		this.pareja = pareja;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.estado = estado;
	}

	public RestriccionIdDTO getId() {
		return id;
	}

	public void setId(RestriccionIdDTO id) {
		this.id = id;
	}

	public ParejaDTO getPareja() {
		return pareja;
	}

	public void setPareja(ParejaDTO pareja) {
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