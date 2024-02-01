import java.util.Objects;

public class Bezero {
	private String nan;
	private String izena;
	private String abizena;
	private int j_data;
	private String mail;
	
	public Bezero(String nan, String izena, int j_data, String mail) {
		this.nan = nan;
		this.izena = izena;
		this.j_data = j_data;
		this.mail = mail;
	}

	
	
	public Bezero(String nan, String izena, int j_data) {
		super();
		this.nan = nan;
		this.izena = izena;
		this.j_data = j_data;

	}



	@Override
	public String toString() {
		return "Bezero [nan=" + nan + ", izena=" + izena + ", j_data=" + j_data + ", mail=" + mail + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(izena, j_data, mail, nan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bezero other = (Bezero) obj;
		return Objects.equals(izena, other.izena)
				&& j_data == other.j_data && Objects.equals(mail, other.mail) && Objects.equals(nan, other.nan);
	}



	public String getNan() {
		return nan;
	}



	public void setNan(String nan) {
		this.nan = nan;
	}



	public String getIzena() {
		return izena;
	}



	public void setIzena(String izena) {
		this.izena = izena;
	}



	public int getJ_data() {
		return j_data;
	}



	public void setJ_data(int j_data) {
		this.j_data = j_data;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
