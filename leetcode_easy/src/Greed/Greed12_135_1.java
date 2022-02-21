package Greed;

/** 135.分发糖果
 *
 * @author shkstart
 * @create 2021-11-29 18:42
 */
public class Greed12_135_1 {
    public int candy(int[] ratings){
        //先创建每个孩子分发糖果的数组
        int[] candies = new int[ratings.length];
        for(int i = 0; i < candies.length; i++){
            candies[i] = 1;
        }
        //先从前向后发，局部最优：只要右边评分比左边大，右边的孩子就多发一个糖果
        for(int i = 0; i < ratings.length - 1; i++){
            if(ratings[i] < ratings[i + 1]){
                candies[i + 1] = candies[i] + 1;
            }
        }

        //再从后往前出发，局部最优：只要左边评分比右边大，左边孩子就多发一个糖果
        for(int i = ratings.length - 1; i > 0; i++){
            if(ratings[i - 1] > ratings[i]){
                candies[i - 1] = candies[i] + 1;
            }
        }

        //统计结果
        int res = 0;
        for(int i : candies){
            res += i;
        }

        return res;
    }
}
