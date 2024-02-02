import java.util.Objects;

public class Sarrera {
	private int id;
	private int saioa;
	private float prezioa;
	private int erosketa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSaioa() {
		return saioa;
	}

	public void setSaioa(int saioa) {
		this.saioa = saioa;
	}

	public float getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}

	public int getErosketa() {
		return erosketa;
	}

	public void setErosketa(int erosketa) {
		this.erosketa = erosketa;
	}

	public int getSarrerakop() {
		return sarrerakop;
	}

	public void setSarrerakop(int sarrerakop) {
		this.sarrerakop = sarrerakop;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(erosketa, id, prezioa, saioa, sarrerakop);
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
		return erosketa == other.erosketa && id == other.id
				&& Float.floatToIntBits(prezioa) == Float.floatToIntBits(other.prezioa) && saioa == other.saioa
				&& sarrerakop == other.sarrerakop;
	}

	
	@Override
	public String toString() {
		return "Sarrera [id=" + id + ", saioa=" + saioa + ", prezioa=" + prezioa + ", erosketa=" + erosketa
				+ ", sarrerakop=" + sarrerakop + "]";
	}

	public Sarrera(int id, int saioa, float prezioa, int erosketa) {
		this.id = id;
		this.saioa = saioa;
		this.prezioa = prezioa;
		this.erosketa = erosketa;
		this.sarrerakop = sarrerakop;
	}
	
	
	
}
