import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TimerExample extends JFrame {

    public int X;
    public int XF;
    public int DX;
    public Timer timer;

    public long StartTime;
    public long duration = 800;

    public JLabel label;

    public TimerExample() {
        setTitle("Timer");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        X = 0;
        XF = 245;
        DX = 1;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 500);
        panel.setBackground(Color.gray);

        JPanel panelM = new JPanel();
        panelM.setLayout(null);
        panelM.setBounds(X, 0, 250, 500);

        timer = new Timer(16, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                long tiempoTranscurrido = System.currentTimeMillis() - StartTime;

               
                if (tiempoTranscurrido >= duration) {
                    timer.stop();

                    if(DX == 1){
                        X = XF;
                    }else if(DX == -1){
                        X = 0;
                    }
                    
                } else {
                    
                    float t = (float) tiempoTranscurrido;
                    float d = (float) duration;
                    float porcentaje = t / d;

                    if(DX == 1){
                        X = (int) (XF * porcentaje);
                    }else if (DX == -1){
                        X = (int) (XF - (XF*porcentaje));
                    }


                    
                }

                panelM.setBounds(X, 0, 250, 500);
            }
        });

        ImageIcon imagenRegistrarorg = new ImageIcon(getClass().getResource("iconos/Registro.png"));
        ImageIcon imagenIniciarorg = new ImageIcon(getClass().getResource("iconos/Iniciar.png"));

        Image RegisEscalada = imagenRegistrarorg.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image IniEscalada = imagenIniciarorg.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);


        ImageIcon Registrar = new ImageIcon(RegisEscalada);
        ImageIcon Iniciar = new ImageIcon(IniEscalada);

            
        



        JButton botonregi = new JButton("Sign in",Iniciar);
        botonregi.setBounds(60 + X, 400, 100, 50);

        JButton botonINi = new JButton("Sign up" , Registrar);
        botonINi.setBounds( 60 + X, 400, 100, 50);

        botonregi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DX = -1; 
                StartTime = System.currentTimeMillis(); 
                if (!timer.isRunning()) {
                    panelM.remove(botonregi);
                    panelM.add(botonINi);
                    revalidate();
                    repaint();
                    
                    timer.start();
                }
            }

        });

        


        botonINi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DX = 1; 
                StartTime = System.currentTimeMillis(); 
                if (!timer.isRunning()) {
                    panelM.remove(botonINi);
                    panelM.add(botonregi);
                    revalidate();
                    repaint();
                    
                    timer.start();
                }
            }

        });



        panel.add(panelM);
        panelM.add(botonINi);
        
        add(panel);
        
    }

    public static void main(String[] args) {
        TimerExample tm = new TimerExample();
        tm.setVisible(true);
    }
}


