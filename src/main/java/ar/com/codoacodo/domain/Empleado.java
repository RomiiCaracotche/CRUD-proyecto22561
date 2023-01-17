package ar.com.codoacodo.domain;

public class Empleado {
	private int dni;
	private String nombre;
	private String apellido;
	private int departamento;
	
	public Empleado(int dni, String nombre, String apellido, int departamento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.departamento = departamento;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "hacerlo";
	}
}
