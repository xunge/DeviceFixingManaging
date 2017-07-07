package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.CustomerDao;
import edu.heusoft.DeviceFixingManaging.javabean.Customer;

public class DeleteCustomerServlet extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String customer_idno = request.getParameter("customer_idno");
		String flag 		 = request.getParameter("flag");
		CustomerDao dao = new CustomerDao();
		
		boolean result = dao.deleteCustomer(customer_idno);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+(result?"删除成功!":"删除失败!")+"');");
//		out.println("javascript :history.back(-1);");
		if(flag.equals("query"))
			out.println("javascript :history.back(-1);");
		else 
			out.println("self.location='/DeviceFixingManaging/Service/addCustomer.jsp';");
//		out.println("setTimeout(function {document.forms[0].submit();},1000);"); 
		out.println("</script>");
		
		out.flush();
		out.close();
		
	}

}
