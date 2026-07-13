package co.edu.unbosque.backProyectoPoligamia.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALMACEN")
public class Almacen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_almacen")
	private Integer idAlmacen;
	
	@Column(name = "ciudad", nullable = false)
	private String ciudad;
	
	@Column(name = "Via_direccion", nullable = false)
	private String viaDireccion;
	
	@Column(name = "Numero_direccion", nullable = false)
	private String numeroDireccion;
	
	@Column(name = "Complemento", nullable = false)
	private String complementoDireccion;
	
	@OneToMany(mappedBy = "almacen")
	private List<Compra> compras;
	
	public Almacen() {
		// TODO Auto-generated constructor stub
	}

	public Almacen(Integer idAlmacen, String ciudad, String viaDireccion, String numeroDireccion,
			String complementoDireccion, List<Compra> compras) {
		super();
		this.idAlmacen = idAlmacen;
		this.ciudad = ciudad;
		this.viaDireccion = viaDireccion;
		this.numeroDireccion = numeroDireccion;
		this.complementoDireccion = complementoDireccion;
		this.compras = compras;
	}

	public Integer getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getViaDireccion() {
		return viaDireccion;
	}

	public void setViaDireccion(String viaDireccion) {
		this.viaDireccion = viaDireccion;
	}

	public String getNumeroDireccion() {
		return numeroDireccion;
	}

	public void setNumeroDireccion(String numeroDireccion) {
		this.numeroDireccion = numeroDireccion;
	}

	public String getComplementoDireccion() {
		return complementoDireccion;
	}

	public void setComplementoDireccion(String complementoDireccion) {
		this.complementoDireccion = complementoDireccion;
	}
	
	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
}
