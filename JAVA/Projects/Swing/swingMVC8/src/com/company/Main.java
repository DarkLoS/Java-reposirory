package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new DialogFrame();
                frame.setTitle("DialogTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    static public class AboutDialog extends JDialog
    {
        public AboutDialog(JFrame owner)
        {
            super(owner, "About DialogTest", true);
            add(
                    new JLabel(
                            "<html><h1><i>Core Java</i></h1><hr>By Cay Horstmann and Gary Cornell</html>"),
                    BorderLayout.CENTER);
            JButton ok = new JButton("OK");
            ok.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    setVisible(false);
                }
            });
            JPanel panel = new JPanel();
            panel.add(ok);
            add(panel, BorderLayout.SOUTH);
            pack();
        }
    }
    static public class DialogFrame extends JFrame
    {
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 200;
        private AboutDialog dialog;
        public DialogFrame()
        {
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);
            JMenu fileMenu = new JMenu("File");
            menuBar.add(fileMenu);
            JMenuItem aboutItem = new JMenuItem("About");
            aboutItem.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    if (dialog == null)
                        dialog = new AboutDialog(DialogFrame.this);
                    dialog.setVisible(true);
                }
            });
            fileMenu.add(aboutItem);
            JMenuItem exitItem = new JMenuItem("Exit");
            exitItem.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    System.exit(0);
                }
            });
            fileMenu.add(exitItem);
        }
    }

}
