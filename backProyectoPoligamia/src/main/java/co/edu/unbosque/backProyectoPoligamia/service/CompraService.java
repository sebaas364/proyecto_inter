package co.edu.unbosque.backProyectoPoligamia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.backProyectoPoligamia.dto.CompraDTO;
import co.edu.unbosque.backProyectoPoligamia.dto.CompraHistorialDTO;
import co.edu.unbosque.backProyectoPoligamia.model.Almacen;
import co.edu.unbosque.backProyectoPoligamia.model.Compra;
import co.edu.unbosque.backProyectoPoligamia.model.Pareja;
import co.edu.unbosque.backProyectoPoligamia.repository.AlmacenRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.AutorizacionSobrecupoRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.CompraRepository;
import co.edu.unbosque.backProyectoPoligamia.repository.ParejaRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepo;

	@Autowired
	private ParejaRepository parejaRepo;

	@Autowired
	private AlmacenRepository almacenRepo;
	@Autowired
	private AutorizacionSobrecupoRepository autorizacionRepo;

	@Autowired
	private ModelMapper modelMapper;

	public int create(int idPareja, int idAlmacen, CompraDTO dto) {
		Optional<Pareja> parejaOpt = parejaRepo.findById(idPareja);
		Optional<Almacen> almacenOpt = almacenRepo.findById(idAlmacen);

		if (parejaOpt.isEmpty()) {
			return 1; // la pareja no existe
		}
		if (almacenOpt.isEmpty()) {
			return 2; // el almacén no existe
		}

		Compra entity = new Compra();
		entity.setFecha(dto.getFecha());
		entity.setHora(dto.getHora());
		entity.setMonto(dto.getMonto());
		entity.setSobrecupo(dto.getSobrecupo());
		entity.setPareja(parejaOpt.get());
		entity.setAlmacen(almacenOpt.get());

		compraRepo.save(entity);
		return 0;
	}

	public List<CompraDTO> getAll() {
		List<CompraDTO> dtoList = new ArrayList<>();
		for (Compra c : compraRepo.findAll()) {
			dtoList.add(modelMapper.map(c, CompraDTO.class));
		}
		return dtoList;
	}

	public CompraDTO getById(int idCompra) {
		Optional<Compra> found = compraRepo.findById(idCompra);
		if (found.isEmpty()) {
			return null;
		}
		return modelMapper.map(found.get(), CompraDTO.class);
	}

	public List<CompraHistorialDTO> getHistorialReciente() {
		List<CompraHistorialDTO> resultado = new ArrayList<>();

		List<Compra> compras = compraRepo.findAllByOrderByFechaDescHoraDesc();
		Pareja pareja;
			for (Compra compra : compras) {
				pareja = compra.getPareja();
				
				String estado;
				if (compra.getSobrecupo() == 'S' && !autorizacionRepo.existsByCompraIdCompra(compra.getIdCompra())) {
					estado = "Sobrecupo pendiente";
				} else {
					estado = "Aprobada";
				}

				resultado.add(new CompraHistorialDTO(
						compra.getIdCompra(),
						nombreCompleto(pareja.getPrimerNombre(), pareja.getSegundoNombre(), pareja.getPrimerApellido(), pareja.getSegundoApellido()),
						compra.getAlmacen().getNombre(),
						compra.getFecha(),
						compra.getHora(),
						compra.getMonto(),
						estado));
			}

			return resultado;
	}

	


	public int update(int idCompra, CompraDTO dto) {
		Optional<Compra> found = compraRepo.findById(idCompra);
		if (found.isPresent()) {
			Compra compra = found.get();
			compra.setFecha(dto.getFecha());
			compra.setHora(dto.getHora());
			compra.setMonto(dto.getMonto());
			compra.setSobrecupo(dto.getSobrecupo());
			compraRepo.save(compra);
			return 0;
		}
		return 1;
	}

	public int delete(int idCompra) {
		Optional<Compra> found = compraRepo.findById(idCompra);
		if (found.isPresent()) {
			compraRepo.deleteById(idCompra);
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
