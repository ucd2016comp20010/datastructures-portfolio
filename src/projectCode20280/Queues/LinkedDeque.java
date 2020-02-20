package projectCode20280.Queues;

import projectCode20280.LinkedLists.DoublyLinkedList;

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

	@Override
	public void addFirst(E e) {
		dll.addFirst(e);
		
	}

	@Override
	public void addLast(E e) {
		dll.addLast(e);
		
	}

	@Override
	public E removeFirst() {
		return dll.removeFirst();
	}

	@Override
	public E removeLast() {
		return dll.removeLast();
	}

	@Override
	public String toString() {
		return dll.toString();
	}
}
