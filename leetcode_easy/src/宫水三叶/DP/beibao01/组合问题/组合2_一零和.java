package 宫水三叶.DP.beibao01.组合问题;

/**
 * @author shkstart
 * @create 2022-06-08 9:10
 */
public class 组合2_一零和 {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
        int[][] dp = new int[60001][60001];

        for(String s : strs){
            int oneNum = 0, zeroNum = 0;
            for(char c : s.toCharArray()){
                if(c == '0'){
                    zeroNum++;
                }else{
                    oneNum++;
                }
            }
            //dp遍历
            for(int i = m; i >= zeroNum; i--){
                for(int j = n; j >= oneNum; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];

    }
}
