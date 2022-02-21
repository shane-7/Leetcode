package com.easy;

import java.util.HashMap;
import java.util.Map;

/** 字符串转整型
 * @author shkstart
 * @create 2021-04-29 14:56
 */
public class easy8 {
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}
class Automaton{
    public int sign = 1;
    public long ans = 0;
    private  String state = "start";
    //列自动机表
    private Map<String, String[]> table = new HashMap<String, String[]>(){
        {
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
    };

    public void get(char c){
        state = table.get(state)[get_col(c)];
        if("in_number".equals(state)){
            ans = ans * 10 + c - '0';   //很妙，char型数字-减去‘0’就是本身数字整型
            ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE); //这里的负号用的很秒
        }else if("signed".equals(state)){
            sign = c == '+' ? 1 : -1;
        }
    }

    public int get_col(char c){
        if(c == ' '){
            return 0;
        }
        if(c == '+' || c == '-'){
            return 1;
        }
        if(Character.isDigit(c)){
            return 2;
        }
        return 3;
    }

}

