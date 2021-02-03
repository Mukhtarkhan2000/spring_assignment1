package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "beans.xml");
        Scanner s = new Scanner(System.in);

        Account user1 = context.getBean("userAccount1", Account.class);
        Account user2 = context.getBean("userAccount2", Account.class);
        Account admin1 = context.getBean("administratorAccount1", Account.class);
        Account admin2 = context.getBean("administratorAccount2", Account.class);

        AccountList accountList = context.getBean("accountList", AccountList.class);
        accountList.addUser(user1);
        accountList.addUser(user2);
        accountList.addAdministrator(admin1);
        accountList.addAdministrator(admin2);

        loop:
        while (true) {
            System.out.println("Choose account type");
            System.out.println("1. User" +
                    "\n2. Administrator");
            int choose = s.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Enter your username");
                    String userName = s.next();
                    if (accountList.getUserAccounts().contains(userName)) {
                        System.out.println("Enter the card number");
                        int cardNumber = s.nextInt();
                        System.out.println("Enter the pin code");
                        int pinCode = s.nextInt();
                        for (Account accounts : accountList.getUserAccounts()) {
                            if (cardNumber == accounts.getCardNumber() && pinCode == accounts.getPinCode()) {
                                System.out.println("Choose operation");
                                System.out.println("1. Check balance" +
                                        "\n2. Withdraw" +
                                        "\n3. Top up" +
                                        "\n4. Exit");
                                int ch = s.nextInt();
                                switch (ch) {
                                    case 1:
                                        System.out.println("Your balance is: " + accounts.getBalance());
                                        break;
                                    case 2:
                                        System.out.println("Enter withdraw amount");
                                        int withdraw = s.nextInt();
                                        if (withdraw <= accounts.getBalance()) {
                                            accounts.setBalance(accounts.getBalance() - withdraw);
                                        } else {
                                            System.out.println("Your balance is less than " + withdraw);
                                        }
                                        System.out.println("Now your balance is: " + accounts.getBalance());
                                        break;
                                    case 3:
                                        System.out.println("Enter top up amount");
                                        int topUp = s.nextInt();
                                        accounts.setBalance(accounts.getBalance() + topUp);
                                        System.out.println("Now your balance is:" + accounts.getBalance());
                                        break;
                                    case 4:
                                        break loop;
                                }
                            }
                        }
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 2:
                    System.out.println("Enter your username");
                    String adminName = s.next();
                    if (accountList.getUserAccounts().contains(adminName)) {
                        System.out.println("Enter the card number");
                        int cardNumber = s.nextInt();
                        System.out.println("Enter the pin code");
                        int pinCode = s.nextInt();
                        for (Account accounts : accountList.getAdministratorAccounts()) {
                            if (cardNumber == accounts.getCardNumber() && pinCode == accounts.getPinCode()) {
                                System.out.println("Choose operation");
                                System.out.println("1. Check balance" +
                                        "\n2. Withdraw" +
                                        "\n3. Top up" +
                                        "\n4. Exit");
                                int ch = s.nextInt();
                                switch (ch) {
                                    case 1:
                                        System.out.println("Your balance is: " + accounts.getBalance());
                                        break;
                                    case 2:
                                        System.out.println("Enter withdraw amount");
                                        int withdraw = s.nextInt();
                                        if (withdraw <= accounts.getBalance()) {
                                            accounts.setBalance(accounts.getBalance() - withdraw);
                                        } else {
                                            System.out.println("Your balance is less than " + withdraw);
                                        }
                                        System.out.println("Now your balance is: " + accounts.getBalance());
                                        break;
                                    case 3:
                                        System.out.println("Enter top up amount");
                                        int topUp = s.nextInt();
                                        accounts.setBalance(accounts.getBalance() + topUp);
                                        System.out.println("Now your balance is:" + accounts.getBalance());
                                        break;
                                    case 4:
                                        break loop;
                                }
                            }
                        }
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                default:
                    System.out.println("Please, try again");
                    break;
            }
        }
        context.close();
    }
}
