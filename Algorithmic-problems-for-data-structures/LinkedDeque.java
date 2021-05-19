/**
 * implementation of a linked list that goes to the Deque
 *
 * implements Deque functions : size() , isEmpty, first() ,last(),
 * addLast(), addFirst(), removeFirst(), removeLast()
 *
 * extra functions added : to string() .
 * @author salmane Madkour , 19724421
 * @author Aonghus lawlor
 * reference : data structures.
 */
public class LinkedDeque<E> implements Deque<E> {
	private DoublyLinkedList<E> list = new DoublyLinkedList<>();
	// main method to  run tests on it to check whether the functions
	// are working properly or not.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedDeque<Integer> lD = new LinkedDeque<>();
		lD.addFirst(11);
		lD.addFirst(21);
		lD.addLast(31);
		lD.addLast(48);
		System.out.println(lD);
		System.out.println(lD.first());
		lD.removeLast();
		lD.removeFirst();
		System.out.println(lD);
	}

	@Override
	// returns number of elements in the deque
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	//checks  whether the deque is empty.
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	//returns the first element of the deque.
	public E first() {
		// TODO Auto-generated method stub
		return list.get(0);
	}

	@Override
	//returns last element of the deque
	public E last() {
		// TODO Auto-generated method stub
		return list.get(size());
	}

	@Override
	//inserts element at the front of the queue
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		list.addFirst(e);
	}

	@Override
	//inserts element at the back of the deque
	public void addLast(E e) {
		// TODO Auto-generated method stub
		list.addLast(e);
	}

	@Override
	// removes and returns first element of the deque
	public E removeFirst() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	// removes and returns last element of the deque
	public E removeLast() {
		// TODO Auto-generated method stub
		return list.removeLast();
	}

	public String toString(){
		return list.toString();
	}

}