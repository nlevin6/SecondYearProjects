package LA3Q2;

import LA3Q1.*;

import static LA3Q1.NikitaDemoHashingWithLinearProbing.*;

public class NikitaHashingWithAllOpenAddressingTechniques {
    public static void main(String[] args) {
        myHeader(3, 2);
        System.out.print("Let's demonstrate our understanding on all the open addressing techniques...\n");
        System.out.print("How many data items: ");
        items = input.nextInt(); //take user input for number of items
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble(); //take user input for the load factor
        tableCapacity = checkPrime((int) (items / lf)); //calculate the tableCapacity using the checkPrime method
        System.out.printf("The minimum required table capacity would be: %d\n", tableCapacity);
        hashTable = new NikitaValueEntry[tableCapacity];//set hashTable to be the size of the table capacity

        emptyHashTable();
        Integer[] myArr = new Integer[]{14,1,17,32,19};
        System.out.print("The given dataset is: ");
        printArray(myArr);
        System.out.println("Let's enter each data item from the above to the hash table:\n");

        System.out.println("Adding data - linear probing resolves collision");
        for (Integer i : myArr) {//add each item from the array into the probing method
            addValueLinearProbe(i);
        }
        printHashTable();
        emptyHashTable();//reset the hash table between each probing method
        System.out.println("\nAdding data - quadratic probing resolves collision");
        for (Integer i : myArr) {//add each item from the array into the probing method
            addValueQuadraticProbe(i);
        }
        printHashTable();
        emptyHashTable();//reset the hash table between each probing method
        System.out.println("\nAdding data - double-hashing resolves collision");
        System.out.println("The q value for double hashing is: " + thePrimeNumberForSecondHashFunction(tableCapacity));
        for (Integer i : myArr) {//add each item from the array into the probing method
            addValueDoubleHashing(i);
        }
        printHashTable();


        myFooter(3, 2);

    }

    public static void addValueDoubleHashing(Integer key) {
        try {
            NikitaValueEntry entry = new NikitaValueEntry(key); //make instance of the hashEntry which is using key
            int hashValue = entry.getKey() % tableCapacity; //ex: if table capacity is 7, and my keys are 14,1,17,32,19, the index would be 0,1,3,4,5,6
            int previousPrime = thePrimeNumberForSecondHashFunction(tableCapacity - 1);//using previous prime number calc hashValue2
            int hashValue2 = previousPrime - (entry.getKey() % previousPrime);
            if (hashValue < 0) {
                hashValue += tableCapacity; //need to do this to account for negative numbers, so that they would have the right index
            }
            while (hashTable[hashValue].getKey() != -1) {//double probe this bad boy
                hashValue += hashValue2;//increment hashValue index by the step size which is the previous prime number to the table capacity (if table capacity is 23 then increment by 19)
                hashValue %= tableCapacity;//wrap around
            }
            //use available slot if the key is not found
            hashTable[hashValue] = entry;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Probing failed! Use a load factor of 0.5 or less. Goodbye!\n");
        }
    }

    public static void addValueQuadraticProbe(Integer key) {
        try {
            NikitaValueEntry entry = new NikitaValueEntry(key); //make instance of the hashEntry which is using key
            int hashValue = entry.getKey() % tableCapacity; //ex: if table capacity is 7, and my keys are 14,1,17,32,19, the index would be 0,1,3,4,5,6
            if (hashValue < 0) {
                hashValue += tableCapacity; //need to do this to account for negative numbers, so that they would have the right index
            }
            //search probe sequence
            int n = 0;
            while (hashTable[hashValue].getKey() != -1) { //loop through table size (11), check if there is a null available for that index, if no go into while loop, if yes just put it in
                //note first available slot
                hashValue = n * n;//next cell
                n++;
                hashValue %= tableCapacity; //wrap around
            }
            //use available slot if the key is not found
            hashTable[hashValue] = entry;
        } catch (ArrayIndexOutOfBoundsException e) { //catch bad values that can't be probed
            System.out.print("Probing failed! Use a load factor of 0.5 or less. Goodbye!\n");
        }


    }

    public static void printArray(Integer[] arr) {
        System.out.print("[");
        for (Integer integer : arr) {//loop through the array and print it
            System.out.print(integer + ", ");
        }
        System.out.print("\b\b]\n");
    }

    public static void emptyHashTable() {
        //Instantiate the table contents with no-argument constructor. so that all the nulls be replaced with -1, since the flag for null is -1
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new NikitaValueEntry();
        }
    }

    public static int thePrimeNumberForSecondHashFunction(int q) {//q will accept the current table capacity
        for (int i = q - 1; i >= 2; i--) {//ex: pass 23. so i=22, loops until i>=2, subtract i every run
            boolean prime = true;//use boolean to check if its prime
            for (int j = 2; j <= Math.sqrt(i); j++) {//ex: start looping from j=2, until sqrt(22)=4 since its int, add +1 j every run
                if (i % j == 0) { //is 22 mod 2 = 0? yes, not prime number, break out of this loop, go to outer loop, i is now 21. 21 mod 2=0? no. try 21 mod 3? yes, not prime
                    prime = false;
                    break;
                }
            }
            if (prime) {//keep repeating until we reach 19. 19 mod 2=0? no its 1, 19 mod 3=0? no its 1, 19 mod 4=0? no its 3. j for loop conditions have been met,
                return i;//so prime number have been found. return i which is 19
            }
        }
        return 2; //default return value
    }
}

