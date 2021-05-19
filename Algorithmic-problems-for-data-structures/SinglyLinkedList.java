package SinglyLink;
import java.util.Iterator;


import java.util.*;
/**
 * A basic singly linked list implementation.
 */

/**
 * @author Salmane Madkour , 19724421
 *
 * @author Aonghus lawlor
 *
 * reference : Data structures and algorithms.
 *
 * Implementation of Singly linked list.
 *
 * list implementation for the functions: isEmpty(),get(int i ) , add( int i , E e ) , addFirst(E e )
 * addLast( E e ) , remove( int i ) , removeLast() , removeFirst(), iterator(), first() , last()
 * reverse() , toString().
 *
 * the singly linked list contains an inner node class to represent list nodes.
 */
public class SinglyLinkedList<E> implements Cloneable, Iterable<E>, List<E> {

    //---------------- nested Node class ----------------

    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */

    public static class Node<E> {
        private E element;// element that is going to be stored in the node
        Node<E> next;// meaning it goes to the next node of the list
        /**
         * creates a new node on the element that is given and for the next node.
         * it goes through the next node.
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        //accessor for element
        public E getElement() {
            return element;
        }
        //accessor for next node meaning Node<E>
        public Node<E> getNext() {
            return this.next;
        }
        //mutator for next node<E>
        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() {
        head = new Node<E>(null, null);
    }              // constructs an initially empty list

    // access methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    // returning size
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    //returning empty
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    //returning false on contains function
    public boolean contains(Object o) {
        return false;
    }

    @Override
    /**
     * it basically goes at index of i of the list by returning the element.
     * @param i a index of the list which require element
     * @param return returning th element of index i
     */
    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            // if index is less than zero or index greater than or equal to then throw run time exception and say cannot get
            throw new RuntimeException("cannot get");
        }
        Node<E> curr = head;
        Node<E> prev = null;
        for (int k = 0; k < i; k++) {
            prev = curr;
            curr = curr.getNext();
        }
        return curr.getElement(); // returning the element
    }

    @Override
    /**
     *
     */
    public E set(int i, E e) throws IndexOutOfBoundsException {
        Node<E> curr = head;
        int index = 0;
        while (index != i) {
            curr = curr.getNext();
            index++;
        }
        E a = curr.next.element;
        curr.next.element = e;

        return a;
    }

    /**
     * inserts a element e at the index of i for the list
     * @param i index so we can insert the element e
     * @param e because of the given index the element e to be inserted.
     * @throws IndexOutOfBoundsException if a specified list is out of bounds
     */

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Indexing is out of bounds");
        } else {
            if (i == 0) {
                addFirst(e);
            } else {
                Node<E> prev = head;
                Node<E> curr = prev.next;
                for (int f = 1; f <= size; f++) {
                    if (f == i) {
                        // inserting the require index of the new node.
                        Node<E> newOne = new Node<>(e, curr); //creating a new node to be inserted
                        prev.next = newOne;
                        size++;
                        break;
                    }
                    prev = prev.next;
                    curr = curr.next;
                }
            }

        }
    }

    /**
     * Remove the element at index i of the list
     * @param i it is a index from which element tha is going to be removed.
     * @return basically returns the element that has been removed.
     * @throws IndexOutOfBoundsException if a specified list is out of bounds.
     */
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        Node<E> curr = head;
        int index = 0;
        if (i == 0) {
            //setting index to 0 if the statement is true then call remove first function.
            removeFirst();
        }
        for (int j=0;j<i-1;j++)
            curr=curr.getNext();

        Node<E> tmp = curr.getNext(); // temporary node for list traversal.

        curr.setNext(tmp.getNext());
        size--; // decrementing the size

        return tmp.element; // returning the temporary element
    }

    @Override
    // returning zero in the function indexof and passing the object
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    //returning 0 at lastindexof function and passing the object
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    // returning null in the list iterator
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    //returning null in the list iterator and passing a integer variable
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    //returning null and sublist and passing 2 integer variables and
    public List<E> subList(int fromIndex, int toIndex) {
        return null; // return null
    }


    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (isEmpty()) return null; // return null if the list is empty
        return head.getElement(); // return the element
    }

    /**
     * Returns the last node of the list
     *
     * @return last node of the list (or null if empty)
     */
    public Node<E> getLast() {
        return null; // returning null in the getlast function

    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {

        if (isEmpty()) return null;// if the list is empty return null
        return get(size - 1);
    }

    public E removeLast() {

        return this.remove(size - 1);     // returning remove last element on the list
    }


    // update methods

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {
        // TODO
        Node<E> tmp = head;
        if (tmp == null)
            head = new Node<>(e, null);
        else
            head = new Node<>(e, tmp);

        size++; // incrementing the size
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {
        if (this.isEmpty()) {
            addFirst(e);
            return;
        }
        Node<E> curr=head;
        for (int i=0;i<size-1;i++)
            curr=curr.getNext(); // making the current last node point the newly node.
        curr.setNext(new Node<E>(e,null));

        size++; // incrementing the size

    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty()) return null;
        // storing first element in the variable and remove the node.
        E answer = head.getElement();
        head = head.getNext();
        size--;
        return answer;
    }

    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
        if (o instanceof SinglyLinkedList) {
            SinglyLinkedList<E> other = (SinglyLinkedList<E>) o;
            if (other.size() == this.size()) {
                Iterator<E> it1 = (other.iterator());
                Iterator<E> it2 = this.iterator();
                while (it1.hasNext()) {
                    if (it1 != it2)
                        return false;
                    it1.next();
                    it2.next();
                }
                return true;
            }

        }
        return false;   // if we reach this, everything matched successfully
    }

    @SuppressWarnings({"unchecked"})
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> newSLL = new SinglyLinkedList<E>();
        for (Iterator<E> it = this.iterator(); it.hasNext(); ) {
            E iteration = it.next();
            newSLL.addLast(iteration);

        }
        return null;
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    /**
     * gives the representation of the string list
     * @return returning the string containing comma that is separated by the list of elements
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

    // inner class that instance that is returned by the iterator method.
    private class SinglyLinkedListIterator<E> implements Iterator<E> {
        int i = 0; // initializing i to zero
        Node<E> curr = (Node<E>) head;

        @Override
        public boolean hasNext() {
            // TODO
            return i < size; // returning i less than the size
        }

        @Override
        public E next() {
            // TODO
            Node<E> temp = curr;
            i++;
            curr = curr.next;

            return temp.element; // returning the temporarily variable
        }
    }


    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>(); // returning the singly linked list
    }

    @Override
    public Object[] toArray() {
        return new Object[0]; // returning the object at index 0
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null; // returning null
    }

    @Override
    public boolean add(E e) {
        return false; // returning false in the add  function
    }

    @Override
    public boolean remove(Object o) {
        return false; // returning false in the remove function
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false; // returning false in the contains all.
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;// returning false in add all function
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false; //returning false on the function addall
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false; // return false in remove all function
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false; // returning false on the function retain all
    }

    @Override
    public void clear() {

    }

    //for testing purposes only
    public void print() {
        System.out.println(toString());
    }
    // main method to run the tests and the program.
    public static void main(String[] args) {
        ArrayList<String> all;
        LinkedList<String> ll;
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();


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

}