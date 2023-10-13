
public class LinkedList_ADT<T extends Comparable<T>> {

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

	int compareTo(T o) {
		if(current.data > )
	}
	

	
	
	/*
	// this whole method needs revision , slides lecture09 page 172
	public boolean checkAvail(Contact contact) {
		Node<Contact> temp = new Node<Contact>(); // i think it should be [ Node<Contact> temp = current ]
		current = head;

		if (isEmpty()) { // if the list is empty
			return false;
		}

		if (current.next == null && current.data.getName().equalsIgnoreCase(temp.data.getName()) // if only one contact in the list
				|| current.data.getphNumber() == temp.data.getphNumber()) {

			return true;
		}

		do { // do while for the linked list has only one contact. or isEmpty()
			if (current.data.getName().equalsIgnoreCase(temp.data.getName())
					|| current.data.getphNumber() == temp.data.getphNumber())
				return true;
			else
				current = current.next;
		} while (current.next != null);

		return false;
	}
	*/

}
