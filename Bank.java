// simple bank application using methods 

import java.util.Scanner;

public class Bank {

    // this method is for adding money

    public static int  deposit(int balance,int amount){
        balance+=amount;
        System.out.println("\nrs:"+amount+" amount is created");
        return balance;
    }

    // this method is for debit money

    public static int  debit(int balance,int amount){
        if (amount>balance){
            System.out.println("\nbalance amount is low ");
            System.out.println("BALANCE AMOUNT : "+balance);
            return balance;
        }
        else{
            balance-=amount;
            System.out.println("\nrs "+amount+" is debited from your account");
            return balance;
        }
    }

    // this method is for check balance

    public static void checkbalance(String name,String account_no,int balance,String IFSC){
        System.out.println("ACCOUNT NUMBER : "+account_no+"  NAME : "+name);
        System.out.println("IFSC CODE : "+IFSC);
        System.out.println("BALANCE AMOUNT : "+balance);
    }

    //  here is the main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        String acc;
        String IFSC;
        int balance=0;

        System.out.println("Enter your ACCOUNT : ");
        acc = sc.next();
        sc.nextLine();
        System.out.println("Enter your name : ");
        name=sc.nextLine();
        System.out.println("enter your IFSC code : ");
        IFSC=sc.next();
        while(true){
            int choice,amount;
            System.out.println("\nEnter (1) for deposit\nEnter (2) for debit\nEnter (3) for checkbalance\nEnter (4) for exit\n");
            System.out.println("\nenter your choice : ");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nEnter Amount to credit : ");
                    amount=sc.nextInt();
                    System.out.println("\nACCOUNT NUMBER : "+acc+"  NAME : "+name);
                    balance=deposit(balance, amount);
                    break;
                
                case 2:
                    System.out.println("\nEnter Amount to debit : ");
                    amount=sc.nextInt();
                    System.out.println("\nACCOUNT NUMBER : "+acc+"  NAME : "+name);
                    balance=debit(balance, amount);
                    break;
                
                case 3:
                    checkbalance(name, acc, balance,IFSC);
                    break;
                
                case 4:
                    sc.close();
                    return;
                
                default :
                    System.out.println("\nenter correct option");
                    
            }


        }


    }
}
