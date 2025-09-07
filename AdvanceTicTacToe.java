import java.util.Scanner;

public class AdvanceTicTacToe {
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

    public static int checkgame(String[] li){
        String[] check = new String[3];

        int[][] checklist={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for(int i=0;i<checklist.length;i++){
            for(int j=0;j<3;j++){
                check[j]=li[checklist[i][j]];                        
            }
            if(check[0]=="O" && check[1]=="O" && check[2]=="O"){
                displayboard(li);
                // System.out.println("\n O player is won");
                return 1;
                
            }
            else if(check[0]=="X" && check[1]=="X" && check[2]=="X"){
                displayboard(li);
                // System.out.println("X player is won");
                return 2;
                
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while(true){
            int option;
            
            System.out.println("Enter (1) for Start the game\nEnter (2) for exit the game");
            System.out.print("\nEnter your option : ");
            option=sc.nextInt();

            switch (option) {

                case 1:

                    String Oname,Xname;
                    System.out.println("welcome to TIC TAC TOE game\n");

                    System.out.print("\nEnter name of O player : ");
                    Oname=sc.next();
                    
                    System.out.print("\nEnter name of X player : ");
                    Xname=sc.next();
                   

                    String[] li = {"1","2","3","4","5","6","7","8","9"};

                    int c=0;
                    
                    while(c<9){
                        int choice;

                         // it is for checking winner of the game 

                        if(c>4){
                            if (checkgame(li)==1) {
                                System.out.println("\n "+Oname+" player is won");
                                break;
                            }
                            else if(checkgame(li)==2){
                                System.out.println("\n "+Xname+" player is won");
                                break;
                            }
                    
                        }
                
                     // it is for X player turn

                        if(c%2==0){

                            displayboard(li);

                            System.out.print("\nit is "+Xname+" turn 'X': ");
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
                        
                                System.out.print("\nit is "+Oname+" turn 'O': ");
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
                        break;
                    
                    case 2:
                        System.out.println("\nThank you for Playing");
                        sc.close();
                        return;

                    default:
                        System.out.println("choose correct option");
                        break;
                }

        }
        
    }
}
