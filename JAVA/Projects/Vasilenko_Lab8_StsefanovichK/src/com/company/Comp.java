package com.company;
import java.util.Comparator;
class ComparatorByNumber implements Comparator<Integer> {
    @Override
    public int compare(Integer v1, Integer v2) {
        if(v1<0) v1*=-1;
        if(v2<0) v2*=-1;
        return v1.toString().length()<v2.toString().length()?-1:v1.toString().length()>v2.toString().length()?+1:0;
    }
}
class ComparatorByNumberReverse implements Comparator<Integer> {
    @Override
    public int compare(Integer v1, Integer v2) {
        if(v1<0) v1*=-1;
        if(v2<0) v2*=-1;
        return v1.toString().length()>v2.toString().length()?-1:v1.toString().length()<v2.toString().length()?+1:0;
    }
}