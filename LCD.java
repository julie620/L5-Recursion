import java.util.Scanner;

public class LCD {
    public static Scanner input = new Scanner(System.in);
    public static int[] numers;
    public static int[] denoms;

    public static void main (String[] args) {
        fracArrays(intro());
        newFrac(calculate(2));
    }

    // introduces user to the program
    public static int intro() {
        System.out.println("Welcome to the Least Common Denominator Calculator");
        System.out.println("How many fractions would you like to enter?");
        int fracNum = input.nextInt();
        input.nextLine();
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
        }
    } // end of fracArrays method

    // calculates the greatest common divisor/factor of two numbers
    public static int gcd(int num1, int num2, int ans) {
        if (num1 % ans == 0 && num2 % ans == 0) { // if both numbers are fully divisible by ans
            return ans; // ans is returned as the greatest common divisor/factor
        } else {
            return gcd(num1, num2, ans - 1); //reduces the possible answer by 1 each step
        }
    } // end of gcd method

    // calculates the least common multiple of two numbers
    public static int lcm(int num1, int num2) {
        // formula to find least common multiple is a * b / gcd(a,b)
        return (num1 * num2) / gcd(num1, num2, num2);  
    } // end of lcm method

    // calculates the final answer out of all denominators
    public static int calculate(int index) {
        if (denoms.length == 2) { // if there are only two fractions lcm runs once
            return lcm(denoms[0], denoms[1]);
        }
        /*if we are at the last index of the denoms array the final answer is 
        the lcm of the previously calcualted lcm and the last denominator*/
        else if (index == denoms.length - 1) { 
            return lcm(lcm(denoms[index - 2], denoms[index - 1]), denoms[index]);
        } 
        /*to calculate the lcm of more than 2 values you can use the least common multiple of
        two other values EX. 3 values {a, b, c} The lcm = lcm(lcm(a,b), c)*/
        else { 
            return lcm(lcm(denoms[index - 1], denoms[index]), denoms[index + 1]);
        }
    } // end of calculate

    // prints out original and new fractions
    public static void newFrac(int ans) {
        //prints out the original fractions
        System.out.print("Original Fractions: [");
        for (int i = 0; i < numers.length; i ++) {
            System.out.print(numers[i] + " / " + denoms[i]);
            if (i < numers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        //prints out the new fractions
        System.out.print("New Fractions: [");
        for (int i = 0; i < numers.length; i ++) {
            // calculates the factor by which you multiply the old denominator to get the new denominator
            int mult = ans / denoms[i]; 
            System.out.print((numers[i] * mult)  + " / " + ans); 
            if (i < numers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    } // end of newFrac method
}