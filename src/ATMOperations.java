import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ATMOperations implements ATMOperationInterface{
    ATM atm = new ATM();
    Map<String,String> miniStatement = new HashMap<>();
    @Override
    public void depositAmount(String deposit) {
        int creditAmount=0;
        int count_10 = 0;
        int count_20 = 0;
        int count_50 = 0;
        LocalDateTime depositTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDepositTime = depositTime.format(myFormatObj);

        String[] denominations = deposit.split(" ");
        creditAmount = 0;
        for(String denominationstr: denominations){
            if (denominationstr.equals(".")) {
                break;
            }
            int denomination = Integer.parseInt(denominationstr);
            if (denomination == 10 || denomination == 20 || denomination == 50){
                creditAmount = creditAmount+denomination;
                switch (denomination){
                    case 10:
                        atm.setBalance_10(atm.getBalance_10()+1);
                        break;
                    case 20:
//                        creditAmount=+20;
                        atm.setBalance_20(atm.getBalance_20()+1);
                        break;
                    case 50:
//                        creditAmount=+50;
                        atm.setBalance_50(atm.getBalance_50()+1);
                        break;
                }
                System.out.println("Accepted: "+denomination+"₹");

            }
            else{
                System.out.println("Invalid denomination:"+denomination);
            }
        }
//        creditAmount = count_10*10 + count_20*20 + count_50*50;

        String depositStatement = "Credit\t"+creditAmount+".0\t"+atm.getBalance()+".0\t";
        miniStatement.put(formattedDepositTime,depositStatement);

    }

    @Override
    public void withdrawAmount(Integer amount) {
        int debitAmount = 0;
        LocalDateTime withdrawTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedWithdrawTime = withdrawTime.format(myFormatObj);
        debitAmount = amount;
        int withdrawn_10 = 0;
        int withdrawn_20 = 0;
        int withdrawn_50 = 0;


        while (amount >= 50 && atm.getBalance_50()>0){
            amount -= 50;
            atm.setBalance_50(atm.getBalance_50()-1);
            withdrawn_50++;
        }
        while (amount >= 20 && atm.getBalance_20()>0){
            amount -= 20;
            atm.setBalance_20(atm.getBalance_20()-1);
            withdrawn_20++;
        }
        while (amount >= 10 && atm.getBalance_10()>0){
            amount-=10;
            atm.setBalance_10(atm.getBalance_10()-1);
            withdrawn_10++;
        }
        if (amount==0){
            String debitStatement = "Debit\t"+debitAmount+".0\t"+atm.getBalance()+".0\t";
            miniStatement.put(formattedWithdrawTime,debitStatement);
            for (int i =1; i<=withdrawn_50;i++){
                System.out.println("Dispensing "+"50₹");
            }
            for (int i =1; i<=withdrawn_20;i++){
                System.out.println("Dispensing "+"20₹");
            }
            for (int i =1; i<=withdrawn_10;i++){
                System.out.println("Dispensing "+"10₹");
            }

        }
        else {
            System.out.println("Requested denomination not available in ATM.");
        }

    }

    @Override
    public void viewBalance() {
        System.out.println("Available balance: "+atm.getBalance()+".0");
//        int balance = atm.getBalance();
//        return balance;
    }

    @Override
    public void viewMiniStatement() {
        System.out.println("---------------------------------------------------");
        System.out.println("Date Time\t\tTransaction\tAmount\tClosing Balance");
        System.out.println("---------------------------------------------------");
        LinkedHashMap<String, String> reverseMiniStatement = new LinkedHashMap<>();
        List<String> keys = new ArrayList<>(miniStatement.keySet());
        Collections.reverse(keys);
        for (String key : keys) {
            reverseMiniStatement.put(key, miniStatement.get(key));
        }

        for (Map.Entry<String,String> m : reverseMiniStatement.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
        System.out.println("---------------------------------------------------");

    }
}
