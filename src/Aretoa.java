import java.util.Objects;

public class Aretoa {
	public int izena;
	public int id;
	public int data;
	public int ordutegia;
	public Object filmak;

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

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getOrdutegia() {

		return ordutegia;

	}

	public void setOrdutegia(int ordutegia) {
		this.ordutegia = ordutegia;
	}

	public Object getFilmak() {
		return filmak;
	}

	public void setFilmak(Object filmak) {
		this.filmak = filmak;
	}

	@Override
	public String toString() {
		return "Aretoa [izena=" + izena + ", id=" + id + ", data=" + data + ", ordutegia=" + ordutegia + ", filmak="
				+ filmak + "]";
	}

	public Aretoa(int izena, int id, int data, int ordutegia, Object filmak) {
		this.izena = izena;
		this.id = id;
		this.data = data;
		this.ordutegia = ordutegia;
		this.filmak = filmak;
	}
	
	
	
	public Aretoa() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, filmak, id, izena, ordutegia);
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
		return data == other.data && Objects.equals(filmak, other.filmak) && id == other.id && izena == other.izena
				&& ordutegia == other.ordutegia;
	}

}
