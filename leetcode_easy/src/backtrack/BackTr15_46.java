package backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** 46.全排列  对不重复数字的数组，返回所有不重复的全排列
 * @author shkstart
 * @create 2021-11-22 23:31
 */
public class BackTr15_46 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    private void backTracking(int[] nums, boolean[] used){
        //终止条件：当path存储的数据长度与等于nums数组的长度
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //找到一组，则就是找到了叶子节点
        for(int i = 0; i < nums.length; i++){
            if(used[i] == true) continue;   //这个标记在全排列中很关键
            used[i] = true;
            path.push(nums[i]);
            backTracking(nums, used);
            path.pop();
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            used[i] = false;
        }
        backTracking(nums, used);
        return result;
    }

}
