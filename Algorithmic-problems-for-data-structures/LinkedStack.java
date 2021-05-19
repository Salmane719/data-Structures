/**
 * implementation of a linked list that goes to the stack
 *
 * implements functions of stack : size() , isEmpty() , push( E e ) , top (), pop()
 *
 * additional functions: toString()
 *
 * @author salmane Madkour , 19724421
 * @author Aonghus lawlor
 *
 * refrence:data structures.
 */

import SinglyLink.SinglyLinkedList;
public class LinkedStack<E> implements Stack<E> {
	private SinglyLinkedList<E>  element_of_list = new SinglyLinkedList<>();
	// creating a linkedStack function.
	public LinkedStack()
	{
		;
	}
	// testing the main method to check whether the functions are working properly.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack<Integer> linked_stack = new LinkedStack<Integer>();
		linked_stack.push(1);
		linked_stack.push(2);
		System.out.println(linked_stack);
	}
	// gets the current number of stack elements and return the
	// current size of teh stack
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return element_of_list.size();
	}
	//check if the stack is empty
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return element_of_list.isEmpty();
	}
	// inserts element at the top
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		element_of_list.addFirst(e);
	}

	@Override
	// find the top element at the top stack
	public E top() {
		// TODO Auto-generated method stub
		return element_of_list.get(0);
	}

	@Override
	//removes element from the top stack
	public E pop() {
		E e = element_of_list.removeFirst();
		return e;
	}
	// using ToString here the gets the string representation of
	// the stack
	public String toString()
	{
		return element_of_list.toString();
	}

}