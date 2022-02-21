package HashMap;

/**
 * @author shkstart
 * @create 2021-08-16 9:18
 */
public class HashMap1_242 {
    public boolean isAnagram(String s, String t){
        int[] record = new int[26];
        for(char c : s.toCharArray()){
            record[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            record[c - 'b']--;
        }

        for(int i = 0; i < 26; i++){
            if(record[i] != 0){
                return false;
            }
        }
        return true;
    }


}
