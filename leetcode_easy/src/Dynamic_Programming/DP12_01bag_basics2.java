package Dynamic_Programming;

/** 用一维数组代替之前用的二维数组。 后面都倾向于用一维数组
 *  二维数组更倾向于理解背包问题。
 * @author shkstart
 * @create 2021-12-06 11:42
 */

/*
   1.确定dp数组的定义：
   在一维dp数组中，dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]。
   2.递推公式变为：
   dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
   3.初始化：
   dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]，那么dp[0]就应该是0，因为背包容量为0所背的物品的最大价值就是0。
   4.遍历顺序：
   for(int i = 0; i < weight.size(); i++) { // 遍历物品
        for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
            dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
        }
    }
    注意：二维dp遍历的时候，背包容量是从小到大，而一维dp遍历的时候，背包是从大到小。
    具体原因解析：可看carl哥github

 */

//测试代码
public class DP12_01bag_basics2 {
    int[] weight = new int[]{1, 3, 4};
    int[] value = new int[]{15, 20, 30};
    int bagWeight = 4;
    public void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.length; i++){
            for(int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for(int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + ",");
        }
    }

    public static void main(String[] args) {
        DP12_01bag_basics2 test = new DP12_01bag_basics2();
        test.testWeightBagProblem(test.weight, test.value, test.bagWeight);
    }

}
