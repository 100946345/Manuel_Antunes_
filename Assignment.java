/*   Name: Manuel Antunes
     Date: 2025-02-17
     Description: This program calculates the user's input temperatures for each day they choose.
                  It checks the input for correctness and calculates the daily averages,
                  as well as the highest and lowest temperatures during the specified days.
*/

import java.util.Scanner;
public class Assignment {
    final double MIN_TEMP= -100;
    final double MAX_TEMP = 100.0;
    static final int MIN_DAYS = 2;
    static final int MAX_DAYS = 366;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of days < " + MIN_DAYS + " and " + MAX_DAYS + " > - ");
        int days = input.nextInt();
        while (days < 2 || days > 366) {
            System.out.print("Invalid input. Please enter a number between " + MIN_DAYS + " and " + MAX_DAYS + " - ");
            days = input.nextInt();

        }

    }
}
