import java.io.*;

public class Archivo {
    

    //CREA EL ARCHIVO TXT
    public void crearArchivo(){


        try {
            FileWriter writerUsuarios = new FileWriter("Usuarios.txt");
            for(Usuario us : Datos.usuarios){
                writerUsuarios.write(us.getNombre() + " ," + us.getContraseña() + " ," + us.getEmail() +  "\n");
            }
            writerUsuarios.close();

            FileWriter writerReportes = new FileWriter("Reportes.txt");
            for(Reporte re : Datos.reportes){
                writerReportes.write(re.getUsuario() + "," + re.getDireccion() + "," + re.getDescripcion() + "," + re.getTipoReporte() + "," + re.getEstado() + "\n");
            }
            writerReportes.close();

            


            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //AHORA PARA GUARDAR ESOS DATOS EN EL ARCHIVO  O SEA LEE EL TXT
    public void cargarArchivo(){
        Datos.usuarios.clear();
        Datos.reportes.clear();

        try {
            BufferedReader readerUsuarios = new BufferedReader(new FileReader("Usuarios.txt"));
            String linea;

            while ((linea = readerUsuarios.readLine()) != null) {
                String [] d = linea.split(",");

                if(d.length == 3){
                    Datos.usuarios.add(new Usuario(d[0].trim(), d[1].trim() , d[2].trim()));
                }
            }
            readerUsuarios.close();

            BufferedReader readerReportes = new BufferedReader(new FileReader("Reportes.txt"));
            while ((linea = readerReportes.readLine()) != null) {

                String [] R = linea.split(",");

                if(R.length == 5){
                    Datos.reportes.add(new Reporte(R[0] , R[1] , R[2] , R[3] , R[4]));
                }
                
            }
            readerReportes.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
