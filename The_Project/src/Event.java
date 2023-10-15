// Not completed //
public class Event implements Comparable<Event>{

	private String title;
	private String date;
	private String time; // 24H
	private String location;
	//private String contactName;
	// and the contact involved <-----

	// Note: نحتاج نربط كونتاكت بالايفنت ونقدر نفترض انه كل كونتاكت له ايفنت واحد
	//

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override // don't forget to connect contact and no conflict
	public String toString() {
		return "Event title: " + title + "\nEvent date and time (DD/MM/YYYY - HH:MM): " + date + " - " + time
				+ "\nEvent location: " + location;
	}

	@Override
	public int compareTo(Event o) {
		return this.title.compareToIgnoreCase(o.title);
	}

	public boolean noConflict(Event o) {
		if(date.substring(0, 2).equalsIgnoreCase(o.date.substring(0, 2)) 
				&& time.substring(0, 2).equalsIgnoreCase(o.time.substring(0, 2)))
			return false;
		return true;
	}

	// public String printByName(), printByTitle()////ظ

}