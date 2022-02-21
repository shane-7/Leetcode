package Everyday;

import java.util.Deque;
import java.util.LinkedList;

/**2047.句子中的有效单词数
 * @author shkstart
 * @create 2022-01-27 9:33
 */
public class Jan27_2047_1 {
    public int countValidWords(String sentence) {
        //特殊情况考虑
        if(sentence.length() == 1) {
            if(isMinuscule(sentence.charAt(0)) || isPunctuation(sentence.charAt(0))){
                return 1;
            }else {
                return 0;
            }
        }

        int res = 0;

        //1.先将句子由空格拆分成单词：
        char[] chars = sentence.toCharArray();
        Deque<String> deque = new LinkedList<>();

        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < sentence.length(); i++){
            if(chars[i] == ' ') continue;
//            if(isMinuscule(chars[i])){ //是小写字母的话，获取分割的子字符串
            else {
                startIndex = i;
                endIndex = FindEndIndex(startIndex, chars);
                deque.addLast(sentence.substring(startIndex, endIndex + 1));
                i = endIndex;
            }
        }

        //2.单独判断单词是否合理：
        while(!deque.isEmpty()){
            String temp = deque.removeFirst();
            char[] word = temp.toCharArray();
            //2.1 是否存在'_', 并存在是否合理
            if(isValid(word)){
                System.out.println(temp);
                res++;
            }
        }

        return res;
    }

    public boolean isValid(char[] word){
        int countUL = 0;
        for(int i = 0; i < word.length; i++){
            if(isMinuscule(word[i]) && countUL <= 1) continue;
            //如果是数字，直接false
            if(48 <= Integer.valueOf(word[i]) && Integer.valueOf(word[i]) <= 57){
                return false;
            }
            //2.1 是否存在'-', 并存在是否合理
            if(word[i] == '-' && countUL > 1){
                return false;
            }
            if(word[i] == '-' ){
                if(countUL <= 1 && isMinuscule(word[i + 1])){
                    countUL++;
                }else {
                    return false;
                }
            }

            //2.2 是否存在标点符号，并存在是否合理
            if(word[i] == ',' || word[i] == '!' || word[i] == '.' ){
                if(word.length == 1){
                    return true;
                }else if (i != word.length - 1){
                    return false;
                }
            }
        }
        return true;
    }

//    //判断是否标点符号后，是否还有小写字母，如果有则false
//    public boolean isPunctuation(int startIndex, char[] st){
//        if(st[startIndex] == '-' || st[startIndex] == ',' || st[startIndex] == '!' || st[startIndex] == '.' ){
//            if(isMinuscule(st[startIndex + 1])){
//                return false;
//            }
//        }
//        return true;
//
//    }


    public int FindEndIndex(int startIndex, char[] st){
        for(int i = startIndex + 1; i < st.length; i++){
            if(st[i] == ' '){
                int EndIndex = i - 1;
                return EndIndex;
            }
        }
        return st.length - 1;
    }

    public boolean isMinuscule(char c){
        //判断字符是否是小写字母
        if(97 <= Integer.valueOf(c) && Integer.valueOf(c) <= 122){
            return true;
        }
        return false;
    }

    //判断是否标点符号后，是否还有小写字母，如果有则false
    public boolean isPunctuation(char c){
        if(c == ',' || c == '!' || c == '.' ){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String sentence = "a-b-c";
        Jan27_2047_1 test = new Jan27_2047_1();
        test.countValidWords(sentence);
    }
}
