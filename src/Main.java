import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Controller controller=new Controller();;

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        boolean mainMenu=true;
        while(mainMenu){

        System.out.println("""
        -----------------------------------------------
        Press :
        1) If you are a hospital adminstator
        2) If you are a patient
        3) Exit
        -----------------------------------------------
        """);
        System.out.print("Enter Option: ");
        int user=sc.nextInt();

            if(user==1){
               administrator();
            }
            if(user==2){
                user();
            }
            if(user==3){
                mainMenu=false;
            }
        }
    }



    private static void administrator() {
        boolean adminMenu=true;
        while(adminMenu) {
            Scanner sc = new Scanner(System.in);
            System.out.println(""" 
                    -----------------------------------------------
                    Press :
                    1) Add a doctor
                    2) Add doctor Availablity
                    3) Exit
                    ------------------------------------------------
                    """);
            System.out.print("Enter Option: ");
            int objective = sc.nextInt();
            if (objective == 1) {
                controller.addDoctor();
            } else if (objective == 2) {
               controller.addDocAvailability();
            } else {
                adminMenu = false;
            }
        }
    }

    private static void user() {
        boolean userMenu=true;
        while(userMenu) {
            Scanner sc = new Scanner(System.in);
            System.out.println(""" 
                    -----------------------------------------------
                    Press :
                    1) View Doctors
                    2) Book an appointment
                    3) View a Selected doctor's bookings
                    4) Register Patient
                    5) Exit
                    -----------------------------------------------
                    """);
            System.out.print("Enter Option: ");
            int objective = sc.nextInt();
            if (objective == 1) {
                controller.viewDoctor();
            } else if (objective == 2) {
                controller.bookAppoinment();
            } else if (objective == 3) {
                controller.viewDoctorBooking();
            } else if (objective == 4) {
               controller.registerPatient();
            } else {
                userMenu=false;
            }

        }
    }


    }
