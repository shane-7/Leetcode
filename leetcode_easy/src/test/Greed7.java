package test;

/** 055 跳跃游戏
 * @author shkstart
 * @create 2021-11-24 13:44
 */
public class Greed7 {
    public boolean canJump (int[] nums){
        int cover = 0;
        if(nums.length == 1) return true;
        for(int i = 0; i < cover; i++){
            cover = Math.max(1 + nums[i], cover);
            if(cover >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
