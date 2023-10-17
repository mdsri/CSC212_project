public class LinkedList_ADT<T> {

	private Node<T> head;
	private Node<T> current;

	public LinkedList_ADT() {
		head = current = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean first() {
		return current.previous == null;
	}

	public boolean full() {
		return false;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public void findPrevious() {
		current = current.previous;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T val) {
		current.data = val;
	}

	public void insert(T val) {
		Node<T> temp = new Node<T>(val);
		if (isEmpty()) {
			current = head = temp;
		} else {
			temp.next = current.next;
			temp.previous = current;
			if (current.next != null)
				current.next.previous = temp;
			current.next = temp;
			current = temp;
		}
	}

	public void insertBeforeFirst(T val) {
		Node<T> temp = new Node<T>(val);

		temp.next = head;
		temp.previous = null;

		if (head != null)
			head.previous = temp;

		head = temp;
	}

	public void remove() {
		if (current == head)
			head = head.next;
		else
			current.previous.next = current.next;

		if (current.next != null)
			current.next.previous = current.previous;

		if (current.next == null)
			current = head;

		else
			current = current.next;
	}
}
