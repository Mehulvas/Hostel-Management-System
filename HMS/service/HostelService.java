package service;

import model.*;
import exception.HostelException;
import java.io.*;
import java.util.*;

public class HostelService implements Serializable {
    private final Map<Integer, Student> students = new LinkedHashMap<>();
    private final Map<Integer, Room> rooms = new LinkedHashMap<>();
    private final List<Complaint> complaints = new ArrayList<>();
    private final Map<Integer, Double> payments = new HashMap<>();
    private int nextComplaintId = 1;

    public void addRoom(int roomNumber, int capacity) throws HostelException {
        if (rooms.containsKey(roomNumber)) {
            throw new HostelException("Room already exists");
        }

        if (capacity < 1) {
            throw new HostelException("Capacity must be positive");
        }

        Room room = new Room(roomNumber, capacity);
        rooms.put(roomNumber, room);
    }

    public void addStudent(Student student) throws HostelException {
        if (students.containsKey(student.getId())) {
            throw new HostelException("Student ID already exists");
        }

        students.put(student.getId(), student);
    }

    public void allotRoom(int studentId, int roomNumber) throws HostelException {
        Student student = findStudent(studentId);
        Room room = rooms.get(roomNumber);

        if (room == null) {
            throw new HostelException("Room not found");
        }

        if (student.getRoomNo() != null) {
            throw new HostelException("Student already has a room");
        }

        if (room.isFull()) {
            throw new HostelException("Room is full");
        }

        room.getOccupants().add(studentId);
        student.setRoomNo(roomNumber);
    }

    public void vacateRoom(int studentId) throws HostelException {
        Student student = findStudent(studentId);

        if (student.getRoomNo() == null) {
            throw new HostelException("Student has no room");
        }

        Room room = rooms.get(student.getRoomNo());
        room.getOccupants().remove(Integer.valueOf(studentId));
        student.setRoomNo(null);
    }

    public Complaint addComplaint(int studentId, String text) throws HostelException {
        findStudent(studentId);

        Complaint complaint = new Complaint(nextComplaintId, studentId, text);
        complaints.add(complaint);
        nextComplaintId++;
        return complaint;
    }

    public void resolveComplaint(int complaintId) throws HostelException {
        for (Complaint complaint : complaints) {
            if (complaint.getId() == complaintId) {
                complaint.resolve();
                return;
            }
        }

        throw new HostelException("Complaint not found");
    }

    public void pay(int studentId, double amount) throws HostelException {
        findStudent(studentId);

        if (amount <= 0) {
            throw new HostelException("Amount must be positive");
        }

        double currentAmount = payments.getOrDefault(studentId, 0.0);
        payments.put(studentId, currentAmount + amount);
    }

    private Student findStudent(int studentId) throws HostelException {
        Student student = students.get(studentId);

        if (student == null) {
            throw new HostelException("Student not found");
        }

        return student;
    }

    public Collection<Student> students() {
        return students.values();
    }

    public Collection<Room> rooms() {
        return rooms.values();
    }

    public List<Complaint> complaints() {
        return complaints;
    }

    public Map<Integer, Double> payments() {
        return payments;
    }

    public void save(String path) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
            output.writeObject(this);
        }
    }

    public static HostelService load(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            return (HostelService) input.readObject();
        }
    }
}

