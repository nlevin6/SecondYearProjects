package Q1;

public class Driver_DoublyLinkedList {
    public static void main(String[] args) {
        myHeader(3, 1);

        //create the DLL
        DoublyLinkedList<MyStudent> nikitaList = new DoublyLinkedList<>();

        //instance of the students and their score
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);

        //add the students into the doubly linked list from the back
        nikitaList.addLast(s0);
        nikitaList.addLast(s1);
        nikitaList.addLast(s2);
        nikitaList.addLast(s3);

        //print the list
        System.out.print("Adding 4 students to the list.\n");
        System.out.print("The list Content: \n");
        System.out.print(nikitaList.toString() + "\n");

        //obtain the info for s2 and s3 and store them in back and front variables
        DoublyLinkedList.Node<MyStudent> back = nikitaList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> front = nikitaList.findNode(s3);

        //add s4 between s2 and s3
        nikitaList.addBetween(s4, back, front);

        //add s4 into the list between 2 elements in the middle
        System.out.print("Adding Hermione to the list between Luna and Vincent.....\n");
        System.out.print("The list Content: \n");
        System.out.print(nikitaList.toString() + "\n");

        myFooter(3, 1);

    }

    public static void myHeader(int labE_number, int q_number) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Exercise %d-Q%d\n", labE_number, q_number);
        System.out.print("Prepared By: Nikita Levin\n");
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Understand how doubly linked lists work\n");
        System.out.print("=======================================================\n");
    }

    public static void myFooter(int labE_number, int q_number) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Exercise %d-Q%d is successful!\n", labE_number, q_number);
        System.out.print("Signing off - Nikita\n");
        System.out.print("=======================================================");
    }
}
