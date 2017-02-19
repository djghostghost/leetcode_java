package org.practise.stack;

import java.util.Stack;

/**
 * Created by liguoxiang on 2017/02/19.
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {

        if(preorder==null || preorder.length()==0){
            return true;
        }

        String[] inputs=preorder.split(",");

        Stack<String> stack=new Stack<>();



        for(int i=0;i<inputs.length;i++){

            if(inputs[i].equals("#")){

                while(!stack.isEmpty() && stack.peek().equals("#")) {

                        stack.pop();

                        if (stack.isEmpty()) {
                            return false;
                        } else {
                            stack.pop();

                        }

                }

                if(stack.isEmpty()){
                    if(i==inputs.length-1){
                        return true;
                    }else{
                        return false;
                    }


                }
            }
            stack.push(inputs[i]);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree sol=new VerifyPreorderSerializationOfABinaryTree();
        System.out.println(sol.isValidSerialization("9,#,#,1"));


    }
}
