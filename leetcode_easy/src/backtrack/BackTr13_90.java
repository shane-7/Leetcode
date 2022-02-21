package backtrack;

import java.util.*;

/** 子集(II) 可重复数字的数组
 *   对于可重复数字的数组要先进行排序
 * @author shkstart
 * @create 2021-11-22 16:16
 */
public class BackTr13_90 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();


    private void backTracking(int[] nums, int startIndex, boolean[] used){
        result.add(new ArrayList<>(path));
        for(int i = startIndex; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                continue;
            }
            used[i] = true;
            path.push(nums[i]);
            backTracking(nums, i + 1, used);
            used[i] = false;
            path.pop();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        for(int i = 0; i < used.length; i++){
            used[i] = false;
        }
        //要先排序
        Arrays.sort(nums);
        backTracking2(nums, 0 , used);
        return result;
    }


    private void backTracking2(int[] nums, int startIndex, boolean[] used){
        result.add(new ArrayList<>(path));
        HashSet<Integer> sets = new HashSet<>();
        for(int i = startIndex; i < nums.length; i++){
            if(sets.contains(nums[i])) continue;

            sets.add(nums[i]);
            path.push(nums[i]);
            backTracking(nums, i + 1, used);
            path.pop();
        }
    }
}
