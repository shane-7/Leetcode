package HashMap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author shkstart
 * @create 2021-08-19 8:41
 */
public class HashMap5_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[0] = map.get(temp);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 7, 15};
        int target = 9;
        HashMap5_1 test = new HashMap5_1();
        int[] res = test.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
