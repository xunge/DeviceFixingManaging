//MJRT
//MODIFIED BY SLIAN ON 20160729
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.common.DateUtil;
import edu.heusoft.DeviceFixingManaging.dao.ReportRecordDao;
import edu.heusoft.DeviceFixingManaging.javabean.ReportRecord;

public class QueryReportRecordServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
//			int 	report_record_no        = Integer.parseInt(request.getParameter("report_record_no"));       
		    String 	customer_idno           = request.getParameter("customer_idno");      
//		    int 	report_equip_no         = Integer.parseInt(request.getParameter("report_equip_no"));          
		    Date	report_time             = DateUtil.HTMLtoServlet(request.getParameter("report_time"));         
//		    int 	predict_price           = Integer.parseInt(request.getParameter("predict_price"));  
		    Date    predict_complete_time   = DateUtil.HTMLtoServlet(request.getParameter("predict_complete_time")); 
		    String  report_status           = request.getParameter("report_status");
		    String  page 					= request.getParameter("page");
		    
//		    ReportRecord rr = new ReportRecord(report_record_no, customer_idno, report_equip_no, report_time, predict_price, predict_complete_time, report_status);
		    ReportRecord rr = new ReportRecord();
			rr.init();
//			
//			rr.getReport_record_no();
//			rr.getReport_status();
			
			String paramReport_record_no=request.getParameter("report_record_no");
			String paramReport_equip_no=request.getParameter("report_equip_no");
			String paramPredict_price=request.getParameter("predict_price");
			
			if(paramReport_record_no!=""){
				rr.setReport_record_no(Integer.parseInt(request.getParameter("report_record_no")));	
			}
			if(paramReport_equip_no!=null&&paramReport_equip_no!=""){
				rr.setReport_equip_no(Integer.parseInt(request.getParameter("report_equip_no")));	
			}
			if(paramPredict_price!=""){
				rr.setPredict_price(Integer.parseInt(request.getParameter("predict_price")));	
			}
			rr.setPredict_complete_time(predict_complete_time);
			rr.setReport_time(report_time);
			rr.setReport_status(report_status);
			rr.setCustomer_idno(customer_idno);
			

			ReportRecordDao dao = new ReportRecordDao();
			
			//分页
			int totalRows = 0; // 总数据量
			int pageSize = 5; 
			int pages = 0;		//总页数
			int currentPage = 1;
			int startPosition = 0; // 起始位置
			
			
			totalRows = dao.queryReportRecordTotalRows(rr);

			
			pages = (int) Math.ceil((double)totalRows/pageSize);
			if(page != null)
			{
				currentPage = Integer.parseInt(page);
			}
			startPosition = (currentPage-1)*pageSize;
			
			ArrayList<ReportRecord> result = dao.queryReportRecord(rr, startPosition, pageSize);
			
			request.setAttribute("data", result);
			request.setAttribute("totalpages",pages);
			request.setAttribute("currentpage",currentPage);
			
			request.getRequestDispatcher("/Service/queryreportrecord.jsp").forward(request, response);
		    
	}      
}
