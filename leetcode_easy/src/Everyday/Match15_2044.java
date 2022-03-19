package Everyday;

/**
 * @author shkstart
 * @create 2022-03-16 8:24
 */

//核心思想：二进制枚举!!!,很妙！要记住！
    // 其实就是翻牌子， 是1就选 0就不选

//位或 运算符 ‘|’

public class Match15_2044 {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length, max = 0, res = 0;
        int mask = 1 << n;

        for(int s = 0; s < mask; s++){
            int cur = 0;
            for(int i = 0; i < n; i++){
                if(((s >> i) & 1) == 1) cur = cur | nums[i];
            }
            if(cur > max){
                max = cur;
                res = 1;
            }else if(cur == max){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5};
        Match15_2044 test = new Match15_2044();
        int res = test.countMaxOrSubsets(nums);
        System.out.println(res);
    }
}
