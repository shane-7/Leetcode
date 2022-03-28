package JzOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2022-03-28 9:29
 */
public class of06 {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while(head != null){
            deque.addFirst(head.val);
            head = head.next;
        }
        int[] res = new int[deque.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = deque.pop();
        }
        return res;
    }
}
