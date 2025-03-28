import java.util.Scanner;

public class WRMTester {
    public static void main(String[] args) {
        WRM wrm = new WRM();
        System.out.println("** Welcome to Waiting Room Management System **");
        System.out.println("==Choose an option ==");

        System.out.println("1.registerPatient()");
        System.out.println("2.servePatient()");
        System.out.println("3.showAllPatients()");
        System.out.println("4.canDoctorGoHome()");
        System.out.println("5.cancelAll()");
        System.out.println("6.reverseTheLine()");
        System.out.println("7.Exit");

        Scanner input = new Scanner(System.in);
        int chosen = input.nextInt();
        input.nextLine();  // To clear the newline after reading integer input

        while (chosen != 7) {
            if (chosen == 1) {
                System.out.println("Executing Register Patient...");
                System.out.print("Enter id: ");
                int id = input.nextInt();
                input.nextLine();  // Clear the newline after reading the integer
                System.out.print("Enter name: ");
                String name = input.nextLine();  // Now correctly reads the name
                System.out.print("Enter age: ");
                int age = input.nextInt();
                input.nextLine();  // Clear the newline after reading the integer
                System.out.print("Enter bloodgroup: ");
                String group = input.nextLine();  // Now correctly reads the group
                wrm.registerPatient(id, name, age, group);
                System.out.println("Successful registration of the patient");
            } else if (chosen == 2) {
                wrm.servePatient();
            } else if (chosen == 3) {
                System.out.println("The ids of the patients to serve are as follows :");
                wrm.showAllPatient();
            } else if (chosen == 4) {
                if(!wrm.canDoctorGoHome()) System.out.println("No");
                else if(wrm.canDoctorGoHome())System.out.println("yes");
                
            } else if (chosen == 5) {
                wrm.cancelAll();
                System.out.println("Success");
            } else if (chosen == 6) {
                wrm.reverseTheLine();
                System.out.println("Success");
            }

            System.out.println();
            System.out.println("** Welcome to Waiting Room Management System **");
            System.out.println("==Choose an option ==");
            System.out.println("1.registerPatient()");
            System.out.println("2.servePatient()");
            System.out.println("3.showAllPatients()");
            System.out.println("4.canDoctorGoHome()");
            System.out.println("5.cancelAll()");
            System.out.println("6.reverseTheLine()");
            System.out.println("7.Exit");
            chosen = input.nextInt();
            input.nextLine();  // Clear the newline after reading integer input
        }
        if (chosen == 7) {
            System.out.println("Thanks for using our service");
        }
    }
}