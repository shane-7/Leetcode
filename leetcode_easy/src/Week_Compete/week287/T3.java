package Week_Compete.week287;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author shkstart
 * @create 2022-04-03 12:30
 */
public class T3 {
    public int maximumCandies(int[] candies, long k) {
        int[] tempCandy = candies;
        //排序
        Arrays.sort(tempCandy);
        int sum = 0;
        for(int i : tempCandy){
            sum += i;
        }
        if(sum < k){
            return 0;
        }

        long left = 1, right = sum;
        long res = 0;

        //二分
        while(left <= right){
            long mid = left + (right - left) /2;
            if(check(candies, mid, k)){
                res = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return (int) res;

    }

    private boolean check(int[] candies, long mid, long k) {
        for(int i : candies){
            if(i >= mid) {
                k -= i / mid;
            }else {
                continue;
            }
        }
        if(k <= 0) return true;
        else return false;
    }
}
