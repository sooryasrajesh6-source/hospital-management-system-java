import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println("Patient ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Disease    : " + disease);
        System.out.println("----------------------------");
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    void display() {
        System.out.println("Doctor ID       : " + id);
        System.out.println("Name            : " + name);
        System.out.println("Specialization  : " + specialization);
        System.out.println("----------------------------");
    }
}

class Appointment {
    int appointmentId;
    String patientName;
    String doctorName;
    String date;

    Appointment(int appointmentId, String patientName, String doctorName, String date) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
    }

    void display() {
        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Patient Name   : " + patientName);
        System.out.println("Doctor Name    : " + doctorName);
        System.out.println("Date           : " + date);
        System.out.println("----------------------------");
    }
}

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static int patientId = 1;
    static int doctorId = 1;
    static int appointmentId = 1;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Search Patient");
            System.out.println("8. Delete Patient");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    bookAppointment();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    searchPatient();
                    break;
                case 8:
                    deletePatient();
                    break;
                case 9:
                    System.out.println("Thank you for using Hospital Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 9);
    }

    static void addPatient() {
        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(patientId, name, age, disease));
        patientId++;

        System.out.println("Patient added successfully.");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("\n===== PATIENT LIST =====");
        for (Patient p : patients) {
            p.display();
        }
    }

    static void addDoctor() {
        System.out.print("Enter doctor name: ");
        String name = sc.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = sc.nextLine();

        doctors.add(new Doctor(doctorId, name, specialization));
        doctorId++;

        System.out.println("Doctor added successfully.");
    }

    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        System.out.println("\n===== DOCTOR LIST =====");
        for (Doctor d : doctors) {
            d.display();
        }
    }

    static void bookAppointment() {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Add patients and doctors first.");
            return;
        }

        System.out.print("Enter patient name: ");
        String patientName = sc.nextLine();

        System.out.print("Enter doctor name: ");
        String doctorName = sc.nextLine();

        System.out.print("Enter appointment date: ");
        String date = sc.nextLine();

        appointments.add(new Appointment(appointmentId, patientName, doctorName, date));
        appointmentId++;

        System.out.println("Appointment booked successfully.");
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        System.out.println("\n===== APPOINTMENT LIST =====");
        for (Appointment a : appointments) {
            a.display();
        }
    }

    static void searchPatient() {
        System.out.print("Enter patient ID to search: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("\nPatient found:");
                p.display();
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    static void deletePatient() {
        System.out.print("Enter patient ID to delete: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                patients.remove(p);
                System.out.println("Patient deleted successfully.");
                return;
            }
        }

        System.out.println("Patient not found.");
    }
}
