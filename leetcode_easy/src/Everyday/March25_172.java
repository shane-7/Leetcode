package Everyday;

/** 172.阶乘后的零
 *    题解：
 *   https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
 *
 *   本题考的是分析问题的能力
 * @author shkstart
 * @create 2022-03-25 10:21
 */
public class March25_172 {
    public int trailingZeroes(int n){
        int count = 0;
        while(n > 0){
            count += n / 5;
            //对n进行降维
            n = n / 5;
        }
        return count;
    }

}
