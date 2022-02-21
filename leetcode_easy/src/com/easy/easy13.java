package com.easy;

import java.util.HashMap;
import java.util.Map;

/**罗马转整数
 *
 * @author shkstart
 * @create 2021-05-13 10:55
 */
public class easy13 {

    public int romanToInt(String s){
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for(int i = 0; i < s.length();) {
            //重点：要对字符个数进行分类讨论（1个还是2个）
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {   //这里的 i+1 < s.lengh() 是为了判断 s 是否为单个字符
                ans += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        easy13 test = new easy13();
        String s = "MMMDCCLXXXVIII";
        int res = test.romanToInt(s);
        System.out.println(res);
    }

}
