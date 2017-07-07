package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.common.DateUtil;
import edu.heusoft.DeviceFixingManaging.dao.PriceDao;
import edu.heusoft.DeviceFixingManaging.dao.RepairRecordDao;
import edu.heusoft.DeviceFixingManaging.javabean.Price;
import edu.heusoft.DeviceFixingManaging.javabean.RepairRecord;

/**在price表中添加数据。
 * 
 * @author LZMA
 *
 */
public class AddPriceServlet extends HttpServlet {
	
	private static final String defaultRepair_status = "撤销";

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean result=true;

		String no=request.getParameter("no");
		String rc=request.getParameter("repaircharge");
		String mc=request.getParameter("matercharge");

		double grandTotal=0;
		int repairNo=-1;
		
		RepairRecordDao rrdao=new RepairRecordDao();
		PriceDao pdao=new PriceDao();
		Price p=new Price();
		
		if(no!=null&&!no.equals("")){
			repairNo=Integer.parseInt(no);
		} else {
			System.out.println("AddPriceServlet: Parameter  \"no\" not found!");
		}
		
		if(rc!=null&&!rc.equals("")){
			grandTotal+=Double.parseDouble(rc);
		} else {
			System.out.println("AddPriceServlet: Parameter \"repaircharge\" not found!");
		}
		
		if(mc!=null&&!mc.equals("")){
			grandTotal+=Double.parseDouble(mc);
		} else {
			System.out.println("AddPriceServlet: Parameter \"matercharge\" not found!");
		}
		
		p.setPrice(grandTotal);
		p.setPrice_time(new Date());
		if(!pdao.addPrice(p)) result=false;
		
		
		RepairRecord rr=new RepairRecord();
		rr.init();
		rr.setRepair_record_no(repairNo);
		rr.setRepair_status(defaultRepair_status);
		
		if(!rrdao.updateRepairRecord(rr)) result=false;
		
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

}
