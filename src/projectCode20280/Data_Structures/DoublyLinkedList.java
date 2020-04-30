package projectCode20280.Data_Structures;

import java.util.Iterator;

/**
 * A Singly Linked List made up of nodes that stores an element and a reference to the next node in the list. And
 * a reference to the previous element in the list.
 * It contains all functions of the List ADT.
 * @author Thomas Reilly - thomas.reilly@ucdconnect.ie
 */
public class DoublyLinkedList<E> implements List<E> {
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	private class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;

		private Node(E e, Node<E> prev, Node<E> next) {
			this.element = e;
			this.next = next;
			this.prev = prev;
		}

		private E getElement() { return this.element; }

		private Node<E> getNext() { return this.next; }

		private Node<E> getPrev() { return this.prev; }

		private void setNext(Node<E> N) { this.next = N; }

		private void setPrev(Node<E> P) { this.prev = P; }

	}

	/** Private utility function for easy insertion of nodes */
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	/**
	 * Returns the size of the list.
	 * @return int representing the size of the list.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if size is 0
	 * @return true if the list is empty.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Gets the element stored at index i of the list.
	 * @param i index of the element you wish to access.
	 * @return E that is at position i in the list.
	 */
	@Override
	public E get(int i) throws IndexOutOfBoundsException{
		if (i < 0) {
			throw new IndexOutOfBoundsException("Index " + i + " is too small for this List.");
		} else if (i > size) {
			throw new IndexOutOfBoundsException("Index " + i + " is too too big for this List.");
		}
		Node<E> nodeI = header.getNext();
		for (int j=0; j<=i; j++) {
			if(i == j) {
				return nodeI.getElement();
			} else {
				nodeI = nodeI.getNext();
			}
		}
		return null;
	}

	/**
	 * Add's an element e at index i in the list.
	 * @param i The index at which you wish to add the element.
	 * @param e The element that you wish to add to the list.
	 */
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException{
		if (i < 0) {
			throw new IndexOutOfBoundsException("Index " + i + " is too small for this List.");
		} else if (i > size) {
			throw new IndexOutOfBoundsException("Index " + i + " is too too big for this List.");
		}
		Node<E> nodeI = header;
		for (int j = 0; j <= i; j++) {
			if (i == j) {
				addBetween(e, nodeI, nodeI.getNext());
			} else {
				nodeI = nodeI.getNext();
			}
		}
	}

	/**
	 * Removes the element stored at index i of the List.
	 * @param i The index of the element you wish to remove.
	 * @return On sucess, the E that has been removed.
	 */
	@Override
	public E remove(int i) throws IndexOutOfBoundsException{
		if (i < 0) {
			throw new IndexOutOfBoundsException("Index " + i + " is too small for this List.");
		} else if (i > size) {
			throw new IndexOutOfBoundsException("Index " + i + " is too too big for this List.");
		}
		Node<E> nodeI = header.getNext();
		for (int j = 0; j <= i ; j++) {
			if(j == i) {
				return remove(nodeI);
			} else {
				nodeI = nodeI.getNext();
			}
		}
		return null;
	}

	/** A private utility function that allows for easy removal of a node from the list. */
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		Node<E> curr;
		private ListIterator() {
			curr = header.getNext();
		}

		public boolean hasNext() {
			return curr.getElement()!= null;
		}

		@Override
		public E next() {
			E res = curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}

	/**
	 * Removes the element stored at the front of the list.
	 * @return the element (E) that was removed.
	 */
	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		} else {
			return remove(header.getNext());
		}
	}

	/**
	 * Removes the element stored at the end of the list.
	 * @return the element (E) that was removed.
	 */
	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		} else {
			return remove(trailer.getPrev());
		}
	}

	/**
	 * Adds an element to the front of the list.
	 * @param e The element you wish to add.
	 */
	@Override
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	/**
	 * Adds an element to the end of the list.
	 * @param e The element you wish to add.
	 */
	@Override
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

	/**
	 * Gets the element at the front of the list.
	 * @return The element (E) at the front of the list.
	 */
	public E first() { return get(0); }

	/**
	 * Gets the element at the end of the list.
	 * @return The element (E) at the end of the list.
	 */
	public E last() { return get(size-1); }

	@Override
	public String toString() {
		Node<E> nodeI = header.getNext();
		String s = "[";
		while(nodeI.getElement() != null) {
			s=s.concat(nodeI.getElement().toString());
			if (nodeI.getNext().getElement() != null) {
				s=s.concat(", ");
			}
			nodeI = nodeI.getNext();
		}
		s=s.concat("]");
		return s;
	}


	public static void main(String[] args) {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		for(int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}
		ll.addFirst(50);
		System.out.println("After addFirst(50): " + ll);

		System.out.println("Size: " + ll.size());

		System.out.println(ll);

		System.out.println("removeFirst(): " + ll.removeFirst());
		System.out.println("After removing the first element" + ll);

		System.out.println("removeLast(): " + ll.removeLast());
		System.out.println("After removing the last element" + ll);
	}

	
}
