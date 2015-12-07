package org.practise.unionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: ghost
 * Date  : 2015-12-07
 * TIME  : 19:44
 * PACKAGE:org.practise.unionFind
 * leetcode 130
 */
public class SurroundedRegions {
    private final int[][] dirs={{0,-1},{0,1},{-1,0},{1,0}};

    class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public void solve(char[][] board) {
        if(board==null|| board.length==0){
            return;
        }

        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            capture(board,i,0);
            capture(board,i,n-1);
        }

        for(int j=1;j<n;j++){
            capture(board,0,j);
            capture(board,m-1,j);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='N'){
                    board[i][j]='O';
                }else if(board[i][j]=='V'||board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    public void capture(char[][] board,int i,int j){

        Queue<Point> queue=new LinkedList<>();
        queue.add(new Point(i,j));

        while(!queue.isEmpty()){

            Point point=queue.poll();
            int x=point.x;
            int y=point.y;

            if(board[x][y]=='V'||board[x][y]=='N'){
                continue;
            }

            if(board[x][y]=='O'){
                board[x][y]='N';
                for(int[] dir:dirs){
                    int x1=x+dir[0];
                    int y1=y+dir[1];

                    if(x1>=0 && x1<board.length && y1>=0 && y1<board[0].length){
                        queue.add(new Point(x1,y1));
                    }
                }
            }else{
                board[x][y]='V';
            }

        }
    }
}
