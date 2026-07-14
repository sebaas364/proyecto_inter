package co.edu.unbosque.backProyectoPoligamia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.backProyectoPoligamia.model.AutorizacionSobrecupo;

public interface AutorizacionSobrecupoRepository extends JpaRepository<AutorizacionSobrecupo, Integer> {

	boolean existsByCompraIdCompra(Integer idCompra);

}