package com.company;
import java.util.*;
class Sort extends Thread
{
    private Integer mas[];
    private int index;
    public Sort(Integer mas[],int index) {
        this.mas=new Integer[mas.length];
        for(int i=0;i<mas.length;i++) {
            this.mas[i]=mas[i];
        }
        this.index=index;
    }
    public Integer[] get() {
        return  mas;
    }
    private void calculate()
    {
        if(index==1)
            Arrays.sort(mas);
        else if(index==2)
            Arrays.sort(mas,Collections.reverseOrder());
        else if(index==3)
            Arrays.sort(mas,new ComparatorByNumber());
        else if(index==4)
            Arrays.sort(mas,new ComparatorByNumberReverse());
    }
    @Override
    public void run()
    {
        calculate();
    }
}