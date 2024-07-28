import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Doctor extends Person{
    private int docID;
    private String specialization;

    public ArrayList<Date> docAvailability=new ArrayList<>();
    public HashMap<Date,ArrayList<Appoinment>> allAppoinments =new HashMap<>();

    public String getSpecialization() {
        return specialization;
    }


    public int getDocID() {
        return docID;
    }

    public Doctor(int docID, String docName, String doctorDOB, String specialization, String docContactNo) {
        super(docName,doctorDOB,docContactNo);
        this.docID = docID;
        this.specialization = specialization;

    }

    public boolean isPhysician(){
        if(this.specialization.endsWith("Physician")){
            return true;
        }
        return false;
    }

    public void setDocAvailability(Date availabilityDate) {

        this.docAvailability.add(availabilityDate);
    }
    public void setAppointment(Appoinment appointment, Date date) {
        ArrayList<Appoinment> currentAppointments = this.allAppoinments.get(date);
        if (currentAppointments == null) {
            ArrayList<Appoinment> tempApppointmentList = new ArrayList<>();
            tempApppointmentList.add(appointment);
            this.allAppoinments.put(date, tempApppointmentList);
        } else {
            currentAppointments.add(appointment);
            this.allAppoinments.put(date, currentAppointments);
        }
    }
}
