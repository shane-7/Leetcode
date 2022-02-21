package backtrack;

import java.util.*;

/** 47.全排列II 重复数字的数组全排列，返回所有不重复的全排列
 *
 *  注： 对于可重复数字的数组，去重重要的一步：对数组进行排序
 * @author shkstart
 * @create 2021-11-23 10:46
 */
public class BackTr16_47 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    private void backTracking(int[] nums, boolean[] used){
        //确定终止条件
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //单层检索逻辑
        for(int i = 0; i < nums.length; i++){
            if(used[i] == true) continue;   //这个标记在全排列中很关键
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
                continue;
            used[i] = true;
            path.push(nums[i]);
            backTracking(nums, used);
            used[i] = false;
            path.pop();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        //对于可重复数字的数组，去重要先进行排序
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        //对标记数组进行初始化
        for(int i = 0; i < nums.length; i++){
            used[i] = false;
        }

        backTracking(nums, used);
        return result;
    }


}
