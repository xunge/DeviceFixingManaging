//MJRT
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.PriceDao;
import edu.heusoft.DeviceFixingManaging.javabean.Price;

public class BossQueryPriceServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
//		String price_no  = request.getParameter("price_no");
//		String price_time = request.getParameter("price_time");
//		String price	   = request.getParameter("price");
		String page = request.getParameter("page");
		
		Price cus = new Price();
		cus.init();
		
//		cus.getPrice_no();
//		cus.setCustomer_linkman(price_time);
//		cus.setCustomer_mobilephone(price);
//		

		PriceDao dao = new PriceDao();
		
		//分页
		int totalRows = 0; // 总数据量
		int pageSize = 5; 
		int pages = 0;		//总页数
		int currentPage = 1;
		int startPosition = 0; // 起始位置
		
		
		totalRows = dao.queryPriceTotalRows(cus);
		pages = (int) Math.ceil((double)totalRows/pageSize);
		if(page != null)
		{
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		
		
		ArrayList<Price> result = dao.queryPrice(cus, startPosition, pageSize);
		
		request.setAttribute("data", result);
		request.setAttribute("pages",pages);
		request.setAttribute("currentPage",currentPage);
		
		
		request.getRequestDispatcher("/Boss/QueryPrice.jsp").forward(request, response);
	}

}
