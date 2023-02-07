package Q1L1;

import java.util.Scanner;

public class TestingExecutionTime {
    public static void main(String[] args) {
        myHeader(1);

        double fact = 0;
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;
        double timeElapsedInSeconds = 0;

        do {//go into loop at least once, I have to enter the loop first time no matter what so i use a do-while loop
            System.out.print("Enter an integer number: ");
            Scanner input = new Scanner(System.in);
            fact = input.nextInt();
            if (fact < 0)
                System.out.print("You have to input a positive number!\n");
        } while (fact < 0);// condition to break out of the loop, validation of user input
        startTime = System.nanoTime();//store starting time
        double result = 1;//iterative method of finding factorial done inside main loop
        int i = 1;
        while (i <= fact) {
            result = result * i;
            i++;
        }
        endTime = System.nanoTime();//store ending time
        timeElapsed = endTime - startTime;//calculate time elapsed in seconds
        timeElapsedInSeconds = (double) timeElapsed / 1_000_000_000;//convert from nanoseconds to seconds
        System.out.printf("Factorial (%d) is %.0e\n", (int) fact, result);
        System.out.printf("Time taken by iterative solution inside main: %.2e sec\n", timeElapsedInSeconds);

        startTime = System.nanoTime();//overwrite old numbers
        System.out.printf("Factorial (%d) with iterative method is %.0e\n", (int) fact, myFactorialIterative(fact));
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        timeElapsedInSeconds = (double) timeElapsed / 1_000_000_000;
        System.out.printf("Time taken by iterative method call: %.2e sec\n", timeElapsedInSeconds);

        startTime = System.nanoTime();//overwrite old numbers again
        System.out.printf("Factorial (%d) with recursive method is %.0e\n", (int) fact, myFactorialRecursive(fact));
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        timeElapsedInSeconds = (double) timeElapsed / 1_000_000_000;
        System.out.printf("Time taken by recursive method call: %.2e sec\n", timeElapsedInSeconds);


        myFooter(1);

    }

    public static void myHeader(int labNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Exercise %d-Q1\n", labNum);
        System.out.print("Prepared By: Nikita Levin\n");
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Checking the code-execution time!\n");
        System.out.print("=======================================================\n");
    }

    public static void myFooter(int questionNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Exercise %d is successful!\n", questionNum);
        System.out.print("Signing off - Nikita\n");
        System.out.print("=======================================================");
    }

    //iterative method of finding the factorial of a number
    public static double myFactorialIterative(double n) {//if n = 5 do 5*4*3*2*1
        double result = 1;//store answer
        int i = 1;

        while (i <= n) {//as long as i is less than or equal to n (inputted number by user), keep going
            result = result * i;//store answer by multiplying previous answer by the new i number
            i++;//add 1 to i to go to next number (ex: 0 then 1, then 2, then 3, etc.)
        }
        return result;// return the final answer

    }

    //recursive method of finding the factorial of a number
    public static double myFactorialRecursive(double n) {
        if (n == 1) {// in case the factorial is 1
            return 1;
        }
        return n * myFactorialRecursive(n - 1);//calc and return the factorial using recursion here
    }

}
