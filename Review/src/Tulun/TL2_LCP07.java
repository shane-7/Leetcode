package Tulun;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TL2_LCP07 {
    /*
    BFS解法
     */
    public static int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] r : relation){
            int a = r[0], b = r[1];
            Set<Integer> s = map.getOrDefault(a, new HashSet<>());
            s.add(b);
            map.put(a, s);
        }
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        while (!d.isEmpty() && k-- > 0){
            int size = d.size();
            while (size -- > 0){
                int poll = d.pollFirst();
                Set<Integer> es = map.get(poll);
                if(es == null) continue;
                for(int next : es){
                    d.addLast(next);
                }
            }
        }
        int ans = 0;
        while (!d.isEmpty()){
            if(d.pollFirst() == n - 1) ans++;
        }
        return ans;

    }

    /*
    DFS解法
     */
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int n1, k1, ans;
    public int numWays1(int n, int[][] rs, int k) {
        n1 = n; k1 = k;
        for(int[] r : rs){
            int a = r[0], b = r[1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
        }
        dfs(0, 0);
        return ans;
    }
    void dfs(int timeCount, int curNum){
        if(timeCount == k1){
            if(curNum == n1 - 1) ans++;
            return;
        }
        Set<Integer> es = map.get(curNum);
        if(es == null){
            return;
        }
        for(int i : es){
            dfs(timeCount + 1, i);
        }
    }


    public static void main(String[] args) {
        int res = TL2_LCP07.numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3);
        System.out.println(res);

    }
}
