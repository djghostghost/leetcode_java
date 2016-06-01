package org.practise.BinarySearch;

import java.util.*;

/**
 * Created by liguoxiang on 6/1/16.
 */
public class IntersectionOfArrays {
    //leet code 349
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ress = new HashSet<>();


        if (!(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)) {

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            for (int i = 0,j=0; i < nums1.length&&j<nums2.length; ) {

                if (nums1[i] == nums2[j]) {
                    ress.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    i++;

                } else if (nums1[i] > nums2[j]) {
                    j++;
                }

            }
        }


        return ress.stream().mapToInt(i->i).toArray();
    }
}
