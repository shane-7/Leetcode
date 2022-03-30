package JzOffer;

/** 青蛙跳台阶问题，和70题相同
 * @author shkstart
 * @create 2022-03-30 19:24
 */
public class of10 {
    public int numWays(int n) {
        if(n == 0) return 1;
        //和70题相同
//        dp数组及下标的定义：爬上第i阶有几种方法
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            //递推公式：爬上第i阶台阶可以从第i-1阶台阶或第i-2阶台阶上来
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;  //这里结果要取个模
        }
        return dp[n];

    }
}
