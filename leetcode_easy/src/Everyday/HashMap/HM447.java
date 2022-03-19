package Everyday.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-03-14 17:10
 */
public class HM447 {
    public int numberOfBoomerangs(int[][] points) {
        // 与 [1, 0] 距离为1的点有2个: [0, 0] 和 [2, 0]
        // 然后我们再遍历每一条边的统计信息:
        // 即在相同长度的边中挑选2条即可, 注意因为要考虑顺序, 所以挑选不能用组合的C(n, 2), 要用排列的A(n, 2)
        // A(n, 2) = n * (n - 1)  ..这里解决了为什么下面是 cnt * (cnt - 1)
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
                int dist = x * x + y * y;
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int dist : map.keySet()) {
                int cnt = map.get(dist);
                ans += cnt * (cnt - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] point = new int[3][2];
        int a = 0;
        for(int i = 0; i < point.length; i++){
            point[i][0] = a++;
        }
        HM447 test = new HM447();
        int res = test.numberOfBoomerangs(point);

    }
}
