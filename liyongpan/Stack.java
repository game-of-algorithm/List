public class Stack<T> {

	private Node<T> first = null;
	private int n = 0;

	public void push (T node) {
		Node<T> old = first;
		first = new Node<T>();
		first.item = node;
		first.next = old;
		n++;
	}

	public T pop () throws Exception {
		if (isEmpty()) throw new Exception("Stack is empty");
		T item = first.item;
		first = first.next;
		n--;
		return item;
	}

	public boolean isEmpty () {
		return n == 0;
	}

	public int size () {
		return n;
	}

	private static class Node<T> {
		private T item;
		private Node<T> next;
	}
}
