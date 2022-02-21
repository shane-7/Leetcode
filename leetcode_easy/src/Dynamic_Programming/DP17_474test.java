package Dynamic_Programming;

/** 474.一零和
 *
 * @author shkstart
 * @create 2021-12-10 12:58
 */
public class DP17_474test {
    public int findMaxForm(String[] strs, int m, int n){
        //1.确定dp数组以及下标的含义 dp[i][j]
        //最多有i个0和j个1的strs的最大子集为dp[i][j]

        //3.dp数组初始化
        int[][] dp = new int[m + 1][n + 1];

        //4.开始遍历
        for(String str : strs){
            //定义两个0和1的计数器
            int zeroNum = 0; int oneNum = 0;
            for(char c : str.toCharArray()){
                if(c == '0') {
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            for(int i = m; i >= zeroNum; i--){
                for(int j = n; j >= oneNum; j--){
                    //2.确定遍历顺序
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
