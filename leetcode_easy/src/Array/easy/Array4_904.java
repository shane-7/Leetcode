package Array.easy;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2021-07-29 20:32
 */
public class Array4_904 {
        public int totalFruit(int[] tree) {
            int ans = 0, i = 0;
            Counter count = new Counter();
            for (int j = 0; j < tree.length; ++j) {
                count.add(tree[j], 1);
                while (count.size() >= 3) {
                    count.add(tree[i], -1);
                    if (count.get(tree[i]) == 0)
                        count.remove(tree[i]);
                    i++;
                }

                ans = Math.max(ans, j - i + 1);
            }

            return ans;
        }

    public static void main(String[] args) {
        Array4_904 test = new Array4_904();
        int[] nums = {1, 1, 2, 2, 3, 4};
        int res = test.totalFruit(nums);
        System.out.println(res);

    }

}

class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k, int v) {
        put(k, get(k) + v);
    }
}
