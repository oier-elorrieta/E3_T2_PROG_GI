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

		
		
		
}
