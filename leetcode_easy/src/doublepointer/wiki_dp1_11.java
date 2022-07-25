package doublepointer;

import java.util.HashMap;
import java.util.Map;

/** 11.盛最多水的容器
 *  //双指针+哈希表
 * @author shkstart
 * @create 2022-04-02 13:42
 */
public class wiki_dp1_11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int res = 0;
        while (i < j) {
            Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
