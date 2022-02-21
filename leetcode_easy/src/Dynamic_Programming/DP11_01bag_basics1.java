package Dynamic_Programming;

/**  动规11篇：背包问题基础，非常值得多看几遍、
 *   这里用的是二维数组，二维数组能更好的理解背包问题
 * @author shkstart
 * @create 2021-12-06 9:10
 */

/*
    递推公式为：
    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
 */
public class DP11_01bag_basics1 {
    public int testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        //dp下标以及含义： i：表示第几个物品，也相当于weight的下标， j：背包的重量。上面bagWeight是背包的容量
        //dp[i][j]表示在背包容量为j时，从下标[0-i]的物品里任意取，价值总和为多少
        int[][] dp = new int[weight.length + 1][bagWeight + 1];
        //dp初始化，因为dp[i][j] 由dp[i - 1][j]决定，所以要完成 i为0的初始化
        //1.考虑i = 0时，当j < weight[0]时，背包容量比编号0的物体重量还小
        for(int j = 0; j < weight[0]; j++){
            dp[0][j] = 0;
        }
        for(int j = weight[0]; j <= bagWeight; j++){
            dp[0][j] = value[0];
        }

        //遍历顺序
        //先遍历物品
        for(int i = 1; i < weight.length; i++){
            for(int j = 0; j <= bagWeight; j++){
                if(j < weight[i]){
                    dp[i][j] = dp[i - 1][j];      //不放物品i的价值
                }
                else { //背包放得下weight[i]

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);  //max(不放物品i的价值，放了物品i的价值)
                }
            }
        }
        return dp[weight.length - 1][bagWeight];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int bagWeight = 4;

        DP11_01bag_basics1 test = new DP11_01bag_basics1();
        int res = test.testWeightBagProblem(weight, value, bagWeight);
        System.out.println(res);

    }
}
