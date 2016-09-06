package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame =new ButtonFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true);
            }
        });
    }
}
class  ButtonFrame extends  JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    public ButtonFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        buttonPanel = new JPanel();
        makeButton("Yellow",Color.YELLOW);
        makeButton("Blue",Color.BLUE);
        makeButton("Red",Color.RED);
        add(buttonPanel);
    }
    public void makeButton(String name, final Color backgroundColor)
    {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(backgroundColor);
            }
        });
    }
}
