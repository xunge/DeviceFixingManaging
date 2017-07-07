//SLIAN
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.RepairRecordDao;
import edu.heusoft.DeviceFixingManaging.dao.ReportEquipmentDao;
import edu.heusoft.DeviceFixingManaging.dao.ReportRecordDao;
import edu.heusoft.DeviceFixingManaging.dao.StaffDao;
import edu.heusoft.DeviceFixingManaging.javabean.RepairRecord;
import edu.heusoft.DeviceFixingManaging.javabean.ReportEquipment;
import edu.heusoft.DeviceFixingManaging.javabean.ReportRecord;
import edu.heusoft.DeviceFixingManaging.javabean.Staff;

/**查询已经维修完成的维修记录。
 * 
 * @author LZMA
 *
 */
public class QueryCompletedTasksServlet extends HttpServlet {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -308283494490779034L;
	private static final String defaultRepair_status = "已维修";

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String recordId=request.getParameter("repair_record_no_input");
		//String repairType=request.getParameter("repair_type_input");
		String date=request.getParameter("repair_date_input");
		String page=request.getParameter("page");
		
		
		RepairRecord rr=new RepairRecord();
		RepairRecordDao dao=new RepairRecordDao();
		StaffDao sdao=new StaffDao();
		ReportRecordDao rptdao=new ReportRecordDao();
		ReportEquipmentDao rptEqpdao=new ReportEquipmentDao();
		
		//初始查询条件ֵ
		rr.init();
		rr.setRepair_status(defaultRepair_status);

		//设置查询条件
		if(recordId!=null&&!recordId.equals("")){
			try {
				rr.setRepair_record_no(Integer.parseInt(recordId));
			} catch (NumberFormatException e) {
				e.printStackTrace();
				rr.setRepair_record_no(-1);
			}
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		if(!date.equals("")){
			try {
				rr.setRepair_time(sdf.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
				rr.setRepair_time(null);
			}
		}
		
		//分页代码
		int totalRows=0;
		int pageSize=5;
		int pages=0;
		int currentPage=1;
		int startPosition=0;
		
		totalRows=dao.queryRepairRecordTotalRows(rr);
		pages=(int)Math.ceil(totalRows/(double)pageSize);
		if(null!=page&&page!=""){
			currentPage=Integer.parseInt(page);
		}
		startPosition=(currentPage-1)*pageSize;
		//分页功能结束
		
		ArrayList<RepairRecord> tasks=dao.queryRepairRecord(rr, startPosition, pageSize);
		ArrayList<Staff> stf=new ArrayList<Staff>();//结果
		ArrayList<Staff> stb=new ArrayList<Staff>();//中间值
		ArrayList<ReportEquipment> equipments=new ArrayList<ReportEquipment>();
		ArrayList<ReportRecord> rptRecord=new ArrayList<ReportRecord>();
		ArrayList<ReportRecord> rptUnit=new ArrayList<ReportRecord>();
		
		ReportRecord rrp=new ReportRecord();
		for(RepairRecord tp:tasks){
			System.out.println(tp.getRepair_person_no());
			stb=sdao.queryStaff(new Staff(tp.getRepair_person_no(),"","",""), 0, 1);
			stf.add(stb.get(0));
			
			rrp.init();
			rrp.setReport_record_no(tp.getReport_record_no());
			rptUnit=rptdao.queryReportRecord(rrp, 0, 1);
			rptRecord.add(rptUnit.get(0));
			
		}
		
		for(ReportRecord rp:rptRecord){
			ReportEquipment re=new ReportEquipment();
			re.init();
			re.setReport_equip_no(rp.getReport_equip_no());
			
			equipments.add(rptEqpdao.queryEquipment(re, 0, 1000).get(0));
		}
		
		
		request.setAttribute("tasks_data", tasks);
		request.setAttribute("staff_data", stf);
		request.setAttribute("equip_data", equipments);
		
		request.setAttribute("totalpages", pages);
		request.setAttribute("currentpage", currentPage);
		
		request.getRequestDispatcher("/Service/z-querycheckout.jsp").forward(request, response);
		
	}

}
