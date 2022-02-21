package com.easy;

import java.util.HashMap;

/**无重复字符的最长子串
 * 此题用到了滑动窗口
 *
 * @author shkstart
 * @create 2021-04-15 15:29
 */
public class easy3 {
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0){
            return 0;
        }                                                                      //key: 字符， value：字符在s的索引
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();   //创建hashmap对象，hashmap类似集合,其中元素是无序的
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){         //string.chartAt(i)是，返回字符串中第i个元素，HashMap.containsKey()判断前面返回的元素在
                                                      //hashmap中是否有对应的键
                left = Math.max(left, map.get(s.charAt(i)) + 1);   //HashMap.get(key)返回对应键的键值，也就是对应字符在字符串s中的索引
            }
            map.put(s.charAt(i), i);     //HashMap.put(key, value);
            max = Math.max(max, i - left + 1);  //更新max值
        }
    return max;
    }


    public static void main(String[] args) {
        String s = new String("abba");
        int result = 0;
        easy3 e = new easy3();
        result = e.lengthOfLongestSubstring(s);
        System.out.println("result = " + result );
    }
}
