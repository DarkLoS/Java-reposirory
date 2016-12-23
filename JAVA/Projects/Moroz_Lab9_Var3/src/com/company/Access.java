package com.company;
import java.util.*;
import java.math.*;
import java.security.*;
public class Access{
    private String md="827ccb0eea8a706c4c34a16891f84e7b";
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