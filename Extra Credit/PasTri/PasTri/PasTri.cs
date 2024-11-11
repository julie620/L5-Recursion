//Name: Juliana Serrano
//Date: 11/10/2024
//Lab 5: Recursion Lab - Pascal's Triangle (Extra Credit)
//Purpose: Creates Pascal's Triangle based on user-specified number of rows

using System;

namespace PasTri 
{
    public class PasTriangle {
        public static void Main(string[] args) {
            Triangle(Intro() - 1, 0);
        }
            // introduces program to user and ask for amount of rows
        public static int Intro() {
            Console.WriteLine("Welcome to the Pascal's Triangle Generator");
            Console.WriteLine("How many rows would you like?");
            int totalRows = Convert.ToInt32(Console.ReadLine());
            return totalRows;
        } // end of intro method

        // calculates the numbers in a certain row
        //Equation to calcualte element (k) of row (n): previousElemnt * (n + 1 - k) / k
        public static void CalcRow(int n, int k, int pre) {
            if (k == n) {
                Console.Write(pre + " ");
                Console.Write(pre * (n + 1 - k) / k + " ");
            } // end of if statement
            else {
                Console.Write(pre + " ");
                pre = pre * (n + 1 - k) / k;
                CalcRow(n, k + 1, pre);
            } // end of else statement
        } //end of calcRow method

        public static void Space(int n) {
            for (int i = 0; i < n; i ++) {
                Console.Write(" ");
            }
        }

        // prints out traingle
        public static void Triangle(int totalRows, int row) {
            if (row == 0) { // prints first row
                Console.WriteLine();
                Space(totalRows);
                Console.WriteLine(1);
                Triangle(totalRows, row + 1);
            } // end of if statement
            else if (row == totalRows) { // prints last row
                CalcRow(row, 1, 1);
                Console.WriteLine();
            } // end of else if statement
            else {
                Space(totalRows - row);
                CalcRow(row, 1, 1);
                Console.WriteLine();
                Triangle(totalRows, row + 1);
            } // end of else statement
        } // end of triangle method
    }
}