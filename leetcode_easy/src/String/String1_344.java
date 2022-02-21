package String;

/** 344.反转字符串
 * @author shkstart
 * @create 2021-09-07 22:26
 */
public class String1_344 {
    public void reverseString(char[] s){
        int l = 0;
        int r = s.length - 1;
        while(l < r){
            s[l] ^= s[r]; //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l]; //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r]; //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l++;
            r--;
        }
    }

}
