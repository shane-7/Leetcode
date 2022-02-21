package doublepointer;

/**142.环形链表
 *
 * 此题要进行公式演算。
 * @author shkstart
 * @create 2021-09-26 17:11
 */
public class dp9_142 {
    public ListNode detectCycle (ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) //相遇则有环
            {
                ListNode index1 = fast; //从相遇节点出发
                ListNode index2 = head; //从头节点出发
                while(index1 != index2){  //x = z
                    index1 = index1.next;  //z
                    index2 = index2.next;  //x
                }
                return index2;
            }
        }
        return null;
    }

}
