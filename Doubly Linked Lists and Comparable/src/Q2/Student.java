package Q2;

public class Student implements Comparable<Student> {
    private double score;
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName, double score) {
        this.score = score;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
        this.score = 100;
        this.firstName = "Nikita";
        this.lastName = "Levin";
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("\n%-5s %s %s: %.2f"," ", firstName, lastName, score);
    }

    //this will compare student scores to each other
    @Override
    public int compareTo(Student s) {
        int value = 0;

        //if this score is greater than the passed score, set value to -1
        if (this.score > s.score)
            value = -1;

        else if (this.score < s.score)
            value = 1;

        //by default if neither applies, return 0
        return value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
