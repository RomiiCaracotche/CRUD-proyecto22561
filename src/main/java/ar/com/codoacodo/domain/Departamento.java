package ar.com.codoacodo.domain;

public class Departamento {
	private int id;
	private String nombre;
	private Double presupuesto;
	
	public Departamento(int id, String nombre, Double presupuesto) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	@Override
	public String toString() {
		return "hacerlo";
	}
}
