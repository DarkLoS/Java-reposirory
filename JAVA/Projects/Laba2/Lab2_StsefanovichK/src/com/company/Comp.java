package com.company;
import java.lang.reflect.Array;
import java.math.*;
import java.util.*;
import java.util.Comparator;
/**
 * Created by Костя on 05.09.2016.
 */
public class Comp implements Comparator<Integer> {
    @Override
    public int compare(Integer emp1, Integer emp2) {
        return Integer.compare(emp2,emp1);
    }
}
