package Peak_Test.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomList {
    private List<Room> rooms;

    public RoomList() {
        this.rooms = new ArrayList<Room>();
    }

    public String createRoom(String floor, String room) {
        Room r = new Room(floor, room, 1);
        add(r);

        return "Hotel created with " + floor + " floor(s), " + room + " room(s) per floor." ;
    }

    public String list_Available() {
        String emptyRoom = "";
        for (Room r: rooms) {
            if (r.getStatus() == 1) emptyRoom += (r.getRoomName() + " ");
        }
        return emptyRoom ;
    }

    public void add(Room room) {
        rooms.add(room);
    }

    public Room find(String roomName) {
        for (Room r : rooms) {
            if (r.getRoomName().equals(roomName)) return r;
        }
        return null;
    }

    public boolean checkRoomEmptyWithFloor(String flr) {
        boolean status = true;
        for (Room r: rooms) {
            if (r.getFloor().equals(flr) && r.getStatus() == 0) status = false;
        }
        return status;
    }

    public List<Room> getRoomEmptyWithFloor(String flr) {
        List<Room> rooms = new ArrayList<Room>();
        for (Room r: rooms) {
            if (r.getFloor().equals(flr)) {
                rooms.add(r);
            }
        }
        return rooms;
    }
}
