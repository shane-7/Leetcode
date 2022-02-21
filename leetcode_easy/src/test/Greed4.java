package test;

/** 053.最大子序列和
 *  让count尽量保持非负，有学问在里面
 *  为什么说count是尽量保持非负呢，因为如果nums[]中全是负数，则count应该找出最大的负数，所以count应该不断的更新自己
 *
 * @author shkstart
 * @create 2021-11-24 10:37
 */
public class Greed4 {
    public int maxSubArray(int[] nums){
        int count = 0; //count要尽量保持非负
        //注意：sum应该初始化为一个最小值
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            count += nums[i];
            sum = Math.max(count, sum);

            if(count < 0) count = 0;   //这一步太妙了，让count尽量保持非负。
                                       //如果nums[]全是负数，则让count = 0， 保持对count = nums[i]的更新，
                                       //让sum得到nums[]中的最大负数
        }
        return sum;
    }

}
