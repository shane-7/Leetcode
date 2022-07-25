package 宫水三叶.DFS;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-04-29 23:28
 */
public class dfs3_组合总数 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, target, candidates);
        return res;
    }
    void dfs(int startIndex, int target, int[] candidates){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++){
            //剪枝操作
            if(sum + candidates[i] > target) break;
            sum += candidates[i];
            path.addLast(candidates[i]);
            dfs(i,target, candidates);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        dfs3_组合总数 test = new dfs3_组合总数();
        List<List<Integer>> res = test.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(res.toString());
    }
}
