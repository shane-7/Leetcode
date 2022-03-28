package JzOffer;

import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2022-03-28 15:53
 */
public class of09 {
    public static void main(String[] args) {
        //LinkedList.add()在尾部添加， remove方法用的是去除栈顶元素
        LinkedList<Integer> A = new LinkedList<>();
        A.add(1);
        A.add(2);
        int s = A.remove();
        System.out.println(s);
    }
}
