package tests;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import source.Date;

class DateTest {
	
	@Test
	void testShouldThrowExceptionOnDaySmallerThan1()  {
			
		Date date = new Date();
		
		assertThrows(IllegalArgumentException.class, () -> date.setDay(0) );
	}

	@Test
	void testShouldThrowExceptionOnDayBiggerThan31() {
			
		Date date = new Date();
		
		assertThrows(IllegalArgumentException.class, () -> date.setDay(32) );
	}

	@Test
	void testShouldThrowExceptionOnDayBiggerThan30On30DayMonth() {
			
		Date date = new Date().setMonth(4);
		
		assertThrows(IllegalArgumentException.class, () -> date.setDay(31) );
	}
	
	@Test
	void testShouldThrowExceptionOnDayBiggerThan28OnNonLeapYear() {
			
		Date date = new Date().setMonth(2).setYear(2001);
		
		assertThrows(IllegalArgumentException.class, () -> date.setDay(29) );
	}

	@Test
	void testShouldThrowExceptionOnDayBiggerThan29OnLeapYear() {
			
		Date date = new Date().setMonth(2).setYear(2000);
		
		assertThrows(IllegalArgumentException.class, () -> date.setDay(30) );
	}
	
	@Test
	void testShouldThrowExceptionOnDayBiggerThan28OnFebNonLeapYear() {
			
		Date date = new Date().setMonth(2).setYear(2001);
		
		assertThrows(IllegalArgumentException.class, () -> date.setDay(29) );
	}
	
	@Test
	void testShouldThrowExceptionOnMonthLessThan1() {
		Date date = new Date();
		
		assertThrows(IllegalArgumentException.class, () -> date.setMonth(0) );
	}
	
	@Test
	void testShouldThrowExceptionOnMonthGreaterThan12() {
		Date date = new Date();
		
		assertThrows(IllegalArgumentException.class, () -> date.setMonth(13) );
	}
	
	@Test
	void testShouldThrowExceptionOnYearLessThan2000() {
		Date date = new Date();
		
		assertThrows(IllegalArgumentException.class, () -> date.setYear(1999) );
	}
	
	@Test
	void testShoulNotThrowExceptionOnFebruary29thLeapYear() {
		Date date = new Date().setMonth(2);
		
		assertDoesNotThrow( () -> date.setDay(29) );
	}
	
	@Test
	void testShoulNotThrowExceptionOnFebruary28thNonLeapYear() {
		Date date = new Date().setMonth(2).setYear(2001);
		
		assertDoesNotThrow( () -> date.setDay(28) );
	}
	
	@Test
	void testShoulThrowExceptionOnDayBiggerThan30On30DayMonth() {
		Date date = new Date().setMonth(4).setYear(2000);
		
		assertThrows(IllegalArgumentException.class, () -> date.setDay(31) );
	}
	
	@Test
	void testShoulNotThrowExceptionOnDaySmallerThan31On30DayMonth() {
		Date date = new Date().setMonth(4).setYear(2000);
		
		assertDoesNotThrow(() -> date.setDay(30) );
	}
		
	@Test
	void testDateShouldStartWithDay1Month1Year2000() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
				
		Date date = new Date();		
		
		Field field = date.getClass().getDeclaredField("day");
		field.setAccessible(true);
		int testDay = field.getInt(date);
		
		field = date.getClass().getDeclaredField("month");
		field.setAccessible(true);
		int testMonth = field.getInt(date);
		
		field = date.getClass().getDeclaredField("year");
		field.setAccessible(true);
		int testYear = field.getInt(date);
		
		assertEquals(1, testDay);
		assertEquals(1, testMonth);
		assertEquals(2000, testYear);
				
	}

	@Test 
	void testAdvanceOnFirstDay() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {		
		Date date = new Date();		
		
		date.advance();
	
		Field field = date.getClass().getDeclaredField("day");
		field.setAccessible(true);
		int testDay = field.getInt(date);
		
		field = date.getClass().getDeclaredField("month");
		field.setAccessible(true);
		int testMonth = field.getInt(date);
		
		field = date.getClass().getDeclaredField("year");
		field.setAccessible(true);
		int testYear = field.getInt(date);
		
		assertEquals(2, testDay);
		assertEquals(1, testMonth);
		assertEquals(2000, testYear);
	}
	
	@Test 
	void testAdvanceOnLastDayOf31DayMonth() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {		
		Date date = new Date();		
	
		date.setDay(31);
		
		date.advance();
		
		Field field = date.getClass().getDeclaredField("day");
		field.setAccessible(true);
		int testDay = field.getInt(date);
		
		field = date.getClass().getDeclaredField("month");
		field.setAccessible(true);
		int testMonth = field.getInt(date);
		
		field = date.getClass().getDeclaredField("year");
		field.setAccessible(true);
		int testYear = field.getInt(date);

		assertEquals(1, testDay);
		assertEquals(2, testMonth);
		assertEquals(2000, testYear);
	}

	@Test
	void testAdvanceOn29thFebruaryLeapYear() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Date date = new Date();		
		
		date.setDay(29).setMonth(2).setYear(2000);
		
		date.advance();
		
		Field field = date.getClass().getDeclaredField("day");
		field.setAccessible(true);
		int testDay = field.getInt(date);
		
		field = date.getClass().getDeclaredField("month");
		field.setAccessible(true);
		int testMonth = field.getInt(date);
		
		field = date.getClass().getDeclaredField("year");
		field.setAccessible(true);
		int testYear = field.getInt(date);
		
		assertEquals(1, testDay);
		assertEquals(3, testMonth);
		assertEquals(2000, testYear);
	}
	
	@Test
	void testAdvanceOn28thFebruaryNonLeapYear() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Date date = new Date();		
		
		date.setDay(28).setMonth(2).setYear(2001);

		date.advance();
		
		Field field = date.getClass().getDeclaredField("day");
		field.setAccessible(true);
		int testDay = field.getInt(date);
		
		field = date.getClass().getDeclaredField("month");
		field.setAccessible(true);
		int testMonth = field.getInt(date);
		
		field = date.getClass().getDeclaredField("year");
		field.setAccessible(true);
		int testYear = field.getInt(date);
		
		assertEquals(1, testDay);
		assertEquals(3, testMonth);
		assertEquals(2001, testYear);
	}
	
	@Test
	void testAdvanceOnLastDayOfTheYear() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Date date = new Date();		
		
		date.setDay(31).setMonth(12).setYear(2000);
		
		date.advance();
		
		Field field = date.getClass().getDeclaredField("day");
		field.setAccessible(true);
		int testDay = field.getInt(date);
		
		field = date.getClass().getDeclaredField("month");
		field.setAccessible(true);
		int testMonth = field.getInt(date);
		
		field = date.getClass().getDeclaredField("year");
		field.setAccessible(true);
		int testYear = field.getInt(date);
		
		assertEquals(1, testDay);
		assertEquals(1, testMonth);
		assertEquals(2001, testYear);
	}

}
