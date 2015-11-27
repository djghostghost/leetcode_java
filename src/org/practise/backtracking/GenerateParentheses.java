package org.practise.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: ghost
 * Date  : 2015-11-27
 * TIME  : 21:08
 * PACKAGE:org.practise.backtracking
 * leetcode 22
 */
public class GenerateParentheses {
    public List<String> generateParenthesisWithStack(int n) {
        List<String> ress = new LinkedList<>();
        if (n == 0) {
            return ress;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        int lcount = 1;
        int rcount = 0;
        while (sb.length() != 0) {

            if (lcount == n && rcount == n) {
                ress.add(sb.toString());

                while (sb.length() != 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb.deleteCharAt(sb.length() - 1);
                    rcount--;
                    if (sb.charAt(sb.length() - 1) == '(') {
                        sb.deleteCharAt(sb.length() - 1);
                        lcount--;

                        if (lcount > rcount) {
                            break;
                        }
                    }
                }
                if (sb.length() == 0)
                    break;
                sb.append(')');
                rcount++;

            } else if (lcount < n) {
                sb.append('(');
                lcount++;
            } else if (rcount < n) {
                sb.append(')');
                rcount++;
            }

        }

        return ress;
    }


    public List<String> generateParenthesis(int n) {
        List<String> ress=new LinkedList<>();
        generateParenthesisHelper(0,0,n,"",ress);

        return ress;
    }
    public void generateParenthesisHelper(int lindex,int rindex,int n,String res,List<String> ress){
        if(lindex>n || rindex>n || lindex<rindex) return ;
        if(lindex==n&&rindex==n){
            ress.add(res);
            return ;
        }

        generateParenthesisHelper(lindex+1,rindex,n,res+"(",ress);
        generateParenthesisHelper(lindex,rindex+1,n,res+")",ress);
    }
}
