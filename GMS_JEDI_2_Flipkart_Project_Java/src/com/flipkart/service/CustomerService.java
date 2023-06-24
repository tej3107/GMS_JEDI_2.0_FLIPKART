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
	
	public int bookSlots(String slotId,String customerId) {
		if(isFull(slotId)) {
			return 1;
		}
		else if(alreadyBooked(slotId,customerId)) {
			return 0;
		}else {
			customerDao.bookSlots(slotId, customerId);
			return 2;
		}
	}
	
	public boolean alreadyBooked(String slotId,String customerId) {
		return customerDao.changeGymSlot(slotId,customerId);

	}
	
	public boolean isFull(String slotId) {
		return customerDao.isFull(slotId);
	}
	
	public boolean bookSlot(String slotId,String customerId,int date) {
		return true;
	}
	
	public void bookedSlots(String customerId) {
		customerDao.bookedGymList(customerId);
		return ;
	}
}
