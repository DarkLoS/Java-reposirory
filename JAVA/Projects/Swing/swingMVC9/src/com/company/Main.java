package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new DataExchangeFrame();
                frame.setTitle("DataExchangeTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    static public class PasswordChooser extends JPanel
    {
        private JTextField username;
        private JPasswordField password;
        private JButton okButton;
        private boolean ok;
        private JDialog dialog;

        public PasswordChooser()
        {
            setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 2));
            panel.add(new JLabel("User name:"));
            panel.add(username = new JTextField(""));
            panel.add(new JLabel("Password:"));
            panel.add(password = new JPasswordField(""));
            add(panel, BorderLayout.CENTER);
            okButton = new JButton("Ok");
            okButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    ok = true;
                    dialog.setVisible(false);
                }
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    dialog.setVisible(false);
                }
            });
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(okButton);
            buttonPanel.add(cancelButton);
            add(buttonPanel, BorderLayout.SOUTH);
        }

        /**
         * Sets the dialog defaults.
         * @param u the default user information
         */
        public void setUser(User u)
        {
            username.setText(u.getName());
        }
        public User getUser()
        {
            return new User(username.getText(), password.getPassword());
        }
        public boolean showDialog(Component parent, String title)
        {
            ok = false;
            Frame owner = null;
            if (parent instanceof Frame) owner = (Frame) parent;
            else owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
            if (dialog == null || dialog.getOwner() != owner)
            {
                dialog = new JDialog(owner, true);
                dialog.add(this);
                dialog.getRootPane().setDefaultButton(okButton);
                dialog.pack();
            }
            dialog.setTitle(title);
            dialog.setVisible(true);
            return ok;
        }
    }
    static public class DataExchangeFrame extends JFrame
    {
        public static final int TEXT_ROWS = 20;
        public static final int TEXT_COLUMNS = 40;
        private PasswordChooser dialog = null;
        private JTextArea textArea;

        public DataExchangeFrame()
        {
            JMenuBar mbar = new JMenuBar();
            setJMenuBar(mbar);
            JMenu fileMenu = new JMenu("File");
            mbar.add(fileMenu);
            JMenuItem connectItem = new JMenuItem("Connect");
            connectItem.addActionListener(new ConnectAction());
            fileMenu.add(connectItem);
            JMenuItem exitItem = new JMenuItem("Exit");
            exitItem.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    System.exit(0);
                }
            });
            fileMenu.add(exitItem);

            textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
            add(new JScrollPane(textArea), BorderLayout.CENTER);
            pack();
        }
        private class ConnectAction implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if (dialog == null) dialog = new PasswordChooser();
                dialog.setUser(new User("yourname", null));
                if (dialog.showDialog(DataExchangeFrame.this, "Connect"))
                {
                    User u = dialog.getUser();
                    textArea.append("user name = " + u.getName() + ", password = "
                            + (new String(u.getPassword())) + "\n");
                }
            }
        }
    }
    static public class User
    {
        private String name;
        private char[] password;
        public User(String aName, char[] aPassword)
        {
            name = aName;
            password = aPassword;
        }
        public String getName()
        {
            return name;
        }
        public char[] getPassword()
        {
            return password;
        }
        public void setName(String aName)
        {
            name = aName;
        }
        public void setPassword(char[] aPassword)
        {
            password = aPassword;
        }
    }

}
