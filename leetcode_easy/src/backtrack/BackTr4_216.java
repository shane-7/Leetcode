package backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**  求组合综合
 * @author shkstart
 * @create 2021-11-18 19:44
 */
public class BackTr4_216 {

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    private void backtracking(int targetSum, int k, int sum, int startIndex){
        if(path.size() == k){
            if(targetSum == sum){
                result.add(new ArrayList<>(path));
            }
        }
        for(int i = startIndex; i <= 9; i++){
            sum += i;
            path.add(i);
            backtracking(targetSum, k, sum, i + 1);
            sum -= i; //回溯
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n){
        backtracking(n, k, 0, 1);
        return result;
    }

}
