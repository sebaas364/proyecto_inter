package co.edu.unbosque.backProyectoPoligamia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUPERVISOR")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "Id_supervisor", referencedColumnName = "id_persona")
public class Supervisor extends Persona{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "cargo", nullable = false)
	private String cargo;
	
	public Supervisor() {

	}

	public Supervisor(String cargo) {
		super();
		this.cargo = cargo;
	}

	public Supervisor(Integer idPersona, String cedula, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, String contrasenia, String telefono, String viaDireccion,
			String numeroDireccion, String complementoDireccion, String cargo) {
		super(idPersona, cedula, primerNombre, segundoNombre, primerApellido, segundoApellido, contrasenia, telefono,
				viaDireccion, numeroDireccion, complementoDireccion);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
