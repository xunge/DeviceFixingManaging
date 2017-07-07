// xunge
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.PartDetailDao;
import edu.heusoft.DeviceFixingManaging.javabean.PartDetail;

public class ChuKuQueryPartDetailServlet extends HttpServlet {

	/**
	 * Chuku, first query the 'part detail'
	 * 		then, update the 'part'
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		               
		//此处应该过滤没有输入框的值
//			String part_detail_no = request.getParameter("part_detail_no");
//			String part_no=request.getParameter("part_no");
//			String repair_record_no=request.getParameter("repair_record_no");
//			String part_detail_num=request.getParameter("part_detail_num");
			String part_detail_status=request.getParameter("part_detail_status");
			String page=request.getParameter("page");
			
//			int a = -1,b = -1,c = -1, d = -1; 
//			if(!part_detail_no.equals(""))
//			{
//				a=Integer.parseInt(part_detail_no);
//			}
//			if(!part_no.equals(""))
//			{
//				b=Integer.parseInt(part_no);
//			}
//			if(!repair_record_no.equals(""))
//			{
//				c=Integer.parseInt(repair_record_no);
//			}
//			if(!part_detail_num.equals(""))
//			{
//				d=Integer.parseInt(part_detail_num);
//			}
			
			PartDetail pd = new PartDetail();
			
	    	pd.setPart_detail_no(-1);
	     	pd.setPart_no(-1);
	     	pd.setRepair_record_no(-1);
	     	pd.setPart_detail_num(-1);
	     	pd.setPart_detail_status(part_detail_status);
			
			
			//�����ҳ չʾ�������
			int totalRows=0;//�ܵ������
			int pageSize=5;//ÿҳ�������
			int pages=0;//��ҳ�� 
			int currentPage=1;//��ǰҳ  Ĭ�ϵĵ�һҳ
			int startPosition=0;//ÿҳ����ʼλ��
			
			
			//����DAO���� ���÷�����ɲ�ѯ�߼�
			PartDetailDao dao=new PartDetailDao();
			
			totalRows = dao.queryPartDetailTotalRows(pd);
			pages=(int)  Math.ceil( totalRows/(double)pageSize );
			
			if(page!=null)
			{
				currentPage=Integer.parseInt(page);
			}
	
			startPosition=(currentPage-1)*pageSize;
			
			//��ѯ
			ArrayList<PartDetail> result=dao.queryPartDetail(pd,startPosition,pageSize);
			
			request.setAttribute("data",result);
			
//			int part_no = pd.getPart_no();
//			
//			int part_dec_num = pd.getPart_detail_num();
			
			//System.out.println(part_no+" "+part_dec_num);
			
			//boolean result1 = dao1.updatePart(part_no, (-1)*part_dec_num);
			
			RequestDispatcher dis=request.getRequestDispatcher("/userinfo3/queryResult.jsp");
			//ת��
			dis.forward(request, response);
			

			

	}

}
