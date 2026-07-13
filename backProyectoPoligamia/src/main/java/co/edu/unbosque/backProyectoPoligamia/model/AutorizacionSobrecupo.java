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
@Table(name = "AUTORIZACION_SOBRECUPO")
public class AutorizacionSobrecupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_autorizacion")
	private Integer idAutorizacion;

	@Column(name = "Hora", nullable = false)
	private Time hora;

	@Column(name = "Fecha", nullable = false)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "Id_supervisor", nullable = false)
	private Supervisor supervisor;

	@OneToOne
	@JoinColumn(name = "Id_compra", nullable = false, unique = true)
	private Compra compra;

	public AutorizacionSobrecupo() {

	}

	public AutorizacionSobrecupo(Time hora, Date fecha, Supervisor supervisor, Compra compra) {
		super();
		this.hora = hora;
		this.fecha = fecha;
		this.supervisor = supervisor;
		this.compra = compra;
	}

	public AutorizacionSobrecupo(Integer idAutorizacion, Time hora, Date fecha, Supervisor supervisor,
			Compra compra) {
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

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

}