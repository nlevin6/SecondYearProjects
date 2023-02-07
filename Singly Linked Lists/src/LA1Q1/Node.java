package LA1Q1;
//Template class for Node
public class Node<T> {
    private T element;
    private Node<T> next;

    //default constructor
    public Node() {
    }

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    //getter methods that will return values element and next
    public Node<T> getNext() {
        return next;
    }

    public T getElement() {
        return element;
    }

    //setter method to set value next
    public void setNext(Node<T> next) {
        this.next = next;
    }

}
