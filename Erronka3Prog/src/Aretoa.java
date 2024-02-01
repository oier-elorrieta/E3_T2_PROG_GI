import java.util.Date;
import java.util.Objects;

public class Aretoa {
	public int izena;
	public int id;
	public int zinema;
	public int getIzena() {
		return izena;
	}
	public void setIzena(int izena) {
		this.izena = izena;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getZinema() {
		return zinema;
	}
	public void setZinema(int zinema) {
		this.zinema = zinema;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, izena, zinema);
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
		return id == other.id && izena == other.izena && zinema == other.zinema;
	}
	@Override
	public String toString() {
		return "Aretoa [izena=" + izena + ", id=" + id + ", zinema=" + zinema + "]";
	}
	public Aretoa(int izena, int id, int zinema) {
		this.izena = izena;
		this.id = id;
		this.zinema = zinema;
	}
	public Aretoa() {
	}

	
}
