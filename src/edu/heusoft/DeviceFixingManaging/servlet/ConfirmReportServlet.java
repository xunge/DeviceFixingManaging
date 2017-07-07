package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.RepairRecordDao;
import edu.heusoft.DeviceFixingManaging.javabean.RepairRecord;

public class ConfirmReportServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id      	      	= Integer.parseInt(request.getParameter("id"));
		boolean result = false;
		System.out.println(id);
        RepairRecord rr = new RepairRecord();
        rr.init();
        rr.setRepair_record_no(id);
        rr.setRepair_status("未分配");
        
        RepairRecordDao rrDao = new RepairRecordDao();
        result = rrDao.updateRepairRecord(rr);
        
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+(result?"确认成功!":"确认失败!")+"');");
		out.println("parent.doQuery();"); //refresh
//		out.println("javascript :history.back(-1);");
//		out.println("setTimeout(function {document.forms[0].submit();},1000);"); 
		out.println("</script>");
		
		out.flush();
		out.close();
	}
	
	
}
