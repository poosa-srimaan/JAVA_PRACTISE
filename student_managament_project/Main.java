import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        DetailsCollect d = new DetailsCollect();
        ModifyDetails m = new ModifyDetails();
        DeleteStudent ds = new DeleteStudent();
        String filename = "studentdetails.csv";
        File file = new File(filename);
        System.out.println("------------- WELCOME --------------");
        while(true){
            System.out.println("Enter (1) to Enter student marks detail");
            System.out.println("Enter (2) to check student details");
            System.out.println("Enter (3) to view full details");
            System.out.println("Enter (4) to modify student details");
            System.out.println("Enter (5) to delete student data ");
            System.out.println("Enter (6) to EXIT ");
            System.out.print("\nEnter your option : ");
            int option = sc.nextInt();
            sc.nextLine();
            
            switch (option) {
                case 1:
                    s.studentdetailsentry(file,filename,sc);
                    break;
                
                case 2:
                    d.marksdisplay(file,sc);
                    break;

                case 3:
                    d.printFullData(file);
                    break;

                case 4:
                    m.modifyDetails(file, sc);
                    break;

                case 5:
                    ds.deletestudent(file, sc);
                    break;

                case 6:
                    sc.close();
                    return;

            
                default:
                    System.out.println("Invalid option please enter correct option ");
                    break;
            }
        }
    }
}
