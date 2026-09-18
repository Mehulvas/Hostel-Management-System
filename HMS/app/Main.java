package app;

import model.*;
import service.*;
import exception.*;
import java.util.*;
import java.io.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DATA_FILE = "data/hostel.dat";

    public static void main(String[] args) {
        HostelService hostelService = loadHostelData();

        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        addStudent(hostelService);
                        break;
                    case "2":
                        addRoom(hostelService);
                        break;
                    case "3":
                        allotRoom(hostelService);
                        break;
                    case "4":
                        vacateRoom(hostelService);
                        break;
                    case "5":
                        listStudents(hostelService);
                        break;
                    case "6":
                        listRooms(hostelService);
                        break;
                    case "7":
                        addComplaint(hostelService);
                        break;
                    case "8":
                        resolveComplaint(hostelService);
                        break;
                    case "9":
                        recordPayment(hostelService);
                        break;
                    case "10":
                        generateReport(hostelService);
                        break;
                    case "0":
                        saveData(hostelService);
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception error) {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }

    static void displayMenu() {
        System.out.println();
        System.out.println("===== HOSTEL MANAGEMENT SYSTEM =====");
        System.out.println("1. Add student");
        System.out.println("2. Add room");
        System.out.println("3. Allot room");
        System.out.println("4. Vacate room");
        System.out.println("5. List students");
        System.out.println("6. List rooms");
        System.out.println("7. Add complaint");
        System.out.println("8. Resolve complaint");
        System.out.println("9. Record payment");
        System.out.println("10. Generate report");
        System.out.println("0. Save & exit");
        System.out.print("Choose: ");
    }

    static void addStudent(HostelService hostelService) throws Exception {
        System.out.print("ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Course: ");
        String course = scanner.nextLine();

        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        Student student = new Student(studentId, name, phone, course, year);
        hostelService.addStudent(student);
    }

    static void addRoom(HostelService hostelService) throws Exception {
        System.out.print("Room no: ");
        int roomNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        hostelService.addRoom(roomNumber, capacity);
    }

    static void allotRoom(HostelService hostelService) throws Exception {
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Room no: ");
        int roomNumber = Integer.parseInt(scanner.nextLine());

        hostelService.allotRoom(studentId, roomNumber);
    }

    static void vacateRoom(HostelService hostelService) throws Exception {
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        hostelService.vacateRoom(studentId);
    }

    static void listStudents(HostelService hostelService) {
        hostelService.students().forEach(System.out::println);
    }

    static void listRooms(HostelService hostelService) {
        hostelService.rooms().forEach(System.out::println);
    }

    static void addComplaint(HostelService hostelService) throws Exception {
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Complaint: ");
        String complaintText = scanner.nextLine();

        Complaint complaint = hostelService.addComplaint(studentId, complaintText);
        System.out.println("Complaint added successfully. Complaint ID: " + complaint.getId());
    }

    static void resolveComplaint(HostelService hostelService) throws Exception {
        System.out.print("Complaint ID: ");
        int complaintId = Integer.parseInt(scanner.nextLine());

        hostelService.resolveComplaint(complaintId);
    }

    static void recordPayment(HostelService hostelService) throws Exception {
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        hostelService.pay(studentId, amount);
    }

    static void generateReport(HostelService hostelService) {
        System.out.println("Students: " + hostelService.students().size());
        System.out.println("Rooms: " + hostelService.rooms().size());

        long occupiedBeds = hostelService.rooms()
                .stream()
                .mapToLong(room -> room.getOccupants().size())
                .sum();
        System.out.println("Occupied beds: " + occupiedBeds);

        System.out.println("Complaints: " + hostelService.complaints().size());

        double totalPayments = hostelService.payments()
                .values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.println("Payments: " + totalPayments);

        hostelService.complaints().forEach(System.out::println);
    }

    static HostelService loadHostelData() {
        try {
            return HostelService.load(DATA_FILE);
        } catch (Exception error) {
            return new HostelService();
        }
    }

    static void saveData(HostelService hostelService) {
        try {
            new File("data").mkdirs();
            hostelService.save(DATA_FILE);
            System.out.println("Saved successfully.");
        } catch (IOException error) {
            System.out.println("Could not save data.");
        }
    }
}

