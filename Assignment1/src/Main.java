import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int defaultPin = 1234;
        int userPin;
        double balance = 2500.75;
        int choice;
        double depositAmount;
        double withdrawlAmount;
        int attemptCount = 3;

        do {

            System.out.println("Please enter your PIN Number");
            userPin = input.nextInt();

            if (userPin != defaultPin && attemptCount >0) {
                System.out.println("You've entered incorrect password");
                System.out.println("You've "+ attemptCount + " Remaining attempts");
                attemptCount--;
            } else if (userPin != defaultPin && attemptCount == 0) {

                System.out.println("Your account has been locked");
                return;
            } else {

                System.out.println("You've logged in successfully");
            }


        } while (userPin != defaultPin);


        System.out.println("Your current balance is " + balance);


        System.out.println("Please choose from the following options");


        do {

            System.out.println("========= ATM =========\n" + "1. Check Balance\n" + "2. Deposit\n" + "3. Withdraw\n" + "4. Show Account Status\n" + "5. Exit\n" + "=======================");


            choice = input.nextInt();

            switch (choice) {

//                Balance check CASE

                case 1 -> System.out.println("Your current balance is " + balance);

//                Deposite CASE
                case 2 -> {
                    do {
                        System.out.println("Please enter the amount you'd like to deposit");
                        depositAmount = input.nextInt();
                        if (depositAmount <= 0) {
                            System.out.println("Invalid Amount");
                        } else {

                            balance += depositAmount;
                            System.out.println("Your current balance is " + balance);


                        }

                        System.out.println("Would you like to make another deposit?\n1-Yes\n2-No");
                        choice = input.nextInt();

                    } while (choice != 2);


                }
//                Withdraw CASE
                case 3 -> {
                    do {
                        System.out.println("Please enter the amount you'd like to withdraw");
                        withdrawlAmount = input.nextDouble();
                        if ( withdrawlAmount == 0) {
                            System.out.println("Transaction cancelled");
                            return;
                        } else if (withdrawlAmount == balance) {

                            System.out.println("Your account is empty");
                        } else if (withdrawlAmount < balance) {


                            balance -= withdrawlAmount;
                            System.out.println("Your current balance is " + balance);

                        } else {
                            System.out.println("Insufficient balance");
                        }

                        System.out.println("Would you like to make another withdrawl?\n1-Yes\n2-No");
                        choice = input.nextInt();

                    } while (choice != 2);

                }
//                Status CASE
                case 4 -> {

                    if (balance >= 5000) {

                        System.out.println("VIP Customer ");
                    } else if (balance > 1000 && balance < 5000) {
                        System.out.println("Regular Customer");
                    } else {
                        System.out.println("Low balance");
                    }
                }
//                EXIT CASE
                case 5 -> System.out.println("Thank you for using our ATM");

                default -> System.out.println("Invalid choice, please try again");
            }

        } while (choice != 5);


    }
}