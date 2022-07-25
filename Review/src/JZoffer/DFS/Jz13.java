package JZoffer.DFS;

public class Jz13 {
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }
    public int dfs(int x, int y, int m, int n, int k){
        if(x >= m || y >= n || visited[x][y] || calNum(x) + calNum(y) > k){
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, m, n, k) + dfs(x, y + 1, m, n, k);
    }

    //计算一个数的数位和
    public int calNum(int x){
        int s = 0;
        while(x != 0){
            s += x % 10;
            x /= 10;
        }
        return s;
    }
}
