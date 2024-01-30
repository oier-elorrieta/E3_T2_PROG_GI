import java.util.Objects;

public class Sarrera {
	private int id;
	private int data;
	private Object filma;
	private int ordutegia;
	private int aretoa;
	private float prezioa;

	public Sarrera() {
	}

	public Sarrera(int id, int data, Object filma, int ordutegia, int aretoa, float prezioa) {
		this.id = id;
		this.data = data;
		this.filma = filma;
		this.ordutegia = ordutegia;
		this.aretoa = aretoa;
		this.prezioa = prezioa;
	}
	
	@Override
	public String toString() {
		return "Sarrera [id=" + id + ", data=" + data + ", ordutegia=" + ordutegia + ", aretoa=" + aretoa + ", prezioa="
				+ prezioa + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aretoa, data, id, ordutegia, prezioa);
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
		return aretoa == other.aretoa && data == other.data && id == other.id && ordutegia == other.ordutegia
				&& Float.floatToIntBits(prezioa) == Float.floatToIntBits(other.prezioa);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Object getFilma() {
		return filma;
	}
	public void setFilma(Object filma) {
		this.filma = filma;
	}
	public int getOrdutegia() {
		return ordutegia;
	}
	public void setOrdutegia(int ordutegia) {
		this.ordutegia = ordutegia;
	}
	public int getAretoa() {
		return aretoa;
	}
	public void setAretoa(int aretoa) {
		this.aretoa = aretoa;
	}
	public float getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}
}
