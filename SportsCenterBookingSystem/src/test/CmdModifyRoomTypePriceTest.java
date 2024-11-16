package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import org.junit.Test;

import execute.CmdAddNewRoom;
import execute.CmdModifyRoomTypePrice;
import execute.Main;
import execute.RoomType;
import execute.SportsCenter;
import execute.User;

public class CmdModifyRoomTypePriceTest {
	 @Test
	    public void testExecute_ModifyPrice_Success() {
	        // Arrange
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        RoomType roomType = new RoomType("B", "Badminton", 800);
	        sportsCenter.addRoomType(roomType);
	        String input = "B\n900\nY";
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);

	        // Act
	        CmdModifyRoomTypePrice command = new CmdModifyRoomTypePrice();
	        command.execute(scanner);

	        // Assert
	        RoomType updatedRoomType = sportsCenter.getRoomTypeByID("B");
	        assertEquals("The room type price should be updated to 900", 900, updatedRoomType.getPrice());
	        scanner.close();
	    }

	    @Test
	    public void testExecute_RoomTypeIDNotExist() {
	        // Arrange
	    	SportsCenter sportsCenter = SportsCenter.getInstance();
	        RoomType roomType = new RoomType("B", "Badminton", 800);
	        sportsCenter.addRoomType(roomType);
	        String input = "X\nB\n800\nYB\n900\nY";
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);

	        // Act
	        CmdModifyRoomTypePrice command = new CmdModifyRoomTypePrice();
	        command.execute(scanner);
	    }

	    @Test
	    public void testExecute_PriceSameAsOriginal() {
	        // Arrange
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        RoomType roomType = new RoomType("B", "Badminton", 800);
	        sportsCenter.addRoomType(roomType);
	        String input = "B\n800";
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);

	        // Act
	        CmdModifyRoomTypePrice command = new CmdModifyRoomTypePrice();
	        command.execute(scanner);
	    }

	    @Test
	    public void testExecute_CancelPriceModification() {
	        // Arrange
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        RoomType roomType = new RoomType("B", "Badminton", 800);
	        sportsCenter.addRoomType(roomType);
	        String input = "B\n900\nN";
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);

	        // Act
	        CmdModifyRoomTypePrice command = new CmdModifyRoomTypePrice();
	        command.execute(scanner);

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
		    

	        String input = "B\n900\nN";
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);

	        // Act
	        CmdModifyRoomTypePrice command = new CmdModifyRoomTypePrice();
	        command.execute(scanner);

	    }
	
}
