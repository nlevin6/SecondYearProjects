package Q2L1;

import java.util.Scanner;

public class WorkingWithArrays {
    public static void main(String[] args) {
        myHeader(1);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int arrSize = input.nextInt();
        int[] userArray = new int[arrSize];//make array of whatever size the user picks
        double[] arrayResults;
        for (int i = 0; i < userArray.length; i++) {
            System.out.printf("Enter value %d: ", i + 1);//populate the array
            userArray[i] = input.nextInt();
        }
        System.out.print("\nHere is the result......\n\n");
        arrayResults = mma5MethodNikita(userArray);//store results in an array

        if (arrayResults.length != 0) {//check if array is populated
            System.out.printf("The max is: %.2f\n", arrayResults[0]);
            System.out.printf("The min is: %.2f\n", arrayResults[1]);
            System.out.printf("The average of the numbers divisible by 5 is %.2f\n", arrayResults[2]);
            System.out.printf("My student number is %d\n", (int) arrayResults[3]);
        } else {
            System.out.print("In the array there was no number divisible by 5\n");
        }


        myFooter(2);

    }

    public static double[] mma5MethodNikita(int[] arr) {
        int maxVal = arr[0];//make temp val for max and min, I prefer to use an existing number in the array
        int minVal = arr[0];
        double sum = 0;
        int count = 0;
        double avg = 0;
        double studentNumber = 251056228;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0) {
                //check if divisible by 5 and check if current num is bigger than current max val stored
                maxVal = Math.max(arr[i], maxVal);//if it is, overwrite current maxVal with a new maxVal
                minVal = Math.min(arr[i], minVal);
                sum = arr[i] + sum;//add up all numbers that are divisible by 5
                count++;//count how many numbers have been added up so that I could use it for average calculation
            }
        }
        avg = sum / count;//calc the average
        System.out.printf("Nikita found %d numbers that are divisible-by-5\n", count);//show how many numbers are divisible by 5
        return new double[]{maxVal, minVal, avg, studentNumber};
    }

    public static void myHeader(int labNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Exercise %d-Q2\n", labNum);
        System.out.print("Prepared By: Nikita Levin\n");
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Working with arrays and conditional statements!\n");
        System.out.print("=======================================================\n");
    }

    public static void myFooter(int questionNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Exercise %d is successful!\n", questionNum);
        System.out.print("Signing off - Nikita\n");
        System.out.print("=======================================================");
    }
}
