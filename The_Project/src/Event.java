// Not completed 
public class Event {

    private String tutle;
    private String date;
    private String time;
    private String location;
    //and the contact involved <-----
    
    // Note: نحتاج نربط كونتاكت بالايفنت ونقدر نفترض انه كل كونتاكت له ايفنت واحد
    //
    //
    public String getTutle() {
        return tutle;
    }
    
    public void setTutle(String tutle) {
        this.tutle = tutle;
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
    
    
    
    // toString to print the information of the event 
    
    @Override
    public String toString() {
        return "Event [tutle=" + tutle + ", date=" + date + ", time=" + time + ", location=" + location + "]";
    }
    
    
    
}