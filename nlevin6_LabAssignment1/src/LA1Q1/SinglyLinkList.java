package LA1Q1;

public class SinglyLinkList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    //default constructor
    public SinglyLinkList() {
    }

    public SinglyLinkList(Node<T> head, Node<T> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    //getter method to get size
    public int getSize() {
        return size;
    }

    //if the size of the list is 0, return true. If not, return false
    public boolean isEmpty() {
        return size == 0;
    }

    //override the toString method to make it return whatever I want it to return, in whatever format I pick
    @Override
    public String toString() {
        String result = "";
        Node<T> temp = head;
        //loop through the list
        for (int i = 0; i < size; i++) {
            result += temp.getElement();//store values in result
            if (temp.getNext() != null) {//as long as the value after head isn't null, keep printing commas
                result += ", ";
            }
            temp = temp.getNext();
        }
        return ("[" + result + "]");
    }

    //add an element to the front of the list
    public void addFirst(T t) {
        head = new Node<>(t, head);

        if (isEmpty())//in case the size of the list will be 0
            tail = head;
        size++;//increase list size

    }

    //add an element to the end of the list
    public void addLast(T t) {
        Node<T> newest = new Node<>(t, null);//since its added last it will point to null
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    //remove the first element from the linked list
    public T removeFirst() {
        if (isEmpty())//check if the list is empty
            return null;
        T answer = head.getElement(); //if it isn't, assign element at head to answer
        head = head.getNext();//head is equals to next element
        size--;//decrease list size by 1, since we removed an element
        if (isEmpty())
            tail = null;
        return answer;
    }

    //remove last element from linked list
    public T removeLast() {
        Node<T> n = head;
        while (n.getNext() != tail) { //while element next to head isn't the tail, keep looping
            n = n.getNext(); //set the head to the new value of head which is the one next to it
        }
        T answer = tail.getElement();//store tail element in answer type T
        size--; //reduce list size
        tail = n; //make tail equal to head
        tail.setNext(null); //set the tail next element to null

        return answer; //return answer which is of type T
    }

    public void pushAtHead(T element) {
        addFirst(element);
    }

    public T popAtHead() {
        return removeFirst();
    }

    public void pushAtTail(T element) {
        addLast(element);
    }

    public T popAtTail() {
        return removeLast();
    }

    public void enqueueAtTail(T element) {
        addLast(element);
    }

    public T dequeueAtHead() {
        return removeFirst();
    }

    public int searchStack(T element) {
        int location = 1;
        Node<T> temp = head; //hold the head value in a temp variable
        while (temp != null) {
            if (element == temp.getElement()) {//if found return the location
                return location;
            }
            location++;
            temp = temp.getNext();//overwrite old head value with the one next to it
        }
        // Returns 0 if the element is not found
        return 0;
    }

}
