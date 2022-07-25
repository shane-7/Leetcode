package 宫水三叶.DFS;

/**
 * @author shkstart
 * @create 2022-05-15 20:15
 */
public class dfs14_不同路径 {
    int res = 0;
    public int uniquePaths(int m, int n) {

        dfs(1, 1, m, n);
        return res;
    }

    public void dfs(int rowC, int colC, int m, int n){
        if(rowC > m || colC > n){
            return;
        }

        if(rowC == m && colC == n){
            res++;
            return;
        }
        dfs(rowC + 1, colC,m, n);
        dfs(rowC, colC + 1, m, n);
    }

    public static void main(String[] args) {
        dfs14_不同路径 test = new dfs14_不同路径();
        int res = test.uniquePaths(3, 7);
        System.out.println(res);
    }
}
