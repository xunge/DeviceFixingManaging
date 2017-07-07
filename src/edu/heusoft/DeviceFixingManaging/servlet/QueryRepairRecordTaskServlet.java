package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.RepairRecordDao;
import edu.heusoft.DeviceFixingManaging.javabean.RepairRecord;

// ���������Ա��ѯ ά�޼�¼�� ���ҵ�δ��������

public class QueryRepairRecordTaskServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ��ѯ���
//		String repair_record_no = request.getParameter("repair_record_no");
//		String repair_person_no=request.getParameter("repair_person_no");
//		String repair_time=request.getParameter("repair_time");
//		String test_record=request.getParameter("test_record");
//		String repair_record=request.getParameter("repair_record");
//		String repair_test_time=request.getParameter("repair_test_time");
//		String work_amount=request.getParameter("work_amount");
//		String person_price=request.getParameter("person_price");
//		String material_price=request.getParameter("material_price");
//		String repair_promise=request.getParameter("repair_promise");
//		String attention=request.getParameter("attention");
		String repair_status=request.getParameter("repair_status");
		String repair_delay=request.getParameter("repair_delay");
		String page=request.getParameter("page");
		
//		int a = -1, b = -1;
//		if(!repair_record_no.equals(""))
//		{
//			a=Integer.parseInt(repair_record_no);
//		}
//		if(!repair_person_no.equals(""))
//		{
//			b=Integer.parseInt(repair_person_no);
//		}
//		
//		double c = -1.0, d = -1.0;
//		if(!repair_record_no.equals(""))
//		{
//			c = Double.parseDouble(person_price);
//		}
//		if(!repair_person_no.equals(""))
//		{
//			d = Double.parseDouble(material_price);
//		}
		
		
//		SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
//
//		  
//		Date d1=null;
//		Date d2=null;
//		  
//		try {
//			d1 = f1.parse(repair_time);
//			d2 = f2.parse(repair_test_time);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
		
		RepairRecord rr = new RepairRecord();
		rr.init();
//		rr.setRepair_record_no(a);
//		rr.setRepair_person_no(b);
//		rr.setRepair_time(d1);
//		rr.setTest_record(test_record);
//		rr.setRepair_record(repair_record);
//		rr.setRepair_test_time(d2);
//		rr.setWork_amount(work_amount);
//		rr.setPerson_price(c);
//		rr.setMaterial_price(d);
//		rr.setRepair_promise(repair_promise);
//		rr.setAttention(attention);
		rr.setRepair_status("未分配");
		rr.setRepair_delay(repair_delay);

		
		//�����ҳ չʾ�������
		int totalRows=0;//�ܵ������
		int pageSize=5;//ÿҳ�������
		int pages=0;//��ҳ�� 
		int currentPage=1;//��ǰҳ  Ĭ�ϵĵ�һҳ
		int startPosition=0;//ÿҳ����ʼλ��
		
		
		//����DAO���� ���÷�����ɲ�ѯ�߼�
		RepairRecordDao dao=new RepairRecordDao();
		totalRows = dao.queryRepairRecordTotalRows(rr);
		
		pages=(int)  Math.ceil( totalRows/(double)pageSize );
		
		if(page!=null)
		{
			currentPage=Integer.parseInt(page);
		}

		startPosition=(currentPage-1)*pageSize;
		
		//��ѯ
		ArrayList<RepairRecord> result=dao.queryRepairRecord(rr,startPosition,pageSize);
		
		
		//����ѯ����ݷŵ�request�й���
		request.setAttribute("data",result);
		
		//����ҳ��Ϣ�ŵ�request����
		request.setAttribute("pages",pages);
		request.setAttribute("currentPage",currentPage);
		
		
		
		//������ת����QueryResult.jspչʾ��ѯ�����Ϊչʾ�Ƕ�̬��
		//����ת����
		RequestDispatcher dis=request.getRequestDispatcher("/Task/QueryRepairRecord.jsp");
		//ת��
		dis.forward(request, response);
		
	}

}
