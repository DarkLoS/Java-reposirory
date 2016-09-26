package com.company;
import java.util.*;
class LinearEquations extends MyEquation {
    private List<MyEquation> list = new ArrayList<>();
    public MyEquation get(int index){
        return list.get(index);
    }
    public void push(MyEquation elem){
        list.add(elem);
    }
    public int size(){
        return list.size();
    }
    public Float itemAt(int i, int j){
        return list.get(i).at(j);
    }
    public Integer max(int i){
        Float MAX=(float)(Integer.MIN_VALUE);
        Integer pos=0;
        for(int y=0;y<list.size();y++)
        {
            if(Math.abs(list.get(i).at(y))>MAX) {
                MAX =list.get(i).at(y);
                pos=y;
            }
        }
        return pos;
    }
}