package Q1;

public class DoublyLinkedList<E> {

    //---start of nested class---
    public static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }
    }
    //---end of nested class---

    //instance variables of the DoublyLinkedList
    private Node<E> header;
    private Node<E> trailer;

    //size of the list
    private int size = 0;

    //constructor for the empty list
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);//create header
        trailer = new Node<>(null, header, null);//create trailer, comes after header
        header.setNext(trailer);//header is followed by trailer
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);//place just before trailer
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);//create and link a new node
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    //return the node containing element e (or null if empty)
    public Node<E> findNode(E e) {
        Node<E> temp = header; //hold the header value in a temp variable
        while (temp != null) {
            if (e == temp.getElement()) {
                return temp;//return the node if it was found
            }
            temp = temp.getNext();
        }
        return null;//return null if the list is empty
    }

    //override the toString() method
    @Override
    public String toString() {
        String result = "";
        Node<E> temp = header;
        //loop through the list
        for (int i = 0; i < size; i++) {
            temp = temp.getNext();//do this first if I don't want the first element to be null
            result += temp.getElement();//store values in result
            if (temp.getNext() != null) {//as long as the value after head isn't null, keep printing commas
                result += ", ";
            }
        }
        return ("[" + result + "\b\b]");
    }
}
