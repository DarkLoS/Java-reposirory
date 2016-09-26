package com.company;
class Algorithm extends LinearEquations {
    LinearEquations list = null;
    public Algorithm(LinearEquations system){
        list = system;
    }
    public void calculate() {
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i +1; j < list.size(); j++){
                Integer pos=list.max(i);
                Float k = list.get(j).findCoefficient(list.get(j).at(pos), list.get(i).at(pos));
                if(k==0.0f){}
                else {
                    list.get(j).mul(k);
                    list.get(j).addEquation(list.get(i));
                }
            }
        }
    }
    public void calculateInverse(){
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i + 1; j < list.size(); j++){
                Float k = list.get(j).findCoefficient(list.get(j).at(i), list.get(i).at(i));
                list.get(j).mul(k);
                list.get(j).addEquation(list.get(i));
            }
        }
        for(int i = list.size() - 1; i >= 0; i--){
            Float k = list.get(i).at(i);
            list.get(i).mul(1/k);
            for(int j = i - 1; j>=0; j--){
                Float l = list.get(j).findCoefficient(list.get(j).at(i), list.get(i).at(i));
                list.get(j).mul(l);
                list.get(j).addEquation(list.get(i));
            }
        }

    }
}