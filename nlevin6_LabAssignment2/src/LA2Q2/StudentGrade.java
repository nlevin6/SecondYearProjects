package LA2Q2;

public class StudentGrade implements Comparable<StudentGrade> {
    //data fields of StudentGrade object
    private String firstName;
    private String lastName;
    private int grade;

    //empty constructor
    public StudentGrade() {
    }

    //constructor with args
    public StudentGrade(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    //setter methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(StudentGrade s) {
        int value = 0;

        //if this score is greater than the passed score, set value to -1
        if (this.grade > s.grade)
            value = 1;

        else if (this.grade < s.grade)
            value = -1;

        //by default if neither applies, return 0
        return value;
    }

    @Override
    public String toString() {
        return String.format("\n%20s %s \t: %5d", firstName, lastName, grade);
    }
}
