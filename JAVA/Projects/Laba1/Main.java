package com.company;
import java.math.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);
        System.out.println("Введи число");
        double intermediaryValue=in.nextDouble();
        BigDecimal value = BigDecimal.valueOf(intermediaryValue);
        BigDecimal e = BigDecimal.valueOf(1);
        System.out.println("Введи точность");
        int accuracy=in.nextInt();
        for(int i=0;i<accuracy;i++)
            e=e.divide(BigDecimal.valueOf(10));
        BigDecimal answer = BigDecimal.valueOf(1);
        BigDecimal step = BigDecimal.valueOf(1);
        int fact=1;
        while((step.compareTo(BigDecimal.valueOf(0))>=0 && step.compareTo(e)>0)||(step.compareTo(BigDecimal.valueOf(0))<0 && step.multiply(BigDecimal.valueOf(-1)).compareTo(e)>0))
        {
            step=step.multiply(value);
            step=step.multiply(value);
            step=step.multiply(BigDecimal.valueOf(-1));
            step=step.divide(BigDecimal.valueOf((fact)*(fact+1)),100,RoundingMode.HALF_UP);
            fact+=2;
            answer=answer.add(step);
        }
        System.out.println((answer.toString()).substring(0,accuracy+2));
        System.out.println(Math.cos(intermediaryValue));
    }
}
