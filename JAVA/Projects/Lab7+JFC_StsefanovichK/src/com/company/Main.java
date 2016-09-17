package com.company;
import java.io.*;
import java.nio.file.Files;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.thoughtworks.xstream.XStream;
import java.security.*;
import java.math.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new TextComponentFrame();
                frame.setTitle("TextComponentTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}
class conn {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    public static void Conn(JTextArea textArea) throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:123.sdb");

        textArea.append("База Подключена!"+ "\n");
    }
    public static void CreateDB(JTextArea textArea) throws ClassNotFoundException, SQLException
    {
       try
       {
           BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("123.sdb")));
           fout.flush();
           fout.write("");
           fout.close();
       }
       catch (IOException e){
           textArea.append(e.toString()+ "\n");
       }
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'number' text, 'nameDirector' text,'address' text,'numberAttraction' text,'name' text,'yearAcquisitionint' text,'lifeTime' text);");

        textArea.append("Таблица создана или уже существует."+ "\n");
    }
    public static void WriteDB(int n,Attraction[]place,JTextArea textArea ) throws SQLException
    {
        for(int i=0;i<n;i++) {
            statmt.execute("INSERT INTO 'users' ('number', 'nameDirector','address','numberAttraction','name','yearAcquisitionint','lifeTime') VALUES ('"+place[i].getNumber()+"', '"+place[i].getNameDirector()+"', '"+place[i].getAdress()+"','"+place[i].getNumberAttraction()+"','"+place[i].getname()+"','"+place[i].getYearAcquisitionint()+"','"+place[i].getLifeTime()+"'); ");
        }
        textArea.append("Таблица заполнена"+ "\n");
    }
    public static void ReadDB(JTextArea textArea) throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  number = resSet.getString("number");
            String  nameDirector = resSet.getString("nameDirector");
            String  address = resSet.getString("address");
            String  numberAttraction = resSet.getString("numberAttraction");
            String  name = resSet.getString("name");
            String  yearAcquisitionint = resSet.getString("yearAcquisitionint");
            String  lifeTime = resSet.getString("lifeTime");
            textArea.append( "ID = " + id+ "\n" );
            textArea.append( "number = " + number+ "\n" );
            textArea.append( "nameDirector = " + nameDirector+ "\n" );
            textArea.append( "address = " + address+ "\n" );
            textArea.append( "numberAttraction = " + numberAttraction+ "\n" );
            textArea.append( "name = " + name + "\n");
            textArea.append( "yearAcquisitionint = " + yearAcquisitionint+ "\n" );
            textArea.append( "lifeTime = " + lifeTime + "\n");
            textArea.append("\n");
        }
        textArea.append("Таблица выведена");
    }
}
class TextComponentFrame extends JFrame
{
    public static final int TEXTAREA_ROWS = 30;
    public static final int TEXTAREA_COLUMNS = 70;

    public TextComponentFrame()
    {
        final JTextField textField = new JTextField();

        String md="827ccb0eea8a706c4c34a16891f84e7b";
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 1));
        northPanel.add(textField);
        add(northPanel, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
        textArea.append("Для доступа к результатам введите пароль" + "\n");
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        JPanel southPanel = new JPanel();

        JButton insertButton = new JButton("Start");
        JButton clearButton = new JButton("Clear");
        southPanel.add(insertButton);
        southPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                textArea.setText("Для доступа к результатам введите пароль" + "\n");
            }
        });
        insertButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {

                try {
                    String str = textField.getText();
                    MessageDigest m = MessageDigest.getInstance("MD5");
                    m.update(str.getBytes(), 0, str.length());
                    if (new BigInteger(1, m.digest()).toString(16).equals(md))
                        textArea.append("Hello!" + "\n");
                    else {
                        textArea.append("Wrong!" + "\n");
                        return;
                    }
                        RandomAccessFile fin = new RandomAccessFile("1.txt", "r");
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"), "Cp1251"));
                        bw.flush();
                        String line;
                        int n = Integer.parseInt(fin.readLine());
                        Attraction[] place = new Attraction[n];
                        for (int i = 0; i < n; i++) {
                            place[i] = new Attraction();
                            line = new String(fin.readLine().getBytes("ISO-8859-1"), "windows-1251");
                            String[] parts = line.split(" ");
                            place[i].setNumberAttraction(Integer.parseInt(parts[0]));
                            place[i].setName(parts[1]);
                            place[i].setYearAcquisitionint(Integer.parseInt(parts[2]));
                            place[i].setLifeTime(Integer.parseInt(parts[3]));
                            place[i].setNumber(Integer.parseInt(parts[4]));
                            place[i].setNameDirector(parts[5]);
                            place[i].setAdress(parts[6]);
                        }
                        for (int i = 0; i < n; i++) {
                            textArea.append(place[i].toString() + "\n");
                        }
                        int n2 = Integer.parseInt(fin.readLine());
                        Information[] inf = new Information[n2];
                        for (int i = 0; i < n2; i++) {
                            inf[i] = new Information();
                            line = new String(fin.readLine().getBytes("ISO-8859-1"), "windows-1251");
                            String[] parts = line.split(" ");
                            inf[i].setDate(new GregorianCalendar(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                            inf[i].setNumber(Integer.parseInt(parts[3]));
                            inf[i].setNumberAttraction(Integer.parseInt(parts[4]));
                            inf[i].setTickets(Integer.parseInt(parts[5]));
                        }
                        for (int i = 0; i < n2; i++) {
                            textArea.append(inf[i].toString() + "\n");
                        }


                        for (Information i : inf)
                            for (Attraction a : place) {
                                bw.flush();
                                if (a.getNumber() == i.getNumber() && a.getNumberAttraction() == i.getNumberAttraction())
                                    bw.append(a.toString() + System.getProperty("line.separator"));
                            }
                        XStream xstream = new XStream();
                        xstream.alias("serializableclass", Attraction.class);
                        String xml = xstream.toXML(place[0]);
                        textArea.append(xml + "\n");
                        Attraction classIns = (Attraction) xstream.fromXML(xml);
                        textArea.append(classIns.toString() + "\n");
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serializable.dat"));
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream("serializable.dat"));
                        out.writeObject(place);
                        Attraction[] newStaff = (Attraction[]) in.readObject();
                        for (Attraction a : newStaff)
                            textArea.append(a.toString() + "\n");


                        conn.Conn(textArea);
                        conn.CreateDB(textArea);
                        conn.WriteDB(n, place, textArea);
                        conn.ReadDB(textArea);

                }
                catch (FileNotFoundException e){
                    textArea.append(e.toString()+ "\n");
                }
                catch (IOException e){
                    textArea.append(e.toString()+ "\n");
                }
                catch ( ClassNotFoundException e )
                {
                    textArea.append(e.toString()+ "\n");
                }
                catch (NoSuchAlgorithmException e) {
                    textArea.append(e.toString()+ "\n");
                }
                catch(SQLException e)
                {
                    textArea.append(e.toString()+ "\n");
                }
            }
        });

        add(southPanel, BorderLayout.SOUTH);
        pack();
    }
}
