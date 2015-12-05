package org.practise.backtracking;

/**
 * Author: ghost
 * Date  : 2015-12-01
 * TIME  : 19:54
 * PACKAGE:org.practise.backtracking
 * leetcode 79
 */
public class WordSearch {
    private int[][] towards={{0,-1},{0,1},{-1,0},{1,0}};
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||word==null||word.length()==0){
            return false;
        }

        int m=board.length;
        int n=board[0].length;
        int[][] path=new int[m][n];


        char ch=word.charAt(0);
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (ch == board[i][j]) {
                    path[i][j]=1;
                    if (word.length()==1||existerHelper(board, m, n, word.substring(1), i, j,path)) {
                        return true;
                    }
                    path[i][j]=0;
                }
            }
        }


        return false;
    }


    public boolean existerHelper(char[][] board, int m, int n, String word, int i, int j, int[][] path){
        for(int[] toward:towards){
            int newi=i+toward[0];
            int newj=j+toward[1];
            if(newi<m && newj<n && newi>=0 && newj>=0 && path[newi][newj]==0
                    && board[newi][newj]==word.charAt(0)){

                path[newi][newj]=1;
                if(word.length()==1 || existerHelper(board,m,n,word.substring(1),newi,newj,path)){
                    return true;
                }
                path[newi][newj]=0;

            }


        }
        return false;
    }
}
