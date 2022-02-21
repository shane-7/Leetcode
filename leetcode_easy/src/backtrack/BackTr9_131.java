package backtrack;

import java.util.*;

/** 分割回文字符串
 * @author shkstart
 * @create 2021-11-21 8:06
 */
public class BackTr9_131 {
    List<List<String>> result = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public void backtracking(String s, int startIndex){
        //递归的终止条件
        if(startIndex >= s.length()){
            //这里要进行字符串翻转，不然leetcode通不过
            ArrayList<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        for(int i = startIndex; i < s.length(); i++){
            if(isPalindrome(s, startIndex, i)){
                //如果是回文子串
                String substr = s.substring(startIndex, i + 1);
                path.push(substr);
            }else {
                continue;
            }
            //起始位置后移，保证不重复
            backtracking(s, i + 1);
            path.pop();
        }
    }


    //回文字符串判别法
    private boolean isPalindrome(String s, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }


    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;

    }
}
