
import java.util.Scanner;
import java.util.ArrayList;
// abstract 
  abstract class BankAccount {
    private String accountNumber;
    private String accountHolder;
    double balance; 
    private double previousTransaction;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.00;
       
    }
    
    
    //Encapsulation
    public void setBalance(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
        
    }
    public void setpreviousTransaction(double previousTransaction){
        this.previousTransaction=previousTransaction;
    }
    public double getpreviousTransaction(){
        return previousTransaction;
        
    }
    public void setaccountHolder( String accountHolder){
        this.accountHolder=accountHolder;
    }
    public String getaccountHolder(){
        return accountHolder;
        
    }
    public void setaccountNumber(String accountNumber){
        this.accountNumber= accountNumber;
     
    }
    public String getaccountNumber(){
        return accountNumber;
    }
    public void DisplayInfo(){
        System.out.println("Account Holder="+accountHolder);
        System.out.println("Account Number="+accountNumber);
    }
    
    
    
     class bank{
        private final  ArrayList<BankAccount>accounts;
        public bank(){
            this.accounts=new ArrayList<>();
        }
        public void addAccount(BankAccount account){
            accounts.add(account);
            System.out.println("Account added successfully.");
        }
        public BankAccount findAccount (String accountNumber){
            for(BankAccount account:accounts){
                if(account.getaccountNumber().equals(accountNumber)){
                    return account;
                }
            }
            return null;
        }
    }
    
    

   
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction =+ amount;
            System.out.println("Deposit successful. Current balance: RS" + balance);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            previousTransaction = + amount;
            System.out.println("Withdrawal successful. Current balance: Rs" + balance);
        } else {
            System.out.println("Invalid amount for withdrawal or insufficient funds.");
        }
    }
    public void getPreviousTransaction(){
         System.out.println("Previous Transaction: " + previousTransaction);
 }
 
    public void checkBalance() {
        System.out.println("Account Balance for " + accountHolder + ": Rs" + balance);
    } 
}





// Main class to run the program
 public class BankApplication {

    private static double interestRate;
    public static void main(String[] args) {
       
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to the Bank Application!");
            
          
            System.out.print("Enter account number: ");
            String accountNumber = sc.nextLine();
            
            System.out.print("Enter account holder name: ");
            String accountHolder = sc.nextLine();
            
            // Create a BankAccount object
            BankAccount account = new BankAccount(accountNumber, accountHolder) {};
            BankApplication bank = new BankApplication();
           //savingsAccount avingsAccount = new savingsAccount(accountNumber, accountHolder, interestRate);
            
            
      class savingAccount extends BankAccount {
        private double interestRate;
        boolean getInterestRate;
      
       // Constructor for savingingAccount
      public savingAccount(String accountNumber, String accountHolder,double interestRate) {
        super(accountNumber, accountHolder);
      this.interestRate=interestRate;
      
      }
      public double getInterestRate(){ 
          return this.interestRate;
      }
      public void setInterestRate(double interestRate){
          this.interestRate=interestRate;
      }
      public double calcInteRate(){
          return balance * interestRate;
      }
      public void applyInterest(){
          double interest = calcInteRate();
          System.out.printf("interest amount %.2f added to balance%n",interest);
          deposit(interest);
      }
       @Override
      public void deposit(double amount){
    if(amount>0){
        balance+=amount;
        System.out.printf("amount %.2f deposited%n",amount);
        System.out.printf("Current balane is: %.2f%n",balance);
    }
    else{
        System.out.println("A negative number cannot be deposited");
        }
    }
      @Override
      public void withdraw(double amount){  
    if(amount>0){
        if((amount) <=balance){
            System.out.printf("amountof %.2f withdrawn from account%n",amount);
            balance -=amount;
            System.out.printf("Current balance is: %.2f%n",balance);
        }
        else{
            System.out.println("negative amount can not be withdrawn!");
        }
    }
    
}
}

      
         int choice;
            do {
                // Display menu
                System.out.println("\nMenu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. previousTransaction");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1 : {
                        
                        System.out.print("Enter the deposit amount: Rs");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    }
                    case 2 : {
                        System.out.print("Enter the withdrawal amount: Rs");
                        double withdrawalAmount = sc.nextDouble();
                        account.withdraw(withdrawalAmount);
                        break;
                    }
                    case 3  : {
                        account.checkBalance();
                        break;
                    }
                    case 4 : {
                       System.out.println("PreviousTransaction:");
                       account.getPreviousTransaction();
                        break;
                    }
                   
                    case 5 : {
                        System.exit(0);
                        break;
                    }
                    default : System.out.println("Invalid choice please try again");
                }
                
            } while (choice != 5);   
        }
    }
}

    
