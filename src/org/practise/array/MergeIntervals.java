package org.practise.array;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * Created by ghost on 2015/8/26.
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}


public class MergeIntervals {
    /**
     *leetcode 56#
     */
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null || intervals.size()==0 || intervals.size()==1){
            return intervals;
        }


        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start){
                    return o1.end-o2.end;
                }else{
                    return o1.start-o2.start;
                }
            }
        });

        List<Interval> results=new ArrayList<>();

        Interval firstInterval=intervals.get(0);
        results.add(new Interval(firstInterval.start,firstInterval.end));

        for(int i=1;i<intervals.size();i++){

            Interval interval=intervals.get(i);
            Interval pivot=results.get(results.size()-1);
            if(interval.start>pivot.end){
                results.add(new Interval(interval.start,interval.end));
            }else{
                pivot.end=Math.max(interval.end,pivot.end);
            }


        }

        return results;
    }

    public static void main(String[] args) {
        MergeIntervals sol=new MergeIntervals();
        List<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        List<Interval> results=sol.merge(intervals);

        for(Interval result:results){
            System.out.println(result.start+"-->"+result.end);
        }


    }
}
