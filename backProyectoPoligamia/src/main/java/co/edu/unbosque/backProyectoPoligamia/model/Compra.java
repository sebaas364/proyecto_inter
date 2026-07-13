package co.edu.unbosque.backProyectoPoligamia.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPRA")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_compra")
	private Integer idCompra;

	@Column(name = "Fecha", nullable = false)
	private Date fecha;

	@Column(name = "Hora", nullable = false)
	private Time hora;

	@Column(name = "Monto", nullable = false, columnDefinition = "NUMERIC")
	private double monto;

	@Column(name = "Sobrecupo")
	private char sobrecupo;

	@ManyToOne
	@JoinColumn(name = "Id_pareja", nullable = false)
	private Pareja pareja;

	@ManyToOne
	@JoinColumn(name = "Almacen_id_almacen", nullable = false)
	private Almacen almacen;

	@OneToOne(mappedBy = "compra")
	private AutorizacionSobrecupo autorizacionSobrecupo;

	public Compra() {

	}

	public Compra(Date fecha, Time hora, double monto, char sobrecupo, Pareja pareja, Almacen almacen) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.monto = monto;
		this.sobrecupo = sobrecupo;
		this.pareja = pareja;
		this.almacen = almacen;
	}

	public Compra(Integer idCompra, Date fecha, Time hora, double monto, char sobrecupo, Pareja pareja,
			Almacen almacen) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.hora = hora;
		this.monto = monto;
		this.sobrecupo = sobrecupo;
		this.pareja = pareja;
		this.almacen = almacen;
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

	public Pareja getPareja() {
		return pareja;
	}

	public void setPareja(Pareja pareja) {
		this.pareja = pareja;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public AutorizacionSobrecupo getAutorizacionSobrecupo() {
		return autorizacionSobrecupo;
	}

	public void setAutorizacionSobrecupo(AutorizacionSobrecupo autorizacionSobrecupo) {
		this.autorizacionSobrecupo = autorizacionSobrecupo;
	}

}