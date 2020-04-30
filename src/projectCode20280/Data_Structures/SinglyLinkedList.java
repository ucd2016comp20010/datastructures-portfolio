package projectCode20280.Data_Structures;

import java.util.Iterator;

/**
 * A Singly Linked List made up of nodes that store an element and a reference to the next node in the list.
 * It contains all functions of the List ADT.
 * @author Thomas Reilly - thomas.reilly@ucdconnect.ie
 */
public class SinglyLinkedList<E> implements List<E> {
	//Reference to the first node in the list
	private Node<E> head;
	//Int that stores the amount of nodes in the list
	private int size=0;

	private class Node<E> {
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

		private void setElement(E e) {
			this.element = e;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		Node<E> curr;
		private ListIterator() {
			curr = head;
		}

		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public E next() {
			E res = curr.getElement();
			curr = curr.getNext();
			return res;
		}
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
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0) {
			throw new IndexOutOfBoundsException("Index " + i + " is too small for this List.");
		} else if (i > size) {
			throw new IndexOutOfBoundsException("Index " + i + " is too too big for this List.");
		}
		Node<E> nodeI = head;
		for (int j=0; j<=i; j++) {
			if(i == j) {
				return nodeI.getElement();
			}
			nodeI = nodeI.getNext();
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
		if (i < 0) {
			throw new IndexOutOfBoundsException("Index " + i + " is too small for this List.");
		} else if (i > size) {
			throw new IndexOutOfBoundsException("Index " + i + " is too too big for this List.");
		}
		Node<E> curr;
		Node<E> prev;
		if (isEmpty()) {
			head = new Node<>(e, null);
			size++;
		} else if (i == 0) {
			head = new Node<>(e, head);
			size++;
		} else {
			prev = head;
			curr = head.getNext();
			for (int j=1; j<=i; j++) {
				if (i == j) {
					prev.setNext(new Node<>(e, curr));
					size++;
					break;
				} else {
					prev = curr;
					curr = curr.getNext();
				}
			}
		}
	}

	/**
	 * Removes the element stored at index i of the List.
	 * @param i The index of the element you wish to remove.
	 * @return On sucess, the E that has been removed.
	 */
	@Override
	public E remove(int i) {
		if (i < 0) {
			throw new IndexOutOfBoundsException("Index " + i + " is too small for this List.");
		} else if (i > size) {
			throw new IndexOutOfBoundsException("Index " + i + " is too too big for this List.");
		}
		Node<E> nodeI = head;
		if (i==0 && size == 1) {
			head = new Node<>(null, null);
			size--;
		} else if (i == 0) { //removeFirst
			head = head.getNext();
			size--;
			return nodeI.getElement();
		} else {
			for (int j=1; j<=i; j++) {
				if(i == j) { // ie nodeI.getNext is the element we want to remove
					Node<E> temp = nodeI.getNext();
					nodeI.setNext(nodeI.getNext().getNext());
					size--;
					return temp.getElement();
				} else {
					nodeI = nodeI.getNext();
				}
			}
		}
		return null;
	}

	/**
	 * Returns the size of the list.
	 * @return int representing the size of the list.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Removes the element stored at the front of the list.
	 * @return the element (E) that was removed.
	 */
	@Override
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * Removes the element stored at the end of the list.
	 * @return the element (E) that was removed.
	 */
	@Override
	public E removeLast() { return remove(size-1); }

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
		add(size, e);
	}

	/**
	 * Gets the element at the front of the list.
	 * @return The element (E) at the front of the list.
	 */
	public E first() {
		return get(0);
	}

	/**
	 * Gets the element at the end of the list.
	 * @return The element (E) at the end of the list.
	 */
	public E last() { return get(size-1); }

	@Override
	public String toString() {
		Node<E> nodeI = head;
		String s = "[";
		while(nodeI != null) {
			s=s.concat(nodeI.getElement().toString());
			if (nodeI.getNext() != null) {
				s=s.concat(", ");
			}
			nodeI = nodeI.getNext();
		}
		s=s.concat("]");
		return s;
	}
	
	public void reverse() {
		LinkedStack<E> temp = new LinkedStack<>();
		Node<E> curr = head;
		while(curr != null) {
			temp.push(curr.getElement());
			curr = curr.getNext();
		}
		curr = head;
		while(curr != null) {
			curr.setElement(temp.pop());
			curr = curr.getNext();
		}
	}

	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println("After removeFirst(): " + sll.toString());

		sll.removeLast();
		System.out.println("After removeLast(): " + sll.toString());

		sll.remove(2);
		System.out.println("After remove(2): " + sll.toString());

		sll.add(2, "E");
		System.out.println("After add(2, E): " + sll.toString());

		System.out.println("get(4): " + sll.get(4));

		System.out.println("Size: " + sll.size());
	}


}
