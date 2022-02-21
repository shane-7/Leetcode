package Greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shkstart
 * @create 2021-11-29 19:24
 */
public class Greed9_1005_1 {
    public int largestSumAfterKNegations(int[] nums, int k){
        //对数组nums按照绝对值的大小，从大到小排列

        //1.因为自定义的比较器的参数组类型是Integer，要先将int转换成Integer
        Integer[] IntegerArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        //2.按照自定义比较器进行对数组排序
        Arrays.sort(IntegerArr);
        //3.再将Integer数组转换为int型
        nums = Arrays.stream(IntegerArr).mapToInt(Integer::valueOf).toArray();

        int len = nums.length;
        for(int i = 0; i < len; i++){
            //从前向后遍历，遇到负数则变为正，然后k--
            if(nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        //如果此时k仍然>0, 则将数组中最小的数进行变号，直到k = 0；
        while(k > 0){
            nums[len - 1] = -nums[len - 1];
        }

        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        return sum;
    }

    //自定义比较器
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.abs(o1) - Math.abs(o2);
        }
    };

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, -2, 5, 4, -8, 6};
        Arrays.sort(nums, cmp);
        System.out.println(Arrays.toString(nums));

    }
}
