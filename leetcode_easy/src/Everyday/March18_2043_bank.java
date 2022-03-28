package Everyday;

/**2043.简易银行系统(中等)
 * @author shkstart
 * @create 2022-03-18 11:32
 */
public class March18_2043_bank {

    long[] bank;
    public March18_2043_bank(long[] balance) {
        bank = balance;
    }

    boolean check(int account){
        return 1 <= account && account <= bank.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(bank[account1 - 1] >= money){
            bank[account1 - 1] -= money;
            bank[account2 - 1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        bank[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(bank[account - 1] >= money){
            bank[account - 1] -= money;
            return true;
        }
        return false;
    }
}

