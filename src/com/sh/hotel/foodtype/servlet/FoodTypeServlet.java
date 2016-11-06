package com.sh.hotel.foodtype.servlet;



import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.hotel.foodtype.domain.FoodType;
import com.sh.hotel.foodtype.service.impl.FoodTypeService;

import cn.itcast.servlet.BaseServlet;

/**
 * 菜系控制层，优雅实现
 *  control层
 * 接收表单数据，并封装到JavaBean里面
 * 调用service层处理业务逻辑
 * 返回到jsp显示
 * 包括增加菜系
 * 更改菜系
 * 删除菜系
 * 查找所有菜系
 * @author Administrator
 *
 */
public class FoodTypeServlet extends BaseServlet {

	public static Logger log = Logger.getLogger(FoodTypeServlet2.class.toString());
	
	private FoodTypeService foodtypeService = new FoodTypeService();
	
	/**
	 * 添加菜系
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addFoodType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String foodtypeName = request.getParameter("foodtypeName");
		FoodType foodType = new FoodType();
		foodType.setFtName(foodtypeName);
		foodtypeService.add(foodType);
		return findAll(request, response);
		
	}
	/**
	 * 更新菜系
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String updateFoodType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String foodtypeId = request.getParameter("foodtypeId");
		String foodtypeName = request.getParameter("foodtypeName");
		FoodType foodType = foodtypeService.findByFoodTypeId(Integer.parseInt(foodtypeId));
		foodType.setFtName(foodtypeName);
		foodtypeService.update(foodType);
		return findAll(request, response);		
	}
	
	/**
	 * 跟新菜系——根据id查找所有菜系
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByFoodTypeId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String foodtypeId = request.getParameter("foodtypeId");
		log.info(foodtypeId + "------");
		
		FoodType foodType = foodtypeService.findByFoodTypeId(Integer.parseInt(foodtypeId));
		request.setAttribute("foodtype", foodType);
		
		return "f:/sys/foodtype/foodtypeUpdate.jsp";

		
	}
	/**
	 * 删除菜系
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteFoodType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String foodtypeId = request.getParameter("foodtypeId");
		foodtypeService.delete(Integer.parseInt(foodtypeId));
		return findAll(request, response);		
	}
	/**
	 * 查找所有的菜系
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FoodType> foodtypeList = foodtypeService.findAll();
		request.setAttribute("foodtypeList", foodtypeList);
		return "f:/sys/foodtype/foodtypeList.jsp";
		
	}
}
