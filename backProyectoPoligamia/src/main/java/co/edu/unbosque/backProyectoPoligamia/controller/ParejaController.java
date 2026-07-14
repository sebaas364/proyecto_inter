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

import co.edu.unbosque.backProyectoPoligamia.dto.ParejaDTO;
import co.edu.unbosque.backProyectoPoligamia.service.ParejaService;

@RestController
@RequestMapping("/pareja")
@CrossOrigin("*")
public class ParejaController {

	@Autowired
	private ParejaService parejaServ;

	@PostMapping(path = "/createjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createWithJSON(@RequestBody ParejaDTO nuevaPareja) {
		int estado = parejaServ.create(nuevaPareja);
		return estado == 0
				? ResponseEntity.status(HttpStatus.CREATED).body("Pareja creada exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body("Error al crear la pareja, la cédula ya está registrada");
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(parejaServ.getAll());
	}

	@GetMapping("/get/{idPersona}")
	public ResponseEntity<?> getById(@PathVariable int idPersona) {
		
		ParejaDTO found = parejaServ.getById(idPersona);
		if(found ==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pareja no encontrada");
		}
		return ResponseEntity.ok(found);				
	}

	@PutMapping(path = "/update/{idPersona}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable int idPersona, @RequestBody ParejaDTO parejaDTO) {
		int estado = parejaServ.update(idPersona, parejaDTO);
		return estado == 0
				? ResponseEntity.ok("Pareja actualizada exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pareja no encontrada");
	}

	@DeleteMapping("/delete/{idPersona}")
	public ResponseEntity<String> delete(@PathVariable int idPersona) {
		int estado = parejaServ.delete(idPersona);
		return estado == 0
				? ResponseEntity.ok("Pareja eliminada exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pareja no encontrada");
	}

}