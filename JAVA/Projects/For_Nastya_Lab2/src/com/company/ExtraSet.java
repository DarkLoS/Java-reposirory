package com.company;
class ExtraSet extends Set
{
    public Set diff(Set one, Set two)
    {
        return one.difference(two).union(two.difference(one));
    }
}