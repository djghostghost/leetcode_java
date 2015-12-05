package org.practise.tree;

import java.util.*;

/**
 * Author: ghost
 * Date  : 2015-11-26
 * TIME  : 19:59
 * PACKAGE:org.practise.tree
 * leetcode 297
 */
public class Codec {
    ArrayList<String> ret=new ArrayList<>();
    Queue<TreeNode> queue=new LinkedList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        serializeHelper(root,result);

        int index=result.size()-1;
        while(index>=0 && result.get(index)==null){
            result.remove(index);
            index--;
        }
        return result.toString().replaceAll("\\s+", "");
    }

    private void serializeHelper(TreeNode root, ArrayList<Integer> result){
        if (root == null) {
            result.add(null);
            return;
        }
        result.add(root.val);
        serializeHelper(root.left,result);
        serializeHelper(root.right,result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0){
            return null;
        }else{
            data=data.replace('[', ' ');
            data=data.replace(']',' ');
            data=data.trim();

            if(data.length()==0){
                return null;
            }

            String[] datas=data.split(",");

            Deque<String> strList=new LinkedList<String>(Arrays.asList(datas));

            return deserializeHelper(strList);
        }
    }

    public TreeNode deserializeHelper(Deque<String> strList){
        if(strList.isEmpty()) return null;

        String str=strList.pop();
        if(str.equals("null")) return null;

        TreeNode root=new TreeNode(Integer.parseInt(str));
        root.left=deserializeHelper(strList);
        root.right=deserializeHelper(strList);

        return root;

    }
}
