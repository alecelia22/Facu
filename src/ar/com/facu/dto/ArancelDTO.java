package ar.com.facu.dto;


public class ArancelDTO {

	private Long id;
	private String codigo;
	private String descripcion;
	private String precioSocio;
	private String precioNoSocio;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPrecioSocio() {
		return precioSocio;
	}

	public void setPrecioSocio(String precioSocio) {
		this.precioSocio = precioSocio;
	}

	public String getPrecioNoSocio() {
		return precioNoSocio;
	}

	public void setPrecioNoSocio(String precioNoSocio) {
		this.precioNoSocio = precioNoSocio;
	}
}
