package co.edu.unbosque.backProyectoPoligamia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.backProyectoPoligamia.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	Optional<Persona> findByCedula(String cedula);

	boolean existsByCedula(String cedula);

}