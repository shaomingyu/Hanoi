package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@code ListImplementation} is a Linked List that wraps {@link Node}s and
 * provides useful operations.
 * 
 * @author jcollard
 * 
 */
public class ListImplementation<T> implements ListInterface<T> {
	private int size = 0;
	private Node<T> head;
	private Node<T> tail;
	public ListImplementation() {
		
	}
	
	
	/**
	 * Returns the number of nodes in this list.
	 */
	@Override
	public int size() {
        return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Appends {@code elem} to the end of this {@code ListImplementation} and
	 * returns itself for convenience.
	 */
	@Override
	public ListImplementation<T> append(T elem) {
		if(elem == null) {
			throw new NullPointerException("elem cannot be type null");
		}
		Node<T> node = new Node<T>(elem, null);
		if (isEmpty()) {
			head = node;
		}
		else {
			tail.setNext(node);
		}
		tail = node;
		size++;
		return this;
	}

	/**
	 * Gets the {@code n}th element from this list.
	 */
	@Override
	public T get(int n) {
		if(n >= size()) {
			throw new NoSuchElementException("n must be within the list");
		}
		if(n < 0) {
			throw new NoSuchElementException("n must be greater than zero");
		}
		Node<T> node = head;
		for(int i = 0; i < n; i++) {
			node = node.getNext();
		}
		return node.getData();
	}

	/**
	 * Returns an iterator over this list. The iterator does not support the
	 * {@code remove()} method.
	 */
	@Override
	public Iterator<T> iterator() {
        return new ListIterator<T>(this.head);
	}
}

