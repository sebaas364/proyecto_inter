package co.edu.unbosque.backProyectoPoligamia.dto;

import java.sql.Date;
import java.sql.Time;

public class CompraDTO {

	private Integer idCompra;
	private Date fecha;
	private Time hora;
	private double monto;
	private char sobrecupo;
	private ParejaDTO pareja;
	private AlmacenDTO almacen;
	private AutorizacionSobrecupoDTO autorizacionSobrecupo;

	public CompraDTO() {

	}

	public CompraDTO(Integer idCompra, Date fecha, Time hora, double monto, char sobrecupo, ParejaDTO pareja,
			AlmacenDTO almacen, AutorizacionSobrecupoDTO autorizacionSobrecupo) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.hora = hora;
		this.monto = monto;
		this.sobrecupo = sobrecupo;
		this.pareja = pareja;
		this.almacen = almacen;
		this.autorizacionSobrecupo = autorizacionSobrecupo;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
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

	public char getSobrecupo() {
		return sobrecupo;
	}

	public void setSobrecupo(char sobrecupo) {
		this.sobrecupo = sobrecupo;
	}

	public ParejaDTO getPareja() {
		return pareja;
	}

	public void setPareja(ParejaDTO pareja) {
		this.pareja = pareja;
	}

	public AlmacenDTO getAlmacen() {
		return almacen;
	}

	public void setAlmacen(AlmacenDTO almacen) {
		this.almacen = almacen;
	}

	public AutorizacionSobrecupoDTO getAutorizacionSobrecupo() {
		return autorizacionSobrecupo;
	}

	public void setAutorizacionSobrecupo(AutorizacionSobrecupoDTO autorizacionSobrecupo) {
		this.autorizacionSobrecupo = autorizacionSobrecupo;
	}

}