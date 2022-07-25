package Everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-31 9:09
 */
public class March31_728 {
    public List<Integer> selfDividingNumbers(int left, int right){
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(isDivid(i)) res.add(i);
        }
        return res;
    }
    public boolean isDivid(int num){
        int testNum = num;
        while(testNum > 0){
            int temp = testNum % 10;
            if(temp == 0 || num % temp != 0) return false;
            testNum /= 10;
        }
        return true;
    }

}
