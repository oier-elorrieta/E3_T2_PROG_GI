import java.util.Date;
import java.util.Objects;

public class Saioa {
		private int IdSaioa;
		private Date data;
		private int IdFilma;
		private int IdAreto;
		public Saioa(int idSaioa, Date data, int idFilma, int idAreto) {
			super();
			IdSaioa = idSaioa;
			this.data = data;
			IdFilma = idFilma;
			IdAreto = idAreto;
		}
		public int getIdSaioa() {
			return IdSaioa;
		}
		public void setIdSaioa(int idSaioa) {
			IdSaioa = idSaioa;
		}
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}
		public int getIdFilma() {
			return IdFilma;
		}
		public void setIdFilma(int idFilma) {
			IdFilma = idFilma;
		}
		public int getIdAreto() {
			return IdAreto;
		}
		public void setIdAreto(int idAreto) {
			IdAreto = idAreto;
		}
		@Override
		public int hashCode() {
			return Objects.hash(IdAreto, IdFilma, IdSaioa, data);
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
			return IdAreto == other.IdAreto && IdFilma == other.IdFilma && IdSaioa == other.IdSaioa
					&& Objects.equals(data, other.data);
		}
		
		@Override
		public String toString() {
			return "Saioa [IdSaioa=" + IdSaioa + ", data=" + data + ", IdFilma=" + IdFilma + ", IdAreto=" + IdAreto
					+ "]";
		}
		
		
}
