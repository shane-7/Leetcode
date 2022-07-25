package 宫水三叶.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-04-29 22:40
 */
public class dfs2_括号生成 {
    StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return ans;
    }

    void dfs(int leftNum, int rightNum, int n){
        if(leftNum + rightNum == 2 * n){
            ans.add(sb.toString());
            return;
        }
        if(rightNum > leftNum){

            return;
        }
        if(leftNum < n) {
            sb.append("(");
            dfs(leftNum + 1, rightNum, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(rightNum < leftNum) {
            sb.append(")");
            dfs(leftNum, rightNum + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        dfs2_括号生成 test = new dfs2_括号生成();
        List<String> res = test.generateParenthesis(3);
        System.out.println(res.toString());
    }
}
