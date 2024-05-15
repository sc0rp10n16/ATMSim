import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATMOperationInterface operation = new ATMOperations();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Deposit\n2. Withdraw\n3. Display Balance\n4. Mini Statement\n5. Exit"); //Take user input
            System.out.print("Select an option:");
            int option = sc.nextInt();
            switch (option){
                case 1: // Runs Deposit method
                    System.out.println("Enter ccy denominations to deposit, terminated by. e.g., 10 20 50 .");
                    sc.nextLine();
                    String input = sc.nextLine();
                    operation.depositAmount(input);
                    break;
                case 2: // Runs Withdraw method
                    System.out.println("Enter amount to withdraw");
                    int amount = sc.nextInt();
                    operation.withdrawAmount(amount);
                    break;
                case 3: // Runs Balance method
                    operation.viewBalance();
                    break;
                case 4: //Runs Mini Statement method
                    operation.viewMiniStatement();
                    break;
                case 5:
                    System.out.println("Have a good day!");
                    System.exit(0);
            }
        }
    }
}