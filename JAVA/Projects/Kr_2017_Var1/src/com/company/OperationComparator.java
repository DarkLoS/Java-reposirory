package com.company;
import java.util.Comparator;
class OperationComparator implements Comparator<SliceOperation> {
    @Override
    public int compare(SliceOperation v1, SliceOperation v2) {
        int a=v1.getBeginLine()-v1.getEndLine();
        int b=v2.getBeginLine()-v2.getEndLine();
        return a < b ? -1 : a > b ? +1 : 0;
    }
}