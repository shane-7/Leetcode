package 考试;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-04-20 12:28
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.equals("")) break;
            list.add(s);
        }

        System.out.println(list.toString());
    }
}
