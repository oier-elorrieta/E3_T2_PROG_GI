import java.util.Objects;

public class Zinema {
	private int id;
	private String izena;
	private String helbidea;
	private String kontaktua;
	private String deskribapena;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getHelbidea() {
		return helbidea;
	}
	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(helbidea, id, izena);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zinema other = (Zinema) obj;
		return  Objects.equals(helbidea, other.helbidea) && id == other.id
				&& Objects.equals(izena, other.izena);
	}
	@Override
	public String toString() {
		return "Zinema [id=" + id + ", izena=" + izena + ", helbidea=" + helbidea + "]";
	}
	public Zinema(int id, String izena, String helbidea, int aretokop) {
		this.id = id;
		this.izena = izena;
		this.helbidea = helbidea;
	}
	public Zinema() {
	}
	
	
	
	
}
