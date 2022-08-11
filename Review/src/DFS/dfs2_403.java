package DFS;

import java.util.HashMap;
import java.util.Map;

//青蛙过河 记忆化递归
public class dfs2_403 {

    Map<Integer, Integer> map = new HashMap<>();
    Map<String, Boolean> cache = new HashMap<>();
    public boolean canCross(int[] stones) {
        int n = stones.length;
        for(int i = 0; i < n; i++){
            map.put(stones[i], i);
        }
        //check first step
        if(!map.containsKey(1)) return false;
        return dfs(stones, n, 1, 1);
    }

    /**
     * 判定是否能够跳到最后一块石子
     * @param stones 石子列表【不变】
     * @param n  石子列表长度【不变】
     * @param u  当前所在的石子的下标
     * @param k  上一次是经过多少步跳到当前位置的
     * @return 是否能跳到最后一块石子
     */
    boolean dfs(int[] stones, int n, int u, int k){
        String key = u + "_" + k;
        if(cache.containsKey(key)) return cache.get(key);
        if(u == n - 1) return true;
        for(int i = -1; i <= 1; i++){
            if(k + i == 0) continue;
            int next = stones[u] + k + i;
            if(map.containsKey(next)){
                boolean cur = dfs(stones, n, map.get(next), k + i);
                cache.put(key, cur);
                if(cur) return true;
            }
        }
        cache.put(key, false);
        return false;
    }
}
