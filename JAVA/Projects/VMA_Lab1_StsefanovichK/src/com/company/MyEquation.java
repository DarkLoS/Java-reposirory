package com.company;
import java.util.*;
class MyEquation  {
    private Float[][] mas=new Float[][]
            {{0.7277f,-0.0958f,0.0192f, 0.0383f,0.1341f,1.4363f},
                    {0.0996f, 1.1394f,0.0000f,-0.0766f,0.0766f,-1.6431f},
                    {0.0575f, 0.0000f,0.9154f,-0.2681f,0.1532f,6.0514f},
                    {-0.1149f,0.2413f,0.0000f,0.9001f,-0.0383f,-3.4508f},
                    {0.4788f,0.0000f,0.1724f,0.0192f,1.0724f,5.5727f}};
    private List<Float> equation = new ArrayList<>();
    public Float determinate;
    public MyEquation() {
        determinate=1.0f;
    }
    public List<Float> getEquation(){
        return equation;
    }
    public void generate(int a,int size){
        if (size < 2) size = 2;
        this.equation.clear();
        for (int i = 0; i < size; i++){
            //Random random = new Random();
          // this.equation.add((float) (random.nextInt() % 5) + 1);
            this.equation.add(mas[a][i]);
        }
    }
    public void generate2(int a,LinearEquations l){

        for (int i = 0; i < l.size(); i++){
            this.equation.add(l.itemAt(a,i));
        }
        int x=0;
        for (int i = l.size(); i < l.size()*2; i++){
            if(x==a)
                this.equation.add(1.0f);
            else
                this.equation.add(0.0f);
            x++;
        }
    }
    public int size(){
        return equation.size();
    }
    public void addEquation(com.company.MyEquation item){
        ListIterator<Float> i = equation.listIterator();
        ListIterator<Float> j = item.getEquation().listIterator();
        for(; i.hasNext() && j.hasNext();){
            Float a = i.next();
            Float b = j.next();
            i.set(a + b);
        }
    }
    public void mul(Float coefficient){
        for(ListIterator<Float> i = equation.listIterator(); i.hasNext();){
            Float next = i.next();
            i.set(next * coefficient);
        }
    }
    public Float at(int index){
        return equation.get(index);
    }
}