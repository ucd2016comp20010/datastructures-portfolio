package projectCode20280;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return header.getNext() == null;
	}

	@Override
	public E get(int i) {
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

	@Override
	public void add(int i, E e) {
		if (i<0 || i > size-1) {
			return;
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

	@Override
	public E remove(int i) {
		if (i<0 || i > size-1) {
			return null;
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

	public E remove(Node<E> node) {
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

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		} else {
			return remove(header.getNext());
		}
	}

	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		} else {
			return remove(trailer.getPrev());
		}
	}

	@Override
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	@Override
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

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
		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
		   ll.addFirst(3);
           ll.addFirst(1);
           ll.addFirst(2);
           ll.addLast(-1);
           System.out.println(ll.toString());
           ll.removeFirst();

           System.out.println(ll.toString());

           ll.removeLast();
           System.out.println(ll.toString());

           ll.add(2, 5);
           System.out.println(ll.toString());

			ll.add(2, 6);
			System.out.println(ll.toString());

           for(Integer e: ll) {
                   System.out.println("value: " + e);
           }
	}

	
}
