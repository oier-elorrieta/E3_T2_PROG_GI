import java.util.Objects;

public class Sarrera {
	private int id;
	private Saioa saioa;
	private float prezioa;
	private Erosketa erosketa;
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
	public Erosketa getErosketa() {
		return erosketa;
	}
	public void setErosketa(Erosketa erosketa) {
		this.erosketa = erosketa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(erosketa, id, prezioa, saioa);
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
		return Objects.equals(erosketa, other.erosketa) && id == other.id
				&& Float.floatToIntBits(prezioa) == Float.floatToIntBits(other.prezioa)
				&& Objects.equals(saioa, other.saioa);
	}
	@Override
	public String toString() {
		return "Sarrera [id=" + id + ", saioa=" + saioa + ", prezioa=" + prezioa + ", erosketa=" + erosketa + "]";
	}
	public Sarrera(int id, Saioa saioa, float prezioa, Erosketa erosketa) {
		this.id = id;
		this.saioa = saioa;
		this.prezioa = prezioa;
		this.erosketa = erosketa;
	}
	public Sarrera() {
	}
	
	
}
