package com.sh.hotel.dinnertable.servlet;



import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.sh.hotel.dinnertable.domain.Table;
import com.sh.hotel.dinnertable.service.impl.TableService;

public class TableServlet extends BaseServlet {
	
	private TableService tableService = new TableService();
	
	public String addTable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map map = request.getParameterMap();
		Table table = CommonUtils.toBean(map, Table.class);
		tableService.addTable(table);
		
		return findAllTable(request, response);
	}
	
	public String findAllTable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Table> tables = tableService.findAllTable();
		request.setAttribute("tables", tables);
		
		
		return "f:/sys/table/tableList.jsp";
	}
	
	public String deleteTable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tId = request.getParameter("tId");
		tableService.deleteTable(Integer.parseInt(tId));
		
		
		
		return findAllTable(request, response);
	}

}
