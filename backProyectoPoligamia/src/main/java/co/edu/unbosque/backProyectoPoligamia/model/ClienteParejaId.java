package co.edu.unbosque.backProyectoPoligamia.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ClienteParejaId implements Serializable {

   
	private static final long serialVersionUID = 1L;

	@Column(name = "Id_cliente")
    private Integer idCliente;

    @Column(name = "Id_pareja")
    private Integer idPareja;

    public ClienteParejaId() {
    	
    }
    
    public ClienteParejaId(Integer idCliente, Integer idPareja) {
		super();
		this.idCliente = idCliente;
		this.idPareja = idPareja;
	}
    
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdPareja() {
		return idPareja;
	}

	public void setIdPareja(Integer idPareja) {
		this.idPareja = idPareja;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ClienteParejaId)) return false;
		ClienteParejaId that = (ClienteParejaId) o;
		return Objects.equals(idCliente, that.idCliente) &&
				Objects.equals(idPareja, that.idPareja);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente, idPareja);
	}
}
