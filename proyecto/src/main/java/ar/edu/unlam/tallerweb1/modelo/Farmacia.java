package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Farmacia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	@ManyToOne(cascade = CascadeType.ALL)
	private Direccion direccion;
	@ManyToOne
	private Punto geoLocalizacion;
	public Farmacia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Farmacia(String nombre, String telefono, String diaDeTurno) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.diaDeTurno = diaDeTurno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Farmacia other = (Farmacia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDiaDeTurno() {
		return diaDeTurno;
	}
	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Punto getGeoLocalizacion() {
		return geoLocalizacion;
	}
	public void setGeoLocalizacion(Punto geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}
}
