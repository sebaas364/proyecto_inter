package co.edu.unbosque.backProyectoPoligamia.dto;

public class LoginDTO {

	private String cedula;
	private String contrasenia;

	public LoginDTO() {

	}

	public LoginDTO(String cedula, String contrasenia) {
		super();
		this.cedula = cedula;
		this.contrasenia = contrasenia;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}