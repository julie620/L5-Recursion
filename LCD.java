import java.util.Scanner;

public class LCD {
    public static Scanner input = new Scanner(System.in);
    public static int[] numers;
    public static int[] denoms;

    public static void main (String[] args) {
        fracArrays(intro());
        int lcm1 = lcm(denoms[0], denoms[1]);
        newFrac(calculate(lcm1, 2));
    }

    // calculates the greatest common divisor/factor of two numbers
    public static int gcd(int num1, int num2, int ans) {
        if (num1 % ans == 0 && num2 % ans == 0) {
            return ans;
        } else {
            return gcd(num1, num2, ans - 1);
        }
    } // end of gcd method

    // calculates the least common multiple of two numbers
    public static int lcm(int num1, int num2) {
        return (num1 * num2) / gcd(num1, num2, num2);
    } // end of lcm method

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
        numers = new int[fracNum];
        denoms = new int[fracNum];
        
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

    // calculates the final answer out of all denominators
    public static int calculate(int ans, int index) {
        if (index == denoms.length - 1) {
            return lcm(lcm(denoms[index - 2], denoms[index - 1]), denoms[index]);
        } else if (denoms.length == 2) {
            return ans;
        }else {
            return lcm(lcm(denoms[index - 1], denoms[index]), denoms[index + 1]);
        }
    } // end of calculate

    // prints out original and new fractions
    public static void newFrac(int ans) {
        System.out.print("Original Fractions: [");
        for (int i = 0; i < numers.length; i ++) {
            System.out.print(numers[i] + " / " + denoms[i]);
            if (i < numers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.print("New Fractions: [");
        for (int i = 0; i < numers.length; i ++) {
            int mult = ans / denoms[i];
            System.out.print((numers[i] * mult)  + " / " + ans);
            if (i < numers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    } // end of newFrac method
}