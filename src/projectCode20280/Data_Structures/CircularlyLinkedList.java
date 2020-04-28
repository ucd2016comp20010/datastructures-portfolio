package projectCode20280.Data_Structures;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

	//Tail keeps track of the last element in the list
	private Node<E> tail;
	//Keeps track of the number of nodes in the list
	private int size;

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

	@Override
	public boolean isEmpty() {
		return tail == null;
	}

	@Override
	public E get(int i) {
		Node<E> nodeI = tail.getNext();
		for (int j=1; j<=i; j++) {
			nodeI = nodeI.getNext();
			if(i == j) {
				return nodeI.getElement();
			}
		}
		return null;
	}

	@Override
	public void add(int i, E e) {
		Node<E> nodeI = tail;
		if (isEmpty()) { //initial add
			tail = new Node(e, null);
			tail.setNext(tail);
		} else if (i == size-1) { //addLast
			Node<E> newest = new Node(e, tail.getNext());
			tail.setNext(newest);
			tail = newest;
		} else {
			for (int j = 0; j <= i; j++) {
				if (j == i) {
					nodeI.setNext(new Node<>(e, nodeI.getNext()));
					size++;
					break;
				} else {
					nodeI = nodeI.getNext();
				}
			}
		}

	}

	@Override
	public E remove(int i) {
		Node<E> nodeI = tail;
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

	public E removeFirst() { return remove(0); }

	@Override
	public E removeLast() {
		return remove(size-1);
	}

	@Override
	public void addFirst(E e) {
		add(0, e);
	}

	@Override
	public void addLast(E e) {
		add(size-1, e);
	}


	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		Node<E> curr;

		private ListIterator() {
			curr = tail.getNext();
		}

		public boolean hasNext() {
			return curr != tail;
		}

		@Override
		public E next() {
			E res = curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}

	public void rotate() {
		Node<E> NodeI = tail.getNext();
		while (NodeI.getNext() != tail) {
			NodeI = NodeI.getNext();
		}
		tail = NodeI;
	}

	@Override
	public String toString() {
		Node<E> nodeI = tail.getNext();
		String s = "[";
		do {
			s=s.concat(nodeI.getElement().toString());
			if (nodeI.getNext() != tail.getNext()) {
				s=s.concat(", ");
			}
			nodeI = nodeI.getNext();
		} while(nodeI != tail.getNext());
		s=s.concat("]");
		return s;
	}
	
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		for(int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}

		System.out.println(ll);

		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();

		ll.rotate();
		System.out.println(ll);

		ll.removeFirst();
		ll.rotate();
		System.out.println(ll);

		ll.removeLast();
		ll.rotate();
		System.out.println(ll);

		for (Integer e : ll) {
			System.out.println("value: " + e);
		}

	}
}
