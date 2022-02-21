package doublepointer;

/** 151.翻转字符串里的单词
 * @author shkstart
 * @create 2021-09-19 8:20
 */
public class dp4_151 {

    public String reverseWords(String s){
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0 , sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    //1.先移除首尾以及中间多余的空格
    private StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        while(s.charAt(start) == ' ')
            start++;
        while(s.charAt(end) == ' ')
            end--;
        StringBuilder sb = new StringBuilder();
        while(start <= end){
            char c = s.charAt(start);
            if(c != ' ' || sb.charAt(end - 1) != ' '){
                sb.append(c);
            }
        }
        return sb;
    }

    //2.反转字符串指定区间[start, end]的字符
    public void reverseString(StringBuilder sb, int start, int end){
        while (start < end){
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
        int end = start + 1;
        int n = sb.length();
        while (start < n){
            while(end < n && sb.charAt(end) != ' '){
                end++;
            }
            reverseString(sb, start, end - 1);
            start++;
            end = start + 1;
        }

    }


}
