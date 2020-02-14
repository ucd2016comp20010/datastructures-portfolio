package projectCode20280;

import java.util.Arrays;

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

	@Override
	public void enqueue(E e) {
		rear = (front + size) % MAX_SIZE;
		a[rear] = e;
		rear++;
		size++;
	}

	@Override
	public E first() {
		return a[front];
	}

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
		ArrayQueue<Integer> aq = new ArrayQueue<>(10);

		aq.enqueue(1);
		aq.enqueue(2);
		aq.enqueue(3);
		aq.enqueue(4);
		System.out.println(aq);

		aq.dequeue();
		System.out.println(aq);

		aq.enqueue(5);
		System.out.println(aq);

		System.out.println(aq.size());

		System.out.println(aq.isEmpty());

		System.out.println(aq.first());
		System.out.println(aq);
	}

}
