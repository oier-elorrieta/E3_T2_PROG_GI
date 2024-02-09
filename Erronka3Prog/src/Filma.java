import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Filma {
    private int id;
    private int iraupena;
    private String generoa;
    private double prezioa;
    private String izena;
    private String zuzendaria;
    private String sinopsia;

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

    public Filma[] load(Connection conexioa) {
        Filma[] filmak = null;
        try {
            System.out.println("Konektatuta");
            // Preparar sentencia
            Statement s1 = conexioa.createStatement();
            String sql = "select * from filma";
            ResultSet lerroak = s1.executeQuery(sql);
            int count = 0;
            while (lerroak.next()) {
                count++;
            }
            filmak = new Filma[count];
            lerroak = s1.executeQuery(sql);
            int i = 0;
            while (lerroak.next()) {
                Filma filma = new Filma();
                filma.setId(lerroak.getInt("Idfilma"));
                filma.setIzena(lerroak.getString("Izenburua"));
                filma.setIraupena(lerroak.getInt("Iraupena"));
                filma.setGeneroa(lerroak.getString("Generoa"));
                filma.setPrezioa(lerroak.getDouble("Prezioa"));
                filma.setZuzendaria(lerroak.getString("Zuzendaria"));
                filma.setSinopsia(lerroak.getString("Sinopsia"));
                filmak[i] = filma;
                i++;
            }
        } catch (Exception sqe) {
            sqe.printStackTrace();
        }
        for (int j = 0; j < filmak.length; j++) {
            System.out.println(filmak[j].toString());
        }
        return filmak;
    }

    
}

