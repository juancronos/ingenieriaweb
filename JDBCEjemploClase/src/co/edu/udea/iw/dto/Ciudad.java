package co.edu.udea.iw.dto;
/**
 * 
 * @author Juan
 * @version 1.0
 * Esta clase es POJO que representa una ciudad dentro de la base de datos, refierase al patron DTO
 */
public class Ciudad {	
	/**
	 * Una ciudad tiene 3 parametros su codigo, nombre y codigo de area
	 */
	private Long codigo;
	private String nombre;
	private String codigoArea;
	
	/*
	 * Estos son metodos getter y setter para poder acceder a la informacion
	 * del objeto
	 */
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}	
	

}
