package HashMap;

/**  383.赎金信
 * @author shkstart
 * @create 2021-08-29 10:02
 */
public class HashMap7_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        int temp;
        for(int i = 0; i < magazine.length(); i++){
            temp = magazine.charAt(i) - 'a';
            arr[temp]++;
        }

        for(int i = 0; i < ransomNote.length(); i++){
            temp = ransomNote.charAt(i) - 'a';
            if(arr[temp] > 0){
                arr[temp]--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "aa", B = "ab";
        HashMap7_383 test = new HashMap7_383();
        boolean res = test.canConstruct(A, B);
        System.out.println(res);

    }
}
