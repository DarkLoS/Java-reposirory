package com.company;
import java.util.*;
class DoubleComparator implements Comparator<Double[]> {
    @Override
    public int compare(Double[] v1, Double[] v2) {
        return v1[0] < v2[0] ? -1 : v1[0] > v2[0] ? +1 : 0;
    }
}