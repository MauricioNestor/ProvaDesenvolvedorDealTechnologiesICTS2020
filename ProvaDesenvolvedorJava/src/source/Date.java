package source;

import java.util.Arrays;
import java.util.List;

public final class Date {

	private int day; // from 1 to 31 
	private int month; // from 1 to 12
	private int year; // from 2000 upwards
	
	private final List<Integer> MONTSWITH31DAYS = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
	
	public Date() {
		setYear(2000);
		setMonth(1);
		setDay(1);
	}
	
	public final void advance() {
		
		if(lastDayOfMonth()) {
			day = 1;
			advanceMonth();
		}else {
			day++;
		}
		
	}
	
	private void advanceMonth() {
		
		if(month == 12) {
			month = 1;
			advanceYear();
		}else {
			month++;
		}
	}
	
	private void advanceYear() {
		year++;
	}

	private boolean lastDayOfMonth() {		
		
		if(MONTSWITH31DAYS.contains(month) && day == 31) {
			return true;
		}
		else if(month == 2) {
			if(isLeapYear()) {
				return day == 29;
			}else
				return day == 28;
		}
		
		return day == 30;
	}
	
	private boolean isLeapYear() {
		
		return ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0)));  
	}
	
	public final Date setDay(int day) {
		
		if(day < 1) {
			throw new IllegalArgumentException("O dia deve ser maior que 1!");
		}
		else if(MONTSWITH31DAYS.contains(month)) {
		
			if (day > 31) {
				throw new IllegalArgumentException("O dia deve ser entre 1 e 31!");
			}
		
		}else if(month == 2) {
			
			if(isLeapYear()) {
				
				if(day > 29) {
					throw new IllegalArgumentException("O dia deve ser entre 1 e 29!");
				}
			}else {
				
				if(day > 28) {
					throw new IllegalArgumentException("O dia deve ser entre 1 e 28!");
				}
			}
		
		}else if(day > 30) {
			throw new IllegalArgumentException("O dia deve ser entre 1 e 30!");
		}
		
		this.day = day;
		return this;
	}

	public final Date setMonth(int month) {
		
		if(month < 1 || month > 12) {
			throw new IllegalArgumentException("O mês deve ser entre 1 e 12!");
		}
		
		this.month = month;
		return this;
	}

	public final Date setYear(int year) {
		
		if(year < 2000) {
			throw new IllegalArgumentException("O Ano deve ser superior a 2000!");
		}
		
		this.year = year;
		return this;
	}
}
