import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class CreateAccount {

    // it is the method to know the row size of the csv file
    
    public int detailssize(File file){
        try{
            int count = -1;
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){
                reader.nextLine();
                count+=1;
            }
            reader.close();
            return count;

        }catch(IOException e){
            e.printStackTrace();
        }
        return -1;

    }

    // it is the method to create new account in which account number is created automatically by adding 1 to a base number which i have given
    
    public void createaccount(File file,Scanner sc){
        try{
            FileWriter writer = new FileWriter(file,true);
            System.out.println("------- WELCOME TO ACCOUNT SECTION ---------");
            System.out.print("Enter your name : ");
            int accnum = 1100;
            String name = sc.nextLine();
            System.out.print("Create a (4) digit pin : ");
            String pin = sc.nextLine();
         
            if(file.exists() && file.length()==0){
                writer.append("accountno,name,pin,balance\n");
            }

            accnum+=detailssize(file)+1;
            String fulldetail = "";
            System.out.println("Your Account number is : "+accnum);
            System.out.print("Deposite amount to create ACCOUNT minimum(1000) : ");
            int balance = sc.nextInt();
            sc.nextLine();
            String active = "yes";
            if(balance<2000){
                System.out.println("please enter minimum amount ");
                writer.close();
                return;
            }
            fulldetail = accnum+","+name+","+pin+","+balance+","+active+"\n";
            // here i use append method to write the details at bottom
            writer.append(fulldetail);
            writer.close();
            return;

        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
