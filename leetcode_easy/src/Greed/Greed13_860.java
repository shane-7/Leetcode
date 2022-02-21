package Greed;

/** 860. 柠檬水找零
 *   bills[]开头只能是5
 *   5 找零钱是万能的
 *   10 找钱需消耗一个5，且找20有用，找10和5是没用的
 *   20 一点都没有。
 *
 *   在找20的零钱时格外注意：有10的话，先把10找出去，而不应该把3张5用掉，5的用处大。
 *                         如果没有10的话，再找3张5；
 *
 *
 * @author shkstart
 * @create 2021-11-26 22:36
 */
public class Greed13_860 {
    int fiveCount = 0;
    int tenCount = 0;
    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0 || bills == null) return true;
        if(bills[0] != 5) return false;

        fiveCount++;
        for(int i = 1; i < bills.length; i++){
            if(bills[i] == 5) fiveCount++;
            if(bills[i] == 10) {
                fiveCount--;
                tenCount++;
            }
            if(bills[i] == 20) {    //当收到的面值为20时，处理的时候
                if(tenCount >= 1){
                    fiveCount--;
                    tenCount--;
                }else{
                    fiveCount -=3;
                }
            }
            if(fiveCount < 0 || tenCount < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Greed13_860 test = new Greed13_860();
        int[] bills = {5, 5, 20, 5, 5, 10, 5, 10, 5, 20};
        boolean res = test.lemonadeChange(bills);
        System.out.println(res);
    }
}
