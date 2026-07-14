package co.edu.unbosque.backProyectoPoligamia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.backProyectoPoligamia.dto.LoginDTO;
import co.edu.unbosque.backProyectoPoligamia.model.Persona;
import co.edu.unbosque.backProyectoPoligamia.repository.PersonaRepository;
import co.edu.unbosque.backProyectoPoligamia.security.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = { "*" })
public class AuthController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getCedula(), loginRequest.getContrasenia()));
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String jwt = jwtUtil.generateToken(userDetails);
			String rol = userDetails.getAuthorities().stream()
					.findFirst()
					.map(a -> a.getAuthority().replace("ROLE_", ""))
					.orElse(null);
			
			return ResponseEntity.ok(new AuthResponse(jwt, rol));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body("Cédula o contraseña inválidas");
		}
	}
	
	@GetMapping("/me")
	public ResponseEntity<?> me(Authentication authentication) {
		String cedula = authentication.getName();
		Persona persona = personaRepository.findByCedula(cedula).orElse(null);
		if (persona == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
		}
		String rol = authentication.getAuthorities().stream()
				.findFirst()
				.map(a -> a.getAuthority().replace("ROLE_", ""))
				.orElse(null);

		StringBuilder nombreCompleto = new StringBuilder();
		nombreCompleto.append(persona.getPrimerNombre());
		if (persona.getSegundoNombre() != null && !persona.getSegundoNombre().isBlank()) {
			nombreCompleto.append(" ").append(persona.getSegundoNombre());
		}
		nombreCompleto.append(" ").append(persona.getPrimerApellido());
		if (persona.getSegundoApellido() != null && !persona.getSegundoApellido().isBlank()) {
			nombreCompleto.append(" ").append(persona.getSegundoApellido());
		}

		return ResponseEntity.ok(new UsuarioActual(persona.getIdPersona(), nombreCompleto.toString(), rol));
	}

	private static class AuthResponse {

		private final String token;
		private final String rol;

		public AuthResponse(String token, String rol) {
			this.token = token;
			this.rol = rol;
		}

		public String getToken() {
			return token;
		}

		public String getRol() {
			return rol;
		}
	}
	
	private static class UsuarioActual {
		private final Integer idPersona;
		private final String nombreCompleto;
		private final String rol;

		public UsuarioActual(Integer idPersona, String nombreCompleto, String rol) {
			this.idPersona = idPersona;
			this.nombreCompleto = nombreCompleto;
			this.rol = rol;
		}

		public Integer getIdPersona() {
			return idPersona;
		}

		public String getNombreCompleto() {
			return nombreCompleto;
		}

		public String getRol() {
			return rol;
		}
	}

}