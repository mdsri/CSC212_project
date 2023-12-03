public class Event implements Comparable<Event> {

	private String type;
	private String title;
	private String date;
	private String time;	// 24H
	private String location;
	private String contactName;
	private ContactBST contacts;

	public Event(String type, String title, String date, String time, String location) {
		this.type = type;
		this.title = title;
		this.date = date;
		this.time = time;
		this.location = location;
		this.contacts = new ContactBST();
	}

	public String getType() {
		return type;
	}
	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getLocation() {
		return location;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {	///////////////////////////
		this.contactName = contactName;
	}
	
	@Override
	public String toString() {
		return type +" Title: " + title + "\nDate and time (DD/MM/YYYY - HH:MM): " + date + " - " + time
				+ "\nLocation: " + location;
	}
	
	public void printEventDetails() {
		System.out.print(toString() + "\nContact: ");
		contacts.printAllContactsName();
		System.out.println();
	}

	@Override
	public int compareTo(Event o) {
		return this.title.compareToIgnoreCase(o.title);
	}

	public boolean noConflict(Event o) {
		if (date.equalsIgnoreCase(o.date) && time.equalsIgnoreCase(o.time))
			return false;
		return true;
	}
	
	public boolean insertContactInEvent(Contact c) {
		return contacts.insert(c.getName(), c);
	}
	
	public boolean deleteContactInEvent(String name) {
		if(contacts.search(name))
			return contacts.removeKey(name);
		return false;
	}
	
	public void printContactInEvent() {
		
	}

}