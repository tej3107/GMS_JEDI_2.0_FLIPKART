/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import java.time.LocalDate;
import com.flipkart.dao.*;
/**
 * 
 */
public class CustomerService { 
	CustomerGMSDao customerDao = new CustomerGMSDao();
	
	public void registerCustomer(User user, Customer customer) {
		customerDao.registerCustomer(user, customer);
	}
	
	public Customer fetchCustomerDetails(String customerId) {
		return new Customer();
	}
	
	public void fetchGymList() {
		customerDao.fetchGymList();
		return;
	}
	
	public void fetchAvilableSlots(String gymId) {
		customerDao.fetchSlotList(gymId);
	}
	
	public int bookSlots(String slotId,String customerId,int date) {
		if(alreadyBooked(slotId,customerId,date)) {
			return 0;
		}else if(isFull(slotId,date)) {
			return 1;
		}else {
			customerDao.bookSlots(slotId, customerId, date);
			return 2;
		}
	}
	
	public boolean alreadyBooked(String slotId,String customerId,int date) {
		return false;
	}
	
	public boolean isFull(String slotId,int date) {
		return customerDao.isFull(slotId, date);
	}
	
	public boolean bookSlot(String slotId,String customerId,int date) {
		return true;
	}
	
	public void bookedSlots(String customerId) {
		return ;
	}
}
