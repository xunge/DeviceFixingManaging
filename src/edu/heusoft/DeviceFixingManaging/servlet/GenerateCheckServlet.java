package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.CustomerDao;
import edu.heusoft.DeviceFixingManaging.dao.PartDao;
import edu.heusoft.DeviceFixingManaging.dao.PartDetailDao;
import edu.heusoft.DeviceFixingManaging.dao.RepairRecordDao;
import edu.heusoft.DeviceFixingManaging.dao.ReportEquipmentDao;
import edu.heusoft.DeviceFixingManaging.dao.ReportRecordDao;
import edu.heusoft.DeviceFixingManaging.dao.StaffDao;
import edu.heusoft.DeviceFixingManaging.javabean.Customer;
import edu.heusoft.DeviceFixingManaging.javabean.Part;
import edu.heusoft.DeviceFixingManaging.javabean.PartDetail;
import edu.heusoft.DeviceFixingManaging.javabean.RepairRecord;
import edu.heusoft.DeviceFixingManaging.javabean.ReportEquipment;
import edu.heusoft.DeviceFixingManaging.javabean.ReportRecord;

public class GenerateCheckServlet extends HttpServlet {
	
	private static final int maxQuery = 1000;

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String recordId=request.getParameter("no");
		String personCost=request.getParameter("personcost");
		String materCost=request.getParameter("matercost");
		
		RepairRecord rr=new RepairRecord();
		
		RepairRecord rResult=new RepairRecord();
		ReportRecord rpt=new ReportRecord();
		ReportEquipment eqp=new ReportEquipment();
		Customer customer=new Customer();
		PartDetail pdquery=new PartDetail();
		Part pquery=new Part();
		ArrayList<PartDetail> pdSet=new ArrayList<PartDetail>();
		ArrayList<Part> pSet=new ArrayList<Part>();
		
		RepairRecordDao rrdao=new RepairRecordDao();
		//StaffDao sdao=new StaffDao();
		ReportRecordDao rptdao=new ReportRecordDao();
		ReportEquipmentDao eqpdao=new ReportEquipmentDao();
		CustomerDao cdao=new CustomerDao();
		PartDetailDao pddao=new PartDetailDao();
		PartDao pdao=new PartDao();
		
		rr.init();
		
		if(recordId!=null&&!recordId.equals("")){
			try {
				rr.setRepair_record_no(Integer.parseInt(recordId));
			} catch (NumberFormatException e) {
				e.printStackTrace();
				rr.setRepair_record_no(-1);
			}
		}
		
		rResult=rrdao.queryRepairRecord(rr, 0, 1).get(0);
		rpt.init();
		rpt.setReport_record_no(rResult.getReport_record_no());
		rpt=rptdao.queryReportRecord(rpt, 0, 1).get(0);
		eqp.init();
		eqp.setReport_equip_no(rpt.getReport_equip_no());
		eqp=eqpdao.queryEquipment(eqp, 0, 1).get(0);
		customer.init();
		customer.setCustomer_idno(rpt.getCustomer_idno());
		customer=cdao.queryCustomer(customer, 0, 1).get(0);
		
		pdquery.init();
		pdquery.setRepair_record_no(rResult.getRepair_record_no());
		pdquery.setPart_detail_status("已出库");
		pdSet=pddao.queryPartDetail(pdquery, 0, maxQuery);
		
		for(PartDetail pdunit:pdSet){
			System.out.println(pdunit);
			pquery.init();
			pquery.setPart_no(pdunit.getPart_no());
			pSet.add(pdao.queryPart(pquery, 0, 1).get(0));
		}
		
		double gt=Double.parseDouble(materCost)+Double.parseDouble(personCost);
		String grandTotal=""+gt;
		
		
		
		request.setAttribute("repairrecord", rResult);
		request.setAttribute("reportrecord", rpt);
		request.setAttribute("equipment", eqp);
		request.setAttribute("customer", customer);
		request.setAttribute("partdetailset", pdSet);
		request.setAttribute("partset", pSet);
		
		
		request.setAttribute("personcost", personCost);
		request.setAttribute("matercost", materCost);
		request.setAttribute("grandtotal", grandTotal);
		
		request.getRequestDispatcher("/Service/checkoutprint.jsp").forward(request, response);
		
	}

}
