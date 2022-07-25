package 宫水三叶.DFS;

/**
 * @author shkstart
 * @create 2022-05-01 8:50
 */
public class dfs7_整数替换 {
    int num = 0;
    public int integerReplacement(int n) {
        long temp = n;
        dfs(temp);
        return num;
    }
    void dfs(long temp){
        if(temp == 1){
            return;
        }

        //为奇数
        if(temp % 2 != 0){
            if((temp + 1) % 4 == 0){
                temp = temp + 1;
                if(temp == 4) {
                    temp = 2;
                }
            }else {
                temp = temp - 1;
            }
            num++;
            dfs(temp);
        }else{
            //为偶数
            temp = temp / 2;
            num++;
            dfs(temp);
        }
    }

    public static void main(String[] args) {
        dfs7_整数替换 test = new dfs7_整数替换();
        int res = test.integerReplacement(2147483647);
        System.out.println(res);
    }
}
