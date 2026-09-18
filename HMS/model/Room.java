package model;

import java.io.Serializable;
import java.util.*;

public class Room implements Serializable {
    private final int roomNo;
    private final int capacity;
    private final List<Integer> occupants = new ArrayList<>();

    public Room(int roomNo, int capacity) {
        this.roomNo = roomNo;
        this.capacity = capacity;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Integer> getOccupants() {
        return occupants;
    }

    public boolean isFull() {
        return occupants.size() >= capacity;
    }

    @Override
    public String toString() {
        return "Room " + roomNo +
               " | Capacity=" + capacity +
               " | Occupants=" + occupants.size() + "/" + capacity +
               " | IDs=" + occupants;
    }
}

