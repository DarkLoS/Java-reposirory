package com.company;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class Main {
    public static void main(String[] args) {
        Map<String,String> map =new HashMap<>();
        int countWords=0;
        int countParagraph=0;
        int countLines=0;
        try {
            BufferedReader bn = new BufferedReader(new FileReader("Alice.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
            String line;

            while ((line = bn.readLine()) != null) {
                System.out.println(line);
                bw.flush();
                countParagraph++;
                String[] parts=line.split("[!.?]+");
                for(String str:parts) {
                    if(str.equals("\'")){}
                    else
                    {
                        countLines++;
                        ArrayList<String> words=new ArrayList<>(Arrays.asList(str.split("[ \"&'()*+,-:;]+")));
                        ListIterator<String> aIter = words.listIterator();
                        while (aIter.hasNext())
                        {
                            String s=aIter.next();
                            if(s.equals("")){}
                            else{
                                countWords++;
                                map.put(Integer.toString(countParagraph) + " " + Integer.toString(countLines) + " " + Integer.toString(countWords),s);
                            }
                        }
                    }
                }
            }
            for (Map.Entry<String, String> entry : map.entrySet())
            {
                String key = entry.getKey();
                String value = entry.getValue();
                bw.append("key=" + key + ", value=" + value+System.getProperty("line.separator"));
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
        System.out.println(new Date(System.currentTimeMillis()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar(2013,0,31);
        System.out.println(sdf.format(calendar.getTime()));
        try
        {
            FileInputStream fin=new FileInputStream("1.txt");
            FileOutputStream fos=new FileOutputStream("2.txt");
            System.out.println("Размер файла: " + fin.available() + " байт(а)");
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, fin.available());
            ByteArrayInputStream byteStream1 = new ByteArrayInputStream(buffer);
            int b;
            while((b=byteStream1.read())!=-1){
                System.out.print(Character.toChars(b));
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(buffer);
            fos.write(baos.toByteArray(), 0, buffer.length);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
