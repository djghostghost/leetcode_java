package org.practise.other;

import java.util.Iterator;
import java.util.ListIterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
// leetcode #284
class PeekingIterator implements Iterator<Integer> {

    private Integer cache;
    private Iterator<Integer> itera;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.itera=iterator;
        next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer retVal=cache;
        cache=itera.hasNext()?itera.next():null;
        return retVal;
    }


    @Override
    public boolean hasNext() {

        return (cache!=null);
    }
}