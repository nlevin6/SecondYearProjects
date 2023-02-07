package Q_LE2;

import java.util.*;

public class GenericsAndArrays_Nikita {
    public static void main(String[] args) {
        myHeader(2);
        boolean runLoop = true;

        ArrayList<Integer> studyYear = new ArrayList<>(Arrays.asList(2, 3, 4, 3, 2, 2));
        ArrayList<String> studentName = new ArrayList<>(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));

        Pair<Integer, String>[] studentInfo = new Pair[studyYear.size()];//make an array of key and value objects

        for (int i = 0; i < studentInfo.length; i++) {
            studentInfo[i] = new Pair<>(studyYear.get(i), studentName.get(i));//populate the array
        }

        while (runLoop) {
            System.out.print("Enter Academic Year (2,3, or 4): ");
            try {
                Scanner input = new Scanner(System.in);
                int selectedYear = input.nextInt();
                int count = 0;
                switch (selectedYear) {
                    case 2://do these to avoid duplicate code, I want all three cases to do the same thing anyway
                    case 3:
                    case 4:
                        for (int i = 0; i < studentInfo.length; i++) {
                            if (studentInfo[i].getKey() == selectedYear) {//if the key matches the user input, add up all the matching keys
                                count++;
                            }
                        }
                        System.out.printf("Found %d leader(s) from year %d.\n", count, selectedYear);
                        System.out.print("Here is the list: \n");
                        for (int i = 0; i < studentInfo.length; i++) {
                            if (studentInfo[i].getKey() == selectedYear) {
                                System.out.print(studentInfo[i].getValue() + " ");
                            }
                        }
                        System.out.println();
                        System.out.print("Do you wish to continue? (Press y to continue or any other key to terminate): ");
                        char choice = input.next().charAt(0);
                        if (choice != 'y') {
                            runLoop = false;//break the user out of the while loop and end the program
                        }
                        break;
                    default:
                        throw new InputMismatchException();//by default if the choice isn't 2,3,4 throw this error in your face
                }
            } catch (InputMismatchException e) {//catch the mismatch error and instead of crashing, print this statement
                System.out.print("Incorrect Input! ");
            }
        }
        myFooter(1);

    }

    public static void myHeader(int labNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Exercise %d-Q1\n", labNum);
        System.out.print("Prepared By: Nikita Levin\n");
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Practice array lists and generics\n");
        System.out.print("=======================================================\n");
    }

    public static void myFooter(int questionNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Exercise %d is successful!\n", questionNum);
        System.out.print("Signing off - Nikita\n");
        System.out.print("=======================================================");
    }
}
