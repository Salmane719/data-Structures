import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Implementation of doubly linked list.
 * @author salmane Madkour
 *
 * @author Aonghus lawlor
 *
 * reference : Data structures and algorithms.
 *
 *contains an inner node class to represent list nodes
 *
 * the doubly linked list implemented functions: isEmpty() ,get(int i ) , add(int i , E e) , addFirst(E e),
 * remove(int i) , removeFirst() , E removeLast() , iterator <E> iterator()
 *
 * additional functions : last (), first() , set(int i , E e) , toString()
 *
 */



public class DoublyLinkedList<E> implements List<E> {

    //---------------- nested Node class ----------------
    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    private static class Node<E> {
        // TODO
        private final E element; // this basically reference the element stored at the node
        private Node<E> prev; // previous node in the list
        private Node<E> next;// next node in the list
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement( ) { return element; }
        public Node<E> getPrev( ) { return prev; }
        public Node<E> getNext( ) { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }
    //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    private Node<E> header;                    // header sentinel

    /** Sentinel node at the end of the list */
    private Node<E> trailer;                   // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
        // TODO
        header = new Node<>(null, null, null);// it creates a header
        trailer = new Node<>(null, header, null);// it creates a trailer
        header.setNext(trailer);
    }


    // public accessor methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; } // returning the size

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; } // returning empty

    @Override
    /**
     * it basically goes at index of i of the list by returning the element.
     * @param i a index of the list which require element
     * @param return returning th element of index i
     */
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
        return null ;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0) { // check if index is less than zero
            throw new RuntimeException("Specified index is out of bounds!");
        } else if (i > size) { // check if index greater than size
            throw new RuntimeException("Specified index is out of bounds!");
        } else {
            if (!(i == 0)) { //check if i equal to zero then flipped
                if (i == size) { // checking if i equals to size
                    addLast(e);
                } else {
                    Node<E> temp = header.getNext(); // Temporary Node for list traversal
                    for (int index = 0; index < size; index++, temp = temp.getNext()) {
                        if (index == i) {
                            // Insert Node when index is found
                            addBetween(e, temp.getPrev(), temp);
                            break;
                        }
                    }
                }
            } else {
                addFirst(e);//else add first for the element e
            }
        }
    }

    @Override
    // this function removes the given node from the list and returns its element.
    public E remove(int i) throws IndexOutOfBoundsException {
        if (isEmpty()) {// check if it empty
            return null;
        } else if (i >= size) {// check if i greater than or equal to size

            return null;
        } else if (i < 0) { // check if index is less than zero
            return null;
        } else {
            if (i == 0) { // if it equal to 0 call the function removeFirst.
                return removeFirst();
            } else {
                E removed = null; // set to nul
                Node<E> temp = header.getNext();
                int index = 0;
                while (index < size) {
                    if (index == i - 1) { // check
                        removed = temp.getNext().getElement();
                        temp.setNext(temp.getNext().getNext());
                        size--;
                        break;
                    }

                    index = index + 1; // increment
                    temp = temp.getNext();
                }
                return removed;// return it

            }
        }
    }


    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        // TODO
        if (!isEmpty()) {
            return header.getNext().getElement();// first element of the header.
        }
        return null;  // check if it empty
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        // TODO
        if (!isEmpty()) {
            return trailer.getPrev( ).getElement(); // last element before trailer
        }
        return null;// check if empty

    }

    // public update methods
    /**
     * Adds an element to the front of the list.
     * @param e   the new element to add
     */
    public void addFirst(E e) {
        // TODO
        addBetween(e,header,header.getNext()); //  after the header

        return;
    }

    /**
     * Adds an element to the end of the list.
     * @param e   the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(),trailer);// before the trailer

    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        // TODO
        if (!isEmpty()) {
            return remove(header.getNext()); // beyond header
        }
        return null;
    }

    /**
     * Removes and returns the last element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        // TODO
        if (!isEmpty()) {
            return remove(trailer.getPrev());// remove last element before going in to the trailer.
        }
        return null;

    }

    // private update methods
    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor   node just before the location where the new element is inserted
     * @param successor     node just after the location where the new element is inserted
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // TODO
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest); // has to be node before
        successor.setPrev(newest);// has to be node after

        size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     * @param node    the node to be removed (must not be a sentinel)
     */
    private E remove(Node<E> node) {
        // TODO
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement(); // returning node for the element
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    // to string method used to separate list with coma and brackets
    public String toString() {
        // TODO
        StringBuilder s = new StringBuilder("[");

        for (E e : this) {
            s.append(e).append(", ");
        }

        String ss = s.substring(0, s.length() - 2);
        return ss += "]";
    }

    private class DoublyLinkedListIterator<E> implements Iterator<E> {
        int i = 0 ;
        Node<E> curr = (Node<E>) header.next;
        @Override
        public boolean hasNext() {
            // TODO

            return i < size; // returning index less than size in the has next function

        }

        @Override
        public E next() {
            // TODO
            Node<E> temp = curr ;
            i++;
            curr = curr.next;
            return temp.element; // returning temporary that has element

        }
    }
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator<E>();
    } // iterator

// testing parts and running test on main to check whether the function created are working as meant to be.

    public static void main(String [] args) {
        ArrayList<String> all;
        LinkedList<String> ll;
        DoublyLinkedList<String> sll = new DoublyLinkedList<String>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        System.out.println(sll.toString());

        for (String s : sll) {
            System.out.print(s + ", ");
        }
    }
} //----------- end of DoublyLinkedList class -----------