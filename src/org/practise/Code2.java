package org.practise;

import java.util.*;

public class Code2 {
    public int solution(int[] A) {


        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length == 1) {

            return 1;
        }

        int maxLength = 0;

        for (int i = 0; i < A.length; i++) {
            Set<Integer> biValueSet = new HashSet<>();
            int currentLength = 0;
            for (int j = i; j < A.length; j++) {
                biValueSet.add(A[j]);
                if (biValueSet.size() > 2) {
                    break;

                } else {
                    currentLength++;
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }
        return maxLength;
    }
}
