import java.util.Objects;

public class Sarrera {
	private int id;
	private Object saioa;
	private float prezioa;
	private Object erosketa;
	
	
	public Sarrera(int id, Object saioa, float prezioa, Object erosketa) {
		super();
		this.id = id;
		this.saioa = saioa;
		this.prezioa = prezioa;
		this.erosketa = erosketa;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Object getSaioa() {
		return saioa;
	}


	public void setSaioa(Object saioa) {
		this.saioa = saioa;
	}


	public float getPrezioa() {
		return prezioa;
	}


	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}


	public Object getErosketa() {
		return erosketa;
	}


	public void setErosketa(Object erosketa) {
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
}
