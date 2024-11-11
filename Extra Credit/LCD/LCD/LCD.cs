//Name: Juliana Serrano
//Date: 11/08/2024
//Lab 5: Recursion Lab - Least Common Denominator (Extra Credit C#)
//Purpose: Takes two or more fractions and returns new fractions with least common denominator

using System;

namespace LCD
{
    class LCD1 {
        public static int[] numers;
        public static int[] denoms;
        public static void Main(string[] args) {
            FracArrays(Intro());
            NewFrac(Calculate(denoms.Length - 1));
        } // end of main class
        
        //introduces user to the program
        public static int Intro() {
            Console.WriteLine("Welcome to the Least Common Denominator Calculator");
            bool invalidNum = true;
            int fracNum = 0;
            while(invalidNum) {
                Console.WriteLine("How many fractions would you like to enter?");
                fracNum = Convert.ToInt32(Console.ReadLine());
                if (fracNum > 1) {
                    invalidNum = false;
                } else {
                    Console.WriteLine("Please enter a number greater than 1");
                }
            }
            return fracNum;
        } // end of Intro method

        // initializes array to track denominators
        public static void FracArrays(int fracNum) {
            numers = new int[fracNum]; // initialzes numerator array
            denoms = new int[fracNum]; // initialize denominator array
            //add values to each array
            for (int  i = 0; i < fracNum; i++) {
                int counter = i + 1;
                Console.WriteLine("Please enter Numerator " + counter + ": ");
                numers[i] = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("Please enter Denominator " + counter + ": ");
                denoms[i] = Convert.ToInt32(Console.ReadLine());
            } // end of for loop
        } //end of FracArrays method

        // calculates the greatest common divisor/factor of two numbers
        public static int GreatCD(int num1, int num2, int ans) {
            if (num1 % ans == 0 && num2 % ans == 0) { // if both numbers are fully divisible by ans
                return ans; // ans is returned as the greatest common divisor/factor
            } else {
                return GreatCD(num1, num2, ans - 1); //reduces the possible answer by 1 each step
            } // end of if else statement
        } // end of GreatCD method

        // calculates the least common multiple of two numbers
        public static int LeastCM(int num1, int num2) {
            // formula to find least common multiple is a * b / gcd(a,b)
            return num1 * num2 / GreatCD(num1, num2, num2);
        } // end of LeastCM method

        // calculates the final answer out of all denominators
        public static int Calculate(int index) {
            if (index == 1) { 
                return LeastCM(denoms[index - 1], denoms[index]);
            } // end of if statement
            else { 
                return LeastCM(Calculate(index - 1), denoms[index]);
            } // end of else statement
        } // end of Calculate method

        // prints out original and new fractions
        public static void NewFrac(int ans) {
            //prints out the original fractions
            Console.Write("Original Fractions: [");
            for (int i = 0; i < numers.Length; i ++) {
                Console.Write(numers[i] + " / " + denoms[i]);
                if (i < numers.Length - 1) {
                    Console.Write(", "); // prints out comma after each fraction except the last
                } // end of if statement
            } // end of for statement
            Console.WriteLine("]");
            //prints out the new fractions
            Console.Write("New Fractions: [");
            for (int i = 0; i < numers.Length; i ++) {
                // calculates the factor by which you multiply the old denominator to get the new denominator
                int mult = ans / denoms[i]; 
                Console.Write((numers[i] * mult)  + " / " + ans); 
                if (i < numers.Length - 1) { // prints out comma after each fraction except the last 
                    Console.Write(", ");
                } // end of if statement
            } // end of for statement
            Console.WriteLine("]");
        } // end of NewFrac method
    } // end of LCD class
}