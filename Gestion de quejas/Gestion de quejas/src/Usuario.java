import javax.swing.JOptionPane;

public class Usuario {
    private String nombre;
    private String email;
    private String contraseña;


    public Usuario(String nombre, String contraseña, String email){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
    }
    
    
    public String getNombre(){return nombre;}
    public String getContraseña(){return contraseña;}
    public String getEmail(){return email;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setContraseña(String contraseña){this.contraseña = contraseña;}
    public void setEmail(String email){this.email = email;}


    public void Reportar(){

        String direccion = JOptionPane.showInputDialog("Ingresa la direccion:");
        if(direccion == null || direccion.trim().isEmpty()){
            System.out.println("1.Oprimiste cancelar o dejaste un campo vacio..");
            return;
        }

        String descripcion = JOptionPane.showInputDialog("Ingresa la descripcion:");
        if(descripcion == null || descripcion.trim().isEmpty()){
            System.out.println("2.Oprimiste clacelar o deejaste un campo sin llenar");
            return;
        }

        String tipoReporte = JOptionPane.showInputDialog("Tipo de reporte (Infraestructura o servicios publicos), escribe la palabra correctamente");
        if(tipoReporte == null || tipoReporte.trim().isEmpty()){
            System.out.println("3.Oprimiste cancelar o dejaste un campo sin llenar");
            return;
        }
        String estado = "pendiente";
        
        Reporte reporte = new Reporte(this.email, direccion, descripcion,tipoReporte,estado);
        Datos.reportes.add(reporte);
        Archivo archivo = new Archivo();
        archivo.crearArchivo();
        archivo.cargarArchivo();

        System.out.println("Reporte creado con exito podras verlo en el menu");

    }

    public String VerReportes(){

        StringBuilder reporte = new StringBuilder();


        if(Datos.reportes.isEmpty()){
            reporte.append("No tienes reportes.");

        }else{
            
            for(Reporte rep : Datos.reportes){
                reporte.append("Usuario: ").append(rep.getUsuario()).append("\n");
                reporte.append("Direccion: ").append(rep.getDireccion()).append("\n");
                reporte.append("Descripcion: ").append(rep.getDescripcion()).append("\n");
                reporte.append("Tipo de reporte: ").append(rep.getTipoReporte()).append("\n");
                reporte.append("Estado: ").append(rep.getEstado()).append("\n");
            }
        }

        return reporte.toString();


    }

}
