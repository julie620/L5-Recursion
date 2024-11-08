//Name: Juliana Serrano
//Date: 11/08/2024
//Lab 5: Recursion Lab - Least Common Denominator
//Purpose: Takes two or more fractions and returns new fractions with least common denominator

import java.util.Scanner;

public class LCD {
    public static Scanner input = new Scanner(System.in);
    public static int[] numers;
    public static int[] denoms;

    public static void main (String[] args) {
        fracArrays(intro());
        newFrac(calculate(denoms.length - 1));
    }

    // introduces user to the program
    public static int intro() {
        System.out.println("Welcome to the Least Common Denominator Calculator");
        Boolean invalidNum = true;
        int fracNum = 0;
        while(invalidNum) {
            System.out.println("How many fractions would you like to enter?");
            fracNum = input.nextInt();
            input.nextLine();
            if (fracNum > 1) {
                invalidNum = false;
            } else {
                System.out.println("Please enter a numebr greater than 1");
            }
        }
        return fracNum;
    } // end of intro method

    // initialzes array to track denominators
    public static void fracArrays(int fracNum) {
        numers = new int[fracNum]; // initialzes numerator array
        denoms = new int[fracNum]; // initialize denominator array
        //add values to each array
        for (int  i = 0; i < fracNum; i++) {
            int counter = i + 1;
            System.out.println("Please enter Numerator " + counter + ": ");
            numers[i] = input.nextInt();
            input.nextLine();
            System.out.println("Please enter Denominator " + counter + ": ");
            denoms[i] = input.nextInt();
            input.nextLine();
        } // end of for loop
    } // end of fracArrays method

    // calculates the greatest common divisor/factor of two numbers
    public static int gcd(int num1, int num2, int ans) {
        if (num1 % ans == 0 && num2 % ans == 0) { // if both numbers are fully divisible by ans
            return ans; // ans is returned as the greatest common divisor/factor
        } else {
            return gcd(num1, num2, ans - 1); //reduces the possible answer by 1 each step
        } // end of if else statement
    } // end of gcd method

    // calculates the least common multiple of two numbers
    public static int lcm(int num1, int num2) {
        // formula to find least common multiple is a * b / gcd(a,b)
        return (num1 * num2) / gcd(num1, num2, num2);  
    } // end of lcm method

    // calculates the final answer out of all denominators
    public static int calculate(int index) {
        if (index == 1) { 
            return lcm(denoms[index - 1], denoms[index]);
        } // end of if statement
        else { 
            return lcm(calculate(index - 1), denoms[index]);
        } // end of else statement
    } // end of calculate

    // prints out original and new fractions
    public static void newFrac(int ans) {
        //prints out the original fractions
        System.out.print("Original Fractions: [");
        for (int i = 0; i < numers.length; i ++) {
            System.out.print(numers[i] + " / " + denoms[i]);
            if (i < numers.length - 1) {
                System.out.print(", "); // prints out comma after each fraction except the last
            } // end of if statement
        } // end of for statement
        System.out.println("]");
        //prints out the new fractions
        System.out.print("New Fractions: [");
        for (int i = 0; i < numers.length; i ++) {
            // calculates the factor by which you multiply the old denominator to get the new denominator
            int mult = ans / denoms[i]; 
            System.out.print((numers[i] * mult)  + " / " + ans); 
            if (i < numers.length - 1) { // prints out comma after each fraction except the last 
                System.out.print(", ");
            } // end of if statement
        } // end of for statement
        System.out.println("]");
    } // end of newFrac method
}