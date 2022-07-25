package ListNode;

import java.util.List;

/*
删除链表的倒数第N个结点，mid 双指针
 */
public class LS4_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head, slow = head;
        //fast先走n步
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }

}
