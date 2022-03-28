package Everyday;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2022-03-27 12:53
 */
public class March27_2028 {
    public int[] missingRolls(int[] rolls, int mean, int n){
        int m = rolls.length, cnt = m + n;
        int t = mean * cnt;
        for(int i : rolls) t -= i;
        if(t < n || t > 6 * n) return new int[0];
        int[] ans = new int[n];
        Arrays.fill(ans, t / n);
        if(t / n * n < t) {  //t / n 不为整数
            int d = t - (t / n * n), idx = 0;
            while(d-- > 0) ans[idx++] ++;
        }
        return ans;
    }

}
