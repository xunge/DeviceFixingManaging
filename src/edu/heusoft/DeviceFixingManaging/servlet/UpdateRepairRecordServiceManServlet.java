package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.RepairRecordDao;
import edu.heusoft.DeviceFixingManaging.javabean.RepairRecord;

public class UpdateRepairRecordServiceManServlet extends HttpServlet {

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
		               
		//此处应该过滤没有输入框的值
			String repair_record_no = request.getParameter("repair_record_no");
//			String report_record_no = request.getParameter("report_record_no");
//			String repair_person_no = request.getParameter("repair_person_no");
//			String repair_time = request.getParameter("repair_time");
			String test_record = request.getParameter("test_record");
			String repair_record = request.getParameter("repair_record");
			String repair_test_time = request.getParameter("repair_test_time");
			String work_amount = request.getParameter("work_amount");
			String person_price = request.getParameter("person_price");
			String material_price = request.getParameter("material_price");
			String repair_promise = request.getParameter("repair_promise");
			String attention = request.getParameter("attention");
			String repair_status = request.getParameter("repair_status");
			String repair_delay  = request.getParameter("repair_delay");
			
			
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			
			Date time = null;
//			try {
//				time = f.parse(repair_time);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
			 
            SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
			
			Date time2 = null;
			try {
				time2 = f2.parse(repair_test_time);
			} catch (ParseException e) {
			
			}
			
			
			int a = -1,b = -1,c = -1; 
    		if(!repair_record_no.equals(""))
			{
				a=Integer.parseInt(repair_record_no);
			}
//			if(!report_record_no.equals(""))
//			{
//				b=Integer.parseInt(report_record_no);
//			}
//			if(!repair_person_no.equals(""))
//			{
//				c=Integer.parseInt(repair_person_no);
//			}
		
			double d=-1.0,e=-1.0;
			
			if(!person_price.equals(""))
			{
				d = Double.parseDouble(person_price);
			}
			if(!material_price.equals(""))
			{
				e = Double.parseDouble(material_price);
			}
			
			RepairRecord rr = new RepairRecord(a, b, time, test_record,repair_record, time2, work_amount,d,e,repair_promise,attention,repair_status,repair_delay, c);
			
			RepairRecordDao dao = new RepairRecordDao();
			
			boolean result = dao.updateRepairRecord(rr);
			
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('"+(result?"更新成功!":"更新失败!")+"');");
//			out.println("parent.doQuery();"); //refresh
////			out.println("javascript :history.back(-1);");
////			out.println("setTimeout(function {document.forms[0].submit();},1000);"); 
//			out.println("</script>");
//			
//			out.flush();
//			out.close();
			
			RequestDispatcher dis=request.getRequestDispatcher("/Engineer/QueryRepairRecord.jsp");

			dis.forward(request, response);
	}

}
