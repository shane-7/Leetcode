package 宫水三叶.DFS;

/**
 * @author shkstart
 * @create 2022-05-01 12:02
 */
public class dfs11_目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int res = dfs(nums, target, 0, 0);
        return res;
    }
    int dfs(int[] nums, int target, int sum, int index){
        if(index == nums.length){
            return sum == target ? 1 : 0;
        }
        int left = dfs(nums, target, sum + nums[index], index + 1);
        int right = dfs(nums, target, sum - nums[index], index + 1);
        return left + right;

    }

    public static void main(String[] args) {
        dfs11_目标和 test = new dfs11_目标和();
        int ans = test.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(ans);
    }

}
