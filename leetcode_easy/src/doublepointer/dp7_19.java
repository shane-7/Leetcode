package doublepointer;

/** 19.删除链表的倒数第N个节点
 * @author shkstart
 * @create 2021-09-26 10:28
 */
public class dp7_19 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        //设置虚拟头节点
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode fast = dummyhead;
        ListNode slow = dummyhead;
        //让fast走n+1次
        while(n + 1 > 0){
            fast = fast.next;
            n--;
        }
        //再让slow跟着fast一起走，直到fast == null
        while(fast != null){
            fast= fast.next;
            slow = slow.next;
        }

        //此时slow指向倒数n+1个节点
        slow.next = slow.next.next;

        return dummyhead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode l1 = new ListNode(nums[0]);
        l1.addAll(nums);
        dp7_19 test = new dp7_19();
        ListNode res = test.removeNthFromEnd(l1, 2);
        res.print1();
    }


}
