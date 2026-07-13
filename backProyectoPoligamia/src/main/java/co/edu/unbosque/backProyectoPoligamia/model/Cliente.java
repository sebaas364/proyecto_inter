package co.edu.unbosque.backProyectoPoligamia.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente extends Persona{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="Cupo_total_credito", nullable = false , columnDefinition = "NUMERIC")
	private double cupoTotalCredito;
	
	@OneToMany(mappedBy = "cliente")
	private List<ClientePareja> clienteParejas;
	
	public Cliente() {
		
	}

	public Cliente(double cupoTotalCredito, List<ClientePareja> clienteParejas) {
		super();
		this.cupoTotalCredito = cupoTotalCredito;
		this.clienteParejas = clienteParejas;
	}

	public Cliente(Integer idPersona, String cedula, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String contrasenia, String telefono, String viaDireccion, String numeroDireccion,
			String complementoDireccion, double cupoTotalCredito, List<ClientePareja> clienteParejas) {
		super(idPersona, cedula, primerNombre, segundoNombre, primerApellido, segundoApellido, contrasenia, telefono,
				viaDireccion, numeroDireccion, complementoDireccion);
		this.cupoTotalCredito = cupoTotalCredito;
		this.clienteParejas = clienteParejas;
	}

	public double getCupoTotalCredito() {
		return cupoTotalCredito;
	}

	public void setCupoTotalCredito(double cupoTotalCredito) {
		this.cupoTotalCredito = cupoTotalCredito;
	}

	public List<ClientePareja> getClienteParejas() {
		return clienteParejas;
	}

	public void setClienteParejas(List<ClientePareja> clienteParejas) {
		this.clienteParejas = clienteParejas;
	}
	
	
}
