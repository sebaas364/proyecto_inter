package co.edu.unbosque.backProyectoPoligamia.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAREJA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pareja extends Persona{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cupo_credito", nullable = false , columnDefinition = "NUMERIC")
	private double cupoCredito;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@OneToMany(mappedBy = "pareja")
	private List<ClientePareja> clienteParejas;
	
	@OneToOne(mappedBy = "pareja", cascade = CascadeType.ALL)
    private Restriccion restriccion;
	
	public Pareja() {

	}

	public Pareja(double cupoCredito, String estado, List<ClientePareja> clienteParejas, Restriccion restriccion) {
		super();
		this.cupoCredito = cupoCredito;
		this.estado = estado;
		this.clienteParejas = clienteParejas;
		this.restriccion = restriccion;
	}

	public Pareja(Integer idPersona, String cedula, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String contrasenia, String telefono, String viaDireccion, String numeroDireccion,
			String complementoDireccion, double cupoCredito, String estado, List<ClientePareja> clienteParejas, Restriccion restriccion) {
		super(idPersona, cedula, primerNombre, segundoNombre, primerApellido, segundoApellido, contrasenia, telefono,
				viaDireccion, numeroDireccion, complementoDireccion);
		this.cupoCredito = cupoCredito;
		this.estado = estado;
		this.clienteParejas = clienteParejas;
		this.restriccion = restriccion;
	}

	public double getCupoCredito() {
		return cupoCredito;
	}

	public void setCupoCredito(double cupoCredito) {
		this.cupoCredito = cupoCredito;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ClientePareja> getClienteParejas() {
		return clienteParejas;
	}

	public void setClienteParejas(List<ClientePareja> clienteParejas) {
		this.clienteParejas = clienteParejas;
	}

	public Restriccion getRestriccion() {
		return restriccion;
	}

	public void setRestriccion(Restriccion restriccion) {
		this.restriccion = restriccion;
	}
	
	
}
