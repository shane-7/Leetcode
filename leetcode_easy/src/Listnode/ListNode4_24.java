package Listnode;

/**24：两两交换列表中的节点
 * @author shkstart
 * @create 2021-08-10 9:21
 */
public class ListNode4_24 {
    public ListNode swapParis(ListNode head){
        //添加虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur.next != null && cur.next.next != null){
            //先把第3个指针存储起来
            ListNode temp = head.next.next;
            //cur.next 指向2(head.next),  cur, 2
            cur.next = head.next;
            //cur.next.next 指向1(head)   cur, 2, 1
            cur.next.next = head;
            //将head.next接上 temp       cur, 2, 1, 3
            head.next = temp;
            //更新节点
            cur = cur.next.next;    //2, 1(cur_new / head)
            head = head.next;         //2, 1(cur_new), 3(head)

        }
        return dummy.next;   //尤其注意：使用虚拟头节点时，返回一定是dummy.next
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode l1 = new ListNode(nums[0]);
        System.out.println(l1.val);
        l1.addAll(nums);
        ListNode4_24 test = new ListNode4_24();
        ListNode res = test.swapParis(l1);
        res.print1();
    }
}
