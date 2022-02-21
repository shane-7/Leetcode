package Week_Compete;

import java.util.Arrays;

/** 5993.将找到的值乘以2
 * @author shkstart
 * @create 2022-01-30 14:30
 */
public class week278_1_5993 {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == original){
                original = original * 2;
            }
        }
        return original;


    }

//    public boolean isExist(int startIndex, int[] nums, int original){
//        for(int i = startIndex; i < nums.length; i++){
//            if(nums[i] == original){
//                original = original * 2;
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        week278_1_5993 test = new week278_1_5993();
        int[] nums = {5,3,6,1,12};
        int original= 3;
        int res = test.findFinalValue(nums, original);


    }
}
