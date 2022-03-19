package Week_Compete.double74;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shkstart
 * @create 2022-03-19 23:14
 */
public class double74_1 {
    public boolean divideArray(int[] nums){
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }

        int cnt = 0;
        for(int i : map.keySet()){
            cnt += map.get(i) / 2;
        }
        if(n == cnt) return true;
        else return false;
    }

    public static void main(String[] args) {
        double74_1 test = new double74_1();
        int[] nums = {3,2,3,2,2,2};
        boolean res = test.divideArray(nums);
        System.out.println(res);
    }
}
