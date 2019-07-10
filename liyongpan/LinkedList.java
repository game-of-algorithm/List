public class LinkedList<T> {

	private Node<T> first = null;
	private Node<T> last = null;
	private int n = 0;

	public void add (T item) {
		Node<T> old = first;
		first = new Node<T>();
		first.item = item;
		first.next = old;

		if (last == null) last = first;
		else old.prve = first;
		n++;
	}

	public void add (T item, int index) throws Exception {
		if (index > n) throw new Exception("index out");
		if (index == n) {
			addLast(item);
			return;
		}
		if (index == 0) {
			add(item);
			return;
		}
		Node<T> next = getNode(index);
		Node<T> node = new Node<T>();

		node.item = item;
		node.next = next;
		node.prve = next.prve.prve;

		next.prve = node;

		next.prve.prve.next = node;
		n++;
	}

	public void addLast (T item) {
		Node<T> old = last;
		last = new Node<T>();
		last.item = item;
		last.prve = old;
		if (first == null) first = old;
		else old.next = last;
		n++;
	}

	public T remove () throws Exception {
		if (isEmpty()) throw new Exception("List is empty");
		T item = first.item;
		first = first.next;
		first.prve = null;
		if (first == null) last = null;
		n--;
		return item;
	}

	public T removeLast () throws Exception {
		if (isEmpty()) throw new Exception("List is empty");
		T item = last.item;
		last = last.prve;
		last.next = null;
		if (first == null) last = null;
		n--;
		return item;
	}

	public T remove (int index) throws Exception {
		if (index >= n) throw new Exception("index out");
		// 首尾直接删
		if (index == 0)
			return remove();
		if (index == n - 1)
			return removeLast();
		if (isEmpty()) throw new Exception("List is empty");
		Node<T> temp = getNode(index);
		T item = temp.item;
		temp.prve.next = temp.next;
		temp.next.prve = temp.prve;
		n--;
		return item;
	}

	public T get (int index) throws Exception {
		if (index >= n) throw new Exception("index out");
		return getNode(index).item;
	}

	public Node<T> getNode (int index) {
		Node<T> temp = null;
		// 离首尾远近不同查找方向也不同
		if (index < n - index) {
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			temp = last;
			for (int i = n - 1; i > index; i--) {
				temp = temp.prve;
			}
		}
		return temp;
	}

	public boolean isEmpty () {
		return n == 0;
	}

	public int size () {
		return n;
	}

	public void clear () {
		while (first != null) {
			Node<T> next = first.next;
			first.next = null;
			first.prve = null;
			first.item = null;
			first = next;
		}
		n = 0;
		first = null;
		last = null;
	}

	private static class Node<T> {
		private T item;
		private Node<T> prve;
		private Node<T> next;
	}

	public static void main(String[] args) throws Exception {
		LinkedList<String> l = new LinkedList<String>();
		l.add("123");
		l.add("we");
		l.add("sdf");
		l.add("dfg", 3);
		System.out.println(l.get(3));
		System.out.println(l.get(2));
		System.out.println(l.get(1));
		System.out.println(l.get(0));
	}
}
