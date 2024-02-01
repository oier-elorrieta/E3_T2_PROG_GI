import java.util.Objects;

public class Erosketa {
	private int erosketa;
	private int jatorria;
	private int deskontua;
	private double preziotot;
	private String nan;
	
	
	public int getErosketa() {
		return erosketa;
	}
	public void setErosketa(int erosketa) {
		this.erosketa = erosketa;
	}
	public int getJatorria() {
		return jatorria;
	}
	public void setJatorria(int jatorria) {
		this.jatorria = jatorria;
	}
	public int getDeskontua() {
		return deskontua;
	}
	public void setDeskontua(int deskontua) {
		this.deskontua = deskontua;
	}
	public double getPreziotot() {
		return preziotot;
	}
	public void setPreziotot(double preziotot) {
		this.preziotot = preziotot;
	}
	public String getNan() {
		return nan;
	}
	public void setNan(String nan) {
		this.nan = nan;
	}
	@Override
	public int hashCode() {
		return Objects.hash(deskontua, erosketa, jatorria, nan, preziotot);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Erosketa other = (Erosketa) obj;
		return deskontua == other.deskontua && erosketa == other.erosketa && jatorria == other.jatorria
				&& Objects.equals(nan, other.nan)
				&& Double.doubleToLongBits(preziotot) == Double.doubleToLongBits(other.preziotot);
	}
	@Override
	public String toString() {
		return "Erosketa [erosketa=" + erosketa + ", jatorria=" + jatorria + ", deskontua=" + deskontua + ", preziotot="
				+ preziotot + ", nan=" + nan + "]";
	}
	public Erosketa(int erosketa, int jatorria, int deskontua, double preziotot, String nan) {
		super();
		this.erosketa = erosketa;
		this.jatorria = jatorria;
		this.deskontua = deskontua;
		this.preziotot = preziotot;
		this.nan = nan;
	}
	public Erosketa() {
		super();
	}
	
	
	
}
