package co.edu.unbosque.backProyectoPoligamia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.backProyectoPoligamia.dto.ClienteDTO;
import co.edu.unbosque.backProyectoPoligamia.dto.ClienteDashboardDTO;
import co.edu.unbosque.backProyectoPoligamia.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

	@Autowired
	private ClienteService clienteServ;

	@PostMapping(path = "/createjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createWithJSON(@RequestBody ClienteDTO nuevoCliente) {
		int estado = clienteServ.create(nuevoCliente);
		return estado == 0
				? ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body("Error al crear el cliente, la cédula ya está registrada");
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(clienteServ.getAll());
	}

	@GetMapping("/get/{idPersona}")
	public ResponseEntity<?> getById(@PathVariable int idPersona) {
		ClienteDTO found = clienteServ.getById(idPersona);
		if(found ==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado/a");
		}
		return ResponseEntity.ok(found);	
	}
	
	@GetMapping("/getbycedula/{cedula}")
	public ResponseEntity<?> getByCedula(@PathVariable String cedula) {
		ClienteDTO found = clienteServ.getByCedula(cedula);
		if (found == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado/a");
		}
		return ResponseEntity.ok(found);
	}
	
	@GetMapping("/dashboard")
	public ResponseEntity<?> getDashboard(Authentication authentication) {
		String cedula = authentication.getName();
		ClienteDashboardDTO dashboard = clienteServ.getDashboardByCedula(cedula);
		if (dashboard == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado/a");
		}
		return ResponseEntity.ok(dashboard);
	}

	@PutMapping(path = "/update/{idPersona}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable int idPersona, @RequestBody ClienteDTO clienteDTO) {
		int estado = clienteServ.update(idPersona, clienteDTO);
		return estado == 0
				? ResponseEntity.ok("Cliente actualizado exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
	}

	@DeleteMapping("/delete/{idPersona}")
	public ResponseEntity<String> delete(@PathVariable int idPersona) {
		int estado = clienteServ.delete(idPersona);
		return estado == 0
				? ResponseEntity.ok("Cliente eliminado exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
	}

}