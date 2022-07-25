package ListNode;

import java.util.List;
import sun.awt.image.PNGImageDecoder.PNGException;

/*
合并两个有序链表_easy
方法：双指针
 */
public class LS2_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //虚拟头节点：
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null){
            //比较p1 和 p2两个指针，将值较小的节点接到p指针
            if(p1.val > p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1.next != null){
            p.next = p1;
        }
        if(p2.next != null){
            p.next = p2;
        }
        return dummy.next;
    }

}
