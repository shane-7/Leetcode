package com.easy;

import java.util.ArrayList;

/**Z字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列
 * 如输入字符串为 "PAYPALISHIRING",行数为3时，排列如下
 * P   A   H   N
   A P L S I I G
   Y   I   R
 * 也就是说输出的字符串为"PAHNAPLSIIGYIR"
 *
 * 本题要熟知 ArrayList 和 StringBuilder的用法
 * * @author shkstart
 * @create 2021-04-22 23:48
 */
public class easy6 {
    public String convert(String s, int numRows){
        if(numRows == 1) return s;                    //特殊情况：只有1行时则可直接返回字符串
        ArrayList<StringBuilder> rows = new ArrayList<>();   //此处适用StringBuilder存放字符，并根据行数或者字符个数(当然，大多数情况都是字符个数大于行数)
                                                                      // 决定创建多少个StringBuilder
        for(int i = 0; i < Math.min(numRows, s.length()); i++){
            rows.add(new StringBuilder());
        }
        int currow = 0;
        boolean reverse = false;       //当我们向上移动到最上面的行或向下移动到最下面的行时，需要这样一个方向返回标志

        for(char c : s.toCharArray()){
            rows.get(currow).append(c);
            if(currow == 0 || currow == numRows - 1){
                reverse = ! reverse;
            }
            if(reverse == true){    //这个判断属实punchline
                currow++;
            }else{
                currow--;
            }
        }

        //用一个新的StringBuillder将上面的rows，按每行记录的字符一行一行地遍历出来
        StringBuilder ret = new StringBuilder();
        for(StringBuilder row : rows){
            ret.append(row);
        }
        return ret.toString();

    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        easy6 test = new easy6();
        String  result = test.convert(s, 3);
        System.out.println(result);
    }

}
