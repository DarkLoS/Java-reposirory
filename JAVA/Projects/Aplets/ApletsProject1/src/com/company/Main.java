package com.company;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new ResourceTestFrame();
                frame.setTitle("ResourceTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    static class ResourceTestFrame extends JFrame
    {
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 300;

        public ResourceTestFrame()
        {
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            URL aboutURL = getClass().getResource("about.gif");
            Image img = new ImageIcon(aboutURL).getImage();
            setIconImage(img);
            JTextArea textArea = new JTextArea();
            InputStream stream = getClass().getResourceAsStream("about.txt");
            Scanner in = new Scanner(stream);
            while (in.hasNext())
                textArea.append(in.nextLine() + "\n");
            add(textArea);
        }
    }
}
