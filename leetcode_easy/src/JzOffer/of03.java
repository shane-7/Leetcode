package JzOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shkstart
 * @create 2022-03-23 17:20
 */
public class of03 {
    //方法一：HashMap
    public int findRepeatNumber(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                return i;
            }else {
                map.put(i, 1);
            }
        }
        return -1;
    }

    //方法二：set去重
    public int findRepeatNumber1(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)) return i;
            else set.add(i);
        }
        return -1;
    }
}
