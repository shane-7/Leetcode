package stack_And_queue;

import java.util.ArrayDeque;

/**1047.删除字符串中的所有相邻重复项
 *   解决方法：本题要删除相邻相同元素，其实也是匹配问题，
 *   相当于20题的匹配左右括号：相同左元素相当于左括号，相同右元素就是相当于右括号，匹配上了就删除。
 *   把字符串按顺序放入栈中，这样最后栈里剩下的元素都是相邻不相同元素了
 *
 *
 * @author shkstart
 * @create 2021-10-11 10:59
 */
public class sAq4_1047 {
    public String removeDuplicates(String s){
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(deque.isEmpty() || deque.peek() != ch)
            deque.push(ch);
            else {
                //说明deque.peek() == ch
                deque.pop();
            }
        }
        String str = "";
        while(!deque.isEmpty()){
            str = deque.pop() + str;
        }

        return str;

    }
}
