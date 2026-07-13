package co.edu.unbosque.backProyectoPoligamia.dto;

public class SupervisorDTO extends PersonaDTO {

	private String cargo;

	public SupervisorDTO() {

	}

	public SupervisorDTO(String cargo) {
		super();
		this.cargo = cargo;
	}

	public SupervisorDTO(Integer idPersona, String cedula, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, String contrasenia, String telefono,
			String viaDireccion, String numeroDireccion, String complementoDireccion, String cargo) {
		super(idPersona, cedula, primerNombre, segundoNombre, primerApellido, segundoApellido, contrasenia,
				telefono, viaDireccion, numeroDireccion, complementoDireccion);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}