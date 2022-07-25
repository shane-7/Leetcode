package Array.BinarySearch;

/** 注意要给 平方数的变量类型是long
 * 有效平方数
 */
public class BS3_367 {
    public static boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;
            if(sq == num){
                return true;
            }
            if(sq > num){
                right = mid - 1;
            }
            if(sq < num){
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = BS3_367.isPerfectSquare(16);
        System.out.println(res);
    }

}
