package JZoffer;

public class jz001 {
    public static int divide(int a, int b) {

        if(a == Integer.MIN_VALUE && b == -1){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if(a * b < 0) {
            sign = -1;
        }
        if(a > 0){
            a = -a;
        }
        if(b > 0) b = -b;

        int res = 0;
        while(a <= b){
            a -= b;
            res++;
        }


        return sign == -1 ? -res : res;
    }

    public static void main(String[] args) {
        int ans = jz001.divide(-20, 5);
        System.out.println(ans);
    }
}
