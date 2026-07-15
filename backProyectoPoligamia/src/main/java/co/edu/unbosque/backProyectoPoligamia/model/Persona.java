package co.edu.unbosque.backProyectoPoligamia.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSONA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_persona")
	private Integer idPersona;
	
	@Column(name="cedula", nullable = false, unique = true)
	private String cedula;
	
	@Column(name = "primerNombre", nullable = false)
	private String primerNombre;

	@Column(name = "segundoNombre")
	private String segundoNombre;

	@Column(name = "primerApellido", nullable = false)
	private String primerApellido;

	@Column(name = "segundoApellido")
	private String segundoApellido;
	
	@Column(name = "contrasenia", nullable = false)
	private String contrasenia;
	
	@Column(name = "telefono" )
	private String telefono;
	
	@Column(name = "Via_direccion")
	private String viaDireccion;
	
	@Column(name = "Numero_direccion")
	private String numeroDireccion;
	
	@Column(name = "Complemento_direccion")
	private String complementoDireccion;
	
	public Persona() {

	}

	public Persona(Integer idPersona, String cedula, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String contrasenia, String telefono, String viaDireccion, String numeroDireccion,
			String complementoDireccion) {
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String rol;
		if (this instanceof Supervisor) {
			rol = "SUPERVISOR";
		} else if (this instanceof Cliente) {
			rol = "CLIENTE";
		} else if (this instanceof Pareja) {
			rol = "PAREJA";
		} else {
			rol = "PERSONA";
		}
		return List.of(new SimpleGrantedAuthority("ROLE_" + rol));
	}

	@Override
	public String getPassword() {
		return contrasenia;
	}

	@Override
	public String getUsername() {
		return cedula;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
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
