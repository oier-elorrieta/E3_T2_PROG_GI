import java.util.Date;
import java.util.Objects;

public class Saioa {
		private Object saioa;
		private Date data;
		private Object filma;
		private Object areto;
		
		
		public Saioa(Object saioa, Date data, Object filma, Object areto) {
			super();
			this.saioa = saioa;
			this.data = data;
			this.filma = filma;
			this.areto = areto;
		}


		public Object getSaioa() {
			return saioa;
		}


		public void setSaioa(Object saioa) {
			this.saioa = saioa;
		}


		public Date getData() {
			return data;
		}


		public void setData(Date data) {
			this.data = data;
		}


		public Object getFilma() {
			return filma;
		}


		public void setFilma(Object filma) {
			this.filma = filma;
		}


		public Object getAreto() {
			return areto;
		}


		public void setAreto(Object areto) {
			this.areto = areto;
		}


		@Override
		public int hashCode() {
			return Objects.hash(areto, data, filma, saioa);
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
					&& Objects.equals(filma, other.filma) && Objects.equals(saioa, other.saioa);
		}


		@Override
		public String toString() {
			return "Saioa [saioa=" + saioa + ", data=" + data + ", filma=" + filma + ", areto=" + areto + "]";
		}
		
		
		
		
		
}
