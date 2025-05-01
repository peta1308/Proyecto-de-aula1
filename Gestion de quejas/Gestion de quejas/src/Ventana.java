import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Ventana extends JFrame{

    public int X;
    public int XF;
    public int DX;
    Timer timer;
    public long StartTime;
    public long duration = 1000;
    private JLabel Beemo;


    private Image invertirImagen(Image img) {
        
        int w = img.getWidth(null);
        int h = img.getHeight(null);
        BufferedImage imagenInvertida = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imagenInvertida.createGraphics();
        g2.drawImage(img, w, 0, -w, h, null);
        g2.dispose();
        return imagenInvertida;
    }

    public Ventana(){

        setTitle("Gestion de quejas");
        setSize(800,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        

        

        X = 0;
        XF = 425;
        DX = 1;
        //PANELES QUE TENDRA LA VENTANA*************//////
        JPanel panelPrincipal = new JPanel(){
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new java.awt.GradientPaint(0,0 , new Color(50, 200, 245 ),getWidth() ,getHeight() , new Color(158, 255, 254)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            };
        };
        panelPrincipal.setLayout(null);
        panelPrincipal.setBounds(0,0,800,600);

        //PANEL QUE SE MOVERA*************//////
        JPanel panelMove = new JPanel();
        panelMove.setLayout(null);
        panelMove.setBounds(X,0,300,600);

        //ZONA DE LAS IMAGENES E ICONOS ************************//////////
        ImageIcon Iniciaroriginal1 = new ImageIcon(getClass().getResource("iconos/Iniciar.png"));
        Image escalda = Iniciaroriginal1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon Inicio = new ImageIcon(escalda);

        ImageIcon ImagenRegistrar = new ImageIcon(getClass().getResource("iconos/Registro.png"));
        Image RegistrarEscalada = ImagenRegistrar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon ImageRegistrar = new ImageIcon(RegistrarEscalada);

        ImageIcon SalirOriginal = new ImageIcon(getClass().getResource("iconos/salir.png"));
        Image Salirescalada = SalirOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon SalirIcon = new ImageIcon(Salirescalada);

        ImageIcon Entraroriginal = new ImageIcon(getClass().getResource("iconos/entrar.png"));
        Image Entrarescalada = Entraroriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon EntrarIcon = new ImageIcon(Entrarescalada);

        ImageIcon beemo = new ImageIcon(getClass().getResource("personalizar/beemo.jpg"));
        Image escalado = beemo.getImage().getScaledInstance(360, 600, Image.SCALE_SMOOTH);

        ImageIcon beem = new ImageIcon(escalado);

        Beemo = new JLabel(beem);
        Beemo.setBounds(0, 0, 360, 600);

        //AGREGANDO LOS JTEXFIELD 

        JTextField Email = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (getText().isEmpty() && !isFocusOwner()) {

                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setColor(Color.GRAY); 
                    g2.drawString("Correo electronico", 5, getHeight() / 2 + 5);
                    g2.dispose();
                }
            }
        };
        
        Email.setBounds(430 ,150,250,30);

        JPasswordField Pasword = new JPasswordField(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if(getPassword().length == 0 && !isFocusOwner()){

                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setColor(Color.gray);
                    g2.drawString("Contraseña", 5, getHeight() /2 + 5);
                    g2.dispose();
                }
            }
        };
        Pasword.setBounds(430,200,250,30);


        JTextField Name = new JTextField(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                if(getText().isEmpty() && !isFocusOwner()){
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setColor(Color.gray);
                    g2.drawString("Nombre", 5, getHeight() / 2+5);
                    g2.dispose();
                }
            }
        };
        Name.setBounds(100,250,250,30);


        


        //ZONA DE BOTONES*************//////
        JButton sign_up = new JButton("sign up" , ImageRegistrar);
        sign_up.setForeground(new Color(8, 74, 94));
        sign_up.setFont(new Font("Arial" , Font.BOLD, 12));
        sign_up.setBounds(130 + X,510,100,30);

        JButton sign_in = new JButton("sign in", Inicio);
        sign_in.setFont(new Font("Arial" , Font.BOLD, 12));
        sign_in.setBounds(130 + X,510,100,30);

        JButton Registrar = new JButton("Registrar");
        Registrar.setBounds(400,400,150,30);
        
        JButton IniciarSesion = new JButton("Iniciar sesion",EntrarIcon);
        IniciarSesion.setBounds(400,400,150,30);
        

        JButton salir = new JButton("Salir",SalirIcon);
        salir.setBounds(600,400,150,30); 



        //TIMER PARA LA ANIMACION*************//////
        timer = new Timer(16, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                long TiempoTranscurrido = System.currentTimeMillis() - StartTime;

                if(TiempoTranscurrido >= duration ){
                    timer.stop();

                    if(DX == 1){
                        X = XF;
                    }else if(DX == -1){
                        X = 0;
                    }

                }else{
                    float t = (float) TiempoTranscurrido;
                    float d = (float) duration;
                    float porcentaje = t / d;

                    if(DX == 1){
                        X = (int) (XF * porcentaje);
                    }else if (DX == -1){
                        X = (int) (XF - (XF*porcentaje));
                    }


                }

                panelMove.setBounds(X,0,360,600);

                
            }
            
        });

        



        //ACTIONS LISTENER DE CADA BOTON 

        sign_in.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DX = -1;
                StartTime = System.currentTimeMillis();

                Email.setLocation(430,150);
                Pasword.setLocation(430,200);
                salir.setLocation(600,400);
                

                if(!timer.isRunning()){

                    ImageIcon iconoActual = (ImageIcon) Beemo.getIcon();
                    Image imagenActual = iconoActual.getImage();
                    Image imagenInvertida = invertirImagen(imagenActual);
                    Beemo.setIcon(new ImageIcon(imagenInvertida));
                    panelPrincipal.add(IniciarSesion);
                    panelPrincipal.remove(Registrar);
                    sign_in.setVisible(false); 
                    sign_up.setVisible(true);
                    panelPrincipal.remove(Name);
                
                    revalidate();
                    repaint();
                    timer.start();
                }
            }
            
        });


        sign_up.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DX = 1;
                StartTime = System.currentTimeMillis();

                Email.setLocation(X + 20,150);
                Pasword.setLocation(X + 20,200);
                Name.setLocation(X + 20,250);
                salir.setLocation(250,400);
                Registrar.setLocation(70,400);
                

                if(!timer.isRunning()){
                    ImageIcon iconoActual = (ImageIcon) Beemo.getIcon();
                    Image imagenActual = iconoActual.getImage();
                    Image imagenInvertida = invertirImagen(imagenActual);
                    Beemo.setIcon(new ImageIcon(imagenInvertida));
                    panelPrincipal.remove(IniciarSesion);
                    panelPrincipal.add(Registrar);
                    sign_up.setVisible(false);
                    sign_in.setVisible(true);
                    panelPrincipal.add(Name);
                    revalidate();
                    repaint();
                    timer.start();
                }
            }
            
        });

        Registrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String usuaurio = Email.getText();
                String contraseña = new String(Pasword.getPassword());
                String nombre = Name.getText();

                if(usuaurio.isEmpty() || contraseña.isEmpty()|| nombre.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos para poderte registrar");
                }else{
                    Datos.usuarios.add(new Usuario(usuaurio, contraseña, nombre));
                    Archivo archivo = new Archivo();

                    archivo.crearArchivo();
                    archivo.cargarArchivo();

                    JOptionPane.showMessageDialog(null, "Usuario registrado con exito..");
                }
         
            }
            
        });

        IniciarSesion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String usuario = Email.getText();
                String contraseña = new String(Pasword.getPassword());

                boolean usuarioEncontrado = false;


                for(Usuario us : Datos.usuarios){

                    if(us.getEmail().trim().equals(usuario) && us.getContraseña().trim().equals(contraseña)){
                        Menu menu = new Menu(us);
                        usuarioEncontrado = true;
                        JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso...");
                        menu.setVisible(true);
                        
                        dispose();
                        break;  
                    }
                  
                }

                if(!usuarioEncontrado){
                    JOptionPane.showMessageDialog(null, "Este usuario no esta registrado o tiene las credednciales imcorrectas...");

                }
    
            }
            
        });

        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });




        
        panelMove.add(sign_up);
        panelMove.add(sign_in);
        panelMove.add(Beemo);
        panelPrincipal.add(panelMove);
        panelPrincipal.add(IniciarSesion);
        panelPrincipal.add(salir);
        panelPrincipal.add(Pasword);
        panelPrincipal.add(Email);
      
        add(panelPrincipal);

    }
}
