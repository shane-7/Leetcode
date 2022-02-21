package Dynamic_Programming;

/** 474.一零和
 *  这道题非常好，对于01背包的深入理解很有帮助
 *  其实就在于如何转换题意，以及理解题意。
 * @author shkstart
 * @create 2021-12-09 20:00
 */
public class DP17_474 {
    public int findMaxForm(String[] strs, int m, int n) {

        //1.确定dp数组以及下标的含义:dp[i][j]
        //最多有i个0和j个1的strs的最大子集的大小为dp[i][j]

        //3.dp数组初始化
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = 0;
            }
        }

        //开始遍历
        //物品采用正序，背包依然采用倒叙的方式
        for(String str : strs){
            int zeroNum = 0, oneNum = 0;
            for(char c : str.toCharArray()){
                if(c == '0') {
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            //背包倒叙！！！格外注意：for循环不要像之前一样思维定式，
            //因为这里的dp是二维数组,  i和j两个背包都要倒叙
            for(int i = m; i >= zeroNum; i--){
                for(int j = n; j >= oneNum; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }

        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        DP17_474 test = new DP17_474();
        String[] strs = new String[]{"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        int res = test.findMaxForm(strs, 5, 3);
        System.out.println(res);
    }
}
