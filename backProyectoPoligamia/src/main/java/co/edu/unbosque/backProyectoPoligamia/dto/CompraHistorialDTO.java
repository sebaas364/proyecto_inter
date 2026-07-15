package co.edu.unbosque.backProyectoPoligamia.dto;

import java.sql.Date;
import java.sql.Time;

public class CompraHistorialDTO {

	private Integer idCompra;
	private String nombrePareja;
	private String nombreAlmacen;
	private Date fecha;
	private Time hora;
	private double monto;
	private String estado;

	public CompraHistorialDTO() {
	}

	public CompraHistorialDTO(Integer idCompra, String nombrePareja, String nombreAlmacen,
			Date fecha, Time hora, double monto, String estado) {
		this.idCompra = idCompra;
		this.nombrePareja = nombrePareja;
		this.nombreAlmacen = nombreAlmacen;
		this.fecha = fecha;
		this.hora = hora;
		this.monto = monto;
		this.estado = estado;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public String getNombrePareja() {
		return nombrePareja;
	}

	public void setNombrePareja(String nombrePareja) {
		this.nombrePareja = nombrePareja;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}