package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.CustomerDao;
import edu.heusoft.DeviceFixingManaging.javabean.Customer;

public class UpdateCustomerServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		               
		//此处应该过滤没有输入框的值
			String customer_idno          = request.getParameter("customer_idno");
			String customer_visittime     = request.getParameter("customer_visittime");
			String customer_character     = request.getParameter("customer_character");
			String customer_companyname   = request.getParameter("customer_companyname");
			String customer_housephone    = request.getParameter("customer_housephone");
			String customer_mobilephone   = request.getParameter("customer_mobilephone");
			String customer_address       = request.getParameter("customer_address");
			String customer_postcode      = request.getParameter("customer_postcode");
			String customer_linkman       = request.getParameter("customer_linkman");
			String customer_email         = request.getParameter("customer_email");

			
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			
			Date time = null;
			try {
				time = f.parse(customer_visittime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Customer cus = new Customer(customer_idno, time, customer_character, customer_companyname, customer_housephone, customer_mobilephone, customer_address, customer_postcode, customer_linkman, customer_email);
			
			CustomerDao dao = new CustomerDao();
			
			boolean result = dao.updateCustomer(cus);
			
			if(result)
			{
				request.setAttribute("id",customer_idno);
				request.getRequestDispatcher("/Service/updateCustomer.jsp").forward(request, response);
			}
			else
			{
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('"+(result?"更新成功!":"更新失败!")+"');");
//				out.println("parent.doQuery();"); //refresh
				out.println("javascript :history.back(-1);");
//				out.println("setTimeout(function {document.forms[0].submit();},1000);"); 
				out.println("</script>");
				
				out.flush();
				out.close();			
			}

	}

}
