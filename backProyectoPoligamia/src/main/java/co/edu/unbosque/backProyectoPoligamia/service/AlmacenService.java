package co.edu.unbosque.backProyectoPoligamia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.backProyectoPoligamia.dto.AlmacenDTO;
import co.edu.unbosque.backProyectoPoligamia.model.Almacen;
import co.edu.unbosque.backProyectoPoligamia.repository.AlmacenRepository;

@Service
public class AlmacenService {

	@Autowired
	private AlmacenRepository almacenRepo;

	@Autowired
	private ModelMapper modelMapper;

	public int create(AlmacenDTO dto) {
		if (dto != null) {
			Almacen entity = modelMapper.map(dto, Almacen.class);
			entity.setIdAlmacen(null);
			almacenRepo.save(entity);
			return 0;
		}
		return 1;
	}

	public List<AlmacenDTO> getAll() {
		List<AlmacenDTO> dtoList = new ArrayList<>();
		for (Almacen a : almacenRepo.findAll()) {
			dtoList.add(modelMapper.map(a, AlmacenDTO.class));
		}
		return dtoList;
	}

	public AlmacenDTO getById(int idAlmacen) {
		Optional<Almacen> found = almacenRepo.findById(idAlmacen);
		if (found.isEmpty()) {
			return null; 
		}
		return modelMapper.map(found.get(), AlmacenDTO.class);
	}

	public int update(int idAlmacen, AlmacenDTO dto) {
		Optional<Almacen> found = almacenRepo.findById(idAlmacen);
		if (found.isPresent()) {
			Almacen almacen = found.get();
			almacen.setNombre(dto.getNombre());
			almacen.setCiudad(dto.getCiudad());
			almacen.setViaDireccion(dto.getViaDireccion());
			almacen.setNumeroDireccion(dto.getNumeroDireccion());
			almacen.setComplementoDireccion(dto.getComplementoDireccion());
			almacenRepo.save(almacen);
			return 0;
		}
		return 1;
	}

	public int delete(int idAlmacen) {
		Optional<Almacen> found = almacenRepo.findById(idAlmacen);
		if (found.isPresent()) {
			almacenRepo.deleteById(idAlmacen);
			return 0;
		}
		return 1;
	}

}