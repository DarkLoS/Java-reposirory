package com.company;
class Regex {
    private String str;
    public Regex(String str) {
        this.str=str;
    }
    public void calculateBrackets() {
        str=str.replaceAll("[(][^)]*[)]","");
    }
    public void calculateDeleteAfterTwo(){
        str=str.replaceAll("([0-9]{1,2})([0-9]*)","$1");
    }
    public void calculateDeleteZero(){
        str+=" ";
        str=str.replaceAll("([0]+)([0-9]+)([^0-9])","$2$3");
        str=str.substring(0,str.length()-1);
    }
    @Override
    public String toString() {
        return str;
    }
}