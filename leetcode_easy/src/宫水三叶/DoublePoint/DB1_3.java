package 宫水三叶.DoublePoint;

/**
 * 双指针和滑动窗口都可以，这里推荐用滑动窗口
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DB1_3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        int left = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int res = DB1_3.lengthOfLongestSubstring("dvdf");
        System.out.println(res);
    }

}
