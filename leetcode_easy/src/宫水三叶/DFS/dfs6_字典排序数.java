package 宫水三叶.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-05-01 0:02
 */
public class dfs6_字典排序数 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for(int i = 1; i <= 9; i++){
            dfs(i, n);
        }
        return res;
    }

    void dfs(int cur, int limit){
        if(cur > limit){
            return;
        }
        res.add(cur);
        for(int i = 0; i <= 9; i++){
            if(cur * 10 + i > limit){
                break;
            }
            dfs(cur * 10 + i, limit);
        }
    }

    public static void main(String[] args) {
        dfs6_字典排序数 test = new dfs6_字典排序数();
        List<Integer> res = test.lexicalOrder(13);
        System.out.println(res);
    }
}
