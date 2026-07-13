package co.edu.unbosque.backProyectoPoligamia.dto;

import java.util.List;

public class AlmacenDTO {

	private Integer idAlmacen;
	private String nombre;
	private String ciudad;
	private String viaDireccion;
	private String numeroDireccion;
	private String complementoDireccion;
	private List<CompraDTO> compras;

	public AlmacenDTO() {

	}

	public AlmacenDTO(Integer idAlmacen, String nombre, String ciudad, String viaDireccion, String numeroDireccion,
			String complementoDireccion, List<CompraDTO> compras) {
		super();
		this.idAlmacen = idAlmacen;
		this.nombre = nombre;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<CompraDTO> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraDTO> compras) {
		this.compras = compras;
	}

}