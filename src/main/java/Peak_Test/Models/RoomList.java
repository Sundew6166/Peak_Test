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

    public List<Room> getEmptyFloor(String flr) {
        List<Room> roomList = new ArrayList<Room>();
        for (Room r: rooms) {
            if (r.getFloor().equals(flr)) roomList.add(r);
        }
        return roomList;
    }

    public boolean checkFloorIsEmpty(String flr) {
        for (Room r: rooms) {
            if (r.getFloor().equals(flr) && r.getStatus() == 0) return false;
        }
        return true;
    }

}
