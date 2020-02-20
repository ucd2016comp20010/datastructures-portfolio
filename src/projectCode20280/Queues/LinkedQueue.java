package projectCode20280.Queues;

import projectCode20280.LinkedLists.DoublyLinkedList;

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

	@Override
	public void enqueue(E e) {
		dll.addLast(e);
	}

	@Override
	public E first() {
		return dll.get(0);
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return dll.removeFirst();
	}

	@Override
	public String toString() {
		return dll.toString();
	}

	public static void main(String[] args) {
		LinkedQueue<Integer> q = new LinkedQueue<>();

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q);

		q.dequeue();
		System.out.println(q);

		q.enqueue(5);
		System.out.println(q);

		System.out.println("Size: " + q.size());

		System.out.println("Is empty: " + q.isEmpty());

		System.out.println("First: " + q.first());
		System.out.println(q);

	}

}
