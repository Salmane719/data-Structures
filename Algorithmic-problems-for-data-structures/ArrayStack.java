/**
 * @author Salmane Madkour , 19724421
 *
 * @author Aonghus lawlor
 *
 * reference : Data structures and algorithms.
 *
 * Implementation of an arrayStack
 *
 *Implementation of  arrayStack functions: isEmpty() , push(E e) , top() , pop()
 *
 *additional functions: toString()
 */
public class ArrayStack<E> implements Stack<E> {

	private static final int CAPACITY = 1000;// setting capacity to final and initializing to 1000
	private E[] data;// element of the data



	private int A = -1;
	private ArrayStack(){
		this(CAPACITY);
	}

	//constructs array stack.
	ArrayStack(int capacity){
		data = (E[]) new Object[capacity];
	}

	// testing all the functions here to check if it working properly
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		System.out.println(" the Size  " + stack.size());
		stack.push(44);
		System.out.println("it is" + stack.isEmpty());
	}

	@Override
	// gets the current number of stack elements and returns the size of stack.
	public int size() {
		// TODO Auto-generated method stub
		return A + 1;
	}

	@Override
	//checks if the stack is empty and return true if the stack size is 0 otherwise false
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return  A == -1 ;
	}

	@Override
	//this function basically insert an element at the top of stack.
	public void push(E e) {
		if (size() == CAPACITY)
		{
			throw new RuntimeException("Stack is full!");
		}

		else
		{
			A++;
			data[A] = e;
		}
	}


	@Override
	//peek at the top element of the stack
	public E top() {
		{
			if(isEmpty())
				return null;
			return data[A];
		}
	}

	@Override
	//removes the top of the element of stack
	//and returns the removed top element of stack.
	public E pop() {
		{
			if (isEmpty())
				return null;
			E answer = data[A];
			data[A] = null;
			A--;
			return answer;
		}

	}

	// does string representation of the stack
	//and return the removed top of element of stack.


	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i <= A; i++)
		{
			sb.append(data[i] + ", ");
		}

		sb.replace(sb.length()-2, sb.length(), "");
		sb.append("]");

		return sb.toString();
	}

}