/*   Name: Manuel Antunes
     Date: 2025-03-09
     Description:
*/

import java.util.Scanner;

public class assignment_3 {
    static Scanner input = new Scanner(System.in);

    static final int FRAMES = 10;
    static final int PINS = 10;

    public static void main(String[] args) {

        System.out.println("[Insert the name of each player]");
        System.out.print("Player (1) - ");
        String player_1 = input.nextLine();
        System.out.print("Player (2) - ");
        String player_2 = input.nextLine();
        System.out.print("Player (3) - ");
        String player_3 = input.nextLine();


        int[] player1_score = getGameScores(player_1);
        int[] player2_score = getGameScores(player_2);
        int[] player3_score = getGameScores(player_3);





        input.close();
    }

    static int getRoll(){
        int roll = input.nextInt();
        while (roll < 0 || roll > 10){
            System.out.println("Try again by entering a score between 0 and 10 - ");
            roll = input.nextInt();
        }
        input.nextLine();
        return roll;
    }

    static void getTurnScores(){

    }

    static void getGameScores(String player){

    }

}
