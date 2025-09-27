import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ModifyDetails {

    public void modifyDetails(File file,Scanner sc){
        ModifyDetails M = new ModifyDetails();
        System.out.println("----------- WELCOME TO MODEFY SECTION -------------");
        System.out.println("Enter (1) to change name ");
        System.out.println("Enter (2) to change attendance");
        System.out.println("Enter (3) to change marks");
        System.out.println("Enter (4) for no change (exit)");
        System.out.print("Enter your option : ");
        int option = sc.nextInt();
        sc.nextLine();
        switch ((option)) {
            case 1:
                M.changename(file,sc);
                break;

            case 2:
                M.changeattendance(file, sc);
                break;

            case 3:
                M.changemarks(file, sc);
                break;

            case 4:
                return;

            default:
                break;
        }
    }

    public void enterdetails(File file,String data[][]){
        try{
            FileWriter writer = new FileWriter(file);
            for(String[] row : data){
                writer.write(String.join(",",row)+"\n");
            }
            writer.close();
            return;
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void changename(File file,Scanner sc){
        ModifyDetails M = new ModifyDetails();
        DetailsCollect d = new DetailsCollect();
        String[][] data = d.getDetails(file);
        System.out.print("Enter the roll no : ");
        String id = sc.nextLine();
        System.out.print("Enter name to change : ");
        String name = sc.nextLine();
        boolean b=false;
        for(int i=1;i<data.length;i++){
            if(id.equals(data[i][0])){
                data[i][1]=name;
                b=true;
            }
        }
        if(b==true){
            M.enterdetails(file, data);
        }
        
        System.out.println("Enter correct number");

    }

    public void changeattendance(File file,Scanner sc){
        ModifyDetails M = new ModifyDetails();
        DetailsCollect d = new DetailsCollect();
        String[][] data = d.getDetails(file);
        System.out.print("Enter the roll no : ");
        String id = sc.nextLine();
        System.out.print("Enter attendance % to change : ");
        String attendance = sc.nextLine(); 
        boolean b=false;  
        for(int i=1;i<data.length;i++){
            if(id.equals(data[i][0])){
                data[i][3]=attendance;
                b=true;
            }
        }   
        if(b==true){
            M.enterdetails(file, data);
        }
        
        System.out.println("Enter correct number");  
    }

    public void changemarks(File file,Scanner sc){
        ModifyDetails M = new ModifyDetails();
        DetailsCollect d = new DetailsCollect();
        String[][] data = d.getDetails(file);
        System.out.print("Enter the roll no : ");
        String id = sc.nextLine();
        System.out.print("Enter marks % to change : ");
        String marks = sc.nextLine(); 
        boolean b=false;  
        for(int i=1;i<data.length;i++){
            if(id.equals(data[i][0])){
                data[i][4]=marks;
                b=true;
            }
        }   
        if(b==true){
            M.enterdetails(file, data);
        }
        
        System.out.println("Enter correct number");  
            
    }

}
