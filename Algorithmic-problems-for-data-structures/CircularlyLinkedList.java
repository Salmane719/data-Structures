import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Implementation of Circular linked list.
 * @author salmane Madkour
 *
 * @author Aonghus lawlor
 *
 * reference : Data structures and algorithms.
 *
 *contains an inner node class to represent list nodes
 *
 * the Circularly  linked list implemented functions: isEmpty() ,get(int i ) , add(int i , E e) , addFirst(E e),
 * remove(int i) , removeFirst() , E removeLast() , iterator <E> iterator()
 *
 * additional functions : last (), first() , rotate() , toString()
 *
 */
public class CircularlyLinkedList<E> implements List<E> {
    //---------------- nested Node class ----------------
    /**
     * Singly linked node, which stores a reference to its element and
     * to the subsequent node in the list.
     */
    private static class Node<E> {
        // TODO
        private E element ;
        private CircularlyLinkedList.Node<E> next ;
        public Node(E e , CircularlyLinkedList.Node<E> n){
            element = e ;
            next = n ;
        }
        public E getElement ( ) { return element;}
        public CircularlyLinkedList.Node<E> getNext() { return  next;}
        public void setNext(CircularlyLinkedList.Node<E> n) { next = n;}

    } //----------- end of nested Node class -----------

    // instance variables of the CircularlyLinkedList
    /** The designated cursor of the list */
    private Node<E> tail = null;                  // we store tail (but not head)

    /** Number of nodes in the list */
    private int size = 0;                         // number of nodes in the list

    /** Constructs an initially empty list. */
    public CircularlyLinkedList() { }             // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        E ans = null;
        int index = 0;
        Iterator<E> itr = iterator();
        if (!isEmpty()) { // check if it not empty
            if (itr.hasNext()) {  // than go through has next
                do {
                    if (!(index != i)) {
                        ans = itr.next();
                        break;
                    }
                    itr.next();
                    index++;
                } while (itr.hasNext());// iterating through the loop
            }
            return ans;
        } else {
            return null;
        }
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index outside");
        } else if (i >= size) {
            throw new IndexOutOfBoundsException("Index outside");
        }
        if(!(i != 0)){
            E prev = tail.next.element;
            tail.next.element = e;
            return prev;
        }else {
            Node<E> temp = tail.next.next;
            E prev = null;
            int j = 1;
            //loop and increment until we get to index i
            while (!(temp == tail.next)) {
                //change the value
                if (!(i != j)) {
                    prev = temp.element;
                    temp.element = e;
                    break;
                }
                temp = temp.next;
                j++;
            }
            //return old value
            return prev;
        }
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0) {
            throw new RuntimeException("Specified index is out of bounds!");
        } else if (i > size) {
            throw new RuntimeException("Specified index is out of bounds!");
        } else {
            if (i == 0) {
                addFirst(e);
            } else if (i == size) {
                addLast(e);
            } else {
                Node<E> newest = new Node<>(e, null); // Create Node to be inserted
                Node<E> temp = tail.getNext(); // Temporary Node for list traversal
                for (int index = 0; index < size; index++, temp = temp.getNext()) {
                    if (index == i - 1) {
                        // Insert new Node at required index i
                        newest.setNext(temp.getNext());
                        temp.setNext(newest);
                        break;
                    }
                }
                size++;
            }
        }
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            // Cannot remove element if list is empty or specified index is out of bounds
            return null;
        } else if (i < 0 || i >= size) {
            // Cannot remove element if list is empty or specified index is out of bounds
            return null;
        } else {
            if (i == 0) {
                return removeFirst();
            } else {
                E removed = null; // Element to be removed
                Node<E> temp = tail.getNext(); // Temporary Node for list traversal
                for (int index = 0; index < size; index++, temp = temp.getNext()) {
                    if (index == i - 1) {
                        removed = temp.getNext().getElement(); // Element to be removed
                        temp.setNext(temp.getNext().getNext()); // Destroy pointer to Node to be removed
                        size--;
                        break;
                    }
                }
                return removed;
            }
        }
    }


    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
        // TODO
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
        // TODO

        if ( isEmpty()) return null ;
        return tail.getElement();
    }

    // update methods
    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
        // TODO
        if ( tail != null){
            tail = tail.getNext();
        }

    }

    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
        // TODO
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }


    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
        // TODO
        addFirst(e);
        tail = tail.getNext();
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
        // TODO
        if (isEmpty( )) return null;
        Node<E> head = tail.getNext();
        if (head == tail) tail = null;
        else tail.setNext(head.getNext( ));
        size--;
        return head.getElement( );
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        // TODO
        StringBuilder s = new StringBuilder("[");

        for (E e : this) {
            s.append(e).append(", ");
        }

        String ss = s.substring(0, s.length() - 2);
        return ss += "]";
    }
    private class CircularlyLinkedListIterator<E> implements Iterator<E> {
        int i = 0 ;
        CircularlyLinkedList.Node<E> curr = (CircularlyLinkedList.Node<E>) tail;
        @Override
        public boolean hasNext() {
            // TODO

            return i < size;
        }

        @Override
        public E next() {
            // TODO
            CircularlyLinkedList.Node<E> temp = curr ;
            i++;
            curr = curr.next;
            return temp.element;
        }
    }

    public Iterator<E> iterator() {
        return new CircularlyLinkedListIterator<>();
    }

    // for testing the main purposes
    public static void main(String [] args) {
        ArrayList<String> all;
        LinkedList<String> ll;
        CircularlyLinkedList<String> sll = new CircularlyLinkedList<>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        System.out.println(sll.toString());

        sll.rotate();
        sll.rotate();

        for (String s : sll) {
            System.out.print(s + ", ");
        }

    }
}