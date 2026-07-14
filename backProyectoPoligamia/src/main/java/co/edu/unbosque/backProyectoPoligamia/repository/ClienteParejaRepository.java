package co.edu.unbosque.backProyectoPoligamia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.backProyectoPoligamia.model.ClientePareja;
import co.edu.unbosque.backProyectoPoligamia.model.ClienteParejaId;

public interface ClienteParejaRepository extends JpaRepository<ClientePareja, ClienteParejaId> {

	Optional<ClientePareja> findByIdIdCliente(Integer idCliente);

	Optional<ClientePareja> findByIdIdPareja(Integer idPareja);

}