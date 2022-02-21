package Listnode;

/** 206 反转列表
 *  题解来自young
 * @author shkstart
 * @create 2021-08-09 17:07
 */
public class ListNode3_206 {
    //双指针法：
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
        System.out.println(l1.val);
        l1.addAll(nums);
        ListNode3_206 test = new ListNode3_206();
        ListNode res = test.reverseList(l1);
        res.print1();

    }
}
