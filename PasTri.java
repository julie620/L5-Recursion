//Name: Juliana Serrano
//Date: 11/10/2024
//Lab 5: Recursion Lab - Pascal's Triangle
//Purpose: Creates Pascal's Triangle based on user-specified number of rows

import java.util.Scanner;

public class PasTri {
    public static Scanner input = new Scanner(System.in);
    public static void main (String[] args) {
        triangle(intro() - 1, 0); // rows start at 0 for calculation purposes
    }

    // introduces program to user and ask for amount of rows
    public static int intro() {
        System.out.println("Welcome to the Pascal's Triangle Generator");
        System.out.println("How many rows would you like?");
        int totalRows = input.nextInt();
        input.nextLine();
        return totalRows;
    } // end of intro method

    // calculates the numbers in a certain row
    //Equation to calcualte element (k) of row (n): previousElemnt * (n + 1 - k) / k
    public static void calcRow(int n, int k, int pre) {
        if (k == n) {
            System.out.print(pre + " ");
            System.out.print(pre * (n + 1 - k) / k + " ");
        } // end of if statement
        else {
            System.out.print(pre + " ");
            pre = pre * (n + 1 - k) / k;
            calcRow(n, k + 1, pre);
        } // end of else statement
    } //end of calcRow method

    public static void space(int n) {
        for (int i = 0; i < n; i ++) {
            System.out.print(" ");
        }
    }

    // prints out traingle
    public static void triangle(int totalRows, int row) {
        if (row == 0) { // prints first row
            System.out.println();
            space(totalRows);
            System.out.println(1);
            triangle(totalRows, row + 1);
        } // end of if statement
        else if (row == totalRows) { // prints last row
            calcRow(row, 1, 1);
            System.out.println();
        } // end of else if statement
        else {
            space(totalRows - row);
            calcRow(row, 1, 1);
            System.out.println();
            triangle(totalRows, row + 1);
        } // end of else statement
    } // end of triangle method
}
