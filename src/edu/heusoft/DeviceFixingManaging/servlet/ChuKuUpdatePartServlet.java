//xunge
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.PartDao;
import edu.heusoft.DeviceFixingManaging.dao.PartDetailDao;
import edu.heusoft.DeviceFixingManaging.javabean.Part;
import edu.heusoft.DeviceFixingManaging.javabean.PartDetail;

public class ChuKuUpdatePartServlet extends HttpServlet {

	/**
	 * Chuku, first query the 'part detail'
	 * 		then, update the 'part'
	 * 
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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		               
		//此处应该过滤没有输入框的值
			String part_detail_no = request.getParameter("part_detail_no");
			String part_no=request.getParameter("part_no");
//			String repair_record_no=request.getParameter("repair_record_no");
			String part_detail_num=request.getParameter("part_detail_num");
//			String part_detail_status=request.getParameter("part_detail_status");
//			String page=request.getParameter("page");

			int b=Integer.parseInt(part_no);

			int d=Integer.parseInt(part_detail_num);

			//System.out.println(b+" "+d);
			
			PartDetail pd = new PartDetail();
			Part pt = new Part();
			
		
			PartDetailDao dao=new PartDetailDao();
			PartDao dao1= new PartDao();
			

			boolean result1 = dao1.updatePart(b, (-1)*d);
			if(result1) dao.updatePartDetail(Integer.parseInt(part_detail_no), "已出库");
			
			PrintWriter out = response.getWriter();
			
			String message = null;
			
			if (result1) {
				message="出库成功";
			}
			else {
				message="出库失败";
			}
			//parent.query.doQuery();
			out.println("<script>");
			out.println(	"alert('"+message+"');");
			out.println("self.location='/DeviceFixingManaging/Keeper/QueryPartDetail.jsp';");
			out.println("</script>");
			
			out.flush();
			
			

			

	}

}
