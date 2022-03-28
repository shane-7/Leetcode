package Everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-11 0:02
 */
public class March11_2049 {
    long maxScore = 0;
    int cnt = 0;
    int n;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }

        //构图法
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfs(0);
        return cnt;
    }

    public int dfs(int node) {
        long score = 1;
        int size = n - 1;
        for (int c : children[node]) {
            int t = dfs(c);
            score *= t;
            size -= t;
        }
        if (node != 0) {
            score *= size;
        }
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return n - size;
    }


    public static void main(String[] args) {
        int[] parents = new int[]{-1,2,0,2,0};

        March11_2049 test = new March11_2049();
        int res = test.countHighestScoreNodes(parents);
        System.out.println(res);
    }
}
