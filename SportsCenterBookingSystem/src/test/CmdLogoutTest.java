package test;

import execute.CmdLogout;
import execute.Main;
import execute.SportsCenter;
import execute.User;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CmdLogoutTest {

    @Test
    public void testExecute() {
    	CmdLogout cmdLogout = new CmdLogout();
    	cmdLogout.execute(new Scanner(System.in));
        
    }
}