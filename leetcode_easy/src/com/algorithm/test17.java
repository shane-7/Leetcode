package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-06-30 20:23
 */
public class test17 {
    public List<String> letterCombinations(String digits){
        List<String> combinations = new ArrayList<>();
        if(digits.length() == 0){
            return combinations;
        }
        StringBuilder combination = new StringBuilder();
        HashMap<Character, String> phoneMap = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, combination);
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String>phoneMap, String digits, int index, StringBuilder combination) {
        if(index == digits.length()){
            combinations.add(combination.toString());
        }
        else{
            Character digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for(int i = 0; i < letters.length(); i++){
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }

    }

    public static void main(String[] args) {
        test17 test = new test17();
        String digits = "24";
        List<String> combinations = test.letterCombinations(digits);
        for(int i = 0; i < combinations.size(); i++){
            System.out.println(combinations.get(i));
        }

    }

}
