package co.edu.udea.iw.dto;

/**
 * DTO para la informacion de la tabla Usuario
 * @author Juan David Torres - juandavid.torres@gmail.com
 *
 */
public class Usuario {
	private String login;
	private String nombres;
	private String apellidos;
	private String contrasena;
	private Rol rol;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombre) {
		this.nombres = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellido) {
		this.apellidos = apellido;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contraseña) {
		this.contrasena = contraseña;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	

}
