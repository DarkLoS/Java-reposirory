package com.company;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.text.*;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.io.IOUtils;
public class ListParkDrivers {
    private List<ParkDriver> list;
    public ListParkDrivers(String file)throws IOException,ParseException{
        list=new ArrayList<>();
        BufferedReader bn = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bn.readLine()) != null) {
            list.add(new ParkDriver(line.split(";")));
        }
    }
    public ListParkDrivers(String file,String format) throws IOException,ClassNotFoundException{
        list=new ArrayList<>();
        if(format.equals("xml")) {
            XStream xstream = new XStream();
            xstream.alias("serializableclass", ParkDriver.class);
            InputStream is = new FileInputStream(file);
            list=(List)xstream.fromXML(IOUtils.toString(is, "windows-1251"));
        }
        else if(format.equals("bin")){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            list=(List)in.readObject();
        }
    }
    @Override
    public String toString() {
        String string="";
        for(ParkDriver p:list){
            string+=p.show()+"\n";
        }
        return string;
    }
    public void saveToXML(String file)throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        XStream xstream = new XStream();
        xstream.alias("serializableclass", ParkDriver.class);
        String xml = xstream.toXML(list);
        bw.append(xml);
        bw.close();
    }
    public void saveBin(String file)throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(list);
    }
    public void writeToDatabase()throws SQLException,ClassNotFoundException{
        Database.connect();
        Database.createDB();
        Database.writeDB(list);
    }
}