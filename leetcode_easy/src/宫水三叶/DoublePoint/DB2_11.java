package 宫水三叶.DoublePoint;

import com.easy.Maximum_sub_column_sum;
import java.util.NavigableMap;

/**
 * 盛最多水的容器
 */
public class DB2_11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right){
            if(height[left] < height[right]){
                res = Math.max(res, (right - left) * height[left++]);
            }else {
                res = Math.max(res, (right - left) + height[right--]);
            }
        }
        return res;
    }

}
