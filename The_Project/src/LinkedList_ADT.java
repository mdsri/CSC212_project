
public class LinkedList_ADT<T> {

	private Node<T> head;
	private Node<T> tail;
	private Node<T> current;
	

	public LinkedList_ADT() {
		head = current = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addContact(T contact) {
		Node<T> temp = new Node<T>();
		
		if (head == null) {
			current = head = (Node<T>) temp;
		}
		// where current?
		if (checkAvail(contact))
			System.out.println("Contact already added in the Phonebook");
		else {
			temp.next = (Node<T>) current.next;
			temp.previous = (Node<T>) current;
			if (current.next != null)
				current.next.previous = temp;
			current.next = temp;
			current = temp;
		}

	}

	
}
