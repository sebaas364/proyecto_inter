package co.edu.unbosque.backProyectoPoligamia.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.unbosque.backProyectoPoligamia.repository.PersonaRepository;

@Service
public class PersonaDetailsServiceImpl implements UserDetailsService {

	private final PersonaRepository personaRepository;

	public PersonaDetailsServiceImpl(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String cedula) throws UsernameNotFoundException {
		return personaRepository.findByCedula(cedula)
				.orElseThrow(() -> new UsernameNotFoundException("No existe una persona con cédula: " + cedula));
	}

}