package ar.com.facu.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import ar.com.facu.dto.ArancelDTO;
import ar.com.facu.entidades.Arancel;
import ar.com.facu.persistance.dao.impl.ArancelDaoImpl;
import ar.com.facu.utils.Formateador;

import com.opensymphony.xwork2.ActionSupport;

public class ArancelesAction extends ActionSupport {

	private static final long serialVersionUID = -6926652535471038731L;

	// Logica de datos
	private ArancelDaoImpl arancelDao = new ArancelDaoImpl();

	// Lista de aranceles a mostrar por pantalla
	private List<ArancelDTO> arancelesDTO;
	// Datos de pantalla
	private Long id;
	private String codigo;
	private String descripcion;
	private String precioSocio;
	private String precioNoSocio;

	/**
	 * Busco y devuelvo todos los aranceles.
	 */
	public String listarAranceles() {
		// Busco a todos los empleados
		List<Arancel> aranceles = this.arancelDao.buscarAranceles();
		this.arancelesDTO = this.arancelesToDto(aranceles);

		return SUCCESS;
	}

	/**
	 * Cargo la pantalla de nuevo Arancel o de edicion de arancel.
	 */
	public String crearActualizarArancel() {

		return SUCCESS;
	}

	/**
	 * Ejecuto el guardado del arancel.
	 */
	public String guardarArancel() throws ParseException {
		// Creo un arancel con los datos de pantalla
		Arancel arancel = new Arancel();
		arancel.setId(this.id);
		arancel.setCodigo(this.codigo);
		arancel.setDescripcion(this.descripcion);
		arancel.setPrecioNoSocio(Formateador.stringABigDecimal(precioNoSocio));
		arancel.setPrecioSocio(Formateador.stringABigDecimal(precioSocio));

		// Guardo el arancel
		this.arancelDao.guardar(arancel);
		
		return SUCCESS;
	}

	/**
	 * Convierto a todos los aranceles en un DTO.
	 */
	private List<ArancelDTO> arancelesToDto(List<Arancel> aranceles) {
		// Lista a devolver
		List<ArancelDTO> arancelesDto = new ArrayList<ArancelDTO>();
		ArancelDTO arancelDto;
		
		// Recorro cada uno de los aranceles
		for (Arancel arancel : aranceles) {
			// Cargo los datos en el dto
			arancelDto = new ArancelDTO();
			arancelDto.setId(arancel.getId());
			arancelDto.setCodigo(arancel.getCodigo());
			arancelDto.setPrecioNoSocio(Formateador.formatNumero(arancel.getPrecioNoSocio()));
			arancelDto.setPrecioSocio(Formateador.formatNumero(arancel.getPrecioSocio()));

			// Cargo el objeto en la lista 
			arancelesDto.add(arancelDto);
		}

		return arancelesDto;
	}

	// SETs y GETs de los datos de pantalla
	public List<ArancelDTO> getArancelesDTO() {
		return arancelesDTO;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecioSocio(String precioSocio) {
		this.precioSocio = precioSocio;
	}

	public void setPrecioNoSocio(String precioNoSocio) {
		this.precioNoSocio = precioNoSocio;
	}
}
