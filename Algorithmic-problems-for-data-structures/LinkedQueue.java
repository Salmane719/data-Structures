import SinglyLink.SinglyLinkedList;


/**
 * implementation of a linked list that goes to the Queue.
 *
 * implements Queue functions: isEmpty(),size(),enqueue( E e) .
 *
 *
 * additional functions: toString()
 *
 * @author salmane Madkour
 * @author Aonghus lawlor
 * refrence: data structures
 */
public class LinkedQueue<E> implements Queue<E> {
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	//main method fot testing to check whether the functions are
	//working as meant to be .
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedQueue<Integer> list = new LinkedQueue<>();
		list.enqueue(1);
		list.enqueue(2);
		list.enqueue(3);
		System.out.println(list);
		list.dequeue();
		System.out.println(list);
		list.enqueue(34);
		System.out.println(list);

	}

	// finds the number of the Queue element
	// and returns the current size
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}
	// check if the queue is empty.
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	//inserts  element to the rear of the queue
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		list.addLast(e);
	}
	// returns element of the front queue.
	@Override
	public E first() {
		// TODO Auto-generated method stub
		return list.get(0);
	}
	// removes the element from the front queue and return it.
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}
	//using ToString here to get the representation of the string.
	public String toString()
	{
		return list.toString();
	}

}