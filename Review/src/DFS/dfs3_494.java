package DFS;

import com.sun.deploy.security.CachedCertificatesHelper;
import java.util.HashMap;
import java.util.Map;

/**
 * 目标和：记忆化搜索
 */
public class dfs3_494 {
    public int findTargetSumWays(int[] nums, int t){
        return dfs(nums, t, 0, 0);
    }
    Map<String, Integer> cache = new HashMap<>();
    int dfs(int[] nums, int target, int u, int cur){
        String key = u + "_" + cur;
        if(cache.containsKey(key)) return cache.get(key);
        if(u == nums.length){
            cache.put(key, cur == target? 1 : 0);
            return cache.get(key);
        }
        int left = dfs(nums, target, u + 1, cur + nums[u]);
        int right = dfs(nums, target, u + 1, cur - nums[u]);
        cache.put(key, left + right);
        return cache.get(key);
    }
}
