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

import co.edu.unbosque.backProyectoPoligamia.dto.RestriccionDTO;
import co.edu.unbosque.backProyectoPoligamia.service.RestriccionService;

@RestController
@RequestMapping("/restriccion")
@CrossOrigin("*")
public class RestriccionController {

	@Autowired
	private RestriccionService restriccionServ;

	@PostMapping(path = "/createjson/{idPareja}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createWithJSON(@PathVariable int idPareja, @RequestBody RestriccionDTO nuevaRestriccion) {
		int estado = restriccionServ.create(idPareja, nuevaRestriccion);
		switch (estado) {
			case 0:
				return ResponseEntity.status(HttpStatus.CREATED).body("Restricción creada exitosamente");
			case 1:
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La pareja no existe");
			default:
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body("Esa pareja ya tiene una restricción registrada");
		}
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(restriccionServ.getAll());
	}

	@GetMapping("/get/{idPareja}")
	public ResponseEntity<?> getByIdPareja(@PathVariable int idPareja) {
		
		RestriccionDTO found = restriccionServ.getByIdPareja(idPareja);
		if(found ==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pareja no encontrada");
		}
		return ResponseEntity.ok(found);	
	}

	@PutMapping(path = "/update/{idPareja}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable int idPareja, @RequestBody RestriccionDTO restriccionDTO) {
		int estado = restriccionServ.update(idPareja, restriccionDTO);
		return estado == 0
				? ResponseEntity.ok("Restricción actualizada exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restricción no encontrada");
	}

	@DeleteMapping("/delete/{idPareja}")
	public ResponseEntity<String> delete(@PathVariable int idPareja) {
		int estado = restriccionServ.delete(idPareja);
		return estado == 0
				? ResponseEntity.ok("Restricción eliminada exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restricción no encontrada");
	}

}