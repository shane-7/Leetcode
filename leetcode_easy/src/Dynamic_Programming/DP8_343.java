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
            for(int j = 1; j < i; j++){  //carl哥这里是 j < i-1; 都没有报错
                //2.确定递推公式
                //carl哥的这个递推公式真的很值得思索，很棒！
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
