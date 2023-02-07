package LA3Q1;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class NikitaDemoHashingWithLinearProbing {
    public static int items;
    public static Scanner input = new Scanner(System.in);
    public static double lf;
    public static int tableCapacity;
    public static NikitaValueEntry[] hashTable;
    public static NikitaValueEntry[] workingHashTable;

    public static void main(String[] args) {
        myHeader(3, 1);
        System.out.print("Let's decide on the initial table capacity based on the load factor and dataset size");
        System.out.print("\nHow many data items: ");
        items = input.nextInt(); //take user input for number of items
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble(); //take user input for the load factor
        tableCapacity = checkPrime((int) (items / lf)); //calculate the tableCapacity using the checkPrime method
        System.out.printf("The minimum required table capacity would be: %d\n", tableCapacity);
        hashTable = new NikitaValueEntry[tableCapacity];//set hashTable to be the size of the table capacity


        //Instantiate the table contents with no-argument constructor. so that all the nulls be replaced with -1, since the flag for null is -1
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new NikitaValueEntry();
        }

        for (int i = 1; i <= items; i++) {//ask user to input value per item, store the item in the hash using the addValueLinearProbe method
            System.out.printf("Enter item %d: ", i);
            addValueLinearProbe(input.nextInt());
        }

        printHashTable();
        System.out.print("Let's remove two values from the table and then add one.......");
        System.out.print("\nEnter a value you want to remove: ");
        removeValueLinearProbe(input.nextInt());
        System.out.print("Enter a value you want to remove: ");
        removeValueLinearProbe(input.nextInt());
        System.out.print("Enter a value to add to the table: ");
        addValueLinearProbe(input.nextInt());
        printHashTable();

        System.out.print("\nRehashing the table...");
        reHashingWithLinearProbe();
        printHashTable();

        myHeader(3, 1);

    }

    //since in hashing, the prime number has to be greater than 2, we can discard 2; 0 and 1 are not prime numbers by definition
    //checking if the number is divisible by any number that isn't 1 or itself (definition of a prime number)
    public static int checkPrime(int n) {
        int m = n / 2; //need to check only half of the n factors
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) { //if n is not a prime number
                i = 2; //reset i to 2 so that it is incremented to 3 in the for loop
                n++; //go to next n value
                m = n / 2; //need to check only half of the n factors
            }
        }
        return n;
    }

    //add value using linear probing method
    public static void addValueLinearProbe(Integer key) {
        NikitaValueEntry entry = new NikitaValueEntry(key); //make instance of the hashEntry which is using key
        int hashValue = entry.getKey() % tableCapacity; //ex: if table capacity is 7, and my keys are 14,1,17,32,19, the index would be 0,1,3,4,5,6
        if (hashValue < 0) {
            hashValue += tableCapacity; //need to do this to account for negative numbers, so that they would have the right index
        }
        //search probe sequence
        while (hashTable[hashValue] != null && hashTable[hashValue].getKey() != -1 && hashTable[hashValue].getKey() != -111) { //search until empty cell or -1
            //note first available slot
            hashValue++; //go to next cell
            hashValue %= tableCapacity; //wrap around so the value incremented past the max value for its type doesn't cause an error
        }
        //use available slot if the key is not found
        hashTable[hashValue] = entry;

    }

    //remove value using linear probing method
    public static void removeValueLinearProbe(Integer key) {
        boolean keyFound = false;
        for (int i = 0; i < tableCapacity; i++) {
            if (Objects.equals(hashTable[i].getKey(), key)) {
                System.out.print(hashTable[i].getKey() + " is found and removed! ");
                hashTable[i].setKey(-111);
                printHashTable();
                keyFound = true;
            }
        }
        if (!keyFound) {
            System.out.printf("%d is not found! ", key);
            printHashTable();
        }
    }

    //print the hash table
    public static void printHashTable() {
        System.out.print("The Current Hash-Table: ");
        System.out.print("[");
        for (int i = 0; i < tableCapacity; i++) { //loop from 0 to the size of the table
            if (hashTable[i].getKey() == -1) { //if hashTable at position i is -1 print null
                System.out.print("null, ");
            } else if (hashTable[i].getKey() == -111) { //search for available flags, replace -111 with available
                System.out.print("available, ");
            } else {
                System.out.print(hashTable[i].getKey().toString() + ", ");
            }
        }
        System.out.print("\b\b]\n");
    }

    public static void reHashingWithLinearProbe() {
        workingHashTable = hashTable.clone();//copy old array into new array
        tableCapacity = checkPrime(tableCapacity * 2); //double table capacity and check if it is a prime (ex: 11*2=22 with check prime, its 23)
        System.out.printf("\nThe rehashed table capacity is: %d\n", tableCapacity);
        hashTable = new NikitaValueEntry[tableCapacity];//reset the hashTable with the new capacity
        Arrays.fill(hashTable, new NikitaValueEntry());
        for (NikitaValueEntry nikitaValueEntry : workingHashTable) {//gotta loop through the old array to extract the values
            if (nikitaValueEntry.getKey() == -111) {//if spot is available set it to null
                nikitaValueEntry.setKey(-1);
            }
            addValueLinearProbe(nikitaValueEntry.getKey());//add the values again
        }
    }

    //header
    public static void myHeader(int labNum, int qNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Assignment %d, Q%d\n", labNum, qNum);
        System.out.print("Prepared By: Nikita Levin\n");
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Hashing with open-addressing and collision-resolving\n");
        System.out.print("=======================================================\n");
    }

    //footer
    public static void myFooter(int labNum, int qNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Assignment %d,Q%d is successful!\n", labNum, qNum);
        System.out.print("Signing off - Nikita\n");
        System.out.print("=======================================================");
    }
}
