package org.practise.tree;

/**
 * Author: ghost
 * Date  : 2015-11-25
 * TIME  : 19:19
 * PACKAGE:org.practise.tree
 * leetcode 307
 */
public class NumArray {
    public int[] tree;
    public int len;
    public NumArray(int[] nums){
        if(nums!=null && nums.length!=0){
            int len=nums.length;
            this.len=len;
            tree=new int[4*len+10];
            buildSegmentTree(0,nums,0,len-1);

        }else{
            tree=new int[1];
        }
    }

    public int sumRange(int i, int j) {
        if(i<=0 && j>=this.len-1){
            return this.tree[0];
        }else{
            i=Math.max(0, i);
            j=Math.min(this.len-1, j);
            return query(0,0,this.len-1,i,j);
        }

    }

    public void buildSegmentTree(int root,int nums[],int begin,int end){

        if(begin==end){
            tree[root]=nums[begin];
        }else{
            int mid=begin+((end-begin)>>1);
            buildSegmentTree(root*2+1,nums,begin,mid);
            buildSegmentTree(root*2+2,nums,mid+1,end);
            tree[root]=tree[root*2+1]+tree[root*2+2];
        }


    }

    public int query(int root,int tbegin,int tend,int begin,int end){
        if(begin==tbegin && end==tend){
            return tree[root];
        }
        int ret=0;
        int mid=tbegin+((tend-tbegin)>>1);
        if(end<=mid){
            ret+=query(root*2+1,tbegin,mid,begin,end);
        }else if(begin>mid){
            ret+=query(root*2+2,mid+1,tend,begin,end);
        }else{
            ret+=query(root*2+1,tbegin,mid,begin,mid)+
                    query(root*2+2,mid+1,tend,mid+1,end);
        }

        return ret;

    }
    public void update(int index,int val){
        updateNode(0,0,this.len-1,index,val);
    }
    public void updateNode(int root,int tstart,int tend,int index,int val){
        if(tstart==tend){
            if(tstart==index){
                tree[root]=val;
            }
            return;
        }
        int mid=tstart+((tend-tstart)>>1);
        if(index<=mid){
            updateNode(root*2+1,tstart,mid,index,val);
        }else{
            updateNode(root*2+2,mid+1,tend,index,val);
        }

        tree[root]=tree[2*root+1]+tree[2*root+2];
    }

}
