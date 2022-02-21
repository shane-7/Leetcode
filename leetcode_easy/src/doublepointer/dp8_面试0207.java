package doublepointer;

/**
 * @author shkstart
 * @create 2021-09-26 13:44
 */
public class dp8_面试0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0, lenB = 0;
        //获取curA和curB的长度
        while(curA != null){
            curA = curA.next;
            lenA++;
        }
        while (curB != null){
            curB = curB.next;
            lenB++;
        }
        //再将其节点指向位置返回
        curA = headA;
        curB = headB;

        //让curA为最长链表的头，lenA为其长度
        if(lenB > lenA) {
            //swap lenA and lenB
            int temlen = lenA;
            lenA = lenB;
            lenB = temlen;

            //swap curA and curB
            ListNode temNode = curA;
            curA = curB;
            curB = temNode;
        }
        //求长度差
        int gap = lenA - lenB;
        //让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0){
            curA = curA.next;
        }
        //遍历curA和curB，遇到相同则直接返回
        while(curA != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
