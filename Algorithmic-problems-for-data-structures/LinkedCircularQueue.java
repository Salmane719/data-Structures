/**
 * @author salmane Madkour
 * @author Aonghus lawlor
 * refrence: data structures
 * this provides one additional method not part of the general
Queue interface,a call to rotate(), all of them combined together enqueue , dequeue
all operations are performed in a constant time.
 *
 */

public class LinkedCircularQueue<E> implements Queue<E> {
	CircularlyLinkedList<E> queue;

	public LinkedCircularQueue() {
		queue = new CircularlyLinkedList<>();
	}

	// main method for the tests to check if the function working properly as should they be.
	public static void main(String[] args) {
		LinkedCircularQueue<Integer> lQ = new LinkedCircularQueue<>();
		lQ.enqueue(11);
		lQ.enqueue(12);
		lQ.enqueue(23);
		lQ.enqueue(34);
		System.out.println(lQ);
		lQ.dequeue();
		lQ.rotate();
		System.out.println(lQ);

	}

	@Override
	// it finds number of queue elements and return current size of
	// the queue.
	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}

	@Override
	//checks if queue is empty.
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@Override
	// inserts element at the rear of the queue.
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		queue.addLast(e);
	}

	@Override
	// return element of the front Queue.
	public E first() {
		// TODO Auto-generated method stub
		return queue.get(0);
	}

	@Override
	// removes element from the start and returns element at the front Queue.
	public E dequeue() {
		// TODO Auto-generated method stub
		return queue.removeFirst();
	}
	// using toString method here to  get the representation of the queue
	public String toString(){
		return queue.toString();
	}
	//rotate the first element to the back of the list.
	public void rotate(){
		queue.rotate();
	}


}