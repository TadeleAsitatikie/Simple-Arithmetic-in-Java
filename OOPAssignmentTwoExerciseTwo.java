import java.util.Scanner;

/**
 *
 * Write a java program that reads numbers from the keyboard and shows the sum,
 * product, division and difference of selected two numbers (out of the given
 * number) to the console. In the program, - you should handle when an attempt
 * to divide by zero is made - you should handle appropriately when an attempt
 * to access an index that is not available
 */
public class OOPAssignmentTwoExerciseTwo {

    public static void main(String[] args) {
        try {
            try (Scanner scan = new Scanner(System.in)) {
                int maxSizeOfTheSet;
                System.out.print("How many numbers have you in the set: ");
                maxSizeOfTheSet = scan.nextInt();
                if (maxSizeOfTheSet < 2) {
                    System.out.println("You should have at least two numbers for the operations");
                    return;
                }
                double[] numbersFromKeyboard = new double[maxSizeOfTheSet];
                int counter = 0;
                while (counter < numbersFromKeyboard.length) {
                    int label = counter + 1;
                    System.out.print("\nEnter the " + label + "th of the " + numbersFromKeyboard.length + " numbers: ");
                    try {
                        numbersFromKeyboard[counter] = scan.nextInt();
                        counter += 1;
                    } catch (java.util.InputMismatchException ex) {
                        System.out.println("Only integer numbers are allowed as appropriate input values");
                        return;
                    }
                }
                System.out.print("You have the following numbers in your set: ");
                for (int i = 0; i < numbersFromKeyboard.length; i++) {
                    System.out.print(numbersFromKeyboard[i] + " ");
                }
                System.out.println("\n=== Now it is time to choose two numbers for the mathematical operations ===");
                try {
                    System.out.print("Which index of the numbers list you want as the first number: ");

                    int firstNumberIndex = scan.nextInt();
                    if (firstNumberIndex < 0 || firstNumberIndex >= numbersFromKeyboard.length) {

                        System.out.println(" There is no number at the " + firstNumberIndex + "th position");
                        return;
                    }
                    double firstNumber = numbersFromKeyboard[firstNumberIndex];
                    System.out.print("\n Which index of the numbers list you want as the second number: ");
                    int secondNumberIndex = scan.nextInt();
                    if (secondNumberIndex < 0 || secondNumberIndex >= numbersFromKeyboard.length) {

                        System.out.println(" There is no number at the " + secondNumberIndex + " position");
                        return;
                    }
                    double secondNumber = numbersFromKeyboard[secondNumberIndex];
                    System.out.println("=== You chose " + firstNumber + " and " + secondNumber + " for the operations ===");

                    double sum = firstNumber + secondNumber;
                    double difference = Math.abs(firstNumber - secondNumber);
                    double product = firstNumber * secondNumber;
                    double quotient = firstNumber / secondNumber;
                    System.out.println("\n");

                    System.out.println("Sum: " + sum);
                    System.out.println("Difference: " + difference);
                    System.out.println("Product: " + product);
                    System.out.println("Quotient: " + quotient);

                } catch (java.util.InputMismatchException ex) {
                    System.out.println("Array index can be only whole number");
                } catch (ArithmeticException ex) {
                    System.out.println("Division by zero is not allowed");
                }

            }
        } catch (java.util.InputMismatchException ex) {
            System.out.println("Sorry, Only natural numbers can be entered for size of numbers");
        }

    }
}
