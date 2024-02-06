import java.util.Date;
import java.util.Objects;

public class Aretoa {
	public int id;
	public int izena;
	public Object zinema;
	public Saioa SaioList[];
	
	
	public Aretoa(int id, int izena, Object zinema) {
		super();
		this.id = id;
		this.izena = izena;
		this.zinema = zinema;
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


	public Object getZinema() {
		return zinema;
	}


	public void setZinema(Object zinema) {
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
		return id == other.id && izena == other.izena && Objects.equals(zinema, other.zinema);
	}


	@Override
	public String toString() {
		return "Aretoa [id=" + id + ", izena=" + izena + ", zinema=" + zinema + "]";
	}
	
	
	
}
