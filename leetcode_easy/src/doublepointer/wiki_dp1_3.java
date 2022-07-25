package doublepointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 3.无重复字符的最长子串
 *  //双指针+哈希表
 * @author shkstart
 * @create 2022-04-02 13:42
 */
public class wiki_dp1_3 {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int maxCnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(; end < s.length(); end++){
            char right = s.charAt(end);
            map.put(right, map.getOrDefault(right, 0) + 1);
            while (map.get(right) > 1){
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                start++;
            }
            maxCnt = Math.max(end - start + 1, maxCnt);
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        wiki_dp1_3 test = new wiki_dp1_3();
        String s = "abcabcbb";
        int res = test.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
