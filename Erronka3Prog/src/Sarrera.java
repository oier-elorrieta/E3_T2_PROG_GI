import java.util.Objects;

public class Sarrera {
	private int id;
	private Saioa saioa;
	private float prezioa;
	private int kantitatea;
	
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

	
	public int getKantitatea() {
		return kantitatea;
	}
	public void setKantitatea(int kantitatea) {
		this.kantitatea = kantitatea;
	}

	@Override
	public int hashCode() {
		return Objects.hash(kantitatea, id, prezioa, saioa);
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
		return Objects.equals(kantitatea, other.kantitatea) && id == other.id
				&& Float.floatToIntBits(prezioa) == Float.floatToIntBits(other.prezioa)
				&& Objects.equals(saioa, other.saioa);
	}
	@Override
	public String toString() {
		return "Sarrera [id=" + id + ", saioa=" + saioa + ", prezioa=" + prezioa + ", kantitatea=" + kantitatea + "]";
	}
	public Sarrera(int id, Saioa saioa, float prezioa, Erosketa erosketa) {
		this.id = id;
		this.saioa = saioa;
		this.prezioa = prezioa;
		this.kantitatea = kantitatea;
	}
	public Sarrera() {
	}
	
	
}
