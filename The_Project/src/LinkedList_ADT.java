
public class LinkedList_ADT<Contact> {

	private Node<Contact> head;
	private Node<Contact> tail;
	private Node<Contact> current;

	public LinkedList_ADT() {
		head = current = null;
	}

	public void addContact(Contact contact) {
		Node<Contact> temp = new Node<Contact>();
		
		if (head == null) {
			current = head = temp;
		}
			//where current?
		if (checkAvail(contact))
			System.out.println("Contact already added in the Phonebook");
		else {
			temp.next = current.next;
			temp.previous = current;
			if (current.next != null)
				current.next.previous = temp;
			current.next = temp;
			current = temp;
		}

	}
	
	public boolean checkAvail (Contact contact) {
		Node<Contact> temp = new Node<Contact>();
		current = head;
		while(current != null) {
			if (current.data.getName().equalsIgnoreCase(temp.data.getName())
					|| current.data.getPhnumber() == temp.data.getPhnumber())
				return true;
			else
				current = current.next;
		}
		return false;
	}

}
