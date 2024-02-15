package master;
import java.util.Date;
import java.util.Objects;
public class Erosketa {
	private int id;
	private int jatorria;
	private int deskontua;
	private Date data;
	private double preziotot;
	private Sarrera[] Sarrera;
	private Bezero bezero;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	public Bezero getBezero() {
		return bezero;
	}
	public void setBezero(Bezero bezero) {
		this.bezero = bezero;
	}
	
	
	public Sarrera[] getSarrera() {
		return Sarrera;
	}
	public void setSarrera(Sarrera[] sarrera) {
		Sarrera = sarrera;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bezero, deskontua, id, jatorria, data, preziotot, Sarrera);
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
		return Objects.equals(bezero, other.bezero) && deskontua == other.deskontua && id == other.id
				&& jatorria == other.jatorria && Sarrera == other.Sarrera
				&& Double.doubleToLongBits(preziotot) == Double.doubleToLongBits(other.preziotot);
	}
	@Override
	public String toString() {
		return "Erosketa [id=" + id + ", jatorria=" + jatorria + ", deskontua=" + deskontua + ", Data=" + data+ ", preziotot=" + preziotot
				+ ", bezero=" + bezero + "Sarrera=" + Sarrera + "]";
	}
	public Erosketa(int id, int jatorria, int deskontua, Date data, double preziotot, Bezero bezero, Sarrera[] Sarrera) {
		this.id = id;
		this.jatorria = jatorria;
		this.deskontua = deskontua;
		this.data = data;
		this.preziotot = preziotot;
		this.Sarrera = Sarrera;
		this.bezero = bezero;
	}

	
	
	
}
