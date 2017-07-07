//MJRT
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.common.DateUtil;
import edu.heusoft.DeviceFixingManaging.dao.ReportEquipmentDao;
import edu.heusoft.DeviceFixingManaging.dao.ReportRecordDao;
import edu.heusoft.DeviceFixingManaging.javabean.ReportEquipment;
import edu.heusoft.DeviceFixingManaging.javabean.ReportRecord;

public class QueryReportEquipmentServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int    report_equip_no				= Integer.parseInt(request.getParameter("report_equip_no"));
		String product_type                 = request.getParameter("product_type");                
	    String report_equip_brand           = request.getParameter("report_equip_brand");          
	    String report_equip_model           = request.getParameter("report_equip_model");          
	    String report_equip_series          = request.getParameter("report_equip_series");         
	    String report_equip_absent          = request.getParameter("report_equip_absent");         
	    String report_equip_problem  		= request.getParameter("report_equip_problem");        
	    String report_equip_problem_type    = request.getParameter("report_equip_problem_type");   
	    String  page 						= request.getParameter("page");
	    
	    ReportEquipment re = new ReportEquipment();
	    re.init();
	    re.setReport_equip_no(report_equip_no);
	    
	    ReportEquipmentDao dao = new ReportEquipmentDao();
		
		//分页
		int totalRows = 0; // 总数据量
		int pageSize = 5; 
		int pages = 0;		//总页数
		int currentPage = 1;
		int startPosition = 0; // 起始位置
		
		
		totalRows = dao.queryReportEquipmentTotalRows(re);
		pages = (int) Math.ceil((double)totalRows/pageSize);
		if(page != null)
		{
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		
		
		ArrayList<ReportEquipment> result = dao.queryEquipment(re, startPosition, pageSize);
		
		request.setAttribute("data", result);
		//ce
		request.setAttribute("pages",pages);
		request.setAttribute("currentPage",currentPage);
		
		
		request.getRequestDispatcher("/UserInfo/queryResult.jsp").forward(request, response);
	    
		
	}

}
