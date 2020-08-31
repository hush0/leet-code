package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-07-09
 * @Version 1.0
 */
public class Question23 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /**
     * 合并多个升序的链表 leetcode-23
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        int i;
        int length = lists.length;
        ListNode head = null, pre = null;


        while (true) {
            //从数组中找到第一个不为空的节点
            ListNode current = null;
            for (i = 0; i < length; i++) {
                if (lists[i] != null) {
                    current = lists[i];
                    break;
                }
            }
            if (current == null) {
                return head;
            }

            //找到最小的的非空节点
            int temp =i;
            for (; i < length; i++) {
                if (lists[i] == null) {
                    continue;
                } else if (lists[i].val < current.val) {
                    current = lists[i];
                    temp = i;
                }
            }

            //第一次取节点赋值给头节点
            if(head== null){
                head =  current;
                pre = current;
            } else {
                pre.next =  current;
                pre = current;
            }
            lists[temp] = lists[temp].next;
        }
    }






    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode node1 =  new ListNode(1);
        ListNode node2 =  new ListNode(4);
        ListNode node3 =  new ListNode(5);
        node1.next = node2;
        node2.next = node3;


        ListNode node4 =  new ListNode(1);
        ListNode node5 =  new ListNode(3);
        ListNode node6 =  new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 =  new ListNode(2);
        ListNode node8 =  new ListNode(6);
        node7.next = node8;



        lists[0] = node1;
        lists[1] = node4;
        lists[2] = node7;

        ListNode node = mergeKLists(lists);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
