package projectCode20280.Data_Structures;

import java.util.Arrays;

/**
 * A queue implemented on Java Arrays. This queue consequently has limited space that must be decided upon construction.
 * It contains all functions of the Queue ADT.
 * @author Thomas Reilly - thomas.reilly@ucdconnect.ie
 */
public class ArrayQueue<E> implements Queue<E> {
	//Constant that stores the maximum size a stack can be
	private final int MAX_SIZE;

	//Array that will store the elements of the stack.
	private E[] a;
	//Holds the index of the element at the top of the stack. Initialised as -1 so that the first element is stored at 0.
	private int front=0;
	private int rear=0;
	private int size=0;

	public ArrayQueue(int size) {
		MAX_SIZE = size;
		//Creates an array of elements a, and assigns memory to the array at the size requested.
		a = (E[]) new Object[size];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	/**
	 * Enqueues a given element.
	 * @param e the element to be inserted
	 */
	@Override
	public void enqueue(E e) {
		rear = (front + size) % MAX_SIZE;
		a[rear] = e;
		rear++;
		size++;
	}

	/**
	 * Returns the element at the front of the queue.
	 * @return the element at the front of the queue.
	 */
	@Override
	public E first() {
		return a[front];
	}

	/**
	 * Returns the element at the front of the queue.
	 * @return the element at the front of the queue.
	 */
	@Override
	public E dequeue() {
		E temp = a[front];
		a[front] = null;
		front = (front + 1) % MAX_SIZE;
		size--;
		return temp;
	}

	public String toString() {
		return Arrays.toString(a);
	}

	public static void main(String[] args) {
		System.out.println("Creating an array queue of max size 10");
		ArrayQueue<Integer> aq = new ArrayQueue<>(10);

		aq.enqueue(1);
		aq.enqueue(2);
		aq.enqueue(3);
		aq.enqueue(4);
		System.out.println(aq);

		aq.dequeue();
		System.out.println("After a dequeue: " + aq);

		aq.enqueue(5);
		System.out.println("After enqueueing 5: " + aq);

		System.out.println("Size: " + aq.size());

		System.out.println("isEmpty: " + aq.isEmpty());

		System.out.println("First: " + aq.first());
		System.out.println(aq);
	}

}
