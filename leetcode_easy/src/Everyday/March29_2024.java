package Everyday;

/**
 * @author shkstart
 * @create 2022-03-29 9:29
 */

//此方法原理：如getCnt('T')是对字符串中的 T 进行操作后，计算滑动窗口大小(F的数量)
public class March29_2024 {
    String s;
    int n, h;
    public int maxConsecutiveAnswers(String answerKey, int k) {
        s = answerKey;
        n = s.length();
        h = k;
        return Math.max(getCnt('T'), getCnt('F'));
    }

    public int getCnt(char c){
        int ans = 0;
        for(int i = 0, j = 0, cnt = 0; i < n; i++){
            if(s.charAt(i) == c) cnt++;
            while(cnt > h){
                if(s.charAt(j) == c){
                    cnt--;
                }
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String ans = "TTFTTFTT";
        int k = 1;
        March29_2024 test = new March29_2024();
        int res = test.maxConsecutiveAnswers(ans, k);
        System.out.println(res);
    }
}
