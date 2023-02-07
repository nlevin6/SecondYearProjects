package LA2Q1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class NikitaTestingSortingMethods {
    //adjust this to change the sizes of arrays easily, won't need to worry about changing lots of things, easy to have to change one variable only
    static int sz = 5;

    public static void main(String[] args) {
        //call the header method
        myHeader(2, 1);

        //adjust these to change the range of the randomly generated numbers
        int max = 93;
        int min = 13;
        //timer variables
        double startTime = 0;
        double endTime = 0;
        double sortTime = 0;
        //arrays
        Integer[] nums = new Integer[sz]; //array nums of size 5
        Integer[] backup = new Integer[sz]; //backup array

        //populate array nums with randomly generated numbers between 13 and 93
        for (int i = 0; i < sz; i++) {
            nums[i] = (int) ((Math.random() * (max - min)) + min);
        }
        //copy contents of array nums into the backup array
        System.arraycopy(nums, 0, backup, 0, sz);

        //put array as a list to take advantage of toString()
        List<Integer> listNums = Arrays.asList(nums);

        System.out.printf("Testing execution time of different sorting methods for sorting %d random numbers:\n", sz);
        System.out.printf("The unsorted list: %s\n", listNums);

        startTime = System.nanoTime();//start time
        Collections.sort(listNums);//sort using collections
        endTime = System.nanoTime();//end time
        sortTime = (endTime - startTime) / 1_000_000;//calculate sorting time and convert form nanosecond to milliseconds

        System.out.printf("Collections' Sorting Time: %.2f milliseconds\n", sortTime);
        System.out.printf("The sorted list using Collections' sort method: %s\n\n", listNums);

        //copy the backup array back into the original array, so that I sort the same unsorted array contents
        System.arraycopy(backup, 0, nums, 0, sz);
        System.out.printf("The unsorted list: %s\n", listNums);
        System.out.printf("My Selection-Sort Time: %.2f milliseconds\n", (double)selectionSort(nums)/ 1_000_000);
        System.out.printf("The sorted list using selection-sort: %s\n\n", listNums);

        System.arraycopy(backup, 0, nums, 0, sz);
        System.out.printf("The unsorted list: %s\n", listNums);
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds\n", (double) bubbleSort(nums)/ 1_000_000);
        System.out.printf("The sorted list with Bubble-sort: %s\n\n", listNums);

        System.arraycopy(backup, 0, nums, 0, sz);
        System.out.printf("The unsorted list: %s\n", listNums);
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds\n", (double) insertionSort(nums)/ 1_000_000);
        System.out.printf("The sorted list with Insertion-sort: %s\n\n", listNums);

        System.arraycopy(backup, 0, nums, 0, sz);
        System.out.printf("The unsorted list: %s\n", listNums);
        System.out.printf("My Merge-Sort Time: %.2f milliseconds\n", (double) mergeSort(nums)/ 1_000_000);
        System.out.printf("The sorted list with Merge-sort: %s\n\n", listNums);

        System.arraycopy(backup, 0, nums, 0, sz);
        System.out.printf("The unsorted list: %s\n", listNums);
        System.out.printf("My Quick-Sort Time: %.2f milliseconds\n", (double) quickSort(nums, 0, sz - 1)/ 1_000_000);
        System.out.printf("The sorted list with Quick-sort: %s\n\n", listNums);

        System.arraycopy(backup, 0, nums, 0, sz);
        System.out.printf("The unsorted list: %s\n", listNums);
        System.out.printf("My Bucket-Sort Time: %.2f milliseconds\n", (double) bucketSort(nums, 0, sz - 1, 2)/ 1_000_000);
        System.out.printf("The sorted list with Bucket-sort: %s\n\n", listNums);

        //call the footer method
        myFooter(2, 1);
    }

    //selection sort algorithm
    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long startTime = System.nanoTime();//record start time

        int n = a.length;//store array length in a variable to make it easier to visualize (im just following Quazi's pseudo code honestly)
        //move boundary of the unsorted sub-array one by one
        for (int i = 0; i < n - 1; i++) {
            int smallestIndex = i;
            //find min element in the unsorted array
            for (int j = i + 1; j <= n - 1; j++) {
                if (a[j].compareTo(a[smallestIndex]) < 0) {
                    smallestIndex = j;
                }
            }
            //switch the min element with the first element. has to be generic type T
            T temp = a[i];
            a[i] = a[smallestIndex];
            a[smallestIndex] = temp;
        }

        long endTime = System.nanoTime();//record end time
        return endTime - startTime ;//calculate total time and convert to milliseconds

    }

    //bubble sort algorithm
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long startTime = System.nanoTime();//record start time

        //outer loop to go through each element in the array, start at 1 here, so I wouldn't have to do a.length-i-1 in the inner loop, looks weird
        for (int i = 1; i < a.length; i++) {
            //inner loop to compare and exchange a pair of values in the array
            for (int j = 0; j < a.length - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    //swap the element positions here if it sees that j+1 is bigger
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();//record end time
        return endTime - startTime;//calculate total time and convert to milliseconds
    }

    //insertion sort algorithm
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long startTime = System.nanoTime(); //record start time

        int i = 0;
        int j = 0;
        //outer loop to iterate through the whole array
        for (i = 1; i <= a.length - 1; i++) {
            T key = a[i];//store element in the key
            //inner loop which will execute if j still positive or 0, and if j is greater than the stored element in the key
            for (j = i - 1; j >= 0 && a[j].compareTo(key) > 0; j--) {
                a[j + 1] = a[j];//swap location j into the location of j+1
            }
            a[j + 1] = key;//put the stored key into j+1 location, overwrite old number
        }

        long endTime = System.nanoTime(); //record end time
        return endTime - startTime; //calculate total time and convert to milliseconds

    }

    //merge sort algorithm
    public static <T extends Comparable<? super T>> long mergeSort(T[] S) {
        long startTime = System.nanoTime(); //record start time

        int n = S.length;
        if (n < 2) { //trivially sorted
            long endTime = System.nanoTime();
            return endTime - startTime;
        }
        int mid = n / 2; //divide array in half
        T[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        T[] S2 = Arrays.copyOfRange(S, mid, n); //copy of second half

        //using recursion, sort the halves. doing this without recursion will make this code way longer
        mergeSort(S1);
        mergeSort(S2);

        int i = 0;
        int j = 0;
        //merge sorted halves back into original
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0)) {
                S[i + j] = S1[i]; //copy i element of S1 and increment i
                i++;
            } else {
                S[i + j] = S2[j];//copy j element of S2 and increment j
                j++;
            }
        }

        long endTime = System.nanoTime(); //record end time
        return endTime - startTime; //calculate total time and convert to milliseconds
    }

    //quick sort algorithm
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b) {
        long startTime = System.nanoTime(); //record start time

        if (a >= b) {//trivially sorted
            long endTime = System.nanoTime(); //record start time
            return endTime - startTime; //calculate total time and convert to milliseconds
        }
        int left = a;//left side
        int right = b - 1;//right side
        T pivot = s[b];//pivot point is array at element b, the last element in the array
        T temp; //will be used for the swapping step
        while (left <= right) {
            //scan until reaching value equal or larger than the pivot point
            while (left <= right && s[left].compareTo(pivot) < 0) left++;
            //scan until reaching value equal or smaller than the pivot point
            while (left <= right && s[right].compareTo(pivot) > 0) right--;
            if (left <= right) {
                //swap values here
                temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                //reduce the range
                left++;
                right--;
            }
        }
        //put pivot into its final place
        temp = s[left];
        s[left] = s[b];
        s[b] = temp;
        //sort using recursion, much fewer lines of code
        quickSort(s, a, left - 1);
        quickSort(s, left + 1, b);

        long endTime = System.nanoTime(); //record start time
        return endTime - startTime; //calculate total time and convert to milliseconds
    }

    //bucket sort algorithm
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        long startTime = System.nanoTime(); //record start time
        //radix is 10, so create 10 buckets with vector
        Vector<Integer>[] bucket = new Vector[10];
        //make an instance of each bucket
        for (int i = 0; i < 10; i++) {
            bucket[i] = new Vector<>();
        }
        for (int i = 0; i < maxDigits; i++) {
            //clear the vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }

        long endTime = System.nanoTime(); //record start time
        return endTime - startTime; //calculate total time and convert to milliseconds
    }

    //method for extraction of the i element from a decimal number
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }

    //header
    public static void myHeader(int labNum, int qNum) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Assignment %d, Q%d\n", labNum, qNum);
        System.out.print("Prepared By: Nikita Levin\n");
        System.out.print("Student Number: 251056228\n");
        System.out.print("Goal of this Exercise: Testing sorting time of different sorting algorithms\n");
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
