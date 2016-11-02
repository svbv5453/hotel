package com.sh.hotel.foodtype.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.sh.hotel.foodtype.domain.FoodType;
import com.sh.hotel.foodtype.service.impl.FoodTypeService;

/**
 * control层
 * 接收表单数据，并封装到JavaBean里面
 * 调用service层处理业务逻辑
 * 返回到jsp显示
 * @author Administrator
 *
 */
public class FoodTypeServlet extends HttpServlet {
	public static Logger log = Logger.getLogger(FoodTypeServlet.class.toString());
	
	private FoodTypeService foodtypeService = new FoodTypeService();
	

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if("addFoodType".equals(method)){
			addFoodType(request, response);
			
		} else if("updateFoodType".equals(method)){
			updateFoodType(request, response);
		} else if("deleteFoodType".equals(method)){
			deleteFoodType(request, response);
		} else if("findAll".equals(method)){
			findAll(request, response);
		} else if("findByFoodTypeId".equals(method)){
			findByFoodTypeId(request, response);
		}
		
		
	}
	

	/**
	 * 根据id查找菜系
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findByFoodTypeId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			String foodtypeId = request.getParameter("foodtypeId");
			log.info(foodtypeId + "------");
			
			FoodType foodType = foodtypeService.findByFoodTypeId(Integer.parseInt(foodtypeId));
			request.setAttribute("foodtype", foodType);
			
			String path = "/sys/foodtype/foodtypeUpdate.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
	}



	/**
	 * 添加菜系
	 * @param request
	 * @param response
	 */
	private void addFoodType(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String foodtypeName = request.getParameter("foodtypeName");
		FoodType foodType = new FoodType();
		foodType.setFtName(foodtypeName);
		foodtypeService.add(foodType);
		findAll(request, response);
		
		
		
		
	}
	/**
	 * 查找所有菜系
	 * @param request
	 * @param response
	 */
	private void findAll(HttpServletRequest request,
			HttpServletResponse response)  {
		// TODO Auto-generated method stub
		List<FoodType> foodtypeList = foodtypeService.findAll();
		request.setAttribute("foodtypeList", foodtypeList);
		String path = "/sys/foodtype/foodtypeList.jsp";
		try {
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	



	/**
	 * 更新菜系
	 * @param request
	 * @param response
	 */
	private void updateFoodType(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String foodtypeId = request.getParameter("foodtypeId");
		String foodtypeName = request.getParameter("foodtypeName");
		FoodType foodType = foodtypeService.findByFoodTypeId(Integer.parseInt(foodtypeId));
		foodType.setFtName(foodtypeName);
		foodtypeService.update(foodType);
		findAll(request, response);
		
		 
		
		
	}



	/**
	 * 删除菜系
	 * @param request
	 * @param response
	 */
	private void deleteFoodType(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String foodtypeId = request.getParameter("foodtypeId");
		foodtypeService.delete(Integer.parseInt(foodtypeId));
		findAll(request, response);
		
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

		
	}

}
