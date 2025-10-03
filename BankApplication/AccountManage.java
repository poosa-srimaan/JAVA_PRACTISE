import java.util.Scanner;
import java.io.File;



public class AccountManage {

    public void accountmanage(File file , Scanner sc){
        System.out.println("---------- welcome to ACCOUNT MANAGE SECTION -----------\n");
        System.out.println("Enter (1) for Activate account ");
        System.out.println("Enter (2) for Deactivate account");
        System.out.println("Enter (3) for EXIT");
        System.out.print("Enter your option : ");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                active(file, sc);
                break;

            case 2:
                deactivate(file, sc);
                break;

            case 3:
                return;
        
            default:
                System.out.println("enter correct option ");
                break;
        }
    }

    public void active(File file,Scanner sc){
        GetDetails gd = new GetDetails();
        String[][] data = gd.getdata(file);
        System.out.print("Enter account number : ");
        String accnum = sc.nextLine();
        System.out.print("Enter pin number : ");
        String pin = sc.nextLine();
        for(int i=1;i<data.length;i++){
            if(data[i][0].equals(accnum) && data[i][2].equals(pin)){
                if(data[i][4].equals("yes")){
                    System.out.println("your account is in active");
                    return;
                }
                else{
                    data[i][4]="yes";
                    System.out.println("Your account is activated");
                    writedata(file, data);
                    return;
                }
            }
        }
    }

    public void deactivate(File file, Scanner sc){
        GetDetails gd = new GetDetails();
        String[][] data = gd.getdata(file);
        System.out.print("Enter account number : ");
        String accnum = sc.nextLine();
        System.out.print("Enter pin number : ");
        String pin = sc.nextLine();
        for(int i=1;i<data.length;i++){
            if(data[i][0].equals(accnum) && data[i][2].equals(pin)){
                if(data[i][4].equals("no")){
                    System.out.println("your account is in deactive");
                    return;
                }
                else{
                    data[i][4]="no";
                    System.out.println("Your account is deactivated");
                    writedata(file, data);
                    return;
                }
            }
        }
    }

    public void writedata(File file , String[][] data){
        AccessAccount ac = new AccessAccount();
        ac.writedata(file, data);
    }


}
