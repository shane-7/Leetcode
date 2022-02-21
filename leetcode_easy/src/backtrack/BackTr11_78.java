package backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** 子集I  不重复数字的数组
 * @author shkstart
 * @create 2021-11-22 14:16
 */
public class BackTr11_78 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    private void backTracking(int[] nums, int startIndex){
        //每次递归的时候将结果放进result中，（每次递归相当于在遍历每一个节点，将节点放进result中）
        result.add(new ArrayList<>(path));
        //终止条件
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            path.push(nums[i]);
            backTracking(nums, i + 1);
            path.pop();
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return result;
    }
}
