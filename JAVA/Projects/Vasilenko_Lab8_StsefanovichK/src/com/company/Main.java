package com.company;
import java.util.*;
public class Main {
    static Sort mAnotherOpinion;
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        Random random=new Random();
        System.out.println("Введи число");
        Integer mas[]=new Integer[in.nextInt()];
        for(int i=0;i<mas.length;i++) {
            mas[i]=random.nextInt(20001)-10000;
        }
        System.out.println(mas.length);
        System.out.println(Arrays.toString(mas));
        System.out.println("Введите 1 -для сортировки по возрастанию;\n2-по убыванию;\n3-по количеству цифр по возрастанию\n4-по количеству цифр по убыванию");
        int index=in.nextInt();
        mAnotherOpinion = new Sort(mas,index);
        mAnotherOpinion.start();
        while(mAnotherOpinion.isAlive());
        System.out.println(Arrays.toString(mAnotherOpinion.get()));
    }
}
