package test;

import execute.ViewBookingService;
import execute.Booking;
import execute.Common;
import execute.Room;
import execute.RoomType;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewBookingServiceTest {

    @Test
    public void testViewBooking_InitialDisplay() {
        ArrayList<Booking> allBookings = new ArrayList<>();
        Room room1 = new Room("101", new RoomType("001", "Badminton", 10));
        Booking booking1 = new Booking(room1, "001", "20240520", 10, 12, 100, "X", "BK001");
        Room room2 = new Room("102", new RoomType("001", "Badminton", 10));
        Booking booking2 = new Booking(room2, "002", "20240521", 10, 12, 100, "X", "BK002");
        allBookings.add(booking1);
        allBookings.add(booking2);

        ViewBookingService viewBookingService = new ViewBookingService();
        String[] inputs = {}; 
        StringReader stringReader = new StringReader(String.join("\n", inputs));
        Scanner scanner = new Scanner(stringReader);

        viewBookingService.viewBooking(allBookings, scanner);
        
        scanner.close();
    }

    @Test
    public void testViewBooking_NavigateMonths() {
        ArrayList<Booking> allBookings = new ArrayList<>();
        ViewBookingService viewBookingService = new ViewBookingService();
        String input = "p\n"; 
        StringReader stringReader = new StringReader(input);
        Scanner scanner = new Scanner(stringReader);
        viewBookingService.viewBooking(allBookings, scanner);
        
        scanner.close();
    }

    @Test
    public void testViewBooking_SelectSpecificMonth() {
        ArrayList<Booking> allBookings = new ArrayList<>();
        ViewBookingService viewBookingService = new ViewBookingService();
        String[] inputs = {"s", "2024", "6", "q"}; 
        StringReader stringReader = new StringReader(String.join("\n", inputs));
        Scanner scanner = new Scanner(stringReader);
        viewBookingService.viewBooking(allBookings, scanner);
       
        scanner.close();
    }

    @Test
    public void testViewBooking_Today() {
        ArrayList<Booking> allBookings = new ArrayList<>();
        ViewBookingService viewBookingService = new ViewBookingService();
        String[] inputs = {"t", "q"}; 
        StringReader stringReader = new StringReader(String.join("\n", inputs));
        Scanner scanner = new Scanner(stringReader);
        viewBookingService.viewBooking(allBookings, scanner);
        
    }
}