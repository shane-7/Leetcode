package Listnode;



/** 19.删除列表的倒数第n个节点
 *   方法：双指针法
 * @author shkstart
 * @create 2021-08-11 9:02
 */
public class ListNode5_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);  //设置虚拟头节点
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        //先移动fast点, 让fast指向正向第n+1点
//        while(n --> 0){   n-->0 相当于 for(int i = 0; i < n; i++)
//            fast = fast.next;
//        }

        for(int i = 0; i < n + 1; ++i){
            fast = fast.next;
        }

        //此时将slow移动到倒数n+1的位置上
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return  dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode l1 = new ListNode(nums[0]);
        System.out.println(l1.val);
        l1.addAll(nums);
        ListNode5_19 test = new ListNode5_19();
        ListNode res = test.removeNthFromEnd(l1, 2);
        res.print1();
    }
}
