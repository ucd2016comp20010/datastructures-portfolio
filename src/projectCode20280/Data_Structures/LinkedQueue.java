package projectCode20280.Data_Structures;

/**
 * A queue implemented on a {@code DoublyLinkedList}. This queue is expandable.
 * It contains all functions of the Queue ADT.
 * @author Thomas Reilly - thomas.reilly@ucdconnect.ie
 */
public class LinkedQueue<E> implements Queue<E> {
	DoublyLinkedList<E> dll = new DoublyLinkedList<>();

	@Override
	public int size() {
		return dll.size();
	}

	@Override
	public boolean isEmpty() {
		return dll.isEmpty();
	}

	/**
	 * Enqueues a given element.
	 * @param e the element to be inserted
	 */
	@Override
	public void enqueue(E e) {
		dll.addLast(e);
	}

	/**
	 * Returns the element at the front of the queue.
	 * @return the element at the front of the queue.
	 */
	@Override
	public E first() {
		return dll.get(0);
	}

	/**
	 * Returns the element at the front of the queue.
	 * @return the element at the front of the queue.
	 */
	@Override
	public E dequeue() {
		return dll.removeFirst();
	}

	@Override
	public String toString() {
		return dll.toString();
	}

	public static void main(String[] args) {
		System.out.println("Creating a LinkedQueue");
		LinkedQueue<Integer> q = new LinkedQueue<>();

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q);

		q.dequeue();
		System.out.println("After dequeue:" + q);

		q.enqueue(5);
		System.out.println("After enqueue(5): " + q);

		System.out.println("Size: " + q.size());

		System.out.println("Is empty: " + q.isEmpty());

		System.out.println("First: " + q.first());
		System.out.println(q);

	}

}
