package com.company;
public class Main {
    public static void main(String[] args) {
	Set set=new Set("Paradigmus");
    System.out.println(set.toString());
        if(set.in('d'))
            System.out.println("Contains");
        System.out.println(set.at(5));
        Set set2=new Set(set);
        System.out.println(set.toString());
        Set set3=new Set("Vladic");
        System.out.println(set.intersection(set3));
        System.out.println(set.union(set3));
        System.out.println(set.difference(set3));
        if(set.inIntersection(set3,'r'))
            System.out.println("Contains");
        else System.out.println("Not contains");

        if(set.inUnion(set3,'r'))
            System.out.println("Contains");
        else System.out.println("Not contains");

        if(set.inDifference(set3,'r'))
            System.out.println("Contains");
        else System.out.println("Not contains");
        ExtraSet extraSet=new ExtraSet();
        Set mas[]= new Set [5];
        mas[0]=new Set("CAT walk");
        mas[1]=new Set("I'm am very bad man");
        mas[2]=new Set("Many person are sooooooo cute");
        mas[3]=new Set("Make America great again");
        mas[4]=new Set("Aquaman sucks");
        for(Set s:mas)
            System.out.println(s);
        for(int i=0;i<4;i++)
        {
            System.out.println(extraSet.diff(mas[i],mas[i+1]));
        }
    }
}
