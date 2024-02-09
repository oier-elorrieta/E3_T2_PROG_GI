import javax.swing.SwingUtilities;

public class Modelo {
    public boolean irkeiLogin = false;

    public Modelo() {
    }

    public void abrirVetrorria() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                vEtorria ventana = new vEtorria(null);
                ventana.setVisible(true);
            }
        });
    }

    public void dispose() {
        // Lógica para cerrar la ventana o limpiar recursos
    }

    public static void main(String[] args) {
        // Aquí puedes crear una instancia de Modelo y llamar al método para abrir vEtorria
        Modelo modelo = new Modelo();
        modelo.abrirVetrorria();
    }
}