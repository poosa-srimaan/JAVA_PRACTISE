import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class MainApp {
    public static void main(String[] args) {
        CreateAccount c = new CreateAccount();
        Scanner sc = new Scanner(System.in);
        AccessAccount a = new AccessAccount();
        String filename = "userdetails.csv";
        File file = new File(filename);

        // here file is created if file is exist and it is empty it will appent the header part in csv
        try{
            FileWriter writer = new FileWriter(file,true);
            if(file.length()==0){
                writer.append("accountno,name,pin,balance\n");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        // from here we access all the methods 
        
        while(true){
            System.out.println("\n------------- WELCOME TO BANK HOME SECTION ------------\n");
            System.out.println("Enter (1) to create Account");
            System.out.println("Enter (2) if you have Account");
            System.out.println("Enter (3) to Exit");
            System.out.print("Enter your option : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    c.createaccount(file, sc);
                    break;

                case 2:
                    a.accessing(sc, file);
                    break;
                
                case 3:
                    System.out.println("EXTING .....");
                    sc.close();;
                    return;

                default:
                    System.out.println("Enter correct option ");
                    break;
            }
        }

    }
}