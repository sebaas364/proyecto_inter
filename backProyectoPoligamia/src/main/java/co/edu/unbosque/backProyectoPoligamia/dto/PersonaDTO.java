package co.edu.unbosque.backProyectoPoligamia.dto;

public class PersonaDTO {

	private Integer idPersona;
	private String cedula;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String contrasenia;
	private String telefono;
	private String viaDireccion;
	private String numeroDireccion;
	private String complementoDireccion;

	public PersonaDTO() {

	}

	public PersonaDTO(Integer idPersona, String cedula, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, String contrasenia, String telefono,
			String viaDireccion, String numeroDireccion, String complementoDireccion) {
		super();
		this.idPersona = idPersona;
		this.cedula = cedula;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.contrasenia = contrasenia;
		this.telefono = telefono;
		this.viaDireccion = viaDireccion;
		this.numeroDireccion = numeroDireccion;
		this.complementoDireccion = complementoDireccion;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getViaDireccion() {
		return viaDireccion;
	}

	public void setViaDireccion(String viaDireccion) {
		this.viaDireccion = viaDireccion;
	}

	public String getNumeroDireccion() {
		return numeroDireccion;
	}

	public void setNumeroDireccion(String numeroDireccion) {
		this.numeroDireccion = numeroDireccion;
	}

	public String getComplementoDireccion() {
		return complementoDireccion;
	}

	public void setComplementoDireccion(String complementoDireccion) {
		this.complementoDireccion = complementoDireccion;
	}

}