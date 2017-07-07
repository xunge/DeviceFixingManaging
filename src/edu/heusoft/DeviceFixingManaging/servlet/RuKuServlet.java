// xunge
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
import edu.heusoft.DeviceFixingManaging.javabean.PartDetail;

public class RuKuServlet extends HttpServlet {

	/**
	 * Ruku, first update the part 
	 * 		then, add the part detail autoly.
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

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		               
		//此处应该过滤没有输入框的值
			String part_no          = request.getParameter("part_no");
			String part_inc_num     = request.getParameter("part_inc_num");


			int a = -1,b = -1; 
			if(!part_no.equals(""))
			{
				a=Integer.parseInt(part_no);
			}
			if(!part_inc_num.equals(""))
			{
				b=Integer.parseInt(part_inc_num);
			}

			double d = -1.0;

			PartDao dao = new PartDao();
			
			PartDetailDao dao1 = new PartDetailDao();
			
			PartDetail pd = new PartDetail();
			
			pd.setPart_detail_no(-1);
			pd.setPart_no(2);
			pd.setRepair_record_no(1);
			pd.setPart_detail_num(4);
			pd.setPart_detail_status("");
			
			boolean result = dao.updatePart(a, b);
			
			boolean result1 = dao1.addPartDetail(pd);
			
			
			PrintWriter out = response.getWriter();
			
			String message = null;
			
			if (result1) {
				message="入库成功";
			}
			else {
				message="入库失败";
			}
			
			out.println("<script>");
			out.println(	"alert('"+message+"');");
			out.println("self.location='/DeviceFixingManaging/Keeper/QueryPart.jsp';");
			out.println("</script>");
			
			out.flush();
			

			
			
			
	}
}
