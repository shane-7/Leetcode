package 宫水三叶.JZoffer.BFS;

import javax.xml.xpath.XPath;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-05-07 8:58
 */
public class bfs8_086分割回文子串 {
    List<List<String>> res = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();
    public String[][] partition(String s) {
        dfs(s, 0);
        String[][] resArr = new String[res.size()][];
        for(int i = 0; i < res.size(); i++){
            List<String> list = res.get(i);
            resArr[i] = list.toArray(new String[list.size()]);
        }
        return resArr;

    }
    void dfs(String s, int startIndex){
        if(startIndex >= s.length()){
            res.add(new ArrayList<>(deque));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            if(isPalindrome(s, startIndex, i)){ //是回文子串
                String substr = s.substring(startIndex, i + 1);
                deque.addLast(substr);
            }else {
                continue;
            }
            dfs(s, i + 1);
            deque.pollLast();
        }

    }

    boolean isPalindrome(String s, int startIndex, int end) {
        for(int i = startIndex, j = end; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
