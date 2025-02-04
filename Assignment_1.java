/*   Name: Manuel Antunes
     Date: 2025-01-31
     Description: This program calculates the user's Body Mass Index (BMI) based on height (inches) and weight (pounds),
               checks if the values are valid, and then categorizes the user as underweight, healthy, overweight, or
               obese based on a general reference, which may not be 100% current.
*/

import java.util.Scanner;

public class Assignment_1 {
    public static void main(String[] args) {

        final int MIN_HEIGHT = 24;
        final int MAX_HEIGHT = 120;
        final int MIN_WEIGHT = 25;
        final double BMI_CONVERSION_FACTOR = 703.0;

        Scanner input = new Scanner(System.in);
        double height = 0;
        double weight = 0;
        boolean validHeight = false;
        boolean validWeight = false;

        while (!validHeight || !validWeight) {
            if (!validHeight) {
                System.out.print("Enter your height in inches (" + MIN_HEIGHT + " - " + MAX_HEIGHT + "): ");
                if (input.hasNextDouble()) {
                    height = input.nextDouble();
                    if (height >= MIN_HEIGHT && height <= MAX_HEIGHT) {
                        validHeight = true;
                    } else {
                        System.out.println("Error: Height must be between " + MIN_HEIGHT + " and " + MAX_HEIGHT + ".");
                    }
                } else {
                    System.out.println("Error: Please enter a valid numeric value for height.");
                    input.next();
                }
            }

            if (validHeight && !validWeight) {
                System.out.print("Enter your weight in pounds (Minimum " + MIN_WEIGHT + "): ");
                if (input.hasNextDouble()) {
                    weight = input.nextDouble();
                    if (weight >= MIN_WEIGHT) {
                        validWeight = true;
                    } else {
                        System.out.println("Error: Weight must be at least " + MIN_WEIGHT + " pounds.");
                    }
                } else {
                    System.out.println("Error: Please enter a valid numeric value for weight.");
                    input.next();
                }
            }
        }
        input.close();

        double BMI = (weight / Math.pow(height, 2)) * BMI_CONVERSION_FACTOR;
        String category;
        if (BMI < 16) {
            category = "Severely underweight";
        } else if (BMI < 18.5) {
            category = "Underweight";
        } else if (BMI < 25) {
            category = "Healthy";
        } else if (BMI < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }
        System.out.printf("""
                       |
                       | Height: %.1f inches
                       | Weight: %.1f pounds
                       |
                       | BMI: %.1f
                       | Category: %s
                       |
                       """, height, weight, BMI, category);
    }
}