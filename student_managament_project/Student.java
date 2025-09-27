import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Student {
    public void studentdetailsentry(File file,String filename,Scanner sc){
        try{
            String[] data = new String[5];
            FileWriter writer = new FileWriter(filename,true);
            if(file.exists() && file.length()==0){
                writer.append("rollno,name,branch,attendance,marks");
            }
            System.out.print("Enter roll no : ");
            data[0]=sc.nextLine();
            System.out.print("\nEnter name of student : ");
            data[1]= sc.nextLine();
            data[2]= "CSD";
            System.out.print("\nEnter attendence % : ");
            data[3]= sc.next();
            System.out.print("\nEnter student marks % : ");
            data[4]= sc.next();
            writer.append("\n"+data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]);
            writer.flush();
            writer.close();
            

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public static int countrows(File file){
        try{
            Scanner reader = new Scanner(file);
            int count=0;
            while(reader.hasNextLine()){
                count++;
            }
            reader.close();
            return count;
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(("count row has error"));
        return -1;
    }

}
