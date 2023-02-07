package LA3Q1;

public class NikitaValueEntry {
    private Integer key;

    //default constructor
    public NikitaValueEntry() {
        this.key = -1; //-1 will be considered as the null flag for the hash table
    }

    //constructor with args
    public NikitaValueEntry(int key) {
        this.key = key;
    }

    //setter method
    public void setKey(Integer key) {
        this.key = key;
    }

    //getter method
    public Integer getKey() {
        return this.key;
    }
}
