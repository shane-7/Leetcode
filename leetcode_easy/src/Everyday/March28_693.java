package Everyday;



/** 693.交替位二进制数
 * @author shkstart
 * @create 2022-03-28 8:22
 */
public class March28_693 {
    public boolean hasAlternatingBits(int n) {
        //或运算：相同为0，不同为1
        int cur = -1;
        while(n >= 1){
            int u = (n & 1);
            if((cur ^ u) == 0) return false;
            cur = u;
            n >>= 1;
        }
        return true;
    }

    //巧法:
    public boolean hasAlternatingBits1(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }

}
