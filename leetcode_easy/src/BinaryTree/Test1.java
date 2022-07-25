package BinaryTree;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author shkstart
 * @create 2021-11-18 12:29
 */
public class Test1 {
    public float wordslen(String s){
        float sumlen = 0;
        int preIndex = 0;
        List<String> words = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                words.add(s.substring(preIndex, i));
                preIndex = i+1;
            }
        }
        words.add(s.substring(preIndex, s.length()));
        for(String word : words){
            sumlen += word.length();
        }
        float res = sumlen / words.size();
        return (float) Math.round(res * 100) / 100;

    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        String s = "Who Love Solo";
        String c = "O";
        String s1 = s.toUpperCase().replaceAll(c.toUpperCase(), "");
        System.out.println(s1);

    }


}
