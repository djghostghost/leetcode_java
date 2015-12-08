package org.practise.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by liguoxiang on 5/31/15.
 */
public class KTHELargest {
    public int findKthLargest(int[] nums,int k){

        if(nums==null || nums.length==0 || k==0 || k>nums.length){
            return 0;
        }

        buildMaxHeapify(nums);

        int i=nums.length-1;
        for(int j=1;j<k;j++){
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            maxHeapify(nums,i,0);
            i--;
        }
        return nums[0];
    }


    private void buildMaxHeapify(int[] nums){
        int startIndex=getParentIndex(nums.length-1);

        for(int i=startIndex;i>=0;i--){
            maxHeapify(nums,nums.length,i);
        }
    }

    private  void maxHeapify(int[] nums,int heapSize,int i){
        int left=getLeftIndex(i);
        int right=getRightIndex(i);

        int largest=i;

        if(left<heapSize && nums[i]< nums[left]){
            largest=left;
        }

        if(right<heapSize && nums[largest]<nums[right] ){
            largest=right;
        }

        if(largest!=i){
            int temp=nums[i];
            nums[i]=nums[largest];
            nums[largest]=temp;
            maxHeapify(nums,heapSize,largest);
        }
    }


    public int getParentIndex(int i){
        return (i-1)>>1;
    }

    public int getLeftIndex(int i){
        return (i<<1)+1;
    }
    public int getRightIndex(int i){
        return (i<<1)+2;
    }


    public int findKthLargestByQuickSelect(int[] nums, int k){
        List<Integer> list= IntStream.of(nums).boxed().collect(Collectors.toList());;
        return quickSelect(list,k);

    }
    private int quickSelect(List<Integer> nums, int k){

        int pivot=nums.get(0);

        ArrayList<Integer> largerNum=new ArrayList<>();
        ArrayList<Integer> littleNum=new ArrayList<>();
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)<pivot){
                littleNum.add(nums.get(i));
            }else{
                largerNum.add(nums.get(i));
            }
        }
        if(largerNum.size()==k-1){
            return pivot;
        }else if(largerNum.size()>=k){
            return quickSelect(largerNum,k);
        }else{
            return quickSelect(littleNum,k-largerNum.size()-1);
        }

    }

    public static void main(String[] args) {
        KTHELargest kth=new KTHELargest();
        int nums[]={3,2,1,5,6,4};
        System.out.println(kth.findKthLargest(nums,6));
    }
}
