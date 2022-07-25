package 宫水三叶.DFS;

import java.util.Arrays;

/**  用回溯dfs超时
 * @author shkstart
 * @create 2022-05-26 1:28
 */
public class dfs15_分割等和子集 {
    private static int target = 0;
    private static boolean res = false;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0) return false;
        target = sum / 2;
        Arrays.sort(nums);
        dfs(target, nums, 0, 0);
        return res;
    }
    void dfs(int tar, int[] nums, int sum_num, int Index){
        if(sum_num > tar){
            res = false;
            return;
        }
        if(sum_num == tar){
            res = true;
            return;
        }
        for(int i = Index; i < nums.length; i++){
            sum_num += nums[i];
            dfs(tar, nums, sum_num, i + 1);
            if(res == true) break;
            sum_num -= nums[i];
        }
    }

    public static void main(String[] args) {
        dfs15_分割等和子集 test = new dfs15_分割等和子集();
        boolean re = test.canPartition(new int[]{2, 2, 1, 1, 5, 5, 8, 9,7});
        System.out.println(re);
    }

}
