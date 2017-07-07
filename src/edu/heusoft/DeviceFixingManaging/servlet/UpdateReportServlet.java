package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.common.DateUtil;
import edu.heusoft.DeviceFixingManaging.dao.RepairRecordDao;
import edu.heusoft.DeviceFixingManaging.dao.ReportRecordDao;
import edu.heusoft.DeviceFixingManaging.javabean.RepairRecord;
import edu.heusoft.DeviceFixingManaging.javabean.ReportRecord;

public class UpdateReportServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String recordNo=request.getParameter("report_record_no"); //READONLY
		String customerIdno=request.getParameter("customer_idno"); //READONLY
		String equipNo=request.getParameter("report_equip_no"); //READONLY
		String reportTime=request.getParameter("report_time");
		String predictPrice=request.getParameter("predict_price");
		String predictCompleteTime=request.getParameter("predict_complete_time");
		String reportStatus=request.getParameter("report_status");
		
		ReportRecord rr=new ReportRecord();
		rr.init();
		if(recordNo!=null&&!recordNo.equals("")){
			rr.setReport_record_no(Integer.parseInt(recordNo));
		}
		if(customerIdno!=null&&!customerIdno.equals("")){
			rr.setCustomer_idno(customerIdno);
		}
		if(equipNo!=null&&!equipNo.equals("")){
			rr.setReport_equip_no(Integer.parseInt(equipNo));
		}
		if(reportTime!=null&&!reportTime.equals("")){
			java.util.Date d=DateUtil.HTMLtoServlet(reportTime);
			rr.setReport_time(d);
		}
		if(predictPrice!=null&&!predictPrice.equals("")){
			rr.setPredict_price(Integer.parseInt(predictPrice));
		}
		if(predictCompleteTime!=null&&!predictCompleteTime.equals("")){
			java.util.Date d=DateUtil.HTMLtoServlet(predictCompleteTime);
			rr.setPredict_complete_time(d);
		}
		if(reportStatus!=null&&!reportStatus.equals("")){
			rr.setReport_status(reportStatus);
		}
		
		ReportRecordDao dao=new ReportRecordDao();
		
		System.out.println(rr);
		boolean result=dao.updateReportRecord(rr);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		
		if(result){
			out.println("alert('提交成功！');");
		}else {
			out.println("alert('提交失败');");
		}
		out.println("self.location='/DeviceFixingManaging/Service/z-querycheckout.jsp';");
		
		out.println("</script>");
		out.flush();
		out.close();
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		RepairRecord rr = new RepairRecord();
		rr.init();
		rr.setRepair_record_no(id);
		rr.setRepair_status("未分配");
		RepairRecordDao rrd = new RepairRecordDao();
		
		boolean result = rrd.updateRepairRecord(rr);
		
		PrintWriter out = resp.getWriter();
		
		out.println("<script>");
		out.println("alert('"+(result?"确认成功!":"确认失败!")+"');");
//		out.println("javascript :history.back(-1);");
		out.println("self.location='/DeviceFixingManaging/Service/addReport.jsp';");
//		out.println("setTimeout(function {document.forms[0].submit();},1000);"); 
		out.println("</script>");
		out.flush();
		out.close();
		
		super.doGet(request, resp);
	}


}
