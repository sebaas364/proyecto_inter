package co.edu.unbosque.backProyectoPoligamia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.backProyectoPoligamia.dto.AutorizacionSobrecupoDTO;
import co.edu.unbosque.backProyectoPoligamia.model.AutorizacionSobrecupo;
import co.edu.unbosque.backProyectoPoligamia.model.Compra;
import co.edu.unbosque.backProyectoPoligamia.model.Supervisor;
import co.edu.unbosque.backProyectoPoligamia.repository.AutorizacionSobrecupoRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.CompraRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.SupervisorRepository;

@Service
public class AutorizacionSobrecupoService {

	@Autowired
	private AutorizacionSobrecupoRepository autorizacionRepo;

	@Autowired
	private SupervisorRepository supervisorRepo;

	@Autowired
	private CompraRepository compraRepo;

	@Autowired
	private ModelMapper modelMapper;

	public int create(int idSupervisor, int idCompra, AutorizacionSobrecupoDTO dto) {
		Optional<Supervisor> supervisorOpt = supervisorRepo.findById(idSupervisor);
		Optional<Compra> compraOpt = compraRepo.findById(idCompra);

		if (supervisorOpt.isEmpty()) {
			return 1; // el supervisor no existe
		}
		if (compraOpt.isEmpty()) {
			return 2; // la compra no existe
		}
		if (autorizacionRepo.existsByCompraIdCompra(idCompra)) {
			return 3; // esa compra ya tiene una autorización registrada
		}

		AutorizacionSobrecupo entity = new AutorizacionSobrecupo();
		entity.setHora(dto.getHora());
		entity.setFecha(dto.getFecha());
		entity.setSupervisor(supervisorOpt.get());
		entity.setCompra(compraOpt.get());

		autorizacionRepo.save(entity);
		return 0;
	}

	public List<AutorizacionSobrecupoDTO> getAll() {
		List<AutorizacionSobrecupoDTO> dtoList = new ArrayList<>();
		for (AutorizacionSobrecupo a : autorizacionRepo.findAll()) {
			dtoList.add(modelMapper.map(a, AutorizacionSobrecupoDTO.class));
		}
		return dtoList;
	}

	public AutorizacionSobrecupoDTO getById(int idAutorizacion) {
		Optional<AutorizacionSobrecupo> found = autorizacionRepo.findById(idAutorizacion);
		if (found.isEmpty()) {
			return null;
		}
		return modelMapper.map(found.get(), AutorizacionSobrecupoDTO.class);
	}

	public int update(int idAutorizacion, AutorizacionSobrecupoDTO dto) {
		Optional<AutorizacionSobrecupo> found = autorizacionRepo.findById(idAutorizacion);
		if (found.isPresent()) {
			AutorizacionSobrecupo autorizacion = found.get();
			autorizacion.setHora(dto.getHora());
			autorizacion.setFecha(dto.getFecha());
			autorizacionRepo.save(autorizacion);
			return 0;
		}
		return 1;
	}

	public int delete(int idAutorizacion) {
		Optional<AutorizacionSobrecupo> found = autorizacionRepo.findById(idAutorizacion);
		if (found.isPresent()) {
			autorizacionRepo.deleteById(idAutorizacion);
			return 0;
		}
		return 1;
	}

}