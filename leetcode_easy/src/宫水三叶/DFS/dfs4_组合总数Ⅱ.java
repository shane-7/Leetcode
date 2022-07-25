package 宫水三叶.DFS;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-04-30 11:53
 */
public class dfs4_组合总数Ⅱ {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int sum = 0;
        boolean[] used = new boolean[candidates.length];
        dfs(candidates, target, used, sum, 0);
        return res;

    }

    void dfs(int[] candidates, int target, boolean[] used, int sum, int startIndex){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++){
            if(sum + candidates[i] > target){
                break;
            }
            //亮点在这
            if(i > 0 && (candidates[i] == candidates[i - 1] && used[i - 1] == false)){
                continue;
            }
            sum += candidates[i];
            path.addLast(candidates[i]);
            used[i] = true;
            dfs(candidates, target, used, sum, i + 1);
            sum -= candidates[i];
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        dfs4_组合总数Ⅱ test = new dfs4_组合总数Ⅱ();
        List<List<Integer>> res = test.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(res.toString());
    }


}
