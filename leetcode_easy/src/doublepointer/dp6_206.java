package doublepointer;

/** 206.反转链表
 * @author shkstart
 * @create 2021-09-26 9:56
 */


public class dp6_206 {
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;

        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode l1 = new ListNode(nums[0]);
        l1.addAll(nums);
        dp6_206 test = new dp6_206();
        ListNode res = test.reverseList(l1);
        res.print1();
    }
}
