package co.edu.unbosque.backProyectoPoligamia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.unbosque.backProyectoPoligamia.dto.ClienteDTO;
import co.edu.unbosque.backProyectoPoligamia.dto.ClienteDashboardDTO;
import co.edu.unbosque.backProyectoPoligamia.dto.ResumenParejaDTO;
import co.edu.unbosque.backProyectoPoligamia.model.Cliente;
import co.edu.unbosque.backProyectoPoligamia.model.ClientePareja;
import co.edu.unbosque.backProyectoPoligamia.model.Pareja;
import co.edu.unbosque.backProyectoPoligamia.repository.ClienteParejaRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
	private ClienteParejaRepository clienteParejaRepo;

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

	public ClienteDTO getById(int idPersona) {
		Optional<Cliente> found = clienteRepo.findById(idPersona);
		if (found.isEmpty()) {
			return null;
		}
		return modelMapper.map(found.get(), ClienteDTO.class);
	}

	public ClienteDTO getByCedula(String cedula) {
		Optional<Cliente> found = clienteRepo.findByCedula(cedula);
		if (found.isEmpty()) {
			return null;
		}
		return modelMapper.map(found.get(), ClienteDTO.class);
	}

	public ClienteDashboardDTO getDashboardByCedula(String cedula) {
		Optional<Cliente> found = clienteRepo.findByCedula(cedula);
		if (found.isEmpty()) {
			return null;
		}
		Cliente cliente = found.get();

		List<ClientePareja> relaciones = clienteParejaRepo.findByIdIdCliente(cliente.getIdPersona());
		List<ResumenParejaDTO> resumenParejas = new ArrayList<ResumenParejaDTO>();

		for (ClientePareja clientePareja : relaciones) {
			Pareja pareja = clientePareja.getPareja();

			resumenParejas.add(new ResumenParejaDTO(pareja.getIdPersona(),
					nombreCompleto(pareja.getPrimerNombre(), pareja.getSegundoNombre(),
							pareja.getPrimerApellido(), pareja.getSegundoApellido()),
					pareja.getCupoCredito()));
		}
		
		double cupoAsignado = resumenParejas.stream().mapToDouble(ResumenParejaDTO::getCupoCredito).sum();

		return new ClienteDashboardDTO(
				cliente.getIdPersona(), nombreCompleto(cliente.getPrimerNombre(), cliente.getSegundoNombre(),
						cliente.getPrimerApellido(), cliente.getSegundoApellido()),
				cliente.getCupoTotalCredito(), cupoAsignado, resumenParejas);
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

	public String nombreCompleto(String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido) {
		StringBuilder sb = new StringBuilder();
		sb.append(primerNombre);

		if (segundoNombre != null && !segundoNombre.isBlank()) {
			sb.append(" ").append(segundoNombre);
		}
		sb.append(" ").append(primerApellido);
		if (segundoApellido != null && !segundoApellido.isBlank()) {
			sb.append(" ").append(segundoApellido);
		}
		return sb.toString();
	}
}
