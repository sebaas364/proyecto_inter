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

import co.edu.unbosque.backProyectoPoligamia.dto.SupervisorDTO;
import co.edu.unbosque.backProyectoPoligamia.service.SupervisorService;

@RestController
@RequestMapping("/supervisor")
@CrossOrigin("*")
public class SupervisorController {

	@Autowired
	private SupervisorService supervisorServ;

	@PostMapping(path = "/createjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createWithJSON(@RequestBody SupervisorDTO nuevoSupervisor) {
		int estado = supervisorServ.create(nuevoSupervisor);
		return estado == 0
				? ResponseEntity.status(HttpStatus.CREATED).body("Supervisor creado exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body("Error al crear el supervisor, la cédula ya está registrada");
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(supervisorServ.getAll());
	}

	@GetMapping("/get/{idPersona}")
	public ResponseEntity<?> getById(@PathVariable int idPersona) {
		
		SupervisorDTO found = supervisorServ.getById(idPersona);
		if(found ==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supervisor no encontrado");
		}
		return ResponseEntity.ok(found);	
	}

	@PutMapping(path = "/update/{idPersona}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable int idPersona, @RequestBody SupervisorDTO supervisorDTO) {
		int estado = supervisorServ.update(idPersona, supervisorDTO);
		return estado == 0
				? ResponseEntity.ok("Supervisor actualizado exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supervisor no encontrado");
	}

	@DeleteMapping("/delete/{idPersona}")
	public ResponseEntity<String> delete(@PathVariable int idPersona) {
		int estado = supervisorServ.delete(idPersona);
		return estado == 0
				? ResponseEntity.ok("Supervisor eliminado exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supervisor no encontrado");
	}

}