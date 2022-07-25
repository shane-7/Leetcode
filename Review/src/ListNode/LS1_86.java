package ListNode;

import java.util.List;

/*
分隔链表, 双指针
 */
public class LS1_86 {
    public ListNode partition(ListNode head, int x) {
        //存放小于x的链表的虚拟头节点
        ListNode dummy1 = new ListNode(-1);
        //存放大于等于x链表的虚拟头节点
        ListNode dummy2 = new ListNode(-1);
        //p1, p2指针负责生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;
        //P指针负责遍历原链表
        ListNode p = head;

        while(p != null){
            if(p.val >= x){
                p2.next = p;
                p2 = p2.next;
            }else {
                p1.next = p;
                p1 = p1.next;
            }
            //下面这里是关键
            //断开原链表中的每个节点的next指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        //拼接两个链表，
        p1.next = dummy2.next;

        return dummy1.next;
    }


}
