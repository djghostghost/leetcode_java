package org.practise.math;

import java.util.HashMap;

/**
 * Created by liguoxiang on 6/7/15.
 */
public class HappyNums {
    public boolean isHappy(int n){
        if(n==0){
            return false;
        }

        if(n==1){
            return true;
        }

        HashMap<Integer,Integer> resultHash=new HashMap<>();
        resultHash.put(n, 0);
        while(true){
            n=getPower(n);
            if(n==1){
                return true;
            }else{
                if(resultHash.containsKey(n)){
                    return false;
                }else{
                    resultHash.put(n,0);
                }
            }

        }
    }

    public int getPower(int n){
        int sum=0;
        while(n>=10){
            int x=n%10;
            n = (int) n / 10;
            sum+=(int)Math.pow(x,2);
        }
        sum+=Math.pow(n,2);

        return sum;
    }

    public static void main(String[] args) {
        HappyNums sol=new HappyNums();
        System.out.println(sol.isHappy(19));

    }
}
