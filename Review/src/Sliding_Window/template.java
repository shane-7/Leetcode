package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

/*
    最小覆盖字串模板
 */
public class template {
    public String minWindow(String s, String t){
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        //记录最小覆盖字串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()){
            //c 是即将移入窗口的字符
            char c = s.charAt(right);
            //扩大窗口
            right++;
            //进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            //判断左侧窗口是否要收缩
            while(valid == need.size()){
                //在这里更新最小覆盖字串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //d 是将移除窗口的字符
                char d = s.charAt(left);
                //缩小窗口
                left++;
                //进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        //返回最小覆盖字串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
