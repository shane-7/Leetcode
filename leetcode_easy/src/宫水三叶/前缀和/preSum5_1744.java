package 宫水三叶.前缀和;

/**
 * @author shkstart
 * @create 2022-04-15 11:02
 */
public class preSum5_1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        //先计算前缀和
        int n = candiesCount.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }

        boolean[] ans = new boolean[queries.length];
        for(int i = 0; i < n; i++){
            int t = queries[i][0], d = queries[i][1] + 1, c = queries[i][2];
            int a = sum[t] / c + 1, b = sum[t + 1];
            ans[i] = a <= d && d <= b;
        }
        return ans;
    }

    public static void main(String[] args) {
        preSum5_1744 test = new preSum5_1744();
        int[] candies = {7,4,5,3,8};
        int[][] queries = {{0,2,2},{4,2,4},{2,13,1000000000}};
        boolean[] res = test.canEat(candies, queries);
        System.out.println(res.toString());
    }
}
