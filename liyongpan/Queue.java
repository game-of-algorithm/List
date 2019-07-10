public class Queue<T> {

	private Node<T> first = null;
	private Node<T> last = null;
	private int n = 0;

	public void enqueue (T node) {
		Node<T> old = last;
		last = new Node<T>();
		last.item = node;
		if (first == null) first = last;
		else old.next = last;
		n++;
	}

	public T dequeue () throws Exception {
		if (isEmpty()) throw new Exception("Queue is empty");
		T item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
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
