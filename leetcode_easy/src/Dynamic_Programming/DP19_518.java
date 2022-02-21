package Dynamic_Programming;

/** 518.零钱兑换Ⅱ （mid）
 * @author shkstart
 * @create 2021-12-14 9:37
 */
public class DP19_518 {
    public int change(int amount, int[] coins){
        //1.确定dp数组以及下标的含义：
        //dp[j]:凑成总金额j的货币组合数为dp[j]

        //3.dp数组初始化
        int[] dp = new int[amount + 1];
        dp[0] = 1;   //dp[0]一定要为1，dp[0]=1 是递推公式的基础

        //4.确定遍历顺序：先物品后背包
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j - coins[i]];   //2.确定递推公式：求装满背包有几种方法的一般公式
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        DP19_518 test = new DP19_518();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int res = test.change(amount, coins);
        System.out.println(res);
    }
}
