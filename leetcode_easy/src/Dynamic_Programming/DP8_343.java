package Dynamic_Programming;

/** 343.整数拆分，思路分析比较难，需要多做
 * @author shkstart
 * @create 2021-12-08 13:52
 */
public class DP8_343 {
    public int integerBreak(int n) {
        //1.确定dp数组以及下标的含义：
        //分拆数字i，可以得到的最大乘积为dp[i]

        //3.dp的初始化，i=0,1都没有意义，从下标i=2初始化
        int[] dp = new int[n + 1];
        dp[2] = 1;

        //4.遍历顺序
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){  //carl哥这里是 j < i-1; 都没有报错, 解答(time:2022.3.4): 这里j < i - 1的原因：如果是j<i，当j=i-1时，
                                                                                                // 乘积为(i-1)*1，重复了j=1的时候
                //2.确定递推公式
                //carl哥的这个递推公式真的很值得思索，很棒！
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                //补充(time:2022.3.4):因为在循环中dp[i]每次得到的值不一样大，所以还要加一层Math.max()
            }
        }
        return dp[n];
    }
}
