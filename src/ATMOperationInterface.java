import java.util.Scanner;

public interface ATMOperationInterface {
    public void depositAmount(String deposit);
    public void withdrawAmount(Integer withdraw);
    public void viewBalance();
    public void viewMiniStatement();

}
