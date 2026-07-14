package co.edu.unbosque.backProyectoPoligamia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.backProyectoPoligamia.dto.CompraDTO;
import co.edu.unbosque.backProyectoPoligamia.service.CompraService;

@RestController
@RequestMapping("/compra")
@CrossOrigin("*")
public class CompraController {

	@Autowired
	private CompraService compraServ;

	@PostMapping(path = "/createjson/{idPareja}/{idAlmacen}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createWithJSON(@PathVariable int idPareja, @PathVariable int idAlmacen,
			@RequestBody CompraDTO nuevaCompra) {
		int estado = compraServ.create(idPareja, idAlmacen, nuevaCompra);
		switch (estado) {
			case 0:
				return ResponseEntity.status(HttpStatus.CREATED).body("Compra creada exitosamente");
			case 1:
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La pareja no existe");
			default:
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El almacén no existe");
		}
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(compraServ.getAll());
	}

	@GetMapping("/get/{idCompra}")
	public ResponseEntity<?> getById(@PathVariable int idCompra) {

		CompraDTO found = compraServ.getById(idCompra);
		if (found == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
		}
		return ResponseEntity.ok(found);
	}

	@PutMapping(path = "/update/{idCompra}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable int idCompra, @RequestBody CompraDTO compraDTO) {
		int estado = compraServ.update(idCompra, compraDTO);
		return estado == 0
				? ResponseEntity.ok("Compra actualizada exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
	}

	@DeleteMapping("/delete/{idCompra}")
	public ResponseEntity<String> delete(@PathVariable int idCompra) {
		int estado = compraServ.delete(idCompra);
		return estado == 0
				? ResponseEntity.ok("Compra eliminada exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
	}

}