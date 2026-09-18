package model;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private String course;
    private int year;
    private Integer roomNo;

    public Student(int id, String name, String phone, String course, int year) {
        super(id, name, phone);
        this.course = course;
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        String roomText = (roomNo == null) ? "Not allotted" : String.valueOf(roomNo);

        return "ID=" + getId() +
               ", Name=" + getName() +
               ", Phone=" + getPhone() +
               ", Course=" + course +
               ", Year=" + year +
               ", Room=" + roomText;
    }
}

