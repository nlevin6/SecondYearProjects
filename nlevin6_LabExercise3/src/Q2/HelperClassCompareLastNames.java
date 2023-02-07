package Q2;

import java.util.Comparator;

public class HelperClassCompareLastNames implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        char student1 = s1.getLastName().charAt(0);
        char student2 = s2.getLastName().charAt(0);

        if (student1 < student2) {
            return -1;
        }else if(student1 == student2){
            return 0;
        }
        else return 1;
    }
}
