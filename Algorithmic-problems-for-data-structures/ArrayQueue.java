/**
 * @author Salmane Madkour , 19724421
 *
 * @author Aonghus lawlor
 *
 * reference : Data structures and algorithms.
 *
 * Implementation of an arrayQueue
 *
 *Implementation of  arrayQueue functions: isEmpty() , enqueue(E e) , first() , dequeue()
 *
 *additional functions: toString()
 */

public class ArrayQueue<E> implements Queue<E> {

	public static final int CAPACITY = 1000; // setting capacity to final and initializing to 1000


	private final E[] data;

	private int start  = 0;
	private int last = 0;

	public ArrayQueue()
	{
		this(CAPACITY);
	}

	private ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}


	// testing all the functions here to check if it working properly
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue<Integer> Queue = new ArrayQueue<Integer>();
		Queue.enqueue(1);
		System.out.println(Queue);
		Queue.enqueue(2);
		System.out.println(Queue);
		Queue.enqueue(4);
		System.out.println(Queue);
		System.out.println("the Size is " + Queue.size());
		Queue.dequeue();
		System.out.println(Queue);
		System.out.println( Queue.isEmpty());
		System.out.println("First element in queue is " + Queue.first());
		Queue.enqueue(43);
		System.out.println(Queue);
	}

	@Override
	//returns the current number of element in the queue.
	public int size() {
		// TODO Auto-generated method stub
		return last ;
	}

	@Override
	// checks if the Queue is empty , return queue isempty else false otherwise
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return last == 0;
	}

	@Override
	// inserts element to the rear of the queue.
	public void enqueue(E e) {
		{
			if (size() >= CAPACITY) {
				throw new RuntimeException("the Queue is full!");
			} else {
				last = ((start + size()) % CAPACITY);
				data[last] = e;
				last++;
			}
		}
	}

	@Override
	//returns the element at front of queue.
	public E first() {
		// TODO Auto-generated method stub
		return data[start];
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = (start % CAPACITY); i < last; i++)
		{
			sb.append(data[i] + ", ");
		}

		sb.replace(sb.length()-2, sb.length(), "");
		sb.append("]");

		return sb.toString();
	}

	@Override
	//remove front element of the queue , ad return the front element of
	//the queue.
	public E dequeue() {
		if(isEmpty())
			return null;
		E answer = data[start];
		data[start] = null;
		start = (start + 1) % data.length;
		last--;
		return answer;
	}

}