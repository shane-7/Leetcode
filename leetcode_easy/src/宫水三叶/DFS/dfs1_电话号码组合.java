package 宫水三叶.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-04-29 10:58
 */
public class dfs1_电话号码组合 {

    static  String[] letterMap = {
            " ",
            " ",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };

    static List<String> res = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res;
        }
        dfs(letterMap, 0, digits);
        return res;
    }



    static void dfs(String[] letterMap, int startIndex, String digits){
        if(startIndex == digits.length()){
            res.add(sb.toString());
            return;
        }

        int letterNum = digits.toCharArray()[startIndex] - '0';
        String tempLet = letterMap[letterNum];
        for(int i = 0; i < tempLet.length(); i++){
            sb.append(tempLet.charAt(i));
            dfs(letterMap, startIndex + 1, digits);
            sb.deleteCharAt(sb.length() -1 );
        }

    }


}
