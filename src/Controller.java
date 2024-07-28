import java.util.*;

public class Controller {
    private  ArrayList<Doctor> doctorList=new ArrayList<>();
    private ArrayList<Patient> patientList=new ArrayList<>();
    private int slotNum=2;
    public  void addDoctor(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter doctor ID: ");
        int docID=sc.nextInt();;
        System.out.print("Enter doctor name: ");
        String docName=sc.next();
        System.out.print("Enter date of birth: ");
        String doctorDOB=sc.next();
        System.out.print("Enter specialization: ");
        String specialization=sc.next();
        System.out.print("Contact number: ");
        String docContactNo=sc.next();

        Doctor doc=new Doctor(docID,  docName, doctorDOB, specialization, docContactNo);
        doctorList.add(doc);
        System.out.println("Successfully Added"+"\n");

        System.out.print("Do you want to add another doctor(Y/N): ");
        String anotherDoc=sc.next();
        if(anotherDoc.equalsIgnoreCase("Y")){
            addDoctor();
        }

    }
    public void viewDoctor(){
        int i=1;
        System.out.println("Doctor Details:" );
        for(Doctor doctor:doctorList){
            System.out.println("\nDoctor " +i+ "\nName: "+doctor.getName()+ "\nSpecializationz: "+ doctor.getSpecialization());
            i++;
        }
    }

    public void addDocAvailability(){
        Scanner sc=new Scanner(System.in);
        Doctor selectedDoc=getDoctor();
        if(selectedDoc!=null) {
            System.out.println("Enter Year you want to add avaialability: ");
            int year = sc.nextInt();
            System.out.println("Enter Month you want to add avaialability: ");
            int month = sc.nextInt();
            System.out.println("Enter Day you want to add avaialability: ");
            int day = sc.nextInt();

            Date bookedDate = new Date(year, month, day);
            selectedDoc.setDocAvailability(bookedDate);
            System.out.println("Doctor Avialability Added!!");
        }
    }
    public void registerPatient(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter patient ID: ");
        String patientID=sc.next();
        System.out.print("Enter patient name: ");
        String patientName=sc.next();
        System.out.print("Enter date of birth: ");
        String patientDOB=sc.next();
        System.out.print("Enter Contact number: ");
        String patContactNo=sc.next();

        Patient patient=new Patient(patientID,patientDOB,patientName,patContactNo);
        patientList.add(patient);

        System.out.println("Patient Registered");
    }
    public void bookAppoinment() {
        Scanner sc = new Scanner(System.in);
        Doctor selectedDoc = getDoctor();
        Patient selectedPatient = getPatient();
        if (selectedDoc != null || selectedPatient != null) {
            System.out.println("Enter Year you want to book appointment: ");
            int year = sc.nextInt();
            System.out.println("Enter Month you want to book appointment: ");
            int month = sc.nextInt();
            System.out.println("Enter Day you want to book appointment: ");
            int day = sc.nextInt();
            Date appointmentDate = new Date(year, month, day);

            if (checkAvailability(selectedDoc, appointmentDate)) {
                String slotTime = getTime(selectedDoc, appointmentDate);
                if (slotTime != null) {
                    Appoinment appoinment = new Appoinment(selectedDoc, selectedPatient, "No Notes", appointmentDate, slotTime);
                    selectedDoc.setAppointment(appoinment,appointmentDate);
                    System.out.println(selectedDoc.allAppoinments.toString());
                    System.out.println("Appointment booked");
                }
            } else {
                System.out.println("Sorry Doctor not avaiable for the selected date..All slots filled");
            }
        } else {
            System.out.println("Enter correct details");
        }
    }
    public void viewDoctorBooking(){
        int i=1;
        System.out.println("Bookings" );
        Doctor doc=getDoctor();
        for(Date date : doc.docAvailability){
            System.out.println("\nDoctor " +i+ "\nName: "+doc.getName()+ "\nSpecializationz: "+ doc.getSpecialization()+"\nDate Available: "+date );
            i++;
        }
    }
    public Doctor getDoctor(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter doctor ID: ");
        int docID=sc.nextInt();

        Doctor selectedDoc=null;
        for(Doctor doc: doctorList){
            if(doc.getDocID()==docID){
                selectedDoc=doc;
            }
        }
        if(selectedDoc==null){
            System.out.println("Dcotor not found");
        }
        return selectedDoc;
    }

    public Patient getPatient(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter patient ID: ");
        String patientID=sc.next();

        Patient selectedPat=null;
        for(Patient pat: patientList){
            if(pat.getPatientID().equalsIgnoreCase(patientID)){
                selectedPat=pat;
            }
        }
        if(selectedPat==null){
            System.out.println("Patient not found");
            return null;
        }
        return selectedPat;
    }
    private boolean checkAvailability(Doctor doc,Date bookedDate){
        for(Date day:doc.docAvailability) {
            if(day.equals(bookedDate)){
                return true;
            }
        }
        return false;
    }
    private String getTime(Doctor doc,Date bookedDate){
        for(Map.Entry<Date,ArrayList<Appoinment>> appointment:doc.allAppoinments.entrySet()){
            if(appointment.getKey().equals(bookedDate)){
                int slotTaken=appointment.getValue().size();
                if(slotTaken>slotNum-1){
                    return null;
                }
                System.out.println("Can make booking");
                int setTime=17+appointment.getValue().size();
                String time=setTime+" : 00";
                return time;
            }
        }
        return "17 : 00";
    }
}
