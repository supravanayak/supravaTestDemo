package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Customer;

public class test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getCustomerList().size());
	}
	public static List<Customer> getCustomerList(){
		List<Customer> Customers = new ArrayList<Customer>();
		Customer customer1 = new Customer(1,"suprava","Nayak","abc@gmail.com",6546546);
		Customer customer2 = new Customer(1,"Deva","DD","abcd@gmail.com",65465468);
		Customers.add(customer1);
		Customers.add(customer2);
		System.out.println(Customers);
		return Customers;
	}
}
