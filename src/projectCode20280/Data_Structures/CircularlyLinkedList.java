package projectCode20280.Data_Structures;

import java.util.Iterator;

/**
 * A Circularly Linked List made up of nodes that store an element and a reference to the next node in the list.
 * It also allow the list to be rotated with the {@code CircularlyLinkedList.rotate()} function.
 * It contains all functions of the List ADT.
 * @author Thomas Reilly - thomas.reilly@ucdconnect.ie
 */
public class CircularlyLinkedList<E> implements List<E> {

	//Tail keeps track of the last element in the list
	private Node<E> tail;
	//Keeps track of the number of nodes in the list
	private int size = 0;

	private static class Node<E> {
		//Reference to the element stored in this node
		private E element;
		//Reference to the subsequent node in the list
		private Node<E> next;

		private Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		private E getElement() {
			return this.element;
		}

		private Node<E> getNext() {
			return this.next;
		}

		private void setNext(Node<E> N) {
			this.next = N;
		}
	}

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
		return size <= 0;
	}

	/**
	 * Gets the element stored at index i of the list.
	 * @param i index of the element you wish to access.
	 * @return E that is at position i in the list.
	 */
	@Override
	public E get(int i) {
		if (isEmpty()) {
			return null;
		}
		Node<E> nodeI = tail;
		for (int j=0; j<=i; j++) {
			nodeI = nodeI.getNext();
			if(i == j) {
				return nodeI.getElement();
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
	public void add(int i, E e) {
		if (i == 0) { // addFirst()
			if (isEmpty()) { //First Add
				tail = new Node<>(e, null);
				tail.setNext(tail);
			} else {
				Node<E> newN = new Node<>(e, tail.getNext());
				tail.setNext(newN);
			}
		} else { //add at position i
			Node<E> curr = tail;
			for (int j = 0; j <= i; j++) {
				if (j == i) {
					curr.setNext(new Node<>(e, curr.getNext()));
					break;
				} else {
					curr = curr.getNext();
				}
			}
		}
		size++;

//		Node<E> nodeI = tail;
//		if (isEmpty()) { //initial addFirst
//			tail = new Node<>(e, null);
//			tail.setNext(tail);
//			size++;
//		} else if (i == 0) { //addFirst
//			Node<E> newest = new Node<>(e, tail.getNext());
//			tail.setNext(newest);
//			size++;
//		} else if (i == size-1) { //addLast
//			Node<E> newest = new Node<>(e, tail.getNext());
//			tail.setNext(newest);
//			tail = newest;
//			size++;
//		} else {
//			for (int j = 0; j <= i; j++) {
//				if (j == i) {
//					nodeI.setNext(new Node<>(e, nodeI.getNext()));
//					size++;
//					break;
//				} else {
//					nodeI = nodeI.getNext();
//				}
//			}
//		}

	}

	/**
	 * Removes the element stored at index i of the List.
	 * @param i The index of the element you wish to remove.
	 * @return On sucess, the E that has been removed.
	 */
	@Override
	public E remove(int i) {
		Node<E> nodeI = tail;
		if (isEmpty())
			return null;
		if (i == 0) { //removeFirst
			Node<E> head = tail.getNext();
			E old = tail.getElement();
			if (head == tail)
				tail = null;
			else
				tail.setNext(head.getNext());
			size--;
			return head.getElement();
		}
		for (int j=0; j<=i; j++) {
			if(i == j) { // ie nodeI.getNext is the element we want to remove
				Node<E> temp = nodeI.getNext();
				nodeI.setNext(nodeI.getNext().getNext());
				size--;
				return temp.getElement();
			} else {
				nodeI = nodeI.getNext();
			}
		}
		return null;
	}

	/**
	 * Removes the element stored at the front of the list.
	 * @return the element (E) that was removed.
	 */
	public E removeFirst() { return remove(0); }

	/**
	 * Removes the element stored at the end of the list.
	 * @return the element (E) that was removed.
	 */
	@Override
	public E removeLast() {
		return remove(size-1);
	}

	/**
	 * Adds an element to the front of the list.
	 * @param e The element you wish to add.
	 */
	@Override
	public void addFirst(E e) {
		add(0, e);
	}

	/**
	 * Adds an element to the end of the list.
	 * @param e The element you wish to add.
	 */
	@Override
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}

	/**
	 * Gets the element at the front of the list.
	 * @return The element (E) at the front of the list.
	 */
	public E first() {
		if (isEmpty()) return null;
		return tail.getNext().getElement();
	}

	/**
	 * Gets the element at the end of the list.
	 * @return The element (E) at the end of the list.
	 */
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		Node<E> curr;
		int count;

		private ListIterator() {
			curr = tail.getNext();
			count = 0;
		}

		public boolean hasNext() {
			return count < size;
		}

		@Override
		public E next() {
			E res = curr.getElement();
			curr = curr.getNext();
			count++;
			return res;
		}
	}

	/** Rotates the list putting the last element at the front of the list. */
	public void rotate() {
		tail = tail.getNext();
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		Node<E> nodeI = tail.getNext();
		StringBuilder sb = new StringBuilder("[");
		for (int i=0; i<size; i++) {
			sb.append(nodeI.getElement()).append(", ");
			nodeI = nodeI.getNext();
		}
		if (sb.length()>2) {
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
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

		ll.rotate();
		System.out.println("After rotating the list: " + ll);

		System.out.println("removeFirst(): " + ll.removeFirst());
		ll.rotate();
		System.out.println("After rotating the list & removeFirst: " + ll);

		System.out.println("removeLast(): " + ll.removeLast());
		ll.rotate();
		System.out.println("After rotating the list & removeLast: " + ll);

	}
}
