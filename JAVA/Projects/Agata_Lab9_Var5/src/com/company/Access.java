package com.company;
import java.util.*;
import java.math.*;
import java.security.*;
public class Access{
    private String md="21232f297a57a5a743894a0e4a801fc3";
    public Access() throws NoSuchAlgorithmException{
        Scanner in = new Scanner(System.in);
        String password;
        while(true) {
            System.out.println("Type password.\nFor exit,type exit");
            password=in.next();
            if(confirm(password))break;
        }
    }
    private boolean confirm(String password) throws NoSuchAlgorithmException{
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(password.getBytes(),0,password.length());
        if(password.equals("exit")) System.exit(0);
        else if( new BigInteger(1,m.digest()).toString(16).equals(md))
            return true;
        return false;
    }
}