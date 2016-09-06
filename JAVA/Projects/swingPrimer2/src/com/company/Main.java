package com.company;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame =new DrawFrame();
                frame.setTitle("Draw Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBackground(Color.CYAN);
                frame.setVisible(true);

            }
        });
    }
}
class DrawFrame extends  JFrame
{

    public DrawFrame()
    {
        DrawComponent p=new DrawComponent();
        add(p);
        pack();
    }
}
class DrawComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
       Graphics2D g2=(Graphics2D)g;
        Rectangle2D rect = new Rectangle2D.Double(100,100,200,150);
        g2.draw(rect);
        g2.setPaint(Color.RED);
        g2.fill(rect);
        g2.setPaint(Color.BLACK);
        Ellipse2D ellipse =new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);
        g2.draw(new Line2D.Double(100,100,300,250));
        Ellipse2D circle =new Ellipse2D.Double();
        circle.setFrameFromCenter(rect.getCenterX(),rect.getCenterY(),rect.getCenterX()+150,rect.getCenterY()+150);
        g2.draw(circle);
    }
    public Dimension getPreferredSize()
    {
        return  new Dimension(400,400);
    }
}