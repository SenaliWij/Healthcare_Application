import java.util.Date;

public class Appoinment {
    private Doctor doc;
    private Patient patient;
    private String notes;
    private Date date;
    private String time;

    public Appoinment(Doctor doc, Patient patient, String notes, Date date, String time) {
        this.doc = doc;
        this.patient = patient;
        this.notes = notes;
        this.date = date;
        this.time = time;
    }


}
