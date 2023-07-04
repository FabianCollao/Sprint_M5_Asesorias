package model;

public class Asesoria {
	private int id;
	private String nombre;
	private String detalle;
	private int profesional_id;

	public Asesoria() {
	}

	public Asesoria(int id, String nombre, String detalle, int profesional_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
		this.profesional_id = profesional_id;
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getProfesional_id() {
		return profesional_id;
	}

	public void setProfesional_id(int profesional_id) {
		this.profesional_id = profesional_id;
	}

	@Override
	public String toString() {
		return "Asesoria [id=" + id + ", nombre=" + nombre + ", detalle=" + detalle + ", profesional_id="
				+ profesional_id + "]";
	}

}
