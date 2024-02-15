package master;
import java.util.Date;
import java.util.Objects;
import java.sql.*;

public class Bezero {
	private String nan;
	private String izena;
	private String erabiltzailea;
	private String abizena;
	private Date j_data;
	private String mail;
	private char sexua;
	private String pasahitza;
	
	
	
	public Bezero() {
	}

	public Bezero(String nan, String izena, Date j_data, String mail) {
		this.nan = nan;
		this.izena = izena;
		this.j_data = j_data;
		this.mail = mail;
	}
	
	public Bezero(String nan, String izena,String erabiltzailea, String abizena, Date j_data, String mail, char sexua, String pasahitza) {
		this.nan = nan;
		this.izena = izena;
		this.erabiltzailea = erabiltzailea;
		this.abizena = abizena;
		this.j_data = j_data;
		this.mail = mail;
		this.sexua = sexua;
		this.pasahitza = pasahitza;
	}



	public String getAbizena() {
		return abizena;
	}



	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}



	public char getSexua() {
		return sexua;
	}



	public void setSexua(char sexua) {
		this.sexua = sexua;
	}



	public String getPasahitza() {
		return pasahitza;
	}



	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}



	public String getErabiltzailea() {
		return erabiltzailea;
	}

	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	public Bezero(String nan, String izena, Date j_data) {
		this.nan = nan;
		this.izena = izena;
		this.j_data = j_data;

	}





	@Override
	public int hashCode() {
		return Objects.hash(abizena, izena, j_data, mail, nan, pasahitza, sexua);
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
		return Objects.equals(abizena, other.abizena) && Objects.equals(izena, other.izena)
				&& Objects.equals(j_data, other.j_data) && Objects.equals(mail, other.mail)
				&& Objects.equals(nan, other.nan) && pasahitza == other.pasahitza && sexua == other.sexua;
	}

	@Override
	public String toString() {
		return "Bezero [nan=" + nan + ", izena=" + izena + ", abizena=" + abizena + ", j_data=" + j_data + ", mail="
				+ mail + ", sexua=" + sexua + ", pasahitza=" + pasahitza + "]";
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



	public Date getJ_data() {
		return j_data;
	}



	public void setJ_data(Date j_data) {
		this.j_data = j_data;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}
	
	 public Bezero[] load(Connection conexioa) { 
		 
		 Bezero[] bezeroak = null;;
		 try {
	    	   conexioa = konexioa.hasi();
	           System.out.println("Konektatuta");
	           // Prestatu sententzia
	           int i = 0;
	           Statement s1 = conexioa.createStatement();
	           String sql = "select * from bezeroa";
	           ResultSet lerroak = s1.executeQuery(sql);
	           int count = 0;
	           while (lerroak.next()) {
	        	   count++;
	           }
	           bezeroak =  new Bezero[count];
	           lerroak = s1.executeQuery(sql);
	           while (lerroak.next()) {
	        	   System.out.println("a");
	        	   Bezero bezeroa = new Bezero();
	               bezeroa.setNan(lerroak.getString("NAN"));
	               bezeroa.setErabiltzailea(lerroak.getString("Erabiltzailea"));
	               bezeroa.setIzena(lerroak.getString("Izena"));
	               bezeroa.setAbizena(lerroak.getString("Abizena"));
	               bezeroa.setJ_data(lerroak.getDate("J_data"));
	               bezeroa.setMail(lerroak.getString("Mail"));
	               bezeroa.setSexua(lerroak.getString("Generoa").charAt(0));
	               bezeroa.setPasahitza(lerroak.getString("Pasahitza"));
	               bezeroak[i] = bezeroa;
	               i++;
	           }
	       } catch (Exception sqe) {
	           sqe.printStackTrace();
	       }
		 for(int j = 0; j < bezeroak.length; j++) {
		 System.out.println(bezeroak[j].toString());
		 }
	       return (bezeroak);
	}
}
