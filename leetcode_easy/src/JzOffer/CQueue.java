package JzOffer;

import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2022-03-28 15:58
 */
public class CQueue {
    LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if(A.isEmpty()) return -1;
        return A.removeFirst();
    }

}
