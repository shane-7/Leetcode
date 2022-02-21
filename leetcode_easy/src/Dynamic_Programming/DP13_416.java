package Dynamic_Programming;

/** 416.分割等和子集
 * @author shkstart
 * @create 2021-12-06 13:44
 */
/* 对照01背包：物品i的重量是nums[i],价值也是nums[i], 背包体积是num/2
  1.确定dp数组以及下标的含义：
  dp[i]表示：背包总容量为i，最大可以凑成i的子集总和为dp[i]
  2.递推公式：
  dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i])
  3.初始化：
  题目中说：每个数组中的元素不会超过100，数组的大小不会超过200。
  则总和不会大于20000，背包最大只需要其中的一半，所以dp数组的长度初始化为10001
  int[] dp = new int[10001];
  4.确定遍历顺序：
  在01背包问题中已经说明，如果使用一维dp数组，物品遍历的for循环在外层，遍历背包的for循环在内层，且内层循环为倒叙遍历！
 */
public class DP13_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        if(sum % 2 == 1){
            return false;
        }
        int[] dp = new int[10001];
        int target = sum / 2;
        //开始遍历
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if(dp[target] == target){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,5,1};
        DP13_416 test = new DP13_416();
        boolean res = test.canPartition(nums);
        System.out.println(res);
    }
}
