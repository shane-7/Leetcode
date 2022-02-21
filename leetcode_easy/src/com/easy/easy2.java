package com.easy;

/**
 * 此题考察单链表的使用
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

 请你将两个数相加，并以相同形式返回一个表示和的链表。

 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 *
 * @author shkstart
 * @create 2021-04-14 16:51
 */



public class easy2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null, tail = null;   //head为头结点
        int addone = 0;  //进位符
        while(l1 != null || l2 != null){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + addone;
            if(head == null) {
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;   //在尾处开辟一个新的结点，将尾结点指向下一个位置。
            }

            addone = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(addone > 0){
            tail.next = new ListNode(addone);   //while循环结束(遍历完两个链表后)以后，如果最后一位相加有进位的话则再开辟一位存放addone值
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }

        //ListNode的值打印函数
        public static String print(ListNode l) {
            StringBuilder sb = new StringBuilder();
            while (l != null) {
                sb.append(l.val);
                l = l.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l2.next = new ListNode(6);
        l1.next.next = new ListNode(3);
        l2.next.next = new ListNode(4);
//        l1 = l1.next = new ListNode(3);
//        l2 = l2.next = new ListNode(4);
        //System.out.println(ListNode.print(addTwoNumbers(l1,l2)));
        ListNode a1 = addTwoNumbers(l1, l2);
        System.out.println(ListNode.print(a1));
    }
}


