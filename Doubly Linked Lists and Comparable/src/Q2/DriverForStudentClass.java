package Q2;

import java.util.ArrayList;
import java.util.Collections;

public class DriverForStudentClass {
    public static void main(String[] args) {
        Student myName = new Student();
        myHeader(myName, 3, 2);

        //create the array list
        ArrayList<Student> students = new ArrayList<>();

        //instantiate the students and add them into the list
        Student s0 = new Student();
        Student s1 = new Student("Harry", "Potter", 75.5);
        Student s2 = new Student("Ronald", "Weasley", 86.0);
        Student s3 = new Student("Hermione", "Granger", 91.7);
        Student s4 = new Student("Parvati", "Patil", 93.75);
        students.add(s0);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        System.out.print("The score card:");
        //format the final output
        System.out.println(replaceStuff(students.toString()));

        System.out.print("\nThe sorted list in terms of score in descending order....");
        Collections.sort(students, Student::compareTo);//sort the students by score in descending order
        System.out.println(replaceStuff(students.toString()));

        System.out.print("\nThe sorted list in terms of Last Names.....");
        HelperClassCompareLastNames cLast = new HelperClassCompareLastNames();
        Collections.sort(students, cLast);
        System.out.println(replaceStuff(students.toString()));

        System.out.print("\nThe sorted list in terms of First Names.....");
        HelperClassCompareFirstNames cFirst = new HelperClassCompareFirstNames();
        Collections.sort(students, cFirst);
        System.out.println(replaceStuff(students.toString()));

        myFooter(3, 2);

    }

    private static String replaceStuff(String input){
        return input.replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }

    public static void myHeader(Student myInfo, int labE_number, int q_number) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Exercise %d-Q%d\n", labE_number, q_number);
        System.out.printf("Prepared By: %s %s\n", myInfo.getFirstName(), myInfo.getLastName());
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Understand how collections work\n");
        System.out.print("=======================================================\n");
    }

    public static void myFooter(int labE_number, int q_number) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Exercise %d-Q%d is successful!\n", labE_number, q_number);
        System.out.print("Signing off - Nikita\n");
        System.out.print("=======================================================");
    }
}
