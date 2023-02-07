package LA2Q2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Nikita_SortNameAndGrade {
    public static void main(String[] args) {
        myHeader(2, 2);

        //Three arrays with 8 first names, 8 last names and 8 randomly generated grades between 60 and 85 inclusive
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int) (60 + Math.random() * 26),
                (int) (60 + Math.random() * 26),
                (int) (60 + Math.random() * 26),
                (int) (60 + Math.random() * 26),
                (int) (60 + Math.random() * 26),
                (int) (60 + Math.random() * 26),
                (int) (60 + Math.random() * 26),
                (int) (60 + Math.random() * 26)};

        Vector<StudentGrade> sg = new Vector<>();
        //add each StudentGrade object into the vector class
        for (int i = 0; i < fnArray.length; i++) {
            sg.add(new StudentGrade(fnArray[i], lnArray[i], grd[i]));
        }
        System.out.print("The Unsorted Array................");
        System.out.print(printArray(sg.toString()));
        System.out.println();
        System.out.print("\nSorted by Grades................");
        Collections.sort(sg);//sort using collections, sorts by grade
        System.out.print(printArray(sg.toString()));

        //creating a backup array, same size as the first names array created earlier
        StudentGrade[] studentGradeArr = new StudentGrade[fnArray.length];
        //copy sg into the StudentGrade array
        sg.copyInto(studentGradeArr);
        System.out.print("\n\nSorted by First Names................");
        insertionSort(studentGradeArr, 1);
        System.out.print(printArray(Arrays.toString(studentGradeArr)));
        System.out.print("\n\nSorted by Last Names................");
        insertionSort(studentGradeArr, 2);
        System.out.print(printArray(Arrays.toString(studentGradeArr)));

        myFooter(2, 2);
    }

    //insertion sort algorithm
    public static void insertionSort(StudentGrade[] a, int key) {
        int i = 0;
        int j = 0;
        //outer loop to iterate through the whole array
        for (i = 1; i <= a.length - 1; i++) {
            StudentGrade temp = a[i];//store element in the key
            //inner loop which will execute if j still positive or 0, and if j is greater than the stored element in the key
            if (key == 1) {
                for (j = i - 1; j >= 0 && a[j].getFirstName().compareTo(temp.getFirstName()) > 0; j--) {
                    a[j + 1] = a[j];//swap location j into the location of j+1
                }
            } else if (key == 2){
                for (j = i - 1; j >= 0 && a[j].getLastName().compareTo(temp.getLastName()) > 0; j--) {
                    a[j + 1] = a[j];//swap location j into the location of j+1
                }
            }
            a[j + 1] = temp;//put the stored key into j+1 location, overwrite old number
        }
    }

    private static String printArray(String input) {
        return input.replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }

    //header
    public static void myHeader(int labNum, int qNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Assignment %d, Q%d\n", labNum, qNum);
        System.out.print("Prepared By: Nikita Levin\n");
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Sorting using different methods\n");
        System.out.print("=======================================================\n");
    }

    //footer
    public static void myFooter(int labNum, int qNum) {
        System.out.print("\n=======================================================\n");
        System.out.printf("Completion of Lab Assignment %d,Q%d is successful!\n", labNum, qNum);
        System.out.print("Signing off - Nikita\n");
        System.out.print("=======================================================");
    }
}
