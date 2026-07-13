package co.edu.unbosque.backProyectoPoligamia.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente_pareja")
public class ClientePareja {

    @EmbeddedId
    private ClienteParejaId id;

    @ManyToOne
    @MapsId("idCliente")
    @JoinColumn(name = "Id_cliente")
    private Cliente cliente;

    @ManyToOne
    @MapsId("idPareja")
    @JoinColumn(name = "Id_pareja")
    private Pareja pareja;

}