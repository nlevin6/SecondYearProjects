package LA1Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoSinglyLinkedList {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isLooping = true;
        myHeader(1);

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(56, -22, 34, 57, 98));
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));

        //print lists
        System.out.print("The given Integer array: ");
        System.out.println(Arrays.toString(numbers.toArray()));
        System.out.print("The given String array: ");
        System.out.println(Arrays.toString(names.toArray()));

        //declaring the two linked lists
        SinglyLinkList<Integer> linkedNums = new SinglyLinkList<>();
        SinglyLinkList<String> linkedNames = new SinglyLinkList<>();

        //populate the linkedNums array, add 3 elements from the head, 2 elements from the tail
        for (int i = 0; i < 3; i++) {
            linkedNums.pushAtHead(numbers.get(i));
        }
        for (int i = 4; i > 2; i--) {
            linkedNums.pushAtTail(numbers.get(i));
        }
        System.out.print("Your Integer List: ");
        System.out.println(linkedNums.toString());

        //do the same thing for the strings list
        for (int i = 0; i < 3; i++) {
            linkedNames.pushAtHead((names.get(i)));
        }
        for (int i = 4; i > 2; i--) {
            linkedNames.pushAtTail((names.get(i)));
        }
        System.out.print("Your String List: ");
        System.out.println(linkedNames.toString() + "\n");
        System.out.println("Stack demo with the Integer linked list...");
        stackDemo(linkedNums);//start the stack demo
        System.out.print("\nQueue demo with the String linked list...");
        queueDemo(linkedNames);//start the queue demo

        System.out.print("\n\nLet's search the Stack...");
        System.out.printf("\nThe current stack: %s\n", linkedNums.toString());

        while (isLooping) {
            System.out.print("Enter the value you are searching for: ");
            input = new Scanner(System.in);
            try {
                int searechedValue = input.nextInt();
                if (linkedNums.searchStack(searechedValue) == 0)
                    System.out.println("The value is not found!");
                else
                    System.out.printf("The value %d is found in location %d from the top of the stack\n", searechedValue, linkedNums.searchStack(searechedValue));
                System.out.print("Do you want to continue? (enter 'y' for yes or enter any other key to discontinue): ");
                char userChoice = input.next().charAt(0);
                if (userChoice != 'y')
                    isLooping = false;
            } catch (InputMismatchException e) {
                System.out.print("Not a valid input!\n");
            }

        }
        myFooter(1);

    }

    public static void stackDemo(SinglyLinkList list) {
        boolean sendTest = true;
        System.out.println("Which end of the Linked List would you like to use as the stack top?");
        while (sendTest) {
            try {
                System.out.print("Enter 1 for head or 2 for tail: ");
                input = new Scanner(System.in);
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("\nStack Top: Head of the linked list");
                        System.out.print("\n\nLet's pop all the elements from the stack in sequence: ");
                        System.out.printf("\nThe current stack: %s\n", list.toString());

                        //send message one by one saying which element has been removed
                        for (int i = 0; i < 5; i++) {
                            System.out.printf("\n%s has been popped! The revised stack: %s", list.popAtHead(), list.toString());
                        }
                        System.out.print("\n\nLet's push 39 and -58 in the stack...");
                        System.out.printf("\nThe current stack: %s", list.toString());

                        //push new elements into the linked list
                        list.pushAtTail(39);
                        System.out.printf("\nAfter 39 is pushed, the revised stack: %s", list.toString());
                        list.pushAtTail(-58);
                        System.out.printf("\nAfter -58 is pushed, the revised stack: %s\n", list.toString());
                        sendTest = false;
                        break;
                    case 2:
                        System.out.print("\nStack Top: Tail of the linked list");
                        System.out.print("\n\nLet's pop all the elements from the stack in sequence: ");
                        System.out.printf("\nThe current stack: %s\n", list.toString());

                        //send message one by one saying which element has been removed
                        for (int i = 0; i < list.getSize(); i++) {
                            System.out.printf("\n%s has been popped! The revised stack: %s", list.popAtTail(), list.toString());
                        }
                        System.out.print("\n\nLet's push 39 and -58 in the stack...");
                        System.out.printf("\nThe current stack: %s", list.toString());

                        //push new elements into the linked list
                        list.pushAtTail(39);
                        System.out.printf("\nAfter 39 is pushed, the revised stack: %s", list.toString());
                        list.pushAtTail(-58);
                        System.out.printf("\nAfter -58 is pushed, the revised stack: %s\n", list.toString());
                        sendTest = false;
                        break;
                    default:
                        throw new InputMismatchException();

                }
            } catch (InputMismatchException e) {
                System.out.print("Not a valid input!\n");
            }
        }
    }

    public static void queueDemo(SinglyLinkList list) {
        System.out.print("\nNote: Head is the Q-front, and Tail is the Q-rear");
        System.out.print("\n\nLet's enqueue Joelle and Lukas in the queue in sequence...");
        System.out.printf("\n\nThe current Queue: %s\n", list.toString());

        //push new strings into the linked list at tail
        list.enqueueAtTail("Joelle");
        System.out.printf("\nAfter Joelle is enqueued, the revised Queue: %s", list.toString());
        list.enqueueAtTail("Lukas");
        System.out.printf("\nAfter Lukas is enqueued, the revised Queue: %s\n", list.toString());

        //remove first three strings from the linked list at head
        for (int i = 0; i < 3; i++) {
            System.out.printf("\n%s has been dequeued! The revised queue: %s", list.dequeueAtHead(), list.toString());
        }
    }

    public static void myHeader(int labNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Exercise %d-Q1\n", labNum);
        System.out.print("Prepared By: Nikita Levin\n");
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Understand how linked lists work\n");
        System.out.print("=======================================================\n");
    }

    public static void myFooter(int questionNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Assignment %d is successful!\n", questionNum);
        System.out.print("Signing off - Nikita\n");
        System.out.print("=======================================================");
    }


}
