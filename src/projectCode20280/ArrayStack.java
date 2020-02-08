package projectCode20280;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
	//Constant that stores the maximum size a stack can be
	private final int MAX_SIZE;

	//Array that will store the elements of the stack.
	private E[] a;
	//Holds the index of the element at the top of the stack. Initialised as -1 so that the first element is stored at 0.
	private int top = -1;

	public ArrayStack(int size) {
		MAX_SIZE = size;
		//Creates an array of elements a, and assigns memory to the array at the size requested.
		a = (E[]) new Object[size];
	}

	@Override
	public int size() {
		return top+1;
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public void push(E e) {
		if (top+1 == MAX_SIZE) {
			throw new StackOverflowError("Stack is full, cannot push any more elements");
		}
		top++;
		a[top] = e;
	}

	@Override
	public E top() {
		return a[top];
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E temp = a[top];
		top--;
		return temp;
	}

	@Override
	public String toString() {
		String s = "[";
		for (int i=0; i <= top; i++) {
			s += a[i];
			if (i != top) {
				s += ", ";
			}
		}
		return s + "]";
	}

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>(10);

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		//Expected [1, 2, 3, 4]

		System.out.println(stack.pop());
		//Expected 4
		System.out.println(stack);
		//Expected [1, 2, 3]

		stack.push(5);

		System.out.println(stack);
		//Expected [1, 2, 3, 5]

		System.out.println(stack.top());
		//Expected 5
	}

}
