import java.awt.Graphics;
import java.awt.Graphics2D;

import  javax.swing.*;

public class PanelRedondo extends JPanel {

    public int ArcoAlto;
    public int ArcoAncho;

    public PanelRedondo(int ArcoAlto , int ArcoAncho){

        this.ArcoAlto = ArcoAlto;
        this.ArcoAncho = ArcoAncho;
        setOpaque(false);
        setLayout(null);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fillRoundRect(0,0,getWidth(), getHeight(),ArcoAncho, ArcoAlto);
        g2.dispose();
    }
    
}
