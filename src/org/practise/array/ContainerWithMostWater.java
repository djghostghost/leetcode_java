package org.practise.array;

//Given n non-negative integers a1, a2, ..., an,
// where each represents a point at coordinate (i, ai). n vertical lines
// are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
// Find two lines, which together with x-axis forms a container, such that the container
// contains the most water.


public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null|| height.length<2){
            return 0;
        }

        int first=0;
        int second=height.length-1;
        int maxArea=0;

        while(first<second){
            int area=(second-first)*Math.min(height[first],height[second]);
            maxArea=Math.max(maxArea,area);

            if(height[first]<height[second]){
                first++;
            }else{
                second--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int nums[]={3,8,4,9};
        ContainerWithMostWater sol=new ContainerWithMostWater();
        System.out.println(sol.maxArea(nums));
    }
}
