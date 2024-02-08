import java.util.Date;
import java.util.Objects;

public class Aretoa {
	public int id;
	public int izena;
	
	
	public Aretoa(int id, int izena) {
		this.id = id;
		this.izena = izena;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIzena() {
		return izena;
	}


	public void setIzena(int izena) {
		this.izena = izena;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, izena);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aretoa other = (Aretoa) obj;
		return id == other.id && izena == other.izena;
	}


	@Override
	public String toString() {
		return "Aretoa [id=" + id + ", izena=" + izena + ", zinema=]";
	}
	
	
	
}
