import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteStudent {
    public void deletestudent(File file,Scanner sc ){
        
        DetailsCollect d = new DetailsCollect();
        List<String[]> newdata = new ArrayList<>();
        String[][] data = d.getDetails(file);
        System.out.print("Enter Student roll number to delete : ");
        String id = sc.nextLine();
        for(String[] row : data){
            if(row[0].equals(id)){
                continue;
            }
            else{
                newdata.add(row);
            }
        }
        try{
            FileWriter writer = new FileWriter(file);
            for(String[] row : newdata){
                writer.write(String.join(",",row)+"\n");
            }
            writer.close();
            return;
        }catch(IOException e){
            e.printStackTrace();
        }

       
        System.out.println("Enter correct roll number ");
    }
}
