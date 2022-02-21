package Dynamic_Programming;

/**
 * @author shkstart
 * @create 2021-12-16 19:43
 */
public class DP24_279 {
    public int numSquares(int n){
        //1.确定dp[j]以及下标i的含义：
        //和为j的完全平方数的最少数量为dp[j];

        //2，确定递推公式：联系前后关系： i为一个个完全平方数开方后的数
        //dp[j] = dp[j - i*i] + 1

        //3. dp[]的初始化；
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        double a = 1;
        int b = 0;

        //如果是完全平方数则 赋值为1，否则取最大值
//        for(int i = 1; i < dp.length; i++){
//            a = Math.sqrt(i);
//            b = (int) a;
//            if(a - b == 0){
//                dp[i] = 1;
//            }else{
//                dp[i] = max;
//            }
//        }
        for(int i = 1; i < dp.length; i++){
            dp[i] = max;
        }


        //4.确定遍历顺序：是组合问题(先物品后背包)，且求最小值
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j - i*i >= 0){
                    dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DP24_279 test = new DP24_279();
        int n = 12;
        int res = test.numSquares(12);
        System.out.println(res);
    }
}
