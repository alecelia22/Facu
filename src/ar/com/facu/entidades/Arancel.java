package ar.com.facu.entidades;

import java.math.BigDecimal;

public class Arancel {

	private Long id;
	private String codigo;
	private String descripcion;
	private BigDecimal precioSocio;
	private BigDecimal precioNoSocio;

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

	public BigDecimal getPrecioSocio() {
		return precioSocio;
	}

	public void setPrecioSocio(BigDecimal precioSocio) {
		this.precioSocio = precioSocio;
	}

	public BigDecimal getPrecioNoSocio() {
		return precioNoSocio;
	}

	public void setPrecioNoSocio(BigDecimal precioNoSocio) {
		this.precioNoSocio = precioNoSocio;
	}
/*
	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}
*/
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
