package com.vitaly.t3;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class DbHandlerTest {

	@Test 
	public void testGetInstance() {
		//assertTrue(true);
		try {
			//assertNull(DbHandler.getInstance());
			DbHandler dbHandler = DbHandler.getInstance();
			dbHandler.execute("1");
			
			assertTrue(dbHandler != null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
