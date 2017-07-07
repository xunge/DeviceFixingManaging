package edu.heusoft.DeviceFixingManaging.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.heusoft.DeviceFixingManaging.dao.CustomerDao;
import edu.heusoft.DeviceFixingManaging.javabean.Customer;

public class TestPart {

	public static void main(String[] args) {
		
		
		Customer cus=new Customer();
		CustomerDao dao=new CustomerDao();
		
		
		String d = "1111-12-12";
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = null;
		try {
			dd = f.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cus.setCustomer_idno("");
		cus.setCustomer_visittime(null);
		cus.setCustomer_character("家庭用户");
		cus.setCustomer_companyname("");
		cus.setCustomer_housephone("");
		cus.setCustomer_mobilephone("");
		cus.setCustomer_address("");
		cus.setCustomer_postcode("");
		cus.setCustomer_linkman("");
		cus.setCustomer_email("");
		
//		ArrayList<Customer> result = dao.queryCustomer(cus,0,20);
//		
//		for(Customer key : result)
//			System.out.println(key.toString());
		
		System.out.println(dao.queryCustomerTotalRows(cus));
	}

}
