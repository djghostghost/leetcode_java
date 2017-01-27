package org.practise.math;

/**
 * Created by liguoxiang on 2017/01/22.
 */
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int[] res=new int[2];

        if(area==0){
            return res;
        }

        int L=(int)Math.ceil(Math.sqrt((double)area));

        for(int i=L;i<=area;i++){

            if(area%i==0){
                res[0]=i;
                break;
            }
        }

        res[1]=area/res[0];

        return res;
    }

    public static void main(String[] args) {
        ConstructTheRectangle sol=new ConstructTheRectangle();
        int[] res=sol.constructRectangle(12);

        System.out.println(res[0]+"=="+res[1]);

    }

}
