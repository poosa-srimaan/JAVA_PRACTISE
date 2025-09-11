import java.util.Scanner;

public class Calculator {
    // it is the display method
    public static void displaycal(String str){
        System.out.println("\n|------------------------|");
        System.out.println("|"+str);
        System.out.println("|----------------------- |");
        System.out.println("|  Ac  |  <- |  E  |  +  |");
        System.out.println("|------|-----|-----|---- |");
        System.out.println("|  1   |  2  |  3  |  X  |");
        System.out.println("|------|-----|-----|---- |");
        System.out.println("|  4   |  5  |  6  |  -  |");
        System.out.println("|------|-----|-----|-----|");
        System.out.println("|  7   |  8  |  9  |  /  |");
        System.out.println("|------|-----|-----|---- |");
        System.out.println("|  %   |  0  |  .  |  =  |");
        System.out.println("|------|-----|-----|------");

   }
//    here is the main method
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while(true){
            float sum=0;
            String display="";
            System.out.print("enter num -> ");
            float num=sc.nextFloat();
            sum=num;
            display+=num+"";
            displaycal(display);
            while(true){
                
                System.out.print("enter opt ->");
                String input=sc.next();
                if(input.equals("=")){
                    display=sum+"";
                    displaycal(display);
                    break;
                }else if(input.equals("A")){
                    display="";
                    displaycal(display);
                    break;
                }
                display+=input;
                displaycal(display);
                System.out.print("enter num -> ");
                num=sc.nextFloat();
                display+=num+"";
                displaycal(display);
                switch (input) {
                    case "+":
                        sum+=num;
                        break;

                    case "-":
                        sum-=num;
                        break;

                    case "*":
                        sum*=num;
                        break;

                    case "/":
                        if(num==0){
                            display="Zero division error";
                            displaycal(display);
                            display="";
                        }
                        else{
                            sum/=num;
                        }
                        break;

                    case "%":
                        if(num==0){
                            display="Zero division error";
                            displaycal(display);
                            display="";
                        }
                        else{
                            sum%=num;
                        }
                        break;

                    case "E":
                        sc.close();
                        ;return;


                    default:
                        System.out.println("enter correct options");
                        break;

                }

            }

        }

    }    
}
