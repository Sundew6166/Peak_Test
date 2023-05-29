package Peak_Test.Services;

import Peak_Test.Models.*;

import java.util.ArrayList;
import java.util.List;

public class HardcodeDataSource {

    public RoomList getRoomsData() {
        RoomList rooms = new RoomList();
        rooms.add(new Room("1", "1", 1));
        rooms.add(new Room("1", "2", 1));
        rooms.add(new Room("1", "3", 1));
        rooms.add(new Room("2", "1", 1));
        rooms.add(new Room("2", "2", 1));
        return rooms;
    }

    public KeyCardList getKeyCardsData() {
        KeyCardList keyCards = new KeyCardList();
        keyCards.add(new KeyCard("1", 1));
        keyCards.add(new KeyCard("2", 1));
        keyCards.add(new KeyCard("3", 1));
        keyCards.add(new KeyCard("4", 1));
        keyCards.add(new KeyCard("5", 1));
        return keyCards;
    }

    public BookingList getBookingsData() {
        BookingList bookingList = new BookingList();
        return bookingList;
    }
}