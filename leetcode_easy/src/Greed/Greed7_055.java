package Greed;

/** 055.跳跃游戏
 * @author shkstart
 * @create 2021-11-23 22:28
 */
public class Greed7_055 {
    public boolean canJump(int[] nums) {

        int cover = 0;
        int maxCover = 0;
        if(nums.length == 1) return true;
        for(int i = 0; i < nums.length - 1; i++){
            cover = nums[i];
            maxCover = i + cover;
            if(maxCover >= nums.length - 1) return true;
        }
        return false;
    }

    //carl哥题解
    public boolean canJump1(int[] nums) {

        int cover = 0;
        //特殊情况处理
        if(nums.length == 1) return true;
        for(int i = 0; i <= cover; i++){    //这个for循环的第二条件应该是 i<= cover, 因为i的移动范围现在是由覆盖范围决定的，不能定向思维的是i<nums.length
                                            //第二条件这里是 <=, 不然刚开始cover=0，for循环条件不能成立
            //更新cover
            cover = Math.max(i + nums[i], cover); //在每个单位的i中，寻找最大的覆盖范围（局部最优解），每个局部最优解形成全局最优解。
            if(cover >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Greed7_055 test = new Greed7_055();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean res = test.canJump(nums);
        System.out.println(res);
    }


}
