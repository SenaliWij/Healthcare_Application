import java.util.Date;

public class Patient extends Person{
    private String patientID;

    public Patient(String patientID, String patientDOB, String patientName, String patientContactNo) {
        super(patientName,patientDOB,patientContactNo);
        this.patientID = patientID;

    }

    public String getPatientID() {
        return patientID;
    }

    public char getPatientType(){
        char patientType=patientID.charAt(0);
        return patientType;
    }
}
