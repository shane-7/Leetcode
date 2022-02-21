package Listnode;

/**
 * @author shkstart
 * @create 2021-08-16 8:35
 */
public class ListNode5_19_2 {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();
        dummy.next = head;
        fast = dummy;
        slow = dummy;

        for(int i = 0; i < 1 + n; i++){
            fast = fast.next;
        }

        while (fast != null){  //总共执行（s-n）次
            slow = slow.next;
            fast = fast.next;
        }
        //slow节点在待删除节点的前一个节点上
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode l1 = new ListNode(nums[0]);
        l1.addAll(nums);
        ListNode5_19_2 test = new ListNode5_19_2();
        test.removeNthFromEnd1(l1, 2);
        l1.print1();
    }

}
