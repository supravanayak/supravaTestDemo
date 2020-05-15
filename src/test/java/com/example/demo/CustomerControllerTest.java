package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.controller.CustomerController;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRespository;

@RunWith(MockitoJUnitRunner.class)
class CustomerControllerTest {

	@Mock
	CustomerRespository customerRespositoryMock;
	Customer customer;

	@InjectMocks
	CustomerController customerControllerUnderTest;

	@Test
	public void testGetAllCustomers() {
		when(customerRespositoryMock.findAll()).thenReturn(getCustomerList());
		List<Customer> custList = customerControllerUnderTest.getAllCustomers();
		assertEquals(2, custList.size());
	}
	public List<Customer> getCustomerList(){
		List<Customer> Customers = new ArrayList<Customer>();
		Customer customer1 = new Customer(1,"suprava","Nayak","abc@gmail.com",6546546);
		Customer customer2 = new Customer(1,"Deva","DD","abcd@gmail.com",65465468);
		Customers.add(customer1);
		Customers.add(customer2);
		System.out.println(Customers);
		return Customers;
	}

		
		//fail("Not yet implemented"); }

	/*
	 * 
	 * 
	 * @Test void testCreateCustomer() { fail("Not yet implemented"); }
	 * 
	 * @Test void testUpdateCustomer() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDeleteCustomer() { fail("Not yet implemented"); }
	 * 
	 */}
