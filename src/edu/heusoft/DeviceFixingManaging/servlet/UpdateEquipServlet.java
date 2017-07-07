//SLIAN
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.ReportEquipmentDao;
import edu.heusoft.DeviceFixingManaging.javabean.ReportEquipment;

public class UpdateEquipServlet extends HttpServlet {

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
		
		String report_equip_no = request.getParameter("no");
		System.out.println(report_equip_no);
		ReportEquipmentDao dao = new ReportEquipmentDao();
		ReportEquipment reQuery = new ReportEquipment();
		ArrayList<ReportEquipment> reResult = new ArrayList<ReportEquipment>();
		
		reQuery.init();
		if(!report_equip_no.equals("")){
			reQuery.setReport_equip_no(Integer.parseInt(report_equip_no));
		}
		System.out.println(reQuery);
		reResult = dao.queryEquipment(reQuery, 0, 1);
		System.out.println(reResult.get(0).toString());
		request.setAttribute("data", reResult.get(0));
		
		
		request.getRequestDispatcher("/Service/UpdateEquip.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String report_equip_no = request.getParameter("report_equip_no");
		String report_equip_brand = request.getParameter("report_equip_brand");
		String product_type = request.getParameter("product_type");
		String report_equip_model = request.getParameter("report_equip_model");
		String report_equip_series = request.getParameter("report_equip_series");
		String report_equip_problem_type = request.getParameter("report_equip_problem_type");
		
		ReportEquipmentDao dao = new ReportEquipmentDao();
		ReportEquipment reUpdate = new ReportEquipment();
		
		reUpdate.init();
		reUpdate.setReport_equip_no(Integer.parseInt(report_equip_no));
		reUpdate.setReport_equip_brand(report_equip_brand);
		reUpdate.setProduct_type(product_type);
		reUpdate.setReport_equip_model(report_equip_model);
		reUpdate.setReport_equip_series(report_equip_series);
		reUpdate.setReport_equip_problem_type(report_equip_problem_type);
		
		boolean result = dao.updateReportEquipment(reUpdate);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+(result?"编辑成功!":"编辑失败!")+"');");
		out.println("self.location='/DeviceFixingManaging/Service/queryreportrecord.jsp';");
		out.println("</script>");
		
		out.flush();
		out.close();
		
	}

}
