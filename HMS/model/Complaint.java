package model;

import java.io.Serializable;

public class Complaint implements Serializable {
    private final int id;
    private final int studentId;
    private final String text;
    private String status = "Pending";

    public Complaint(int id, int studentId, String text) {
        this.id = id;
        this.studentId = studentId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getStatus() {
        return status;
    }

    public void resolve() {
        status = "Resolved";
    }

    @Override
    public String toString() {
        return "Complaint #" + id +
               " | Student=" + studentId +
               " | " + text +
               " | " + status;
    }
}

