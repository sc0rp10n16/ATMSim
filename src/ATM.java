public class ATM {
    private int balance_10 = 0;
    private int balance_20 = 0;
    private int balance_50 = 0;
    private int balance;

    //default constructor
    public ATM() {

    }

    // Getter setter


    public int getBalance_20() {
        return balance_20;
    }

    public void setBalance_20(int balance_20) {
        this.balance_20 = balance_20;
    }

    public int getBalance_10() {
        return balance_10;
    }

    public void setBalance_10(int balance_10) {
        this.balance_10 = balance_10;
    }

    public int getBalance_50() {
        return balance_50;
    }

    public void setBalance_50(int balance_50) {
        this.balance_50 = balance_50;
    }

    public int getBalance() {
        balance = balance_10 * 10 + balance_20 * 20 + balance_50 * 50;
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}