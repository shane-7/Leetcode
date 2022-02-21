package Greed;

/** 122.买卖股票的最佳时机
 *  分析：1.只有一只股票 2.当前只有买股票或者卖的操作 3.想获得至少两天为一个交易单元
 *
 *  贪心思路：先从局部最优开始（每天所得的利润），如果某天所得的利润为非正数，则丢弃这一天
 *           全局最优：局部最优加起来就是全局最优
 *
 * @author shkstart
 * @create 2021-11-23 21:42
 */
public class Greed6_122 {
    public int maxProfit(int[] prices){
        int profit = 0;
        int sumProfit = 0;
        for(int i = 1; i < prices.length; i++){
            profit = Math.max(prices[i] - prices[i - 1], 0); //局部最优（每天所得的利润），如果某天所得的利润为非正数，则丢掉这一天
            sumProfit += profit;   //局部最优加起来就是全局最优
        }
        return sumProfit;
    }

    public static void main(String[] args) {
        Greed6_122 test = new Greed6_122();
        int[] prices = new int[]{7, 1, 5, 10, 3, 6, 4};
        int res = test.maxProfit(prices);
        System.out.println(res);
    }
}
