// xunge
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.StaffDao;
import edu.heusoft.DeviceFixingManaging.javabean.Staff;

public class QueryStaffTaskServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String defaultStaffCharacter = "技术工程师";


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ��ѯ���
//		String staff_no = request.getParameter("staff_no");
//		String staff_name=request.getParameter("staff_name");
//		String staff_password=request.getParameter("staff_password");
//		String staff_character=request.getParameter("staff_character");
		String page=request.getParameter("page");
		
		int a = -1;
//		if(!staff_no.equals(""))
//		{
//			a=Integer.parseInt(staff_no);
//		}
		
		Staff qs = new Staff();
		
		qs.init();
//     	qs.setStaffNo(a);
//		qs.setStaffName(staff_name);
//		qs.setStaffPassword(staff_password);
		qs.setStaffCharacter("技术工程师");
//		qs.setStaffCharacter(staff_character);

		
		
		//�����ҳ չʾ�������
		int totalRows=0;//�ܵ������
		int pageSize=5;//ÿҳ�������
		int pages=0;//��ҳ�� 
		int currentPage=1;//��ǰҳ  Ĭ�ϵĵ�һҳ
		int startPosition=0;//ÿҳ����ʼλ��
		
		//����DAO���� ���÷�����ɲ�ѯ�߼�
		StaffDao dao=new StaffDao();
		totalRows = dao.queryStaffTotlRows(qs);

		
		pages=(int)  Math.ceil( totalRows/(double)pageSize );
		
		if(page!=null)
		{
			currentPage=Integer.parseInt(page);
		}

		startPosition=(currentPage-1)*pageSize;
		
		//��ѯ
		ArrayList<Staff> result=dao.queryStaff(qs,startPosition,pageSize);
		
		//����ѯ����ݷŵ�request�й���
		request.setAttribute("data",result);
		
		//����ҳ��Ϣ�ŵ�request����
		request.setAttribute("pages",pages);
		request.setAttribute("currentPage",currentPage);
		
		
		
		//������ת����QueryResult.jspչʾ��ѯ�����Ϊչʾ�Ƕ�̬��
		//����ת����
		RequestDispatcher dis=request.getRequestDispatcher("/Task/QueryStaff.jsp");
		//ת��
		dis.forward(request, response);
		
	}
}
