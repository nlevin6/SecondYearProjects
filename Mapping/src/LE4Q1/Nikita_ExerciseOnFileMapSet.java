package LE4Q1;

import java.io.File;
import java.util.*;

public class Nikita_ExerciseOnFileMapSet {
    public static void main(String[] args) throws Exception {
        myHeader(4);

        //key: lastName, value: number
        TreeMap<String, Integer> lastNamesMap = new TreeMap<>();
        //key: firstName, value: number
        TreeMap<String, Integer> firstNamesMap = new TreeMap<>();

        //create a file object reference
        File file = new File("SE2205Students.txt");
        Scanner fileInput = new Scanner(file);
        //check if the file exists, if not quit the program
        if (!file.exists()) {
            System.out.println("File not found! Goodbye!");
            System.exit(0);
        }

        //populate the arrayList with all the info from the txt file
        ArrayList<String> names = new ArrayList<>();
        while (fileInput.hasNextLine()) {
            names.add(fileInput.nextLine());
        }

        //populates the map with last names and values of duplicate last names
        populateLastNames(names, lastNamesMap);
        //prints the last names and values of how many there are of each last name
        printList(lastNamesMap, true);//use boolean to swap title depending on if it is a last names or first names list

        System.out.println();

        //do the same as above but for first names
        populateFirstNames(names, firstNamesMap);
        printList(firstNamesMap, false);

        fileInput.close(); //close the file

        myFooter(4);
    }

    public static void printList(TreeMap<String, Integer> map, boolean lastName) {
        if (lastName) {
            System.out.println("List of the Number of students with the same Last Names: ");
            System.out.printf("Last-name %-9s numbers\n", " ");
        } else {
            System.out.println("List of the Number of students with the same First Names: ");
            System.out.printf("First-name %-9s numbers\n", " ");
        }
        System.out.println("---------------------------");
        String format = "%-20s%s%n";
        Set<String> x = map.keySet();//keySet returns a set having the keys of the hashmap
        for (Object p : x) {//loop through the set
            if (map.get(p) > 1) {//print the lines where value is greater than 1, so duplicate names and last names only
                System.out.printf(format, p, map.get(p));//format and print the key and value on each line
            }
        }
    }

    public static void populateLastNames(ArrayList<String> names, TreeMap<String, Integer> map) {
        //loop through the arraylist with all the names and last names
        for (String line : names) {
            //pull out the last name only and store in a string which will be the key for the map
            String key = line.replaceAll("\\s.*", "");

            if (map.get(key) == null) {//go to treeMap and get key which is defined above
                map.put(key, 1);//if the key (string) is null, put key with value of 1
                //since counting starts at null i cant have a null as a value so i gotta start from value 1
            } else {
                int value = map.get(key);//create value int, set it equal to map's key
                value++;//count how many people have the same key (last name)
                map.put(key, value);//go to map and add the key (last name) along with value (amount of people with the same last name)
            }
        }
    }

    public static void populateFirstNames(ArrayList<String> names, TreeMap<String, Integer> map) {
        //loop through the arraylist with all the names and last names
        for (String line : names) {
            //pull out the first name only and store in a string which will be the key for the map
            String key = line.replaceAll("^.*?(?<=\\s)([^\\s]+)$", "$1");

            if (map.get(key) == null) {//go to treeMap and get key which is defined above
                map.put(key, 1);//if the key (string) is null, put key with value of 1
                //since counting starts at null i cant have a null as a value so i gotta start from value 1
            } else {
                int value = map.get(key);//create value int, set it equal to map's key
                value++;//count how many people have the same key (last name)
                map.put(key, value);//go to map and add the key (last name) along with value (amount of people with the same last name)
            }
        }
    }

    public static void myHeader(int labNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Exercise %d\n", labNum);
        System.out.print("Prepared By: Nikita Levin\n");
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Using files, maps and sets together\n");
        System.out.print("=======================================================\n");
    }

    public static void myFooter(int labNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Exercise %d is successful!\n", labNum);
        System.out.print("Signing off - Nikita\n");
        System.out.print("=======================================================");
    }
}
