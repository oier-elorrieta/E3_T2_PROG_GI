package master;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Filma {
    private int id;
    private int iraupena;
    private String generoa;
    private double prezioa;
    private String izena;
    private String zuzendaria;
    private String sinopsia;

    
    @Override
	public int hashCode() {
		return Objects.hash(generoa, id, iraupena, izena, prezioa, sinopsia, zuzendaria);
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
				&& Objects.equals(sinopsia, other.sinopsia) && Objects.equals(zuzendaria, other.zuzendaria);
	}

	public Filma() {}

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

    public double getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getZuzendaria() {
        return zuzendaria;
    }

    public void setZuzendaria(String zuzendaria) {
        this.zuzendaria = zuzendaria;
    }

    public String getSinopsia() {
        return sinopsia;
    }

    public void setSinopsia(String sinopsia) {
        this.sinopsia = sinopsia;
    }

    @Override
    public String toString() {
        return "Filma [id=" + id + ", iraupena=" + iraupena + ", generoa=" + generoa + ", prezioa=" + prezioa
                + ", izena=" + izena + ", zuzendaria=" + zuzendaria + ", sinopsia=" + sinopsia + "]";
    }

}

