import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


// this class is to copy the data from csv file

class GetDetails{
    
    // here i used private access modifier to keep data hidden 

    private List<String[]> rows = new ArrayList<>();
    private String[][] data = new String[rows.size()][];

    void setdata(File file){
        
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                rows.add(line.split(","));
            }
            reader.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    


    String[][] getdata(File file){
        setdata(file);
        return rows.toArray(data);
    }

}


// from this class we access the operations

public class AccessAccount {

    // it is the access point of this class from here we access debit,credit ,printdetails methods

    public void accessing(Scanner sc,File file){
        while (true) {
            System.out.println("\n-------------- WELCOME TO ACCOUNT ACCESSING SECTION ----------------\n");
            System.out.println("Enter (1) to CREDIT (ADD MONEY) ");
            System.out.println("Enter (2) to DEBIT (WITHDRAW MONEY) ");
            System.out.println("Enter (3) to print ACCOUNT DETAILS");
            System.out.println("Enter (4) to exit ");
            System.out.print("Enter ypur option : ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    credit(file, sc);
                    break;

                case 2:
                    debit(file, sc);
                    break;

                case 3:
                    printdetails(file, sc);
                    break;
                
                case 4:
                    return;

                default:
                    System.out.println("Enter correct option");
                    break;
            }
        }
    }


    // it is the debit program 

    public void debit(File file,Scanner sc){
        GetDetails g = new GetDetails();

        String[][] data=g.getdata(file);
        System.out.print("Enter your Account number : ");
        String accnum = sc.nextLine();
        System.out.print("Enter pin : ");
        String pin =sc.nextLine();
        for(int i=1;i<data.length;i++){
            if(data[i][4].equals("yes")){
                System.out.println("ACCOUNT  FOUND ");
            }
            else{
                System.out.println("your account is deactivated ");
                return;
            }
            if(data[i][0].equals(accnum) && data[i][2].equals(pin)){
                System.out.print("Enter amount to DEBIT : ");
                int amt = sc.nextInt();
                sc.nextLine();
                int bal=Integer.parseInt(data[i][3]);
                if(amt>bal){
                    System.out.println("you cannot DEBIT your amount is low "+ bal);
                    return;
                }
                bal-=amt;
                data[i][3]=""+bal;
                System.out.println(amt+" is DEBITED from your account , accouunt holder name : "+data[i][1]);
                System.out.println("remaining amount is : "+bal);
                writedata(file, data);
                return;
            }
        }
        System.out.println("enter correct Account number (or) enter correct pin");

    }   


    // it is Credit function

    public void credit(File file,Scanner sc){
        GetDetails g = new GetDetails();

        String[][] data=g.getdata(file);
        System.out.print("Enter your Account number : ");
        String accnum = sc.nextLine();
        System.out.print("Enter pin : ");
        String pin =sc.nextLine();
        for(int i=1;i<data.length;i++){
            if(data[i][4].equals("yes")){
                System.out.println("ACCOUNT  FOUND ");
            }
            else{
                System.out.println("your account is deactivated ");
                return;
            }
            if(data[i][0].equals(accnum) && data[i][2].equals(pin)){
                System.out.print("Enter amount to CREDIT : ");
                int amt = sc.nextInt();
                sc.nextLine();
                int bal=Integer.parseInt(data[i][3]);
                bal+=amt;
                data[i][3]=""+bal;
                System.out.println(amt+" is CREDIT from your account, account holder name : "+data[i][1]);
                System.out.println("remaining amount is : "+bal);
                writedata(file, data);
                return;
            }
        }
        System.out.println("enter correct Account number");

    }    
    
    // it is method to write the changed data in csv file

    public void writedata(File file,String[][] data){
        try{
            FileWriter writer = new FileWriter(file);
            for(String[] rows : data){
                writer.write(String.join(",", rows)+"\n");
            }
            writer.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public void printdetails(File file,Scanner sc){

        GetDetails g = new GetDetails();

        String[][] data=g.getdata(file);
        System.out.print("Enter your Account number : ");
        String accnum = sc.nextLine();
        System.out.println("Enter your pin : ");
        String pin = sc.nextLine();
        for(int i=0;i<data.length;i++){
            if(data[i][0].equals(accnum) && data[i][2].equals(pin)){
                System.out.println("ACCOUNT NUMBER : "+data[i][0]+"        "+"ACCOUNT HOLDER NAME : "+data[i][1]);
                System.out.println("YOUR BALANCE : "+data[i][3]);
                return;
            }
        }
        System.out.println("Enter correct account number (or) Enter correct pin number");

    }


}
