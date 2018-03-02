package ch.fhnw.algd2.collections.list.linkedlist;

import java.util.Arrays;
import java.util.Objects;

import ch.fhnw.algd2.collections.list.MyAbstractList;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private int size = 0;
	private Node<E> first;

	@Override
	public boolean add(E e) {
		if (Objects.equals(e, null)){
			throw new IllegalArgumentException();
		}
		// Speichert e im ersten Node ab
		if(Objects.equals(first, null)){
			first = new Node<>(e,null);
		} else {
		Node<E> currentNode = first;
		// sucht das letzte Element der Liste
		while (!Objects.equals(currentNode.next, null)){
			currentNode = currentNode.next;
		}
		currentNode.next = new Node<>(e, null);
		}
		size++;
		return true;
	}

	@Override
	public boolean contains(Object o) {
		if (Objects.equals(o, null)){
			throw new NullPointerException();
		}
		Node<E> currentNode = first;
		for (int i = 0; i < this.size() ; i++) {
			if (Objects.equals(currentNode.elem, o)) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO implement this operation (part C)
		if (Objects.equals(o, null)){
			throw new NullPointerException();
		}
		Node<E> currentNode = first;
		if (size() == 1){
			if (Objects.equals(currentNode.elem, o)){
				first = null;
				size--;
				return true;

//			} else if(size() == 2){
//				if (Objects.equals(currentNode.elem, o)){
//					first = currentNode.next;
//					first.next = null;
//					size--;
//					return true;
//				} else if (Objects.equals(currentNode.next.elem, o)) {
//					first.next = null;
//					size--;
//					return true;
//				}
			}
		} else{
			for (int i = 0; i < this.size()-1 ; i++) {
				if (Objects.equals(currentNode.next.elem, o)) {
					currentNode.next = currentNode.next.next;
					size--;
					return true;
				}
				currentNode = currentNode.next;
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		// TODO implement this operation (part D)
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, E element) {
		// TODO implement this operation (part D)
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int index) {
		// TODO implement this operation (part D)
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		int index = 0;
		Node<E> current = first;
		while (current != null) {
			array[index++] = current.elem;
			current = current.next;
		}
		return array;
	}

	@Override
	public int size() {
		return size;
	}

	private static class Node<E> {
		private final E elem;
		private Node<E> next;

		private Node(E elem) {
			this.elem = elem;
		}

		private Node(E elem, Node<E> next) {
			this.elem = elem;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
