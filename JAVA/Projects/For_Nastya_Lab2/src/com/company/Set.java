package com.company;
import java.util.*;
class Set {
    private LinkedHashSet<Character> list;
    @Override
    public String toString() {
        return Arrays.toString(list.toArray());
    }
    public Character at(int index) {
        return (char)list.toArray()[index];
    }
    public Set(String str) {
        assert(str.length()>10000);
        list = new LinkedHashSet<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
    }
    public Set(Set other) {
        assert(other.getList().size()<100000);
        list=new LinkedHashSet<>(other.getList().size());
        for(int i=0; i<other.getList().size(); i++)
        {
            list.add(other.at(i));
        }
    }
    public Set() {
        list=new LinkedHashSet<>(0);
    }
    public LinkedHashSet<Character> getList() {
        return list;
    }
    public boolean in(Character character) {
        if(list.contains(character))
            return true;
        return false;
    }
    public void delete(Character character) {
        list.remove(character);
    }
    public void add(Character character) {
        list.add(character);
    }
    public Set difference(Set other){
        Set clone=new Set(this);
        for(Character s:other.getList())
            if(this.in(s))
                clone.delete(s);
        return clone;
    }
    public Set union(Set other){
        Set clone=new Set(this);
        for(Character s:other.getList())
            clone.add(s);
        return clone;
    }
    public Set intersection(Set other){
        Set clone=new Set();
        for(Character s:other.getList())
            if(this.in(s))
                clone.add(s);
        return clone;
    }
    public boolean inIntersection(Set other,Character character){
        Set clone=this.intersection(other);
        if(clone.getList().contains(character))
            return  true;
        return false;
    }
    public boolean inUnion(Set other,Character character){
        Set clone=this.union(other);
        if(clone.getList().contains(character))
            return  true;
        return false;
    }
    public boolean inDifference(Set other,Character character){
        Set clone=this.difference(other);
        if(clone.getList().contains(character))
            return  true;
        return false;
    }
}
