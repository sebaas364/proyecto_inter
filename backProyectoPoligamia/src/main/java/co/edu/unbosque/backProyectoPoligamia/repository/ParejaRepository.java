package co.edu.unbosque.backProyectoPoligamia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.backProyectoPoligamia.model.Pareja;

public interface ParejaRepository extends JpaRepository<Pareja, Integer> {

	Optional<Pareja> findByCedula(String cedula);

}