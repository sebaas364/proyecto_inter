package co.edu.unbosque.backProyectoPoligamia.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.backProyectoPoligamia.dto.RestriccionDTO;
import co.edu.unbosque.backProyectoPoligamia.model.Pareja;
import co.edu.unbosque.backProyectoPoligamia.model.Restriccion;
import co.edu.unbosque.backProyectoPoligamia.model.RestriccionId;
import co.edu.unbosque.backProyectoPoligamia.repository.ParejaRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.RestriccionRepository;

@Service
public class RestriccionService {

	@Autowired
	private RestriccionRepository restriccionRepo;

	@Autowired
	private ParejaRepository parejaRepo;

	@Autowired
	private ModelMapper modelMapper;

	public int create(int idPareja, RestriccionDTO dto) {
		Optional<Pareja> parejaOpt = parejaRepo.findById(idPareja);

		if (parejaOpt.isEmpty()) {
			return 1; // la pareja no existe
		}
		if (restriccionRepo.existsByIdIdPareja(idPareja)) {
			return 2; // esa pareja ya tiene una restricción registrada
		}
		
		List<Restriccion> all = restriccionRepo.findAll();
		Pareja pareja = parejaOpt.get();
		List<Integer> ids = new ArrayList<Integer>();
		for (Restriccion r : all) {
			ids.add(r.getId().getIdRestriccion());
		}
		
		Integer nextId;
		if(all.isEmpty()) {
			nextId = 1;
		}else {
			nextId = Collections.max(ids)+1;
		}

		Restriccion entity = new Restriccion();
		entity.setId(new RestriccionId(nextId, idPareja));
		entity.setPareja(pareja);
		entity.setDia(dto.getDia());
		entity.setHoraInicio(dto.getHoraInicio());
		entity.setHoraFin(dto.getHoraFin());
		entity.setEstado(dto.getEstado());

		restriccionRepo.save(entity);
		return 0;
	}

	public List<RestriccionDTO> getAll() {
		List<RestriccionDTO> dtoList = new ArrayList<>();
		for (Restriccion r : restriccionRepo.findAll()) {
			dtoList.add(modelMapper.map(r, RestriccionDTO.class));
		}
		return dtoList;
	}

	public RestriccionDTO getByIdPareja(int idPareja) {
		Optional<Restriccion> found = restriccionRepo.findByIdIdPareja(idPareja);
		if (found.isEmpty()) {
			return null; 
		}
		return modelMapper.map(found.get(), RestriccionDTO.class);
	}

	public int update(int idPareja, RestriccionDTO dto) {
		Optional<Restriccion> found = restriccionRepo.findByIdIdPareja(idPareja);
		if (found.isPresent()) {
			Restriccion restriccion = found.get();
			restriccion.setDia(dto.getDia());
			restriccion.setHoraInicio(dto.getHoraInicio());
			restriccion.setHoraFin(dto.getHoraFin());
			restriccion.setEstado(dto.getEstado());
			restriccionRepo.save(restriccion);
			return 0;
		}
		return 1;
	}

	public int delete(int idPareja) {
		Optional<Restriccion> found = restriccionRepo.findByIdIdPareja(idPareja);
		if (found.isPresent()) {
			restriccionRepo.delete(found.get());
			return 0;
		}
		return 1;
	}
}