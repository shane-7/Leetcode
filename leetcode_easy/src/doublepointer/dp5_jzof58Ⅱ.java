package doublepointer;

/** 剑指offer 58Ⅱ. 左旋转字符串
 * @author shkstart
 * @create 2021-09-21 11:05
 */
public class dp5_jzof58Ⅱ {

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        //先翻转前n个字符
        reverseString(sb, 0, n - 1);
        //再翻转剩下的len-n个字符
        reverseString(sb, n, len - 1);
        //再全部翻转
        reverseString(sb, 0, len - 1);

        return sb.toString();
    }


    //反转字符串指定区间[start, end]的字符
    public void reverseString(StringBuilder sb, int start, int end){
        while (start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        dp5_jzof58Ⅱ test = new dp5_jzof58Ⅱ();
        String s = "abcdefg";
        int k = 2;
        String s1 = test.reverseLeftWords(s, 2);
        System.out.println(s1);
    }



}
