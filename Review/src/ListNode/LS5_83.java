package ListNode;

public class LS5_83 {
    ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null){
            if(slow.val != fast.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        //断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

}
