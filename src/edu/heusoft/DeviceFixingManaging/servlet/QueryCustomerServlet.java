//MJRT
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.CustomerDao;
import edu.heusoft.DeviceFixingManaging.javabean.Customer;

public class QueryCustomerServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String customer_idno  = request.getParameter("customer_idno");
		String customer_linkman = request.getParameter("customer_linkman");
		String customer_mobilephone	   = request.getParameter("customer_mobilephone");
		String customer_address  = request.getParameter("customer_address");
		String customer_character = request.getParameter("customer_character");
		String customer_email	   = request.getParameter("customer_email");
		
		String page    = request.getParameter("page");
		
		
		Customer cus = new Customer();
		cus.init();
		
		cus.setCustomer_idno(customer_idno);
		cus.setCustomer_mobilephone(customer_mobilephone);
		cus.setCustomer_linkman(customer_linkman);
		cus.setCustomer_character(customer_character);
		cus.setCustomer_address(customer_address);
		cus.setCustomer_email(customer_email);
		
		

		CustomerDao dao = new CustomerDao();
		
		//分页
		int totalRows = 0; // 总数据量
		int pageSize = 5; 
		int pages = 0;		//总页数
		int currentPage = 1;
		int startPosition = 0; // 起始位置
		
		
		totalRows = dao.queryCustomerTotalRows(cus);
		pages = (int) Math.ceil((double)totalRows/pageSize);
		if(page != null)
		{
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		
		
		ArrayList<Customer> result = dao.queryCustomer(cus,startPosition,pageSize);
		
		request.setAttribute("data", result);
		request.setAttribute("pages",pages);
		request.setAttribute("currentPage",currentPage);
		
		request.getRequestDispatcher("/Service/queryCustomer.jsp").forward(request, response);
	}

}
