package backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** 39.组合总和
 * @author shkstart
 * @create 2021-11-18 22:06
 */
public class BackTr7_39 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public void backTracking(int[] candidates, int target, int sum, int startIndex){
        //终止条件
        if(sum > target){
            return;
        }
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, sum, i);
            sum -= candidates[i];               //回溯
            path.removeLast();                  //回溯
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        backTracking(candidates, target, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 5, 3};
        int target = 4;
        BackTr7_39 test = new BackTr7_39();
        test.combinationSum(candidates, target);
    }
}
