package master;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Objects;

public class Saioa {
		private int id;
		private Date data;
		private Filma filma;
		private Aretoa areto;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}
		public Filma getFilma() {
			return filma;
		}
		public void setFilma(Filma filma) {
			this.filma = filma;
		}
		public Aretoa getAreto() {
			return areto;
		}
		public void setAreto(Aretoa areto) {
			this.areto = areto;
		}
		@Override
		public int hashCode() {
			return Objects.hash(areto, data, filma, id);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Saioa other = (Saioa) obj;
			return Objects.equals(areto, other.areto) && Objects.equals(data, other.data)
					&& Objects.equals(filma, other.filma) && id == other.id;
		}
		@Override
		public String toString() {
			return "Saioa [id=" + id + ", data=" + data + ", filma=" + filma + ", areto=" + areto + "]";
		}
		public Saioa(int id, Date data, Filma filma, Aretoa areto) {
			this.id = id;
			this.data = data;
			this.filma = filma;
			this.areto = areto;
		}
		public Saioa() {
		}
		
		public Saioa[] load(Connection conexioa) {   
		    Saioa[] saioak = null;  
		    try {
		        conexioa = konexioa.hasi();
		        System.out.println("Konektatuta");
		        // Prestatu sententzia
		        int i = 0;
		        Statement s1 = conexioa.createStatement();
		        String sql = "select * from saioa";
		        ResultSet lerroak = s1.executeQuery(sql);
		        int count = 0;
		        while(lerroak.next()) {
		            count++;
		        }
		        saioak = new Saioa[count];
		        lerroak = s1.executeQuery(sql);
		        while (lerroak.next()) {
		            Saioa saioa = new Saioa();
		            saioa.setId(lerroak.getInt("id"));
		            saioa.setData(lerroak.getDate("data"));
		            
		            // Obtener los datos de la película y la sala
		            Filma filma = new Filma(); // Debes crear una instancia de Filma aquí
		            filma.setId(lerroak.getInt("id_pelicula")); // Suponiendo que el ID de la película está en una columna llamada id_pelicula
		            saioa.setFilma(filma);
		            
		            Aretoa aretoa = new Aretoa(); // Debes crear una instancia de Aretoa aquí
		            aretoa.setId(lerroak.getInt("id_aretoa")); // Suponiendo que el ID de la sala está en una columna llamada id_aretoa
		            saioa.setAreto(aretoa);
		            
		            saioak[i] = saioa;
		            i++;
		        }
		    } catch (Exception sqe) {
		        sqe.printStackTrace();
		    }
		    
		    for(int j = 0; j < saioak.length; j++) {
		        System.out.println(saioak[j].toString());
		    }
		    
		    return saioak;
		}

		
		
		
}
