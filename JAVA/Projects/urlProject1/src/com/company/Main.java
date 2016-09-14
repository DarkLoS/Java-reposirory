package com.company;
import java.io.*;
import java.net.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13))
        {
            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);

            while (in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
