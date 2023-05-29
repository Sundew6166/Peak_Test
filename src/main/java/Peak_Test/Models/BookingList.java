package Peak_Test.Models;

import java.util.ArrayList;
import java.util.List;

public class BookingList {
    private List<Booking> bookings;

    public BookingList() {
        this.bookings = new ArrayList<Booking>();
    }

    public void add(Booking booking) {
        bookings.add(booking);
    }

    public void remove(Booking booking) {
        int i = 0;
        for (Booking b: bookings){
            if (b.toString().equals(booking.toString())) {
                bookings.remove(i);
                break;
            }
            i+= 1;
        }
    }

    public Booking cardNumInBooked(String number) {
        for (Booking b: bookings) {
            if (b.getKeyCard().getCardNum().equals(number)) return b;
        }
        return null;
    }

    public String booked(Room room) {
        for (Booking b: bookings) {
            if (b.getRoom().getRoomName().equals(room.getRoomName())) return b.getName();
        }
        return null;
    }

    public String checkOut(String cardNum, String name, RoomList roomList, KeyCardList keyCardList) {
        Booking b = cardNumInBooked(cardNum);
        KeyCard k = keyCardList.findStatusNotEmpty(cardNum);
        Room r = roomList.find(b.getRoom().getRoomName());

        if (b.getName().equals(name)){
            remove(b);
            k.setStatus(1);
            r.setStatus(1);
            return "Room "+ r.getRoomName()+" is checkout.";
        }
        return "Only "+ b.getName()+" can checkout with keycard number " + cardNum;
    }

    public String checkIn(String roomName, String name, int age, RoomList roomList, KeyCardList keyCardList) {
        Room r = roomList.find(roomName); // not null
        KeyCard k = keyCardList.findStatusEmpty(); // not null

        String item = booked(r);
        if (r.getStatus() == 0){
            return "Cannot book room " + roomName + " for "+ name +", The room is currently booked by " + item +".";
        }
        else if(k != null && r != null) {
            r.setStatus(0);
            k.setStatus(0);
            Booking booking = new Booking(name, age, r, k);
            add(booking);
            return "Room " + roomName +" is booked by " + name + " with keycard number "+ k.getCardNum() + ".";
        }
        return "no data";
    }

    public String list_guest() {
        String back = "";
        for (Booking b: bookings) {
            back += b.getName() + ", ";
        }
        back = back.substring(0, back.length()-2);
        return back;
    }

    public String get_guest_in_room(String roomName) {
        for (Booking b: bookings) {
            if (b.getRoom().getRoomName().equals(roomName)) return b.getName();
        }
        return "not found";
    }

    public String list_guest_by_age(int age) {
        String back = "";
        for (Booking b: bookings) {
            if (b.getAge() < age) {
                back += b.getName() + ", ";
            }
        }
        back = back.substring(0, back.length()-2);
        return back;
    }

    public String list_guest_by_floor(String flr) {
        String back = "";
        for (Booking b: bookings) {
            if (b.getRoom().getFloor().equals(flr)) {
                back += b.getName() + ", ";
            }
        }
        back = back.substring(0, back.length()-2);
        return back;
    }

    public String checkout_guest_by_floor(String flr, RoomList roomList, KeyCardList keyCardList) {
        String back = "Room ";
        List<Booking> floor = new ArrayList<Booking>();
        for (Booking b: bookings) {
            if (b.getRoom().getFloor().equals(flr)) {
                floor.add(b);
            }
        }
        for(Booking b: floor) {
            back += b.getRoom().getRoomName() + ", ";

            KeyCard k = keyCardList.findStatusNotEmpty(b.getKeyCard().getCardNum());
            Room r = roomList.find(b.getRoom().getRoomName());

            remove(b);
            k.setStatus(1);
            r.setStatus(1);
        }
        back = back.substring(0, back.length()-2);
        return back + " are checkout.";
    }

    public String book_by_floor(String flr, String name, int age, RoomList roomList, KeyCardList keyCardList) {
        boolean check = roomList.checkFloorIsEmpty(flr);
        if (!check) return "Cannot book floor "+flr+" for "+ name + ".";

        List<Room> data = roomList.getEmptyFloor(flr);
        String back = "Room ";
        String card = "";

        for (Room r: data) {
            back += r.getRoomName() + ", ";
            KeyCard k = keyCardList.findStatusEmpty();

            card += k.getCardNum() + ", ";

            r.setStatus(0);
            k.setStatus(0);
            Booking booking = new Booking(name, age, r, k);
            add(booking);
        }

        card = card.substring(0, card.length()-2);
        back = back.substring(0, back.length()-2) + " are booked with keycard number " + card;
        return back;
    }
}
