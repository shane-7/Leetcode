package 宫水三叶.DP.beibao_wanquan;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class DP5_单词分隔 {
    //1.动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]:字符串长度为i的话，dp[i]为true,表示可以拆分为一个或多个在字典中出现的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length(); i++){
            for(int j = 0; j < i; j++){
                //递推公式
                if(wordDict.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    //回溯法
    private Set<String> set;
    private int[] memo;
    public boolean wordBreak1(String s, List<String> wordDict) {
        memo = new int[s.length()];
        set = new HashSet<>(wordDict);
        return backtracking(s, 0);
    }

    public boolean backtracking(String s, int startIndex) {
        // System.out.println(startIndex);
        if (startIndex == s.length()) {
            return true;
        }
        if (memo[startIndex] == -1) {
            return false;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            // 拆分出来的单词无法匹配
            if (!set.contains(sub)) {
                continue;
            }
            boolean res = backtracking(s, i + 1);
            if (res) return true;
        }
        // 这里是关键，找遍了startIndex~s.length()也没能完全匹配，标记从startIndex开始不能找到
        memo[startIndex] = -1;
        return false;
    }


}
