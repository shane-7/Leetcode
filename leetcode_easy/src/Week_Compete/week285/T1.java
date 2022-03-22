package Week_Compete.week285;

import java.util.ArrayList;
import java.util.List;

/** 6027
 * @author shkstart
 * @create 2022-03-20 10:34
 */
public class T1 {
    public int countHillValley(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            //判断是否为峰
            if(i >=1 && nums[i] == nums[i - 1] ){
                continue;
            }
            list.add(nums[i]);
        }
        for(int j = 1; j < list.size() - 1; j++){
            //判断是否有峰
            if(list.get(j) > list.get(j - 1) && list.get(j) > list.get(j + 1)){
                cnt++;
            }
            //判断是否有谷
            if(list.get(j) < list.get(j - 1) && list.get(j) < list.get(j + 1)){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        T1 test = new T1();
        int[] nums = {2,4,1,1,6,5};
        int i = test.countHillValley(nums);
        System.out.println(i);
    }
}
