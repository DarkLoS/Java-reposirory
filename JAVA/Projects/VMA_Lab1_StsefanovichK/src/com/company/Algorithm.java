package com.company;
class Algorithm extends LinearEquations {
    LinearEquations list = null;
    public Algorithm(LinearEquations system){
        list = system;
    }
    public Float[][] calculate(int beta) {
        for(int i = 0; i < list.size() - 1; i++){
            Integer pos=list.max(i);
            determinate*=list.itemAt(i,pos);
            list.get(i).mul(1/list.itemAt(i,pos));
            for(int j = i +1; j < list.size(); j++){

                Float k = -list.itemAt(j,pos);
                if(k==0.0f){}
                else {
                    list.get(i).mul(k);
                    list.get(j).addEquation(list.get(i));
                    list.get(i).mul(1/k);
                }
            }
        }
        Integer pos=list.max(list.size() - 1);
        determinate*=list.get(list.size() - 1).at(pos);
        list.get(list.size() - 1).mul(1/list.itemAt(list.size() - 1,pos));
        Float [][]x = new Float[5][beta-4];
        int i;int j;
        for(i = list.size() - 1; i >= 0; i--) {
            Float sum[] =new Float[beta-4] ;
            for(int y=0;y<beta-4;y++)
                sum[y]=0.0f;
            pos=0;
            for(j = list.size() - 1; j >=0; j--) {
                if(x[j][0]!=null)
                    for(int y=0;y<beta-4;y++)
                      sum[y] += list.itemAt(i, j) * x[j][y];
                if((list.itemAt(i, j)>=0.000001f||list.itemAt(i, j)<=-0.000001f)&& x[j][0]==null) {
                    pos = j;
                }
            }
            for(int y=0;y<beta-4;y++)
            x[pos][y] = (list.itemAt(i, list.size()+y) - sum[y]) / list.itemAt(i, pos);
        }
        return x ;
    }
}