package Dynamic_Programming;

/** 509 斐波那契数
 *  作为动态规划的入门题目非常好
 * @author shkstart
 * @create 2021-12-03 10:43
 */
public class DP2_509 {
    public int fib(int N){
        //这一步一定要有，不能只靠dp[N]返回，因为N大于等于0的，等于0时，无法创建dp数组
        if(N <= 1){
            return N;
        }
        //dp数组初始化
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    //递归法：从结果可以看出递归的效率更低
    public int fib1(int n){
        if(n < 2) return n;
        return fib1(n - 1) + fib1(n - 2);
    }
}
