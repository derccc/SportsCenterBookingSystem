package test;


import execute.CmdAddNewRoom;
import execute.SportsCenter;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class CmdAddNewRoomTest {


	@Test
    public void testAddRoomType() {
        CmdAddNewRoom cmdAddNewRoom = new CmdAddNewRoom();
        String input = "t\nbadminton 40\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner scanner = new Scanner(System.in);
	    cmdAddNewRoom.execute(scanner);
	    scanner.close();
    }
	@Test
    public void testAddRoomToExsitingType() {
        CmdAddNewRoom cmdAddNewRoom = new CmdAddNewRoom();
        String input = "r\n1\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner scanner = new Scanner(System.in);
	    cmdAddNewRoom.execute(scanner);
	    scanner.close();
    }
	@Test
    public void testAddRoomToExsitingType_NotExsit() {
        CmdAddNewRoom cmdAddNewRoom = new CmdAddNewRoom();
        String input = "r\n6\n1\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner scanner = new Scanner(System.in);
	    cmdAddNewRoom.execute(scanner);
	    scanner.close();
    }
	@Test
    public void testAddRoomTypeNot() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
        CmdAddNewRoom cmdAddNewRoom = new CmdAddNewRoom();
        String input = "t\nbadminton 40\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner scanner = new Scanner(System.in);
	    cmdAddNewRoom.execute(scanner);
	    scanner.close();
    }
	
	@Test
    public void testNoRoomType() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		SportsCenter sportsCenter = SportsCenter.getInstance();
		
		Class<?> cls = SportsCenter.class;
	    Constructor<?> cons = cls.getDeclaredConstructor();
	    cons.setAccessible(true);
	    SportsCenter emptyInstance = (SportsCenter) cons.newInstance();
	    
	    // Access private field using reflection
	    Field field = SportsCenter.class.getDeclaredField("INSTANCE");
	    field.setAccessible(true); // Make private field accessible

	    // Modify the private field
	    field.set(sportsCenter, emptyInstance);
	    

        CmdAddNewRoom cmdAddNewRoom = new CmdAddNewRoom();
        String input = "t\nbadminton 40\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner scanner = new Scanner(System.in);
	    cmdAddNewRoom.execute(scanner);
	    scanner.close();
    }
	
		
	}