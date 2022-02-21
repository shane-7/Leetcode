package doublepointer;

/** 344.反转字符串
 * @author shkstart
 * @create 2021-09-17 8:15
 */
public class dp2_344 {
    public void reverseString(char[] s){
        int start = 0;
        int end = s.length - 1;
        while(start < end){
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];
            start++;
            end--;
        }
    }
}
