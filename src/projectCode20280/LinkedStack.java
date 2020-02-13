package projectCode20280;

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

	@Override
	public void push(E e) {
		ll.addLast(e);
	}

	@Override
	public E top() {
		return ll.get(ll.size()-1);
	}

	@Override
	public E pop() {
		return ll.removeLast();
	}

	public String toString() {
		return ll.toString();
	}

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<>();

		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.push(3);
		System.out.println(stack);
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
