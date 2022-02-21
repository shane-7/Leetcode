package Everyday;

/**2047.句子中的有效单词数  写的真好!!!
 * @author shkstart
 * @create 2022-01-27 9:33
 */
public class Jan27_2047_2 {
    public int countValidWords(String sentence) {
        int n = sentence.length();
        int l = 0, r = 0;
        int ret = 0;
        while (true) {
            while (l < n && sentence.charAt(l) == ' ') {
                l++;
            }
            if (l >= n) {
                break;
            }
            r = l + 1;
            while (r < n && sentence.charAt(r) != ' ') {
                r++;
            }
            if (isValid(sentence.substring(l, r))) { // 判断根据空格分解出来的 token 是否有效
                ret++;
            }
            l = r + 1;
        }
        return ret;
    }

    public boolean isValid(String word) {
        int n = word.length();
        //连字符
        boolean hasHyphens = false;
        for (int i = 0; i < n; i++) {
            //首先判断单词中是否包含数字
            if (Character.isDigit(word.charAt(i))) {
                return false;
            } else if (word.charAt(i) == '-') {
                if (hasHyphens == true || i == 0 || i == n - 1 || !Character.isLetter(word.charAt(i - 1)) || !Character.isLetter(word.charAt(i + 1))) {
                    return false;
                }
                hasHyphens = true;
            } else if (word.charAt(i) == '!' || word.charAt(i) == '.' || word.charAt(i) == ',') {
                if (i != n - 1) {
                    return false;
                }
            }
        }
        return true;
    }




    public static void main(String[] args) {
        String sentence = "a-b-c";
        Jan27_2047_2 test = new Jan27_2047_2();
        test.countValidWords(sentence);
    }
}
