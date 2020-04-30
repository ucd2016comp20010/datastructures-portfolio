package projectCode20280.Data_Structures;

/**
 * A stack implemented on the {@code SinglyLinkedList}.
 * It contains all functions of the stack ADT.
 * @author Thomas Reilly - thomas.reilly@ucdconnect.ie
 */
public class LinkedStack<E> implements Stack<E> {

	private SinglyLinkedList<E> ll;

	public LinkedStack() {
		ll = new SinglyLinkedList<>();
	}

	@Override
	public int size() {
		return ll.size();
	}

	@Override
	public boolean isEmpty() {
		return ll.isEmpty();
	}

	/**
	 * Adds an element to the top of the stack.
	 * @param e the element to be inserted
	 */
	@Override
	public void push(E e) {
		ll.addFirst(e);
	}

	/**
	 * Returns the element at the top of the stack.
	 * @return the element (E) at the top of the stack.
	 */
	@Override
	public E top() {
		if (!ll.isEmpty()) {
			return ll.first();
		} else {
			return null;
		}
	}

	/**
	 * Removes an element fron the top of the stack.
	 * @return the removed element (E).
	 */
	@Override
	public E pop() {
		if (!ll.isEmpty()) {
			return ll.removeFirst();
		} else {
			return null;
		}
	}

	public String toString() {
		return ll.toString();
	}

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		//Expected [1, 2, 3, 4]

		System.out.println("Pop: " + stack.pop());
		//Expected 4
		System.out.println(stack);
		//Expected [1, 2, 3]

		stack.push(5);
		System.out.println("Push(5)");

		System.out.println(stack);
		//Expected [1, 2, 3, 5]

		System.out.println("Top: " + stack.top());
		//Expected 5
	}
}
