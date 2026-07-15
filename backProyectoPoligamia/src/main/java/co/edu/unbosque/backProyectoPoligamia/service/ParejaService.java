package co.edu.unbosque.backProyectoPoligamia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.unbosque.backProyectoPoligamia.dto.ParejaDTO;
import co.edu.unbosque.backProyectoPoligamia.dto.ParejaListaDTO;
import co.edu.unbosque.backProyectoPoligamia.model.Cliente;
import co.edu.unbosque.backProyectoPoligamia.model.ClientePareja;
import co.edu.unbosque.backProyectoPoligamia.model.ClienteParejaId;
import co.edu.unbosque.backProyectoPoligamia.model.Pareja;
import co.edu.unbosque.backProyectoPoligamia.repository.ClienteParejaRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.ClienteRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.ParejaRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.RestriccionRepository;

@Service
public class ParejaService {

	@Autowired
	private ParejaRepository parejaRepo;
	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private ClienteParejaRepository clienteParejaRepo;
	@Autowired
	private RestriccionRepository restriccionRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public int create(ParejaDTO dto) {
		Optional<Pareja> found = parejaRepo.findByCedula(dto.getCedula());
		if (found.isEmpty()) {
			Integer idClienteAutenticado = dto.getClienteParejas().getFirst().getCliente().getIdPersona();
			Optional<Cliente> clienteOpt = clienteRepo.findById(idClienteAutenticado);
			if (clienteOpt.isEmpty()) {
				return 2;
			}
			Cliente cliente = clienteOpt.get();

			Pareja entity = modelMapper.map(dto, Pareja.class);
			entity.setIdPersona(null);
			entity.setClienteParejas(null);
			entity.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
			Pareja parejaSaved = parejaRepo.save(entity);

			ClienteParejaId cpId = new ClienteParejaId(cliente.getIdPersona(), parejaSaved.getIdPersona());
			ClientePareja cp = new ClientePareja(cpId, cliente, parejaSaved);
			clienteParejaRepo.save(cp);

			return 0;
		}
		return 1;
	}

	public List<ParejaDTO> getAll() {
		List<ParejaDTO> dtoList = new ArrayList<>();
		for (Pareja p : parejaRepo.findAll()) {
			dtoList.add(modelMapper.map(p, ParejaDTO.class));
		}
		return dtoList;
	}

	public ParejaDTO getById(int idPersona) {
		Optional<Pareja> found = parejaRepo.findById(idPersona);
		if (found.isEmpty()) {
			return null; 
		}
		return modelMapper.map(found.get(), ParejaDTO.class);
	}

	public int update(int idPersona, ParejaDTO dto) {
		Optional<Pareja> found = parejaRepo.findById(idPersona);
		if (found.isPresent()) {
			Pareja pareja = found.get();

			// Campos heredados de Persona
			pareja.setCedula(dto.getCedula());
			pareja.setPrimerNombre(dto.getPrimerNombre());
			pareja.setSegundoNombre(dto.getSegundoNombre());
			pareja.setPrimerApellido(dto.getPrimerApellido());
			pareja.setSegundoApellido(dto.getSegundoApellido());
			pareja.setTelefono(dto.getTelefono());
			pareja.setViaDireccion(dto.getViaDireccion());
			pareja.setNumeroDireccion(dto.getNumeroDireccion());
			pareja.setComplementoDireccion(dto.getComplementoDireccion());

			// Campos propios de Pareja
			pareja.setCupoCredito(dto.getCupoCredito());
			pareja.setEstado(dto.getEstado());

			if (dto.getContrasenia() != null && !dto.getContrasenia().isBlank()) {
				pareja.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
			}

			parejaRepo.save(pareja);
			return 0;
		}
		return 1;
	}

	public int delete(int idPersona) {
		Optional<Pareja> found = parejaRepo.findById(idPersona);
		if (found.isPresent()) {
			parejaRepo.deleteById(idPersona);
			return 0;
		}
		return 1;
	}

	
}