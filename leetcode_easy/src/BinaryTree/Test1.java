package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-11-18 12:29
 */
public class Test1 {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(1);
        path.add(2);
        path.add(3);

        path.remove(path.size() - 1);
        result.add(path);
        System.out.println(path.toString());
        System.out.println(result.toString());

    }


}
