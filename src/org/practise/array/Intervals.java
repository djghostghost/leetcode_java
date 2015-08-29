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


public class Intervals {
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
    // leetcode 57#
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval==null){
            return intervals;
        }

        if(intervals==null){
            intervals=new ArrayList<>();

        }

        if(intervals.size()==0 || newInterval.end<intervals.get(0).start){
            intervals.add(0,newInterval);
            return intervals;
        }

        int len=intervals.size();

        for(int i=0;i<len;i++){
            Interval source=intervals.get(i);

            if(source.start <= newInterval.start && source.end >= newInterval.end){
                return intervals;
            }else if(source.end < newInterval.start && (i==len-1 || intervals.get(i+1).start > newInterval.end)){
                intervals.add(i+1,newInterval);
                return intervals;
            }else if(source.end <newInterval.start){
                continue;
            }else{
                source.start=Math.min(source.start, newInterval.start);
                source.end=Math.max(source.end, newInterval.end);

                ListIterator<Interval> it=intervals.listIterator(i+1);
                while(it.hasNext()){

                    Interval target=it.next();
                    if(source.end < target.start){
                        break;
                    }else{

                        source.end=Math.max(target.end,source.end);
                        it.remove();
                    }


                }
                return intervals;

            }


        }

        return intervals;



    }
    public static void main(String[] args) {
        Intervals sol=new Intervals();
        List<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        Interval newInterval=new Interval(0,0);
        List<Interval> results=sol.insert(intervals,newInterval);

        for(Interval result:results){
            System.out.println(result.start+"-->"+result.end);
        }


    }
}
