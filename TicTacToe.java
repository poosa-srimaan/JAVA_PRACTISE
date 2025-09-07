import java.util.Scanner;


public class TicTacToe {

    // here is the method for displaying board

    public static void displayboard(String[] li){
        System.out.println("-------------");
        System.out.println("| "+li[0]+" | "+li[1]+" | "+li[2]+" |");
        System.out.println("-------------");
        System.out.println("| "+li[3]+" | "+li[4]+" | "+li[5]+" |");
        System.out.println("-------------");
        System.out.println("| "+li[6]+" | "+li[7]+" | "+li[8]+" |");
        System.out.println("-------------");
        return;
    }

    public static void main(String[] args) {
        
        System.out.println("welcome to TIC TAC TOE game");
        Scanner sc = new Scanner(System.in);

        String[] li = {"1","2","3","4","5","6","7","8","9"};

        int c=0;
                
        while(c<9){
            int choice;
            
            // it is for checking winner of the game 

            if(c>4){
                String[] check = new String[3];

                int[][] checklist={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
                for(int i=0;i<checklist.length;i++){
                    for(int j=0;j<3;j++){
                        check[j]=li[checklist[i][j]];                        
                    }
                    if(check[0]=="O" && check[1]=="O" && check[2]=="O"){
                        displayboard(li);
                        System.out.println("\n O player is won");
                        sc.close();
                        return;
                    }
                    else if(check[0]=="X" && check[1]=="X" && check[2]=="X"){
                        displayboard(li);
                        System.out.println("X player is won");
                        sc.close();
                        return;
                    }
                   
                }
                
            }
            
            // it is for X player turn

            if(c%2==0){

                displayboard(li);

                System.out.print("\nit is X turn : ");
                choice = sc.nextInt();
                if(li[choice-1]=="X" || li[choice-1]=="O"){
                    System.out.println("it is already filled");
                    c--;
                }
                else{
                    li[choice-1]="X";
                    c++;
                }

            }

            // it is for O player turn

            else{

                displayboard(li);
                
                System.out.print("\nit is O turn : ");
                choice = sc.nextInt();
                if(li[choice-1]=="X" || li[choice-1]=="O"){
                    System.out.println("it is already filled");
                    c--;
                }
                else{
                    li[choice-1]="O";
                    c++;
                }                
            }
        }
        
        sc.close();


    }
}
