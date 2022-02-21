package algorithm;

/**  i是后缀末尾，j是前缀末尾
 * @author shkstart
 * @create 2021-09-13 9:28
 */
public class KMP {
    public void getNext(int[] next, String s){

        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }
}
