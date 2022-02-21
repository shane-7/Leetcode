package test;

/** 122.买卖股票的最佳时机
 * @author shkstart
 * @create 2021-11-24 11:26
 */
public class Greed6 {
    public int maxProfit(int[] prices){
        int res = 0;
        int diff = 0;
        for(int i = 0; i < prices.length; i++){
            diff = Math.max(prices[i + 1] - prices[i], 0);
            res += diff;

        }
        return res;
    }

}
