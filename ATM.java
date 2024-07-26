import java.util.Scanner;

class Bank_User{
    static int balance = 5000;
    static int min_bal = 1100;
    static Scanner a =new Scanner(System.in);
    
    static void checkBalance(){
        int new_bal;
        System.out.println("balance = "+balance);
    }

    static int deposite(int amount){
        int amt,new_bal;
        amt = amount;
        new_bal = amt+balance;
        System.out.println("Your updated bank balance = "+new_bal);
        balance=new_bal;
        return balance;
    }

    static int withdraw(int amount){
        int debit,new_bal;
        debit = amount;
        new_bal = balance - debit;
        if(new_bal>min_bal){
            System.out.println("Now you can withdraw your money");
            System.out.println("Your updated bank balance = "+new_bal);
            balance = new_bal;
        }
        else{
            System.out.println("Sorry your no much amount to withdraw");
        }
        return balance;
    }
}

public class ATM{
    //static 
    //static 
        
    public static void main(String args[]){
        int pin,acc,cho,val;
        Bank_User b = new Bank_User();
        Scanner s =new Scanner(System.in);

        //List of function display on screen of ATM machine
            System.out.println("\tWelcome to ATM");
            System.out.println("Enter the account number");
            acc = s.nextInt();
            System.out.println("Enter the pin");
            pin = s.nextInt();

            if(acc == 51751209 && pin == 8111975){
                System.out.println("\tWelcome sir\n Please select the operation");
                while(true){
                    System.out.println("\nEnter 1 to see your account balance");
                    System.out.println("Enter 2 to withdraw amount");
                    System.out.println("Enter 3 to deposite amount");;
                    System.out.println("Enter 0 for exit");
                    cho = s.nextInt();
                    
                    switch(cho){
                        case 0: 
                            System.exit(0);
                            break;
                        
                        case 1: 
                            b.checkBalance();
                            break;
                        
                        case 2: 
                            System.out.println("Enter the amount to deposite");
                            val = s.nextInt();
                            b.withdraw(val);
                            break;
                        
                        case 3: 
                            System.out.println("Enter the amount to deposite");
                            val = s.nextInt();
                            b.deposite(val);
                            break;

                        default:
                            System.out.println("Please enter the correct input");
                            break;
                    }
                }
            }
            else{
                System.out.println("Please enter correct account number or pin");
            }
        
    }
        
}
