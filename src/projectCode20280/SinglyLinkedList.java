package projectCode20280;

import java.util.Iterator;
/*
 * Implemented by Thomas Reilly - thomas.reilly@ucdconnect.ie
 * A class that mimics a singly linked list made up of nodes that store an element and a reference
 * to the next node in the list.
 */
public class SinglyLinkedList<E> implements List<E> {
	private Node<E> head;

	private static class Node<E> {
		//Reference to the element stored in this node
		private E element;
		//Reference to the subsequent node in the list
		private Node<E> next;

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return this.element;
		}

		public Node<E> getNext() {
			return this.next;
		}

		public void setNext(Node<E> N) {
			this.next = N;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		Node<E> curr;
		public ListIterator() {
			curr = head;
		}

		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public E next() {
			E res = (E) curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public E get(int i) {
		Node<E> nodeI = head;
		for (int j=1; j<=i; j++) {
			nodeI = nodeI.getNext();
			if(i == j) {
				return (E) nodeI.getElement();
			}
		}
		return null;
	}

	@Override
	public void add(int i, E e) {
		Node<E> nodeI = head;
		for (int j=1; j<=i; j++) {
			if(i == j) {
				Node<E> nodeE = new Node<E>(e, nodeI.getNext());
				nodeI.setNext(nodeE);
				break;
			}
			nodeI = nodeI.getNext();
		}
	}

	@Override
	public E remove(int i) {
		Node<E> nodeI = head;
		for (int j=0; j<=i; j++) {
			if(i == j) {
				Node<E> temp = nodeI.getNext();
				nodeI.setNext(nodeI.getNext().getNext());
				return (E) temp.getElement();

			}
			nodeI.getNext();
		}
		return null;
	}

	@Override
	public int size() {
		Node<E> nodeI = head;
		int a=0;
		while (nodeI != null) {
			a++;
			nodeI = nodeI.getNext();
		}
		return a;
	}


	@Override
	public E removeFirst() {
		Node<E> temp = head;
		head = head.getNext();
		return (E) temp.getElement();
	}

	@Override
	public E removeLast() {
		Node<E> nodeI = head;
		while (nodeI.getNext().getNext() != null) {
			nodeI = nodeI.getNext();
		}
		Node<E> temp = nodeI.getNext();
		nodeI.setNext(null);
		return (E) temp.getElement();
	}

	@Override
	public void addFirst(E e) {
		head = new Node<E>(e, head);
	}

	@Override
	public void addLast(E e) {
		Node<E> nodeI = head;
		while (nodeI.getNext() != null) {
			nodeI = nodeI.getNext();
		}
		nodeI.setNext(new Node<E>(e, null));

	}

	@Override
	public String toString() {
		Node<E> nodeI = head;
		String s = "[";
		while(nodeI != null) {
			s=s.concat(nodeI.getElement().toString());
			s=s.concat(", ");
			nodeI = nodeI.getNext();
		}
		s=s.concat(" ]");
		return s;
	}

	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());

		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());

		sll.add(2, "E");
		System.out.println(sll.toString());

		System.out.println(sll.get(4));

		System.out.println(sll.size());

		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}


}
