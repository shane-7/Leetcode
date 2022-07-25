package Array.DoublePoint;

/*
最长回文子串， mid。中心思想：回文串的长度可能是奇数也可能是偶数，
                 解决的问题的核心是：从中心向两端扩散的双指针技巧
 */
public class DB6_5 {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            //以s[i]为中心的最长回文字串
            String s1 = palindrome(s, i, i);
            //以s[i], s[i + 1]为中心的最长回文字串
            String s2 = palindrome(s, i, i + 1);
            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
        }
        return ans;

    }

    String palindrome(String s, int l, int r){
        //防止数组越界
        while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            //双指针，向两边展开
            l--;
            r++;
        }
        //返回s[l]和s[r]为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
