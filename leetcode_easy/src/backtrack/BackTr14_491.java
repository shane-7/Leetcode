package backtrack;

import java.util.ArrayList;
import java.util.List;

/** 491.递增子序列
 * @author shkstart
 * @create 2021-11-22 16:57
 */
public class BackTr14_491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return result;
    }


    public void backTracking(int[] nums, int startIndex){
        if(path.size() > 1){
            result.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for(int i = startIndex; i < nums.length; i++){
            if(!path.isEmpty() && nums[i] < path.get(path.size() - 1)
            || (used[nums[i] + 100] == 1)) continue;
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
