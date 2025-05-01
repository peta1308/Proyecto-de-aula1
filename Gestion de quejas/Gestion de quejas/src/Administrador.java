
public class Administrador {
    

    
    private String email;
    private String codigo;


    public Administrador(String codigo, String email){
        this.codigo = codigo;
        this.email = email;
       
    }


    public String getCode(){return codigo;}
    public void setCode(String codigo){this.codigo = codigo;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}



    //METODO DEL ADMIN PARA VER LOS REPORTES
    public String VerReportes(){

        StringBuilder reportes = new StringBuilder();

        for(Reporte rep : Datos.reportes){
            reportes.append("usuario: ").append(rep.getUsuario());
            reportes.append("\n Direccion: ").append(rep.getDireccion());
            reportes.append("\n Descripcion: ").append(rep.getDescripcion());
            reportes.append("\n Tipo de reporte: ").append(rep.getTipoReporte());
            reportes.append("\n Estado: ").append(rep.getEstado());
            reportes.append("\n\n");
        }

        return reportes.toString();
    }

    //METODO DEL ADMIN PARA CAMBIAR EL ESTADO DE LOS REPORTES 
    public void CambiarEtado(String usuario, String nuevoEstado){

        boolean estadoCambiado = false;

        for(Reporte reporte: Datos.reportes){

            if(reporte.getUsuario().trim().equals(usuario)){
                reporte.setEstado(nuevoEstado);
                estadoCambiado = true;
                System.out.println("estado cambiado a: " + nuevoEstado);
                
                break;
            }

        }

        if(estadoCambiado){
            new Archivo().crearArchivo();
        }else{
            System.out.println("no se encontro el usuario a modificar: ");
            
        }

    }

    public String estadisticasTiposReportes() {
        int infraestructura = 0;
        int servicios = 0;
    
        for (Reporte r : Datos.reportes) {
            if (r.getTipoReporte().equalsIgnoreCase("infraestructura")) {
                infraestructura++;
            } else if (r.getTipoReporte().equalsIgnoreCase("servicios publicos")) {
                servicios++;
            }
        }
    
        int total = infraestructura + servicios;
    
        if (total == 0) {
            return "No hay reportes para analizar.";
        }
    
        double porcentajeInfra = (infraestructura * 100.0) / total;
        double porcentajeServ = (servicios * 100.0) / total;
    
        return String.format("Total de reportes: %d - Infraestructura: %d (%.2f%%) - Servicios Públicos: %d (%.2f%%)",total, infraestructura, porcentajeInfra, servicios, porcentajeServ);
    }
    

}