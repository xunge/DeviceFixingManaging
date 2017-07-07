package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.PartDao;
import edu.heusoft.DeviceFixingManaging.dao.PartDetailDao;
import edu.heusoft.DeviceFixingManaging.dao.RepairRecordDao;
import edu.heusoft.DeviceFixingManaging.javabean.Part;
import edu.heusoft.DeviceFixingManaging.javabean.PartDetail;

public class EditPriceDetailServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -617720366661741176L;
	
	private static final String defaultPart_detail_status = "已出库";
	
	private static final int maxQuery = 1000;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String recordId=request.getParameter("no");
		
		RepairRecordDao rrdao=new RepairRecordDao();
		PartDetailDao pddao=new PartDetailDao();
		PartDao pdao=new PartDao();
		ArrayList<Part> partSet=new ArrayList<Part>();
		ArrayList<PartDetail> partDetailSet=new ArrayList<PartDetail>();
		
		double partTotal=0; //统计备件总价
		
		PartDetail ptd=new PartDetail();
		ptd.init();
		int recordNo=-1;
		if(!recordId.equals("")&&recordId!=null){
			recordNo=Integer.parseInt(recordId);
		}
		ptd.setRepair_record_no(recordNo);
		ptd.setPart_detail_status(defaultPart_detail_status);
		
		partDetailSet=pddao.queryPartDetail(ptd, 0, maxQuery);
		
		for(PartDetail ptdUnit:partDetailSet){
			Part pt=new Part();
			pt.init();
			pt.setPart_no(ptdUnit.getPart_no());
			partSet=pdao.queryPart(pt, 0, 1);
			int amount=ptdUnit.getPart_detail_num();
			double singlePrice=partSet.get(0).getPart_price();
			partTotal+=singlePrice*amount;
			
		}
		
		request.setAttribute("parttotal", new Double(partTotal));
		
		request.getRequestDispatcher("/Service/checkoutdetailedit.jsp").forward(request, response);
		
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
	}

}
