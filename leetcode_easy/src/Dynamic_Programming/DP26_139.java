package Dynamic_Programming;

import java.util.List;

/**  139.单词拆分
 * @author shkstart
 * @create 2021-12-20 8:32
 */
public class DP26_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //1.确定dp数组以及下标的含义：
        //dp[i]:字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词

        //2.确定递推公式：
        //如果dp[j]是true 且 [j, i]这个区间的子串出现在字典里，那么dp[i]一定是true。 (j < i)

        //3.dp数组如何初始化
        //dp[i]的状态依靠着dp[j]是否为true，那么dp[0]就是递归的根基，所以dp[0]一定为true
        boolean[]  dp = new boolean[s.length() + 1];
        dp[0] = true;
        //4.确定遍历顺序
        //先背包后物品
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String word = s.substring(j, i - j);
                if(wordDict.contains(word) && dp[j] == true) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
