package master;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;

public class Zinema {
	private int id;
	private String izena;
	private String helbidea;
	private String kontaktua;
	private String deskribapena;
	private Aretoa[] aretoak;
	private Saioa[] saioak;
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
	public String getKontaktua() {
		return kontaktua;
	}
	public void setKontaktua(String kontaktua) {
		this.kontaktua = kontaktua;
	}
	public String getDeskribapena() {
		return deskribapena;
	}
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	public Aretoa[] getAretoak() {
		return aretoak;
	}
	public void setAretoak(Aretoa[] aretoak) {
		this.aretoak = aretoak;
	}
	public Saioa[] getSaioak() {
		return saioak;
	}
	public void setSaioak(Saioa[] saioa) {
		this.saioak = saioa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(aretoak);
		result = prime * result + Arrays.hashCode(saioak);
		result = prime * result + Objects.hash(deskribapena, helbidea, id, izena, kontaktua);
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
		Zinema other = (Zinema) obj;
		return Arrays.equals(aretoak, other.aretoak) && Objects.equals(deskribapena, other.deskribapena)
				&& Objects.equals(helbidea, other.helbidea) && id == other.id && Objects.equals(izena, other.izena)
				&& Objects.equals(kontaktua, other.kontaktua) && Arrays.equals(saioak, other.saioak);
	}
	@Override
	public String toString() {
		return "Zinema [id=" + id + ", izena=" + izena + ", helbidea=" + helbidea + ", kontaktua=" + kontaktua
				+ ", deskribapena=" + deskribapena + ", aretoak=" + Arrays.toString(aretoak) + ", saioak="
				+ Arrays.toString(saioak) + "]";
	}
	public Zinema(int id, String izena, String helbidea, String kontaktua, String deskribapena, Aretoa[] aretoak,
			Saioa[] saioak) {
		this.id = id;
		this.izena = izena;
		this.helbidea = helbidea;
		this.kontaktua = kontaktua;
		this.deskribapena = deskribapena;
		this.aretoak = aretoak;
		this.saioak = saioak;
	}
	public Zinema() {
	}

}
