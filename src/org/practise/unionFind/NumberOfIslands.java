package org.practise.unionFind;

/**
 * Author: ghost
 * Date  : 2015-12-07
 * TIME  : 19:41
 * PACKAGE:org.practise.unionFind
 * leetcode 200
 */
public class NumberOfIslands {
    private final int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int numOfIslands=0;

        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    numOfIslands++;
                    sinkIslands(grid,i,j);
                }


            }
        }

        return numOfIslands;
    }

    private void sinkIslands(char[][] grid,int i,int j){
        if(i>=grid.length|| i<0 || j>=grid[0].length||j<0||grid[i][j]=='0') return ;

        grid[i][j]='0';
        for(int[] dir:dirs){
            sinkIslands(grid,i+dir[0],j+dir[1]);
        }
    }
}
