package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.PartDetailDao;
import edu.heusoft.DeviceFixingManaging.javabean.PartDetail;

public class AddPartDetailServiceManServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

//		String part_detail_no	  	= request.getParameter("part_detail_no");
		String part_no	            = request.getParameter("part_no");
		String part_detail_num   	= request.getParameter("part_detail_num");
//		String part_detail_status   = request.getParameter("part_detail_status");
		String repair_record_no     = request.getParameter("repair_record_no");

		
		int a = -1,b = -1,c = -1, d=-1; 
		if(!repair_record_no.equals(""))
		{
			a=Integer.parseInt(repair_record_no);
		}
		if(!part_no.equals(""))
		{
			b=Integer.parseInt(part_no);
		}
		if(!part_detail_num.equals(""))
		{
			c=Integer.parseInt(part_detail_num);
		}

		
		
		PartDetail pd = new PartDetail(d, b, c, "未出库", a);
		PartDetailDao dao = new PartDetailDao();
		
		boolean result = dao.addPartDetail(pd);
		
		PrintWriter out = response.getWriter();
		
		String message=null;
		
		if (result) {
			message="申请成功！";
		}
		else {
			message="申请失败！";
		}
//		parent.query.doQuery();
		out.println("<script>");
		out.println(	"alert('"+message+"');");
		out.println("self.location='/DeviceFixingManaging/Engineer/QueryPart.jsp';");
		out.println("</script>");
		
		out.flush();
		

		
		
	}

}
