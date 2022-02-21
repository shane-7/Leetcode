package Greed;

/** 134.加油站。 自我总结：如果要往贪心方面想，首先要有局部最优的思维。 那么就应该把数组拆开来，一个个分析，看看怎么样才能局部最优。
 * 那么为什么一旦[i，j] 区间和为负数，起始位置就可以是j+1呢，j+1后面就不会出现更大的负数？
 *
 * 如果出现更大的负数，就是更新j，那么起始位置又变成新的j+1了。
 *
 * 而且j之前出现了多少负数，j后面就会出现多少正数，因为耗油总和是大于零的（前提我们已经确定了一定可以跑完全程）。
 *
 * rest[j] = gas[j]- cost[j]
 * 那么局部最优：当前累加rest[j]的和curSum一旦小于0，起始位置至少要是j+1，因为从j开始一定不行。全局最优：找到可以跑一圈的起始位置。
 *
 * 局部最优可以推出全局最优! 贪心思想！！！！
 * @author shkstart
 * @create 2021-11-26 19:52
 */
public class Greed11_134 {
    //暴力解法  index = (i + 1) % 这一行还不明白
    public int canCompleteCircuit_1(int[] gas, int[] cost){
        for(int i = 0; i < cost.length; i++){
            int rest = gas[i] -cost[i]; //记录剩余的油量
            int index = (i + 1) % cost.length;
            while (rest > 0 && index != i) { //模拟以i为起点行驶一圈
                rest += gas[index] - cost[index];
                index = (index + 1) % cost.length;
            }
            //如果以i为起点跑一圈，剩余油量>=0，返回该起点位置
            if(rest >= 0 && index == i) return i;
        }
        return -1;
    }

    //贪心算法：局部最优到全局最优
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for(int i = 0; i < cost.length; i++){
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];  //算总剩余的量； 总剩余量>=0是最大前提
            if(curSum < 0){    //算当前剩余的量curSum，如果<0, 则置0，从下一个索引位置开始累加；
                curSum = 0;
                start = i+ 1;
            }
        }
        //只要totalSum 是 >= 0的， 那么一定可以跑完全程。那么数组中肯定有一个索引位置开始跑一圈是>= 0的。
        // 而把curSum出现过负数的位置都给过滤掉，接下来的位置开始肯定会是正数
        if(totalSum >= 0) {
            return start;
        }
        return -1;
    }



    public static void main(String[] args) {
        Greed11_134 test = new Greed11_134();
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int res = test.canCompleteCircuit(gas, cost);
        System.out.println(res);

    }

}
