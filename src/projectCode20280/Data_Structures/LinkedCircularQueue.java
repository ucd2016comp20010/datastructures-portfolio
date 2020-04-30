package projectCode20280.Data_Structures;

/**
 * A queue implemented on a {@code CircularlyLinkedList}.
 * It contains all functions of the Queue ADT.
 * It also contains a {@code rotate()} function that allows the last element of the queue to be moved to the front.
 * @author Thomas Reilly - thomas.reilly@ucdconnect.ie
 */
public class LinkedCircularQueue<E> implements Queue<E> {

	private CircularlyLinkedList<E> cll = new CircularlyLinkedList<>();

	@Override
	public int size() {
		return cll.size();
	}

	@Override
	public boolean isEmpty() {
		return cll.isEmpty();
	}

	/**
	 * Enqueues a given element, adding it to the end of the queue.
	 * @param e the element to be inserted
	 */
	@Override
	public void enqueue(E e) {
		cll.addLast(e);
	}

	/**
	 * Returns the element at the front of the queue.
	 * @return the element at the front of the queue.
	 */
	@Override
	public E first() {
		return cll.first();
	}

	/**
	 * Returns the element at the front of the queue.
	 * @return the element at the front of the queue.
	 */
	@Override
	public E dequeue() {
		return cll.removeFirst();
	}

	/**
	 * Rotates the queue putting the element at the end of the queue at the front.
	 */
	public void rotate() {
		cll.rotate();
	}

	@Override
	public String toString() {
		return cll.toString();
	}

	public static void main(String[] args) {
		System.out.println("Creating a LinkedCircularQueue");
		LinkedCircularQueue<Integer> q = new LinkedCircularQueue<>();

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

		q.rotate();
		System.out.println("After rotating queue: " + q);
		System.out.println("First: " + q.first());
	}

}
