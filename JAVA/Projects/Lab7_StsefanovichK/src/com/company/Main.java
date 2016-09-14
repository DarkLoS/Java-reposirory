package com.company;
import java.io.*;
import java.nio.file.Files;
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
        String md="827ccb0eea8a706c4c34a16891f84e7b";
        try {
            Scanner init =new Scanner(System.in);
            RandomAccessFile fin =new  RandomAccessFile("1.txt","r");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"), "Cp1251"));
            bw.flush();
            String line;
            int n = Integer.parseInt(fin.readLine());
            Attraction[] place = new Attraction[n];
            for(int i=0;i<n;i++) {
                place[i]=new Attraction();
                line=new String(fin.readLine().getBytes("ISO-8859-1"), "windows-1251");
                String[] parts=line.split(" ");
                place[i].setNumberAttraction(Integer.parseInt(parts[0]));
                place[i].setName(parts[1]);
                place[i].setYearAcquisitionint(Integer.parseInt(parts[2]));
                place[i].setLifeTime(Integer.parseInt(parts[3]));
                place[i].setNumber(Integer.parseInt(parts[4]));
                place[i].setNameDirector(parts[5]);
                place[i].setAdress(parts[6]);
            }
            for(int i=0;i<n;i++) {
                System.out.println(place[i].toString());
            }
            int n2 = Integer.parseInt(fin.readLine());
            Information[] inf = new Information[n2];
            for(int i=0;i<n2;i++) {
                inf[i]=new Information();
                line=new String(fin.readLine().getBytes("ISO-8859-1"), "windows-1251");
                String[] parts=line.split(" ");
                inf[i].setDate(new GregorianCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2])));
                inf[i].setNumber(Integer.parseInt(parts[3]));
                inf[i].setNumberAttraction(Integer.parseInt(parts[4]));
                inf[i].setTickets(Integer.parseInt(parts[5]));
            }
            for(int i=0;i<n2;i++) {
                System.out.println(inf[i].toString());
            }
            System.out.println("Для доступа к результатам введите пароль");
            String str=init.nextLine();
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.update(str.getBytes(),0,str.length());
            if(new BigInteger(1,m.digest()).toString(16).equals(md))
            System.out.println("Hello!");
            else{
                System.out.println("Wrong!");
                return;
            }

            for(Information i :inf)
                for(Attraction a :place)
                {bw.flush();
                    if(a.getNumber()==i.getNumber() && a.getNumberAttraction()==i.getNumberAttraction())
                        bw.append(a.toString()+System.getProperty("line.separator"));
                }
            XStream xstream = new XStream();
            xstream.alias("serializableclass", Attraction.class);
            String xml = xstream.toXML(place[0]);
            System.out.println(xml);
            Attraction classIns = (Attraction) xstream.fromXML(xml);
            System.out.println(classIns.toString());
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serializable.dat"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("serializable.dat"));
            out.writeObject(place);
            Attraction[] newStaff = (Attraction[])  in.readObject();
            for(Attraction a : newStaff)
                System.out.println(a.toString());



            conn.Conn();
            conn.CreateDB();
            conn.WriteDB(n,place);
            conn.ReadDB();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch ( ClassNotFoundException e )
        {
            System.out.println(e);
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }
}
class conn {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:123.sdb");

        System.out.println("База Подключена!");
    }
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
       try
       {
           BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("123.sdb")));
           fout.flush();
           fout.write("");
           fout.close();
       }
       catch (IOException e){
           System.out.println(e);
       }
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'number' text, 'nameDirector' text,'address' text,'numberAttraction' text,'name' text,'yearAcquisitionint' text,'lifeTime' text);");

        System.out.println("Таблица создана или уже существует.");
    }
    public static void WriteDB(int n,Attraction[]place ) throws SQLException
    {
        for(int i=0;i<n;i++) {
            statmt.execute("INSERT INTO 'users' ('number', 'nameDirector','address','numberAttraction','name','yearAcquisitionint','lifeTime') VALUES ('"+place[i].getNumber()+"', '"+place[i].getNameDirector()+"', '"+place[i].getAdress()+"','"+place[i].getNumberAttraction()+"','"+place[i].getname()+"','"+place[i].getYearAcquisitionint()+"','"+place[i].getLifeTime()+"'); ");
        }
        System.out.println("Таблица заполнена");
    }
    public static void ReadDB() throws ClassNotFoundException, SQLException
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
            System.out.println( "ID = " + id );
            System.out.println( "number = " + number );
            System.out.println( "nameDirector = " + nameDirector );
            System.out.println( "address = " + address );
            System.out.println( "numberAttraction = " + numberAttraction );
            System.out.println( "name = " + name );
            System.out.println( "yearAcquisitionint = " + yearAcquisitionint );
            System.out.println( "lifeTime = " + lifeTime );
            System.out.println();
        }
        System.out.println("Таблица выведена");
    }
}