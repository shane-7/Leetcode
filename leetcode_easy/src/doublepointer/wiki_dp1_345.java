package doublepointer;

import sun.security.rsa.RSAUtil;

/** 345.反转字符串中元音字母
 *  //双指针+哈希表
 * @author shkstart
 * @create 2022-04-02 13:42
 */
public class wiki_dp1_345 {
    static boolean[] hash = new boolean[128];
    static char[] vowels = {'a','e','i','o','u'};
    static {
        for(char c : vowels){
            hash[c - ' '] = hash[Character.toUpperCase(c) - ' '] = true;
        }
    }
    public String reverseVowels(String s){
        char[] chars = s.toCharArray();
        int n = s.length();
        int i = 0, j = n - 1;
        while(i < j){
            if(hash[chars[i]] && hash[chars[j]]){
                swap(chars, i, j);
            }else {
                if(!hash[chars[i]]){
                    i++;
                }
                if(!hash[chars[j]]){
                    j--;
                }
            }
        }
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }



}
