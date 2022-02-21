package backtrack;

import java.util.ArrayList;
import java.util.List;

/** 17.电话号码的字母组合
 * @author shkstart
 * @create 2021-11-18 20:53
 */
public class BackTr5_17 {

    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public void backtracking(String digits,  String[] numString, int index){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        for(int i = 0; i < numString[digit].length(); i++){
            sb.append(numString[digit].charAt(i));
            backtracking(digits, numString, ++index);
            index--;                           //回溯
            sb.deleteCharAt(sb.length() - 1);  //回溯
        }
    }


    public List<String> letterCombination(String digits){
        if(digits == null || digits.length() == 0) return result;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits, numString, 0);
        return result;
    }

    public static void main(String[] args) {
        BackTr5_17 test = new BackTr5_17();
        String digits = "23";
        List<String> res = test.letterCombination(digits);

    }

}
