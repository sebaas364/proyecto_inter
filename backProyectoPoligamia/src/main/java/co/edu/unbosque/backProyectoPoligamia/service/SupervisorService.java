package co.edu.unbosque.backProyectoPoligamia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.unbosque.backProyectoPoligamia.dto.SupervisorDTO;
import co.edu.unbosque.backProyectoPoligamia.model.Supervisor;
import co.edu.unbosque.backProyectoPoligamia.repository.SupervisorRepository;

@Service
public class SupervisorService {

	@Autowired
	private SupervisorRepository supervisorRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public int create(SupervisorDTO dto) {
		Optional<Supervisor> found = supervisorRepo.findByCedula(dto.getCedula());
		if (found.isEmpty()) {
			Supervisor entity = modelMapper.map(dto, Supervisor.class);
			entity.setIdPersona(null);
			entity.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
			supervisorRepo.save(entity);
			return 0;
		}
		return 1;
	}

	public List<SupervisorDTO> getAll() {
		List<SupervisorDTO> dtoList = new ArrayList<>();
		for (Supervisor s : supervisorRepo.findAll()) {
			dtoList.add(modelMapper.map(s, SupervisorDTO.class));
		}
		return dtoList;
	}

	public SupervisorDTO getById(int idPersona) {
		Optional<Supervisor> found = supervisorRepo.findById(idPersona);
		if (found.isEmpty()) {
			return null; 
		}
		return modelMapper.map(found.get(), SupervisorDTO.class);
	}

	public int update(int idPersona, SupervisorDTO dto) {
		Optional<Supervisor> found = supervisorRepo.findById(idPersona);
		if (found.isPresent()) {
			Supervisor supervisor = found.get();

			// Campos heredados de Persona
			supervisor.setCedula(dto.getCedula());
			supervisor.setPrimerNombre(dto.getPrimerNombre());
			supervisor.setSegundoNombre(dto.getSegundoNombre());
			supervisor.setPrimerApellido(dto.getPrimerApellido());
			supervisor.setSegundoApellido(dto.getSegundoApellido());
			supervisor.setTelefono(dto.getTelefono());
			supervisor.setViaDireccion(dto.getViaDireccion());
			supervisor.setNumeroDireccion(dto.getNumeroDireccion());
			supervisor.setComplementoDireccion(dto.getComplementoDireccion());

			// Campo propio de Supervisor
			supervisor.setCargo(dto.getCargo());

			if (dto.getContrasenia() != null && !dto.getContrasenia().isBlank()) {
				supervisor.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
			}

			supervisorRepo.save(supervisor);
			return 0;
		}
		return 1;
	}

	public int delete(int idPersona) {
		Optional<Supervisor> found = supervisorRepo.findById(idPersona);
		if (found.isPresent()) {
			supervisorRepo.deleteById(idPersona);
			return 0;
		}
		return 1;
	}

}