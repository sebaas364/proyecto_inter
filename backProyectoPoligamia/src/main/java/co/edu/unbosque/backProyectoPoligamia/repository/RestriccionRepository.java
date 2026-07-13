package co.edu.unbosque.backProyectoPoligamia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unbosque.backProyectoPoligamia.model.Restriccion;
import co.edu.unbosque.backProyectoPoligamia.model.RestriccionId;

public interface RestriccionRepository extends JpaRepository<Restriccion, RestriccionId> {

	Optional<Restriccion> findByIdIdPareja(Integer idPareja);

	boolean existsByIdIdPareja(Integer idPareja);

	@Query("SELECT COALESCE(MAX(r.id.idRestriccion), 0) + 1 FROM Restriccion r")
	Integer getNextIdRestriccion();

}