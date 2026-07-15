package co.edu.unbosque.backProyectoPoligamia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unbosque.backProyectoPoligamia.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

	@Query("SELECT SUM(c.monto) FROM Compra c WHERE c.pareja.idPersona = :idPareja")
	Double sumMontoByParejaIdPersona(@Param("idPareja") Integer idPareja);

	List<Compra> findAllByOrderByFechaDescHoraDesc();
}