package com.sh.hotel.dinnertable.servlet;



import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.sh.hotel.dinnertable.domain.Table;
import com.sh.hotel.dinnertable.service.impl.TableService;
import com.sh.hotel.utils.TableStatus;

/**
 * 餐桌的控制类，
 * 包括增加餐桌
 * 查找所有餐桌
 * 改变餐桌状态
 * 删除餐桌
 * @author Administrator
 *
 */
public class TableServlet extends BaseServlet {
	
	private TableService tableService = new TableService();
	private static Logger log = Logger.getLogger(TableServlet.class.toString());
	/**
	 * 添加餐桌
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addTable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map map = request.getParameterMap();
		Table table = CommonUtils.toBean(map, Table.class);
		tableService.addTable(table);
		
		return findAllTable(request, response);
	}
	/**
	 * 查找餐桌
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllTable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Table> tables = tableService.findAllTable();
		request.setAttribute("tables", tables);
		
		
		return "f:/sys/table/tableList.jsp";
	}
	
	/**
	 * 删除餐桌
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteTable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tId = request.getParameter("tId");
		tableService.deleteTable(Integer.parseInt(tId));
		
		
		
		return findAllTable(request, response);
	}
	/**
	 * 前台
	 * 根据餐桌状态查找，
	 * 并返回到主页index.jsp
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findTableNoUse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Table> tables = tableService.findAllTableNoUse();
		request.setAttribute("tables", tables);
		/*for (Table table : tables) {
			log.info(table.getTableName() + "========");
		}*/
		
		
		return "f:/app/index.jsp";
	}
	

}
