package co.edu.unbosque.backProyectoPoligamia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.backProyectoPoligamia.model.ClientePareja;
import co.edu.unbosque.backProyectoPoligamia.model.ClienteParejaId;

public interface ClienteParejaRepository extends JpaRepository<ClientePareja, ClienteParejaId> {

	List<ClientePareja> findByIdIdCliente(Integer idCliente);

	List<ClientePareja> findByIdIdPareja(Integer idPareja);

}