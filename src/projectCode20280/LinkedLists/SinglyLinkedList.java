package projectCode20280.LinkedLists;

import projectCode20280.Stacks.LinkedStack;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Implemented by Thomas Reilly - thomas.reilly@ucdconnect.ie
 * A class that mimics a singly linked list made up of nodes that store an element and a reference
 * to the next node in the list.
 */
public class SinglyLinkedList<E> implements List<E> {
	//Reference to the first node in the list
	private Node<E> head;
	//Int that stores the amount of nodes in the list
	private int size=0;

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
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public E get(int i) {
		Node<E> nodeI = head;
		for (int j=0; j<=i; j++) {
			if(i == j) {
				return nodeI.getElement();
			}
			nodeI = nodeI.getNext();
		}
		return null;
	}

	@Override
	public void add(int i, E e) {
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

	@Override
	public E remove(int i) {
		Node<E> nodeI = head;
		if (i == 0) { //removeFirst
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

	@Override
	public int size() {
		return this.size;
	}


	@Override
	public E removeFirst() {
		return remove(0);
	}

	@Override
	public E removeLast() { return remove(size-1); }

	@Override
	public void addFirst(E e) {
		add(0, e);
	}

	@Override
	public void addLast(E e) {
		add(size, e);
	}

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
		System.out.println();

		SinglyLinkedList<Integer> ints = new SinglyLinkedList<>();
		ints.addFirst(1);
		ints.addFirst(2);
		ints.addFirst(3);
		ints.addFirst(4);

		System.out.println("Non-reversed List: " + ints);
		ints.reverse();
		System.out.println("Reversed List: " + ints);
	}


}
