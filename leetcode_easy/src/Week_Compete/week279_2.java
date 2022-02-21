package Week_Compete;

import java.util.*;

/** 6001.
 *  方法：用数组下标的 0 - 10 来进行排序和统计
 * @author shkstart
 * @create 2022-02-06 12:22
 */
public class week279_2 {
    public long smallestNumber(long num) {

        List<Integer> res = new ArrayList<>();

        boolean isNegative = false;
        if(num < 0) {
            isNegative = true;
        }

        //统计每个数字出现的频率
        int[] digits = new int[10];
        long num_abs = Math.abs(num);
        while(num_abs != 0){
            digits[(int)(num_abs % 10)]++;
            num_abs /= 10;
        }
        System.out.println(Arrays.toString(digits));

        //如果是正数
        if(!isNegative){
            //如果有0
            if(digits[0] > 0){
                //找一个最小的数在前面
                int x = 1;
                while(x < 10){
                    if(digits[x] == 0){
                        x++;
                    }else {
                        break;
                    }
                }
                res.add(x);
                digits[x]--;
                //把0都放前面
                for(int i = 0; i < digits[0]; i++){
                    res.add(0);
                }

                while(x < 10){
                    for(int i = 0; i < digits[x]; i++){
                        res.add(x);
                    }
                    x++;
                }
            }else { //如果没有0
                for(int x = 1; x < 10; x++){
                    for(int i = 0; i < digits[x]; i++){
                        res.add(x);
                    }
                }
            }
        }else {
        //如果是负数
            for(int x = 9; x > -1; x--){
                for(int i = 0; i < digits[x]; i++){
                    res.add(x);
                }
            }
        }

        //把数组转换为数字
        long res_sum = 0;
        for(int i : res){
            res_sum = res_sum * 10 + i;
        }

        if(isNegative){
            return -res_sum;
        }else {
            return res_sum;
        }

    }



    public static void main(String[] args) {
        week279_2 test = new week279_2();
        long num = -504;
        long res = test.smallestNumber(num);
        System.out.println(res);

    }
}
