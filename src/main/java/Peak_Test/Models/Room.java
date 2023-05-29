package Peak_Test.Models;

public class Room {
    private String floor;
    private String roomNum;
    private int status;

    public Room(String floor, String roomNum, int status) {
        this.floor = floor;
        this.roomNum = roomNum;
        this.status = status;
    }

    public String getFloor() {
        return floor;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRoomName() { return floor + '0' + roomNum; }

    @Override
    public String toString() {
        return floor + ',' + roomNum  + ',' + getRoomName() + ',' + status;
    }
}
