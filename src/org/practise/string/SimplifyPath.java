package org.practise.string;

import java.util.*;
/**
 * Created by liguoxiang on 5/29/15.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        path=path.trim();
        if(path==null){
            return null;
        }

        String mark=path.charAt(0)=='/'?"/":"";

        Stack<String> stack=new Stack<>();
        String splitedStres[]=path.split("/");


        for(String str:splitedStres){
            if(str.equals("..") && !stack.empty()){
                stack.pop();
            //If path is . or .. or space then don't put the path to stack
            }else if(!(str.equals(".") || str.equals("..") || str.equals(""))){
                stack.push(str);
            }
        }

        if(stack.size()==0){
            return "/";
        }else {
            String[] strs = new String[stack.size()];
            stack.toArray(strs);
            return mark ;//+ String.join("/", strs);
        }
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath=new SimplifyPath();

        String path="/home/";
        System.out.println(simplifyPath.simplifyPath(path));

    }

}
