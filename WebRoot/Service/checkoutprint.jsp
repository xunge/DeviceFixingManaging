<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="edu.heusoft.DeviceFixingManaging.javabean.*"  %>
<%@ page import="edu.heusoft.DeviceFixingManaging.common.*"  %>
<%@ page import="java.text.*"  %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>打印报表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String today=sdf.format(new Date());
	ReportRecord reportR=(ReportRecord)request.getAttribute("reportrecord");
	//String reportDay=sdf.format(reportR.getReport_time());
	String reportDay=DateUtil.ServlettoHTML(reportR.getReport_time());
	
	
	
	%>
	<div id="printpages">
    <table border="1" style="border-collapse:collapse">
      <tr>
    <td width="657" colspan="7" valign="top"><p align="center"><strong>***</strong><strong>沈阳市计算机服务有限公司结算清单</strong><strong>***</strong></p></td>
  </tr>
  <tr>
    <td width="165" valign="top"><p>维修单号： </p></td>
    <td width="164" valign="top"><p>No:${repairrecord.repair_record_no}</p></td>
    <td width="164" colspan="2" valign="top"><p>&nbsp;</p></td>
    <td width="164" colspan="3" valign="top"><p>&nbsp;</p></td>
  </tr>
  <tr>
    <td width="165" valign="top"><p>接修日期 </p></td>
    <td width="164" valign="top"><p><%=reportDay %></p></td>
    <td width="164" colspan="2" valign="top"><p>修复日期： </p></td>
    <td width="164" colspan="3" valign="top"><p><%=today %> </p></td>
  </tr>
  <tr>
    <td width="165" valign="top"><p>产品类型 </p></td>
    <td width="164" valign="top"><p>${equipment.product_type}</p></td>
    <td width="164" colspan="2" valign="top"><p>机器品牌 </p></td>
    <td width="164" colspan="3" valign="top"><p>${equipment.report_equip_brand}</p></td>
  </tr>
  <tr>
    <td width="165" valign="top"><p>机器型号 </p></td>
    <td width="164" valign="top"><p>${equipment.report_equip_model}</p></td>
    <td width="164" colspan="2" valign="top"><p>系列号 </p></td>
    <td width="164" colspan="3" valign="top"><p>${equipment.report_equip_series}</p></td>
  </tr>
  <tr>
    <td width="165" valign="top"><p>单位名称 </p></td>
    <td width="164" valign="top"><p>${customer.customer_companyname}</p></td>
    <td width="164" colspan="2" valign="top"><p>联系人 </p></td>
    <td width="164" colspan="3" valign="top"><p>${customer.customer_linkman}</p></td>
  </tr>
  <tr>
    <td width="165" valign="top"><p>合计金额： </p></td>
    <td width="164" valign="top"><p>${grandtotal}</p></td>
    <td width="75" valign="top"><p>修理费 </p></td>
    <td width="89" valign="top"><p>${personcost}</p></td>
    <td width="91" colspan="2" valign="top"><p>材料费 </p></td>
    <td width="73" valign="top"><p>${matercost}</p></td>
  </tr>
  <tr>
    <td width="657" colspan="7" valign="top"><p align="center">机器故障现象 </p></td>
  </tr>
  <tr>
    <td width="657" colspan="7" valign="top"><p align="center">${repairrecord.test_record}</p></td>
  </tr>
  <tr>
    <td width="329" colspan="2" valign="top"><p align="center">保修承诺 </p></td>
    <td width="328" colspan="5" valign="top"><p align="center">注意事项 </p></td>
  </tr>
  <tr>
    <td width="329" colspan="2" valign="top"><p>${repairrecord.repair_promise}</p></td>
    <td width="328" colspan="5" valign="top"><p align="center">${repairrecord.attention}</p></td>
  </tr>
  <tr>
    <td width="165" valign="top"><p>部件名称 </p></td>
    <td width="164" valign="top"><p>规格 </p></td>
    <td width="165" colspan="3" valign="top"><p>数量 </p></td>
    <td width="164" colspan="2" valign="top"><p><a name="OLE_LINK7" id="OLE_LINK7"></a><a name="OLE_LINK6" id="OLE_LINK6">单价</a></p></td>
  </tr>
  <% 
   ArrayList<PartDetail> pdSet=(ArrayList<PartDetail>)request.getAttribute("partdetailset");
   ArrayList<edu.heusoft.DeviceFixingManaging.javabean.Part> pSet=(ArrayList<edu.heusoft.DeviceFixingManaging.javabean.Part>)request.getAttribute("partset");
   
   for(int i=0;i<pdSet.size();i++){
  
  %>
  <tr>
    <td width="165" valign="top"><p><%=pSet.get(i).getPart_name() %></p></td>
    <td width="164" valign="top"><p><%=pSet.get(i).getPart_size() %></p></td>
    <td width="165" colspan="3" valign="top"><p><%=pdSet.get(i).getPart_detail_num() %></p></td>
    <td width="164" colspan="2" valign="top"><p><%=pSet.get(i).getPart_price() %></p></td>
  </tr>
    <%} %>
    </table>
    </div>
    
    <button onclick="javascript:printdiv('printpages')">打印</button>
    
  </body>
  <script>
  function printdiv(printpage)
  {
  var headstr = "<html><head><title></title></head><body>";
  var footstr = "</body>";
  var newstr = document.all.item(printpage).innerHTML;
  var oldstr = document.body.innerHTML;
  document.body.innerHTML = headstr+newstr+footstr;
  window.print(); 
  document.body.innerHTML = oldstr;
  return false;
  }
  </script>
</html>
