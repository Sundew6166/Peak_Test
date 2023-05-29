package Peak_Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Peak_Test.Models.*;
import Peak_Test.Services.*;

public class Main {
    public static void main(String[] args) {
        String output = "";
        HardcodeDataSource dataSource = new HardcodeDataSource();
        RoomList roomList = dataSource.getRoomsData();
        KeyCardList keyCardList = dataSource.getKeyCardsData();
        BookingList bookingList = dataSource.getBookingsData();

        FileDataSource fileDataSource = new FileDataSource();
        try {
            List<String> listInput = fileDataSource.read("input.txt");
            for (String item: listInput) {
                String temp = "";
                String[] data = item.split(" ");
                String comp = data[0].trim();
                if ("create_hotel".equals(comp)) {
                    temp += roomList.createRoom(data[1].trim(), data[2].trim());
                } else if ("list_available_rooms".equals(comp)) {
                    temp += roomList.list_Available();
                } else if ("book".equals(comp)) {
                    temp += bookingList.checkIn(data[1].trim(), data[2].trim(),Integer.parseInt(data[3].trim()), roomList, keyCardList);
                } else if ("checkout".equals(comp)) {
                    temp += bookingList.checkOut(data[1].trim(), data[2].trim(), roomList, keyCardList);
                } else if ("list_guest".equals(comp)) {
                    temp += bookingList.list_guest();
                } else if ("get_guest_in_room".equals(comp)) {
                    temp += bookingList.get_guest_in_room(data[1].trim());
                } else if ("list_guest_by_age".equals(comp)) {
                    temp += bookingList.list_guest_by_age(Integer.parseInt(data[2]));
                } else if ("list_guest_by_floor".equals(comp)) {
                    temp += bookingList.list_guest_by_floor(data[1].trim());
                } else if ("checkout_guest_by_floor".equals(comp)) {
                    temp += bookingList.checkout_guest_by_floor(data[1].trim(), roomList, keyCardList);
                } else {
                    temp += bookingList.book_by_floor(data[1].trim(), data[2].trim(),Integer.parseInt(data[3].trim()), roomList, keyCardList);
                }
                output += temp + "\n";
            }
            System.out.println(output);
        } catch (IOException e) {
            System.err.println("You can't read file");
        }
    }
}
