
public class LinkedList_ADT<Contact> {

	private Node<Contact> head;
	private Node<Contact> current;

	public LinkedList_ADT() {
		head = current = null;
	}

	public void addContact(Contact contact) {
		Node<Contact> temp = new Node<Contact>(contact);
		
		if (head == null) {
			current = head = temp;
		}
		
		else {
			temp.next = current.next;
			temp.previous = current;
			if (current.next != null)
				current.next.previous = temp;
			current.next = temp;
			current = temp;
		}

	}
/*	
	public void searchNumber(int Name){
		
		Node<Contact> current = head;
		
		while(current != null) {
			if(current)
		}
		
		
	}
	
	*/

}
