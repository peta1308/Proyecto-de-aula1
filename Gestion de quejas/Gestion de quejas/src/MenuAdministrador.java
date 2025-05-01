import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class MenuAdministrador extends JFrame {
    public MenuAdministrador(){

        setTitle("Menu Administrador");
        setSize(400,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBounds(0,0,400,300);
        panel.setBackground(new Color(49, 226, 231 ));


        JButton ver = new JButton("Ver reportes");
        ver.setForeground(Color.black);
        ver.setFont(new Font("Arial" , Font.BOLD , 10));
        ver.setBounds(40,100,100,30);
        ver.setFocusPainted(false);

        JButton modificar = new JButton("Modificar reporte");
        modificar.setForeground(Color.black);
        modificar.setFont(new Font("Arial" , Font.BOLD , 10));
        modificar.setBounds(240,100,120,30);
        modificar.setFocusPainted(false);


        JButton est = new JButton("% Reportes");
        est.setForeground(Color.black);
        est.setFont(new Font("Arial" , Font.BOLD , 10));
        est.setBounds(120,50,150,30);
        est.setFocusPainted(false);


        ver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Archivo().cargarArchivo();
                Administrador admin = new Administrador("a" ,"a");

                String reportes = admin.VerReportes();
                if(!reportes.isEmpty()){
                    JOptionPane.showMessageDialog(null,reportes, "Reportes" , JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"No tienes reportes..","Sin reportes", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
            
        });


        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean usuarioEncontrado = false;

                new Archivo().cargarArchivo();

                String usuario = JOptionPane.showInputDialog("Ingrese el usuario que desea modificar.");
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado");
                
                Administrador admin = new Administrador("a" , "a");

                for(Usuario us : Datos.usuarios){
                    if(us.getEmail().trim().equals(usuario)){

                        admin.CambiarEtado(usuario, nuevoEstado);
                        usuarioEncontrado = true;
                        break;

                    }
                }

                if(usuarioEncontrado){
                    String reporte = admin.VerReportes();
                    JOptionPane.showMessageDialog(null, "Estado cambiado con exito:\n " +reporte);
                }else{
                    JOptionPane.showMessageDialog(null,"Error al intertar cambiar el estado...");
                }

      

            }
        });

        est.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Archivo().cargarArchivo();
                
                Administrador admin = new Administrador("a", "a");

                String resultado = admin.estadisticasTiposReportes();
                JOptionPane.showMessageDialog(null, resultado, "% de Tipos de Reportes", JOptionPane.INFORMATION_MESSAGE);
        
                
            }
            
        });


        add(panel);
        panel.add(ver);
        panel.add(modificar);
        panel.add(est);

        
        
    }

    public static void main(String[] args) {
        MenuAdministrador menu = new MenuAdministrador();

        menu.setVisible(true);
    }

}
