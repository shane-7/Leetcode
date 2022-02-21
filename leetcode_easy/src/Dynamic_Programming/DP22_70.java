package Dynamic_Programming;

/** 70.爬楼梯(修改)
 *  每次爬1到2个台阶 改为 一步一个台阶，两个台阶，三个台阶，......,直到m个台阶。
 *  问有多少种不同的方法可以爬到楼顶呢？
 * @author shkstart
 * @create 2021-12-15 9:14
 */
public class DP22_70 {
    public int climbStairs(int n, int m){

        //1.确定dp[i]数组以及下标的含义：
        //表示爬到有i个台阶的楼顶，有dp[i];  楼顶就代表背包， 1阶、2阶.....m阶就代表物品

        //3.dp数组初始化：
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        //4.确定遍历顺序:因为是完全背包中的排列问题(顺序不同，组合方式也就不同)，先背包后物品
        for(int i = 1; i <= n; i++){  // i代表楼顶 = 背包
            for(int j = 1; j <= m; j++){  //j代表每步的阶梯数 = 物品；
                //要加一个判断条件，确保背包不超重
                if(i - j >= 0){
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
