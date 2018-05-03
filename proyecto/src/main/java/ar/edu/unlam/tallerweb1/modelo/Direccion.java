package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Direccion {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String calle;
		private String numero;
<<<<<<< HEAD
		@ManyToOne(cascade = CascadeType.PERSIST)
=======
		@ManyToOne
>>>>>>> parent of 12205da... Test
		private Barrio barrio;
		
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
			Direccion other = (Direccion) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		public Direccion(String calle, String numero, Barrio barrio) {
			super();
			this.calle = calle;
			this.numero = numero;
			this.barrio = barrio;
		}
		public Direccion() {
			super();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCalle() {
			return calle;
		}
		public void setCalle(String calle) {
			this.calle = calle;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public Barrio getBarrio() {
			return barrio;
		}
		public void setBarrio(Barrio barrio) {
			this.barrio = barrio;
		}
		
		
}
