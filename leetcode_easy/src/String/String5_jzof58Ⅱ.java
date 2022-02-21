package String;

/** jzof8Ⅱ
 * 思路：1.反转前n个字符；2.反转区间为n到末尾的子串；3.反转整个子串
 * @author shkstart
 * @create 2021-09-10 12:49
 */
public class String5_jzof58Ⅱ {

    public String reverseLeftWords(String s, int n){
        int l = s.length();
        //将s转换为StringBuilder
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, l -1 );
        reverseString(sb, 0, l - 1);

        return sb.toString();

    }


    public void reverseString(StringBuilder sb, int start, int end){
        while(start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String5_jzof58Ⅱ test = new String5_jzof58Ⅱ();
        String res = test.reverseLeftWords("abcdefgh", 2);
        System.out.println(res);

    }

}
