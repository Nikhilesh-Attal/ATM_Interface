import java.util.Scanner;
import java.util.ArrayList;

class Bank_User {
    static float balance = 5000;
    static float min_bal = 1100;
    static Scanner a = new Scanner(System.in);
    static ArrayList<String> tran_his = new ArrayList<String>();
    static int PIN = 8111975;
    static int acc = 51751209;
    static int pin;
    static Bank_User b = new Bank_User();

    public void check_pin() {
        System.out.println("Please enter the new pin");
        pin = a.nextInt();
        a.nextLine();         // Consume the newline character
        if (pin == PIN) {
            System.out.println("\tWelcome sir\nPlease select the operation");
        } else {
            System.out.println("Please enter correct pin");
        }
    }

    static int cng_pin() {
        System.out.println("Please enter your old pin");
        pin = a.nextInt();
        a.nextLine();         // Consume the newline character
        if (pin == PIN) {
            System.out.println("Please enter new pin");
            pin = a.nextInt();
            a.nextLine();         // Consume the newline character
            PIN = pin;
            System.out.println("Your pin is changed successfully");
        } else {
            System.out.println("Please enter correct pin");
        }
        return PIN;
    }

    static void checkBalance() {
        System.out.println("Balance = " + balance);
    }

    static float deposite(float amount) {
        float new_bal = amount + balance;
        balance = new_bal;
        System.out.println("Your updated bank balance = " + new_bal);
        tran_his.add("Deposite: " + amount);
        return balance;
    }

    static float withdraw(float amount) {
        float new_bal = balance - amount;
        if (new_bal > min_bal) {
            balance = new_bal;
            System.out.println("Now you can withdraw your money");
            System.out.println("Your updated bank balance = " + new_bal);
            tran_his.add("Withdraw: " + amount);
        } else {
            System.out.println("Sorry, you don't have enough balance to withdraw");
        }
        return balance;
    }

    static void transition_history() {
        for (String i : tran_his) {
            System.out.println(i);
        }
    }
}

public class ATM {

    public static void main(String args[]) {
        int pin, acc;
        String cho;
        float val;
        Bank_User b = new Bank_User();
        Scanner s = new Scanner(System.in);

        // List of function display on screen of ATM machine
        System.out.println("\tWelcome to ATM");
        System.out.println("Enter the account number");
        acc = s.nextInt();
        System.out.println("Enter the pin");
        pin = s.nextInt();
        s.nextLine();         // Consume the newline character

        if (acc == 51751209 && pin == 8111975) {
            System.out.println("\tWelcome sir\nPlease select the operation");

            while (true) {
                System.out.println("\nEnter 1 to see your account balance");
                System.out.println("Enter 2 to withdraw amount");
                System.out.println("Enter 3 to deposite amount");
                System.out.println("Enter 4 to see your transaction history");
                System.out.println("Enter 5 to change pin");
                System.out.println("Enter 0 for exit");
                cho = s.nextLine();         // Read the user's choice

                switch (cho) {
                    case "0":
                        System.exit(0);
                        break;

                    case "1":
                        b.checkBalance();
                        break;

                    case "2":
                        System.out.println("Enter the amount to withdraw");
                        val = s.nextFloat();
                        b.withdraw(val);
                        break;

                    case "3":
                        System.out.println("Enter the amount to deposit");
                        val = s.nextFloat();
                        b.deposite(val);
                        break;

                    case "4":
                        b.transition_history();
                        break;

                    case "5":
                        b.cng_pin();
                        b.check_pin();
                        break;

                    default:
                        System.out.println("Please enter the correct input");
                        break;
                }
            }
        } else {
            System.out.println("Please enter correct account number or pin");
        }
    }
}
