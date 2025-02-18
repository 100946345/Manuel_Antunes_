/*   Name: Manuel Antunes
     Date: 2025-02-17
     Description: This program calculates the user's input temperatures for each day they choose.
                  It checks the input for correctness and calculates the daily averages,
                  as well as the highest and lowest temperatures during the specified days.
*/

import java.util.Scanner;
public class Assignment {
    static final double MIN_TEMP= -100;
    static final double MAX_TEMP = 100.0;
    static final int MIN_DAYS = 2;
    static final int MAX_DAYS = 366;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the number of days < " + MIN_DAYS + " and " + MAX_DAYS + " > - ");
            int days = input.nextInt();
            while (days < MIN_DAYS || days > MAX_DAYS) {
                System.out.print("Invalid input. Please enter a number between " + MIN_DAYS + " and " + MAX_DAYS + " - ");
                days = input.nextInt();
        }
        double[] LowestTemperature = new double[days];
        double[] HighestTemperature = new double[days];
        for (int dayIndex = 0; dayIndex < days; dayIndex++) {
            System.out.println("Day " + (dayIndex + 1) + "-");
            while (true) {
                System.out.print("Enter the low temperature for the day (between " + MIN_TEMP + " and " + MAX_TEMP + "): ");
                LowestTemperature[dayIndex] = input.nextDouble();

                if (LowestTemperature[dayIndex] >= MIN_TEMP && LowestTemperature[dayIndex] <= MAX_TEMP) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a temperature between " + MIN_TEMP + " and " + MAX_TEMP + ".");
                }
            }
            while (true) {
                System.out.print("Enter the high temperature for the day (between " + MIN_TEMP + " and " + MAX_TEMP + "): ");
                HighestTemperature[dayIndex] = input.nextDouble();

                if (HighestTemperature[dayIndex] >= MIN_TEMP && HighestTemperature[dayIndex] <= MAX_TEMP && HighestTemperature[dayIndex] >= LowestTemperature[dayIndex]) {
                    break;
                } else {
                    if (HighestTemperature[dayIndex] < LowestTemperature[dayIndex]) {
                        System.out.println("The high temperature cannot be lower than the low temperature. Please enter a valid high temperature.");
                    } else {
                        System.out.println("Invalid input. Please enter a temperature between " + MIN_TEMP + " and " + MAX_TEMP + ".");
                    }
                }
            }
        }

    }
}
