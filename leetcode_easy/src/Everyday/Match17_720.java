package Everyday;

import java.util.HashSet;
import java.util.Set;

/** 720. 词典中最长的单词
 *   关键：用的set存储单词
 *   解决字典序的问题：用到了String中的compareTo方法
 *
 * @author shkstart
 * @create 2022-03-17 8:14
 */
public class Match17_720 {
    public String longestWord(String[] words){
        String ans = "";
        Set<String> set = new HashSet<>();
        for(String s : words) set.add(s);
        for(String s : set){
            int n = s.length(), m = ans.length();
            if(n < m) continue;
            if(n == m && s.compareTo(ans) > 0) continue;  //如果都能由词典里的单词组成，比较字典序，
            //s的字典序在后面的话，比较之后返回的是正数

            //再比较 单词s是否由set中其他单词逐步添加一个字母组成
            boolean ok = true;
            for(int i = 1; i <= n && ok; i++){
                String sub = s.substring(0, i);
                if(! set.contains(sub)) ok = false;
            }
            if(ok) ans = s;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl", "world"};
        Match17_720 test = new Match17_720();
        String s = test.longestWord(words);
        System.out.println(s);
    }
}
