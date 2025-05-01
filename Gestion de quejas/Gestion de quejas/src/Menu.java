import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Menu extends JFrame {

    private Usuario usuarioLogeado;



    //CONSTRUCTOR DE MENU   
    public Menu(Usuario usuarioLogeado){
        this.usuarioLogeado = usuarioLogeado;
        setTitle("Menu Principal");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        


        //PANEL GENERAL, EL DECORATIVO Y TAMBIEN EL DE LOS REPORTES

        JPanel panelGeneral = new JPanel();
        panelGeneral.setBounds(0,0,800,600);
        panelGeneral.setLayout(null);
        panelGeneral.setBackground(new Color(211, 211, 211));


        JPanel panelDecorativo = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g.create();

                g2.setPaint(new java.awt.GradientPaint(0,0,new Color(174, 198, 207) ,getWidth(), getHeight(), new Color(31, 102, 124 ) ));
                g2.fillRect(0,0,getWidth(),getHeight());
            }
        };

        panelDecorativo.setLayout(null);
        panelDecorativo.setBounds(0,0,250,600);
        

        JPanel panelReporte = new JPanel();
        panelReporte.setLayout(null);
        panelReporte.setBounds(270, 0, 500, 600);
        panelReporte.setBackground(Color.WHITE);
        panelReporte.setVisible(false);
        
 
        

        //ICONOS DE LOS BOTONES Y TAMBIEN IMAGENES USADAS EN EL MENU    
        ImageIcon UsuarioOriginal = new ImageIcon(getClass().getResource("iconos/usuario.png"));
        Image UsuarioEscalado = UsuarioOriginal.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon Usuario = new ImageIcon(UsuarioEscalado);

        ImageIcon SaludoOriginal = new ImageIcon(getClass().getResource("iconos/saludo.png"));
        Image SaludoEscalado = SaludoOriginal.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        ImageIcon Saludo = new ImageIcon(SaludoEscalado);

        ImageIcon ReportarOriginal = new ImageIcon(getClass().getResource("iconos/reportar.png"));
        Image ReportarEscalado = ReportarOriginal.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon IconoReportar = new ImageIcon(ReportarEscalado);

        JLabel EtiquetaUsuario = new JLabel(Usuario);
        EtiquetaUsuario.setBounds(90,65,80,80);

        JLabel EtiquetaSaludo = new JLabel(Saludo);
        EtiquetaSaludo.setBounds(270,0,500,400);


        
        //BOTONES PARA ESTE MENU

        JButton Reportar = new JButton("Reportar",IconoReportar);
        Reportar.setBackground(new Color(174, 198, 207));
        Reportar.setForeground(Color.darkGray);
        Reportar.setFont(new Font("Arial" , Font.BOLD, 15));
        Reportar.setBounds(40,200,170,40);
        Reportar.setFocusPainted(false);
        
        JButton VerReportes = new JButton("Ver reportes");
        VerReportes.setBackground(new Color(174, 198, 207));
        VerReportes.setBounds(40,300,170,40);
        VerReportes.setFocusPainted(false);
        VerReportes.setFont(new Font("Arial" , Font.BOLD, 15));


        JButton Admin = new JButton("Admin");
        Admin.setBackground(new Color(174, 198, 207));
        Admin.setBounds(40,500,100,30);

    
        
        
        //ACTIONS LISTENER PARA LOS BOTONES
        Reportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                usuarioLogeado.Reportar();
                
                
            }
        });

        VerReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                

                String reportes = usuarioLogeado.VerReportes();

                JOptionPane.showMessageDialog(null, reportes);
       
            }
        });


        Admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = "admin123";
                String correo = "admin@gmail.com";

                String Code = JOptionPane.showInputDialog("Ingresa el codig de seguridad");
                String email = JOptionPane.showInputDialog("INgresa el correo: ");

                if(Code.trim().equals(codigo) && correo.trim().equals(email)){
                    MenuAdministrador menu = new MenuAdministrador();
                    menu.setVisible(true);
                    dispose();
                }
            }
        });




        //PANEL GENERAL
        add(panelGeneral);
        panelGeneral.add(panelDecorativo);
        panelGeneral.add(EtiquetaSaludo);

        //PANEL DEDCORATIVO
        panelDecorativo.add(Reportar);
        panelDecorativo.add(VerReportes);
        panelDecorativo.add(EtiquetaUsuario);
        panelDecorativo.add(Admin);






        
    }

    public Usuario getUsuarioLogeado() { return usuarioLogeado;}

    public void setUsuarioLogeado(Usuario usuarioLogeado) { this.usuarioLogeado = usuarioLogeado;}

}
