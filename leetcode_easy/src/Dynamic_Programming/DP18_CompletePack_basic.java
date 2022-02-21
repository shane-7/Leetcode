package Dynamic_Programming;

/** 完全背包的基础
 * @author shkstart
 * @create 2021-12-14 8:49
 */
public class DP18_CompletePack_basic {
    public int test_CompletePack(){
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int bagweight = 4;
        int[] dp = new int[bagweight + 1];

        //遍历顺序：先物品后背包
        for(int i = 0; i < weight.length; i++){
            for(int j = 0; j <= dp.length; j++){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        //遍历顺序：先背包后物品
        for(int j = 0; j <= dp.length; j++){
            for(int i = 0; i < weight.length; i++){
                if(j - weight[i] >= 0){
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }

        return dp[bagweight];
    }

}
