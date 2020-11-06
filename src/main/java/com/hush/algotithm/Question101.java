package com.hush.algotithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangshuai
 * @Date: 2020-10-30
 * @Version 1.0
 */
public class Question101 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

    }

    /*public boolean isSymmetric(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        return isSymmetricList(list);
    }

    public boolean isSymmetricList(List<TreeNode> list) {

        if (list == null ) {
            return true;
        }
        int flag = 0;
        for(int k = 0;k<list.size();k++){
            if(list.get(k)==null){
                continue;
            }
            flag = 1;
        }
        if(flag==0){
            return true;
        }


        for(int i=0,j=list.size()-1;i<j; i++,j--){
            if(list.get(i) == list.get(j)){
                continue;
            }
            if(list.get(i) == null || list.get(j)==null){
                return false;
            }
            if(list.get(i).val == list.get(j).val){
                continue;
            } else {
                return false;
            }
        }

        List<TreeNode> newlist = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i)==null){
                newlist.add(null);
            } else {
                newlist.add(list.get(i).left);
                newlist.add(list.get(i).right);
            }
        }

        return isSymmetricList(newlist);
    }*/




    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return isSymmetricTree(root.left, root.right);
    }


    public boolean isSymmetricTree(TreeNode left,  TreeNode right) {

        if(left ==null && right ==null){
            return true;
        }
        if(left ==null || right ==null){
            return false;
        }

        return (left.val == right.val) && (isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left));
    }



    //根结点两次入队列，比较队列相邻的两个值， 如果相等则node1.left node2.left  node1.right node2.right  顺序添加元素再比较
}
