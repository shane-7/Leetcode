package String;

/**
 * @author shkstart
 * @create 2021-09-14 10:14
 */
public class String7_459 {
    public void getNext(int[] next, String s){
        next[0] = 0;
        int j = 0;
        for(int i = 1; i < s.length(); i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }
    public boolean repeatedSubstringPattern (String s){
        if(s.length() == 0){
            return false;
        }
        int[] next = new int[s.length()];
        getNext(next, s);
        int len = s.length();
        if(next[len - 1] != 0 && len % (len - next[len - 1]) == 0){
            return true;
        }

        return false;
    }

}
