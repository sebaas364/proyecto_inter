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

    public ClientePareja() {

    }

    public ClientePareja(ClienteParejaId id, Cliente cliente, Pareja pareja) {
        super();
        this.id = id;
        this.cliente = cliente;
        this.pareja = pareja;
    }

    public ClienteParejaId getId() {
        return id;
    }

    public void setId(ClienteParejaId id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }

}