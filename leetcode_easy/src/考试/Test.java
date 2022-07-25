package 考试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2022-04-19 15:56
 */
public class Test {
    private int Exchange1(int num){
        if(num == 0) return 0;
        int cola = num / 3;
        int res = cola;
        int Empty = num % 3 + cola;
        while(Empty / 3 != 0){
            cola = Empty/3;
            res += cola;
            Empty = Empty % 3 + cola;
        }
        if(Empty == 2)res++;
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int[] nums = new int[amount];
        for(int i = 0; i < amount; i++){
            nums[i] = sc.nextInt();
        }
        int targetIndex = sc.nextInt();
        System.out.println(amount);
        System.out.println(Arrays.toString(nums));
        System.out.println(targetIndex);

    }
}
