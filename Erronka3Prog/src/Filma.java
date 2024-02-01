import java.util.Objects;

public class Filma {

        private int id;
        private int iraupena;
        private String generoa;
        private double prezioa;
        private String izena;
        private String zuendaria;
        private String sinopsia;
        
        
        
        public Filma(int id, int iraupena, String generoa, double prezioa, String izena) {
			this.id = id;
			this.iraupena = iraupena;
			this.generoa = generoa;
			this.prezioa = prezioa;
			this.izena = izena;
		}
		@Override
		public int hashCode() {
			return Objects.hash(generoa, id, iraupena, izena, prezioa, sinopsia, zuendaria);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Filma other = (Filma) obj;
			return Objects.equals(generoa, other.generoa) && id == other.id && iraupena == other.iraupena
					&& Objects.equals(izena, other.izena)
					&& Double.doubleToLongBits(prezioa) == Double.doubleToLongBits(other.prezioa)
					&& Objects.equals(sinopsia, other.sinopsia) && Objects.equals(zuendaria, other.zuendaria);
		}
		@Override
		public String toString() {
			return "Filma [id=" + id + ", iraupena=" + iraupena + ", generoa=" + generoa + ", prezioa=" + prezioa
					+ ", izena=" + izena + ", zuendaria=" + zuendaria + ", sinopsia=" + sinopsia + "]";
		}
		public Filma() {
		}
		public Filma(int id, int iraupena, String generoa, double prezioa, String izena, String zuendaria,
				String sinopsia) {
			this.id = id;
			this.iraupena = iraupena;
			this.generoa = generoa;
			this.prezioa = prezioa;
			this.izena = izena;
			this.zuendaria = zuendaria;
			this.sinopsia = sinopsia;
		}
		public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getIraupena() {
            return iraupena;
        }
        public void setIraupena(int iraupena) {
            this.iraupena = iraupena;
        }
        public String getGeneroa() {
            return generoa;
        }
        public void setGeneroa(String generoa) {
            this.generoa = generoa;
        }
        public double getprezioa() {
            return prezioa;
        }
        public void setprezioa(double prezioa) {
            this.prezioa = prezioa;
        }
        public String getIzena() {
            return izena;
        }
        public void setIzena(String izena) {
            this.izena = izena;
        }
		public String getZuendaria() {
			return zuendaria;
		}
		public void setZuendaria(String zuendaria) {
			this.zuendaria = zuendaria;
		}
		public String getSinopsia() {
			return sinopsia;
		}
		public void setSinopsia(String sinopsia) {
			this.sinopsia = sinopsia;
		}
        
        
    }