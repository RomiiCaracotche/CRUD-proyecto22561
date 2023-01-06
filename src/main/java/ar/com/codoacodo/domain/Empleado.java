package ar.com.codoacodo.domain;

public class Empleado {
	private int dni;
	private String nombre;
	private String apellido;
	private Departamento dpto;
	
	public Empleado() {
		
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

	public Departamento getDpto() {
		return dpto;
	}

	public void setDpto(Departamento dpto) {
		this.dpto = dpto;
	}
	
	@Override
	public String toString() {
		return "hacerlo";
	}
}
