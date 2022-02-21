package Greed;

import java.util.Arrays;
import java.util.Comparator;

/** 1005.K次取反后最大化的数组和
 * @author shkstart
 * @create 2021-11-24 18:46
 */
public class Greed9_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //因为自定义的比较器的参数类型是Integer，先对nums[]数组进行装箱
        Integer[] integerArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        //按照自定义的比较器cmp进行排序
        Arrays.sort(integerArr, cmp);
        //再对integerArr数组进行拆箱，得到int型的数组
        nums  = Arrays.stream(integerArr).mapToInt(Integer::valueOf).toArray();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        while(k > 0) {
            nums[len - 1] = -nums[len - 1];
            k--;
        }
        //这是carl哥的方法，也非常的妙！ 比较k和2的倍数关系，来选取nums[len - 1]的正负号变化
//        if (k % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();

    }

    //自定义的比较器（按照绝对值从大到小排列）。 ！！！这个比较器的自定义方法非常值得使用
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return Math.abs(i2) - Math.abs(i1);
        }
    };

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, -2, 5, 4, -8, 6};
        Arrays.sort(nums, cmp);
        System.out.println(Arrays.toString(nums));

    }
}
