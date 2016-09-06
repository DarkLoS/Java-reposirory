package com.company;
import java.awt.*;
import javax.swing.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame frame =new SimpleFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true);
            }
        });
    }
}
class SimpleFrame extends  JFrame
{

    public SimpleFrame()
    {
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth=screenSize.width;
        int screenHeight=screenSize.height;
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
        Image img =new ImageIcon("icon.jpg").getImage();
        setIconImage(img);
        add(new NotHelloWorldComponent());
    }
}
class NotHelloWorldComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        g.drawString("Not a Hello, World program",75,100);
    }
    public Dimension getPreferredSize()
    {
        return  new Dimension(300,200);
    }
}