package com.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.电话号码字母组合
 * 这里主要用到一种回溯的操作
 *
 * @author shkstart
 * @create 2021-05-29 15:44
 */
public class mid17 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits.length() == 0){
            return combinations;
        }
        StringBuilder combination = new StringBuilder();
        HashMap<Character, String> sites = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, sites, digits, 0, combination);
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for(int i = 0; i < lettersCount; i++){
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);  //这行很吊！在每次循环中，把尾巴剪掉！
            }
        }
    }

    public static void main(String[] args) {
        mid17 test = new mid17();
        String digits = "23";
        List<String> combinations = new ArrayList<String>();
        combinations = test.letterCombinations(digits);
        for(int i = 0; i < combinations.size(); i++){
            System.out.println(combinations.get(i));
        }
    }
}
