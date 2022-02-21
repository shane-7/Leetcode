package String;

/** 28. 用到了KMP算法
 * @author shkstart
 * @create 2021-09-13 11:41
 */
public class String6_28 {
    public void getNext(int[] next, String s){

        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    public int str(String haystack, String needle){
        if(needle.length() == 0){
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String6_28 test = new String6_28();
        String haystack = "aabaabaaf";
        String needle = "aabaaf";
        int res = test.str(haystack, needle);
        System.out.println(res);

    }
}
