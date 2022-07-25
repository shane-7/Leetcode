package JZoffer.TanXin;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TX376 {
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) return 1;
        int curdiff = 0;
        int prediff = 0;
        int ans = 1;
        Map<Integer,Integer> map = new HashMap<>();
        Map<String, String> map1 = new ConcurrentHashMap<>();
        for(int i = 1; i < nums.length; i++){
            curdiff = nums[i] - nums[i - 1];
            if(curdiff == 0) continue;
            if(curdiff * prediff <= 0){
                ans++;
                prediff = curdiff;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int res = TX376.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5});
        System.out.println(res);
    }
}
