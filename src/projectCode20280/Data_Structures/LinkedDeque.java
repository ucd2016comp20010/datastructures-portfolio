package projectCode20280.Data_Structures;

/**
 * A Double Ended Queue build on the {@code DoublyLinkedList}.
 * Contains all functions of the Deque ADT.
 * @param <E>
 */
public class LinkedDeque<E> implements Deque<E> {

	private DoublyLinkedList<E> dll = new DoublyLinkedList<>();

	@Override
	public int size() {
		return dll.size();
	}

	@Override
	public boolean isEmpty() {
		return dll.isEmpty();
	}

	@Override
	public E first() {
		return dll.get(0);
	}

	@Override
	public E last() {
		return dll.get(size()-1);
	}

	/**
	 * Adds an element onto the front of the queue.
	 * @param e the new element
	 */
	@Override
	public void addFirst(E e) {
		dll.addFirst(e);
		
	}

	/**
	 * Adds an element onto the end of the queue.
	 * @param e the new element
	 */
	@Override
	public void addLast(E e) {
		dll.addLast(e);
		
	}

	/**
	 * Removes an element from the front of the queue.
	 * @return the removed element
	 */
	@Override
	public E removeFirst() {
		return dll.removeFirst();
	}

	/**
	 * Removes an element from the end of the queue.
	 * @return the removed element
	 */
	@Override
	public E removeLast() {
		return dll.removeLast();
	}

	@Override
	public String toString() {
		return dll.toString();
	}

	public static void main(String[] args) {
		LinkedDeque<Integer> ld = new LinkedDeque<>();

		ld.addFirst(1);
		ld.addFirst(2);
		ld.addFirst(3);
		ld.addFirst(4);

		ld.addLast(1);
		ld.addLast(2);
		ld.addLast(3);
		ld.addLast(4);

		System.out.println(ld);

		System.out.println("removeFirst(): " + ld.removeFirst());
		System.out.println(ld);

		System.out.println("removeLast(): " + ld.removeLast());
		System.out.println(ld);

		System.out.println("Size: " + ld.size());
	}
}
