package com.company;
import java.io.*;
import java.lang.*;
import org.apache.commons.io.IOUtils;
class DeleteComments {
    private String str;
    public DeleteComments(String s)throws IOException {
        str=fileToStr(s);
    }
    private String fileToStr(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        try
        {
            return IOUtils.toString(is, "windows-1251");
        }
        finally { is.close(); }
    }
    public void calculate(String s)throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(s));
        bw.flush();
        bw.flush();
        String finalString="";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='\'')
            {
                if(str.charAt(i+1)=='\\') {
                    finalString += str.charAt(i);
                    i++;
                }
                finalString+=str.charAt(i);
                i++;
                finalString+=str.charAt(i);
                continue;
            }
            if(str.charAt(i)=='"')
            {
                while (true)
                {
                    finalString+=str.charAt(i);
                    i++;
                    if(str.charAt(i)=='\\')
                    {
                        finalString+=str.charAt(i);
                        i++;
                        finalString+=str.charAt(i);
                        i++;
                    }
                    if(str.charAt(i)=='"')
                    {
                        finalString+=str.charAt(i);
                        break;
                    }
                }
                continue;
            }
            if(str.charAt(i)=='/' && str.charAt(i+1)=='*')
            {
                i++;
                while (true)
                {
                    i++;
                    if(str.charAt(i)=='*' && str.charAt(i+1)=='/')
                        break;
                }
                i++;
                continue;
            }
            if(str.charAt(i)=='/' && str.charAt(i+1)=='/')
            {
                while (true)
                {
                    i++;
                    if(str.charAt(i)=='\n') {
                        i--;
                        break;
                    }
                }
            }
            finalString+=str.charAt(i);
        }
        bw.append(finalString);
        bw.close();
    }
}