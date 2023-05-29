package Peak_Test.Models;

public class Booking {
    private String name;
    private int age;
    private Room room;
    private KeyCard keyCard;

    public Booking(String name, int age, Room room, KeyCard keyCard) {
        this.name = name;
        this.age = age;
        this.room = room;
        this.keyCard = keyCard;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Room getRoom() {
        return room;
    }

    public KeyCard getKeyCard() {
        return keyCard;
    }

    @Override
    public String toString() {
        return name + ',' + age + ',' + room.getRoomName() + ',' + keyCard.getCardNum() ;
    }
}
