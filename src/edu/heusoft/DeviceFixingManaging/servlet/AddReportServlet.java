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
import edu.heusoft.DeviceFixingManaging.dao.RepairRecordDao;
import edu.heusoft.DeviceFixingManaging.dao.ReportEquipmentDao;
import edu.heusoft.DeviceFixingManaging.dao.ReportRecordDao;
import edu.heusoft.DeviceFixingManaging.javabean.RepairRecord;
import edu.heusoft.DeviceFixingManaging.javabean.ReportEquipment;
import edu.heusoft.DeviceFixingManaging.javabean.ReportRecord;

public class AddReportServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean result = false;
		PrintWriter out = response.getWriter();
		
	//ReportRecord
		String customer_idno         	= request.getParameter("customer_idno");
		Date   report_time           	= DateUtil.HTMLtoServlet(request.getParameter("report_time"));
		Date   predict_complete_time 	;
	//ReportEquipment
 		String product_type                 = request.getParameter("product_type");         
		String report_equip_brand           = request.getParameter("report_equip_brand");       
		String report_equip_model           = request.getParameter("report_equip_model");           
		String report_equip_series          = request.getParameter("report_equip_series");         
		String report_equip_absent          = request.getParameter("report_equip_absent");
		String report_equip_problem  		= request.getParameter("report_equip_problem");         
		String report_equip_problem_type    = request.getParameter("report_equip_problem_type");
		
		ReportRecord rtr = new ReportRecord();
		ReportRecordDao rtrDao = new ReportRecordDao();
		ReportEquipment re = new ReportEquipment();
		ReportEquipmentDao reDao = new ReportEquipmentDao();

	//addReportEquipment

		re.init();
		re.setProduct_type(product_type);
		re.setReport_equip_brand(report_equip_brand);
		re.setReport_equip_model(report_equip_model);
		re.setReport_equip_series(report_equip_series);
		re.setReport_equip_absent(report_equip_absent);
		re.setReport_equip_problem(report_equip_problem_type);
		re.setReport_equip_problem_type(report_equip_problem_type);
		
		
		result = reDao.addReportEquipment(re);
		
		if(result = false)
		{
			System.out.println("1");
			failInfo(result,out);
		}
	//addReportRecord
		
		rtr.init();
		rtr.setCustomer_idno(customer_idno);
		rtr.setReport_equip_no(reDao.getLastId());
		rtr.setReport_time(report_time);
		rtr.setPredict_complete_time(report_time);
		
		result = rtrDao.addReportRecord(rtr);
		
		if(result == false)
		{
			System.out.println("2");
			failInfo(result,out);
		}
		

	//addRepairRecord 
		//查保修单号
		
		int report_record_no = rtrDao.getLastId();

		RepairRecord rrr = new RepairRecord();
		rrr.init();
		rrr.setRepair_time(report_time);
		rrr.setRepair_test_time(report_time);
		rrr.setReport_record_no(report_record_no);
		
		RepairRecordDao rrrDao = new RepairRecordDao();
		result = rrrDao.addRepairRecord(rrr);

		if(result = false)
		{
			System.out.println("3");
			failInfo(result,out);
		}
		
//		request.setAttribute("ReportRecord", rtr);
//		request.setAttribute("ReportEquipment", re);
		request.setAttribute("id", rrrDao.getLastId());

		request.getRequestDispatcher("/Service/confirmReport.jsp").forward(request, response);
	}    
	
	
	void failInfo(boolean result ,PrintWriter out)
	{
		out.println("<script>");
		out.println("alert('添加失败!');");
		out.println("parent.doQuery();"); //refresh
		out.println("javascript :history.back(-1);");
//		out.println("setTimeout(function {document.forms[0].submit();},1000);"); 
		out.println("</script>");

		out.flush();
		out.close();
	}
         
}        
         
         