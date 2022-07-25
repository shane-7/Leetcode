package 考试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2022-04-19 12:26
 */
public class T1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(sc.hasNext()){
            list.add(sc.nextInt());
        }
        System.out.println(list.toString());
    }
}
