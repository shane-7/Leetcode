package com.easy;

/**
 * @author shkstart
 * @create 2021-04-29 10:46
 */
public class easy7 {
    public double reverse(int x){
        int x1 = 0;
        if(x < 0){
            x1 = -x;
        }else{
            x1 = x;
        }
        String s = String.valueOf(x1);
        int len = s.length();
        int exp = len;
        double result1 = 0;
        int result = 0;

        for(int i = exp - 1; i >= 0; i--){
            result1 += remainder(x1) * Math.pow(10, i);
            x1 = x1 / 10;
        }

        if(x < 0){
            result1 = -result1;
        }

        if(result1 < -Math.pow(2,31) || result1 > Math.pow(2, 31) - 1){
            return 0;
        }

        return result = (int)result1;
    }

    public double remainder(int x){
        return x % Math.pow(10, 1);
    }

    public static void main(String[] args) {
        easy7 test1 = new easy7();
        System.out.println(test1.reverse(-123));
    }
}
