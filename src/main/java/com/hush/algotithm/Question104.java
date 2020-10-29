package com.hush.algotithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: huangshuai
 * @Date: 2020-10-28
 * @Version 1.0
 */
public class Question104 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        } else if(root.left == null && root.right ==null){
            return 1;
        } else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }


    public static void main(String[] args) {

    }
}
