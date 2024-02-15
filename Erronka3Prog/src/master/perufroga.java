package master;
import java.sql.*;

public class perufroga {

	public static void main(String[] args) {
		Aretoa aretoInstance = new Aretoa(3, "aka");
		
		Connection conexioa = konexioa.hasi();
		aretoInstance.load(conexioa);
	}

}
