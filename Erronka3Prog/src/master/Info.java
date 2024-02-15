package master;
import java.util.Arrays;

public class Info {
	private String[] topseller;
	private String[] topusers;
	private String[] worstsellers;
	private String[] topviewed;
	private String[] genderstats;
	
	
	
	public String[] getTopseller() {
		return topseller;
	}



	public String[] getTopusers() {
		return topusers;
	}



	public String[] getWorstsellers() {
		return worstsellers;
	}



	public String[] getTopviewed() {
		return topviewed;
	}



	public String[] getGenderstats() {
		return genderstats;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(genderstats);
		result = prime * result + Arrays.hashCode(topseller);
		result = prime * result + Arrays.hashCode(topusers);
		result = prime * result + Arrays.hashCode(topviewed);
		result = prime * result + Arrays.hashCode(worstsellers);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Info other = (Info) obj;
		return Arrays.equals(genderstats, other.genderstats) && Arrays.equals(topseller, other.topseller)
				&& Arrays.equals(topusers, other.topusers) && Arrays.equals(topviewed, other.topviewed)
				&& Arrays.equals(worstsellers, other.worstsellers);
	}



	@Override
	public String toString() {
		return "Info [topseller=" + Arrays.toString(topseller) + ", topusers=" + Arrays.toString(topusers)
				+ ", worstsellers=" + Arrays.toString(worstsellers) + ", topviewed=" + Arrays.toString(topviewed)
				+ ", genderstats=" + Arrays.toString(genderstats) + "]";
	}



	public Info() {
	}
	
	
}
