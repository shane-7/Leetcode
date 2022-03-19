package Everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-13 9:04
 */
public class Match13_393 {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; ) {
            int t = data[i], j = 7;
            //从最高位 计算连续有多少个1
            while (j >= 0 && (((t >> j) & 1) == 1)) j--;
            int cnt = 7 - j;
            if (cnt == 1 || cnt > 4) return false;
            if (i + cnt - 1 >= n) return false;
            for (int k = i + 1; k < i + cnt; k++) {
                if ((((data[k] >> 7) & 1) == 1) && (((data[k] >> 6) & 1) == 0)) continue;
                return false;
            }
            //最高位为0
            if (cnt == 0) i++;
            else i += cnt;
        }
        return true;
    }

    public static void main(String[] args) {
        Match13_393 test = new Match13_393();
        int[] data = {228,189,160,229,165,189,13,10};
//        boolean res = test.validUtf8(data);
//        System.out.println(res);
        boolean res = test.validUtf8(data);
        System.out.println(res);
    }
}
