package org.practise.DynamicProgramming;

/**
 * Created by liguoxiang on 2017/02/04.
 */
public class BestTimeToBuyAndSellStock {


    public int maxProfit(int[] prices) {

        if(prices==null || prices.length==0){
            return 0;
        }

        int max=0;
        int minPrice=prices[0];

        for(int i=1;i<prices.length;i++){

            minPrice=Math.min(minPrice,prices[i]);

            max=Math.max(prices[i]-minPrice,max);
        }

        return max;
    }

    public static void main(String[] args) {

        BestTimeToBuyAndSellStock sol=new BestTimeToBuyAndSellStock();
        int[] nums={7};

        System.out.println(sol.maxProfit(nums));



    }

}
