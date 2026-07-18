import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static boolean enterPin(Scanner input) {

        int defaultPin = 1234;
        int userPin;
        int attemptCount = 2;

        do {

            System.out.println("Please enter your PIN Number");
            userPin = input.nextInt();

            if (userPin != defaultPin && attemptCount > 0) {
                System.out.println("You've entered incorrect password");
                System.out.println("You've " + attemptCount + " Remaining attempts");
                attemptCount--;
            } else if (userPin != defaultPin && attemptCount == 0) {

                System.out.println("Your account has been locked");
                return false;
            } else {

                System.out.println("You've logged in successfully");

            }


        } while (userPin != defaultPin);
        return true;
    }


    public static void displayMessage(double balance) {

        System.out.println("Your current balance is " + balance);


        System.out.println("Please choose from the following options");

    }

    public static double depositMethod(double balance, Scanner input) {
        double depositAmount;

        System.out.println("Please enter the amount you'd like to deposit");

        depositAmount = input.nextDouble();

        if (depositAmount <= 0) {
            System.out.println("Invalid Amount");

        } else {
            balance += depositAmount;
            System.out.println("Your current balance is " + balance);

        }


        return balance;
    }

    public static double withdrawMethod(double balance, Scanner input) {

        double withdrawlAmount;

        System.out.println("Please enter the amount you'd like to withdraw");
        withdrawlAmount = input.nextDouble();
        if (withdrawlAmount == 0) {
            System.out.println("Transaction cancelled");
            System.exit(0);
        } else if (withdrawlAmount == balance) {
            balance -= withdrawlAmount;
            System.out.println("Your account is empty");
        } else if (withdrawlAmount < balance) {


            balance -= withdrawlAmount;
            System.out.println("Your current balance is " + balance);

        } else {
            System.out.println("Insufficient balance");
        }

        return balance;
    }

    public static void showAccountStatus(double balance) {

        if (balance >= 5000) {

            System.out.println("VIP Customer ");
        } else if (balance >= 1000) {
            System.out.println("Regular Customer");
        } else {
            System.out.println("Low balance");
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double balance = 2500.75;
        int choice;


        if (enterPin(input)) {

            displayMessage(balance);
        } else {
            return;
        }


        do {

            System.out.println("""
                    ========= ATM =========
                    1. Check Balance
                    2. Deposit
                    3. Withdraw
                    4. Show Account Status
                    5. Exit
                    =======================""");
            choice = input.nextInt();

            switch (choice) {

//                Balance check CASE

                case 1 -> System.out.println("Your current balance is " + balance);

//                Deposit CASE
                case 2 -> {

                    balance = depositMethod(balance, input);

                }
//                Withdraw CASE
                case 3 -> {

                    balance = withdrawMethod(balance, input);
                }
//                Status CASE
                case 4 -> {

                    showAccountStatus(balance);
                }
//                EXIT CASE
                case 5 -> System.out.println("Thank you for using our ATM");

                default -> System.out.println("Invalid choice, please try again");
            }

        } while (choice != 5);

            input.close();
    }
}