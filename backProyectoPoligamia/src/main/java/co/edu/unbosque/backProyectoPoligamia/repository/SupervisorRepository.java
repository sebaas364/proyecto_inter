package co.edu.unbosque.backProyectoPoligamia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.backProyectoPoligamia.model.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {

	Optional<Supervisor> findByCedula(String cedula);

}