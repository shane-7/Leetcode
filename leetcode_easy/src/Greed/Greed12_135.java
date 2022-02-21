package Greed;

/** 135.分发糖果
 *
 * 就是想不到这么巧妙的想法：先从左到右比较左孩子，再从右到左比较右孩子。 太棒了！
 * 多看看carl哥题解。太棒了！！！
 *
 * @author shkstart
 * @create 2021-11-26 21:34
 */
public class Greed12_135 {
    public int candy(int[] ratings) {
        //每人至少分得一颗糖果
        int[] candVec = new int[ratings.length];
        for(int i = 0; i < candVec.length; i++){
            candVec[i] = 1;
        }
        //从左向右比较左孩子
        for(int i = 0; i < ratings.length - 1; i++){
            if(ratings[i] < ratings[i + 1]){
                candVec[i + 1] = candVec[i] + 1;
            }
        }
        //从右向左比较右孩子
        for(int i = ratings.length - 1; i >= 1; i--){
            if(ratings[i - 1] > ratings[i]){
                candVec[i - 1] = Math.max(candVec[i - 1], candVec[i] + 1);
            }
        }

        //统计结果：
        int result = 0;
        for(int i : candVec){
            result += i;
        }
        return result;
    }
}
