package Everyday;

import java.util.HashMap;
import java.util.Map;

/** 1748. 唯一元素的和
 * @author shkstart
 * @create 2022-02-06 10:23
 */
public class Feb6_1748 {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                sum += entry.getKey();
            }
        }

        return sum;

    }

}
