package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-11-11
 * TIME  : 21:42
 * PACKAGE:org.practise.array
 * leetcode 229
 */
import java.util.*;
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {

        ArrayList<Integer> ress=new ArrayList<>();
        if(nums==null || nums.length==0){
            return ress;
        }

        if(nums.length==1){
            ress.add(nums[0]);
            return ress;
        }
        java.util.Hashtable<Integer,Integer> table=new java.util.Hashtable<>();
        for(int n:nums){
            if(table.containsKey(n)){
                table.put(n,(table.get(n)+1));
            }else{
                table.put(n,1);
            }
        }

        int times=nums.length/3;
        java.util.Iterator<Integer> it=table.keySet().iterator();
        while(it.hasNext()){
            Integer key=it.next();
            if(table.get(key)>times){
                ress.add(key);

            }
        }


        return ress;
    }
}
