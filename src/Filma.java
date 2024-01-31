import java.util.Objects;

public class Filma {

        private int id;
        private int iraupena;
        private String generoa;
        private double presioa;
        private String izena;
        
        
        
        public Filma() {
        
        }
        public Filma(int id, int iraupena, String generoa, double presioa, String izena) {

            this.id = id;
            this.iraupena = iraupena;
            this.generoa = generoa;
            this.presioa = presioa;
            this.izena = izena;
        }
        @Override
        public int hashCode() {
            return Objects.hash(generoa, id, iraupena, izena, presioa);
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
                    && Double.doubleToLongBits(presioa) == Double.doubleToLongBits(other.presioa);
        }
        @Override
        public String toString() {
            return "Filma [id=" + id + ", iraupena=" + iraupena + ", generoa=" + generoa + ", presioa=" + presioa
                    + ", izena=" + izena + "]";
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
        public double getPresioa() {
            return presioa;
        }
        public void setPresioa(double presioa) {
            this.presioa = presioa;
        }
        public String getIzena() {
            return izena;
        }
        public void setIzena(String izena) {
            this.izena = izena;
        }
        
        
    }