package String;

/**151.反转字符串中的单词
 * @author shkstart
 * @create 2021-09-09 10:45
 *
 * 1.先去掉首尾以及中间多余空格
 * 2.反转整个字符串
 * 3.反转各个单词
 *
 */
public class String4_151 {

    public String reverseWords(String s){
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);

        return sb.toString();

    }

    //1.先移除首尾以及中间多余的空格
    private StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        while(s.charAt(start) == ' ') start++;
        while(s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while(start <= end){
            char c = s.charAt(start);
            if(c != ' ' || sb.charAt(sb.length() - 1) != ' '){   //   “||”的左右顺序很重要，左边先判断，如果第二个条件放左边的话第一次循环会出错
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    //2.反转字符串指定区间[start, end]的字符
    public void reverseString(StringBuilder sb, int start, int end){
        while(start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    //3.反转字符串中的每个单词
    private void reverseEachWord(StringBuilder sb){
        int start = 0;
        int end = 1;
        int n = sb.length();
        while(start < n){
            while(end < n && sb.charAt(end) != ' '){
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    public static void main(String[] args) {
        String4_151 test = new String4_151();
        String s = " we are the world ";
        String res = test.reverseWords(s);

        System.out.println(res.toString());
    }

}
