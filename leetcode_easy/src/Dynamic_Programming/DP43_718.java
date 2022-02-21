package Dynamic_Programming;

/** 718.最长重复子数组
 * @author shkstart
 * @create 2022-02-15 22:53
 */
public class DP43_718 {
    public int findLength(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length  + 1][nums2.length + 1];
//        for(int i = 1; i <= nums1.length; i++){
//            for(int j = 1; j <= nums2.length;  j++){
//                dp[i][j] = 1;
//            }
//        }

        int res = 0;
        for(int i = 1; i <= nums1.length; i++){
            for(int j = 1; j <= nums2.length; j++){
                if(nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                if(res < dp[i][j])
                    res = dp[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,0,0,0,1};
        int[] B = {1,0,0,1,1};
        System.out.println(new DP43_718().findLength(A, B));
    }
}
