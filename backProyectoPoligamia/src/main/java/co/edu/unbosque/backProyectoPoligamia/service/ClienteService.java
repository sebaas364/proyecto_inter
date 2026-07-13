package co.edu.unbosque.backProyectoPoligamia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.unbosque.backProyectoPoligamia.dto.ClienteDTO;
import co.edu.unbosque.backProyectoPoligamia.model.Cliente;
import co.edu.unbosque.backProyectoPoligamia.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public int create(ClienteDTO dto) {
		Optional<Cliente> found = clienteRepo.findByCedula(dto.getCedula());
		if (found.isEmpty()) {
			Cliente entity = modelMapper.map(dto, Cliente.class);
			entity.setIdPersona(null);
			entity.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
			clienteRepo.save(entity);
			return 0;
		}
		return 1;
	}

	public List<ClienteDTO> getAll() {
		List<ClienteDTO> dtoList = new ArrayList<>();
		for (Cliente c : clienteRepo.findAll()) {
			dtoList.add(modelMapper.map(c, ClienteDTO.class));
		}
		return dtoList;
	}

	public Optional<ClienteDTO> getById(int idPersona) {
		Optional<Cliente> found = clienteRepo.findById(idPersona);
		return found.map(c -> modelMapper.map(c, ClienteDTO.class));
	}

	public int update(int idPersona, ClienteDTO dto) {
		Optional<Cliente> found = clienteRepo.findById(idPersona);
		if (found.isPresent()) {
			Cliente cliente = found.get();

			// Campos heredados de Persona
			cliente.setCedula(dto.getCedula());
			cliente.setPrimerNombre(dto.getPrimerNombre());
			cliente.setSegundoNombre(dto.getSegundoNombre());
			cliente.setPrimerApellido(dto.getPrimerApellido());
			cliente.setSegundoApellido(dto.getSegundoApellido());
			cliente.setTelefono(dto.getTelefono());
			cliente.setViaDireccion(dto.getViaDireccion());
			cliente.setNumeroDireccion(dto.getNumeroDireccion());
			cliente.setComplementoDireccion(dto.getComplementoDireccion());

			// Campo propio de Cliente
			cliente.setCupoTotalCredito(dto.getCupoTotalCredito());

			// La contraseña solo se actualiza si mandan una nueva
			if (dto.getContrasenia() != null && !dto.getContrasenia().isBlank()) {
				cliente.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
			}

			clienteRepo.save(cliente);
			return 0;
		}
		return 1;
	}

	public int delete(int idPersona) {
		Optional<Cliente> found = clienteRepo.findById(idPersona);
		if (found.isPresent()) {
			clienteRepo.deleteById(idPersona);
			return 0;
		}
		return 1;
	}
}
