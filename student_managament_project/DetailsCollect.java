import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class DetailsCollect {
    
    public String[][] getDetails(File file){
        List<String[]> row = new ArrayList<>();
        try{
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String str=reader.nextLine();
                String[] values = str.split(",");
                row.add(values);
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        int rowsize = row.size();
        int colsize = row.get(0).length;
        String[][] data = new String[rowsize][colsize];
        for(int i=0;i<rowsize;i++){
            data[i]=row.get(i);
        }
        return data;

    }

    public void marksdisplay(File file,Scanner sc){
        System.out.println("\n----- Student result section ------\n");
        String data[][] = getDetails(file);
       
        System.out.print("Enter your roll no : ");
        String id = sc.nextLine();
        for(int i=1;i<data.length;i++){
            if(data[i][0].equals(id)){

                System.out.println("NAME : "+data[i][1]+"\nROLL NUMBER : "+data[i][0]);
                System.out.println("BRANCH : "+data[i][2]);
                System.out.println("YOUR MARKS : "+data[i][4]);
                return;

            }
        }
        System.out.println("ENETR correct Roll number");
        
        
    }

    public void addscpace(int j){
        for(int i=j;i<18;i++){
            if(i==11){
                System.out.print("|");
            }
            System.out.print(" ");
        }
    }

    public void printFullData(File file){
        if(file.length()==0){
            System.out.println("file is empty");
            return;
        }
        DetailsCollect D = new DetailsCollect();
        String[][] data = D.getDetails(file);
        System.out.println("-----------|------------------|------------------|------------------|------------------|");
        System.out.println("ROLLNO     |       NAME       |      BRANCH      |    ATTENDANCE    |       MARKS      |");
        System.out.println("-----------|------------------|------------------|------------------|------------------|");
        for(int i=1;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                int k=data[i][j].length();
                System.out.print(data[i][j]);
                D.addscpace(k);
            }
            System.out.println();
        }
    }


}
