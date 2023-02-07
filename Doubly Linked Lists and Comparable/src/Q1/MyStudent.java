package Q1;

public class MyStudent {
    private String firstName;
    private double score;

    //default constructor
    public MyStudent() {
        firstName = "Nikita";
        score = 100;
    }

    public MyStudent(String firstName, double score) {
        this.firstName = firstName;
        this.score = score;
    }

    //override the toString() method
    @Override
    public String toString() {
        return String.format("%s: %.2f", firstName, score);
    }
}
