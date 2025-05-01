public class MainApp {
    public static void main(String[] args) {
        Ventana vn = new Ventana();

        vn.setVisible(true);

        Archivo archivo = new Archivo();
     
        archivo.cargarArchivo();
    }
}
