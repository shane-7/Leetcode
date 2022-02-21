package backtrack;


import java.util.*;

/** 40.组合综合(II)， candidates中的数字只能用一次
 * @author shkstart
 * @create 2021-11-19 16:42
 */
public class BackTr8_40 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public void backTracking(int[] candidates, int target, int sum, int startIndex, boolean[] used){
        //终止条件
//        if(sum > target){
//            return;
//        }
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++){
            if(i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false){
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.push(candidates[i]);
            backTracking(candidates, target, sum, i + 1, used);
            sum -= candidates[i];
            used[i] = false;
            path.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //用boolean型数组来表示candidates数组中的数是否被用过。
        boolean[] used = new boolean[candidates.length];
        //将used数组中的值都初始化为false
        for(int i = 0; i < used.length; i++){
            used[i] = false;
        }

        //先对candidates排个序，让数组整齐一点
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0, used);
        return result;

    }

}
