package com.easy;

/**
 * @author shkstart
 * @create 2021-05-13 10:12
 */
public class mid12 {
    int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] RomanNum = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public String intToRoman(int num){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < value.length && num >= 0; i++){
            while(num >= value[i]){
                str.append(RomanNum[i]);
                num = num - value[i];
            }
        }
        return str.toString();  //stringBuilder要调用toStirng() 方法

    }

    public static void main(String[] args) {
        mid12 test = new mid12();
        int num = 3788;
        System.out.println(test.intToRoman(num));
    }
}
