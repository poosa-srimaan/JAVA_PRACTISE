
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = Math.random()*100;
        int num1 = (int)num;
        while(true){
            System.out.println("enter number you guess (1-100): ");
            int guess = sc.nextInt();
            if(guess == num1){
                System.out.println("YOU WON");
                break;
            }
            else if(guess<num1){
                System.out.println("your guess is low");
            }
            else{
                System.out.println("your guess is high");
            }
        }
        
        sc.close();
        
    }
}