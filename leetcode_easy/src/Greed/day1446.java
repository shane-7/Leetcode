package Greed;

/**
 * @author shkstart
 * @create 2021-12-01 10:38
 */
public class day1446 {
    public int maxPower(String s){
        int count = 1;
        int maxCount = 1;
        char c0 = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            char c1 = s.charAt(i);
            if (c1 == c0) {
                count++;
            }else{
                count = 1;
            }
            c0 = c1;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
