/**
 * 
 */
package com.flipkart.bean;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 */
public class Slots {
	private String slotId;
	private String gymId;

	private int capacity;
	private LocalTime time;
	
	public Slots() {
		
	}
	
	public String getSlotId() {
		return slotId;
	}
	
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public String getGymId() {
		return gymId;
	}

	public void setGymId(String gymId) {
		this.gymId = gymId;
	}
}
