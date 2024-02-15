package master;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Sarrera {
	private int id;
	private Saioa saioa;
	private float prezioa;
	private int kantitatea;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Saioa getSaioa() {
		return saioa;
	}
	
	public void setSaioa(Saioa saioa) {
		this.saioa = saioa;
	}
	
	public float getPrezioa() {
		return prezioa;
	}
	
	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}
	
	public int getKantitatea() {
		return kantitatea;
	}
	
	public void setKantitatea(int kantitatea) {
		this.kantitatea = kantitatea;
	}

	@Override
	public int hashCode() {
		return Objects.hash(kantitatea, id, prezioa, saioa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sarrera other = (Sarrera) obj;
		return Objects.equals(kantitatea, other.kantitatea) && id == other.id
				&& Float.floatToIntBits(prezioa) == Float.floatToIntBits(other.prezioa)
				&& Objects.equals(saioa, other.saioa);
	}
	@Override
	public String toString() {
		return "Sarrera [id=" + id + ", saioa=" + saioa + ", prezioa=" + prezioa + ", kantitatea=" + kantitatea + "]";
	}
	public Sarrera(int id, Saioa saioa, float prezioa, int kantitatea) {
		this.id = id;
		this.saioa = saioa;
		this.prezioa = prezioa;
		this.kantitatea = kantitatea;
	}
	
	public Sarrera() {
	}
	public Sarrera[] Sarreraload(Connection conexioa) {   
	    Sarrera[] sarrerak = null;  
	    try {
	        conexioa = konexioa.hasi();
	        System.out.println("Konektatuta");
	        // Prestatu sententzia
	        int i = 0;
	        Statement s1 = conexioa.createStatement();
	        String sql = "select * from sarrera";
	        ResultSet lerroak = s1.executeQuery(sql);
	        int count = 0;
	        while(lerroak.next()) {
	            count++;
	        }
	        sarrerak = new Sarrera[count];
	        lerroak = s1.executeQuery(sql);
	        while (lerroak.next()) {
	            Sarrera sarrera = new Sarrera();
	            sarrera.setId(lerroak.getInt("id"));
	            Saioa saioa = new Saioa(); 
	            saioa.setId(lerroak.getInt("IdSaioa")); 
	            sarrera.setSaioa(saioa);
	            sarrera.setPrezioa(lerroak.getFloat("Prezioa"));
	            sarrera.setKantitatea(lerroak.getInt("Kantitatea"));
	            sarrerak[i] = sarrera;
	            i++;
	        }
	    } catch (Exception sqe) {
	        sqe.printStackTrace();
	    }
	    
	    for(int j = 0; j < sarrerak.length; j++) {
	        System.out.println(sarrerak[j].toString());
	    }
	    
	    return sarrerak;
	}
}
