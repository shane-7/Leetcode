package Everyday.April;

import javax.management.StandardEmitterMBean;

/**
 * @author shkstart
 * @create 2022-04-05 11:43
 */
public class April3_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        for(int i = 0; i < len; i++){
            int diff = letters[i] - target;
            if(diff > 0) return letters[i];
        }
        return letters[0];


//        int len = letters.length;
//        int l = 0, r = len - 1;
//        while(l < r){
//            int mid = l + (r - l) / 2;
//            if(letters[mid] > target){
//                r = mid;
//            }else {
//                l = mid + 1;
//            }
//        }
//        if(letters[r] > target) return letters[r];
//        else return letters[0];
    }

    public static void main(String[] args) {
        April3_744 test = new April3_744();
        char[] letters = {'c', 'f', 'j'};
        char target = 'y';
        char c = test.nextGreatestLetter(letters, target);
    }
}
