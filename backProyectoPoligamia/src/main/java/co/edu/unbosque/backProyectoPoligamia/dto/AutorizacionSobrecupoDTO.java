package co.edu.unbosque.backProyectoPoligamia.dto;

import java.sql.Date;
import java.sql.Time;

public class AutorizacionSobrecupoDTO {

	private Integer idAutorizacion;
	private Time hora;
	private Date fecha;
	private SupervisorDTO supervisor;
	private CompraDTO compra;

	public AutorizacionSobrecupoDTO() {

	}

	public AutorizacionSobrecupoDTO(Integer idAutorizacion, Time hora, Date fecha, SupervisorDTO supervisor,
			CompraDTO compra) {
		super();
		this.idAutorizacion = idAutorizacion;
		this.hora = hora;
		this.fecha = fecha;
		this.supervisor = supervisor;
		this.compra = compra;
	}

	public Integer getIdAutorizacion() {
		return idAutorizacion;
	}

	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public SupervisorDTO getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(SupervisorDTO supervisor) {
		this.supervisor = supervisor;
	}

	public CompraDTO getCompra() {
		return compra;
	}

	public void setCompra(CompraDTO compra) {
		this.compra = compra;
	}

}