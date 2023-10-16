// Not completed //
public class Event implements Comparable<Event>{

	private String title;
	private String date;
	private String time; // 24H
	private String location;

	public Event(String title, String date, String time, String location) {
		this.title = title;
		this.date = date;
		this.time = time;
		this.location = location;
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
		if(date.equalsIgnoreCase(o.date) 
				&& time.equalsIgnoreCase(o.time))
			return false;
		return true;
	}

}
