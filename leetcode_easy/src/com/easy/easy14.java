package com.easy;


/**最长公共前缀
 * @author shkstart
 * @create 2021-05-17 9:00
 */
public class easy14 {
    public String longestCommonPrefix(String[] strs){
        int minlen = strs[0].length();
        boolean result = true;

        //得出数组中，字符最短的str
        for(int i = 1; i < strs.length; i++){
            minlen = Math.min(strs[i].length(), minlen);
        }
        StringBuffer s1 = new StringBuffer();


        for(int i = 0; i < minlen; i++){
            result = isEqual(strs, i);
            if(result == false){
                break;
            }
            s1.append(strs[1].charAt(i));
        }
        if(s1.length() == 0){
            return "";
        }

        return s1.toString();
    }


    //方法isEqua：判断数组中的每个string中的第j个字符是否相等
    public boolean isEqual(String[] strs, int j){
        boolean is1 = true;
        for(int i = 0; i + 1 < strs.length; i++){
            if(strs[i].charAt(j) != strs[i + 1].charAt(j)){
                is1 = false;
                break;
            }
        }
        return is1;
    }

}
