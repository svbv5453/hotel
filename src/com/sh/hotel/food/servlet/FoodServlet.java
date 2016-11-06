package com.sh.hotel.food.servlet;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sh.hotel.food.domain.Food;
import com.sh.hotel.food.service.impl.FoodService;
import com.sh.hotel.foodtype.domain.FoodType;
import com.sh.hotel.foodtype.service.impl.FoodTypeService;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 * 菜品Food控制层
 * 包括方法
 * 添加菜品
 * 更新菜品
 * 删除菜品
 * 
 * @author Administrator
 *
 */
public class FoodServlet extends BaseServlet {
	
	private static Logger log = Logger.getLogger(FoodServlet1.class.toString());
	private FoodService foodService = new FoodService();
	private FoodTypeService foodTypeService = new FoodTypeService();
	/**
	 * 需要上传文件，和普通表单不一样
	 * 上传三步走
	 * @param request
	 * @param response
	 */
	public String addFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		if(sfu.isMultipartContent(request)){
			try {
				List<FileItem> list = sfu.parseRequest(request);
				Map<String, Object> map = new HashMap<String, Object>();
				for (FileItem fileItem : list) {
					if(fileItem.isFormField()){
						//如果是普通文本类型
						String name = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");//处理文件中文编码问题
						map.put(name, value);
						
					} else {
						//如果是文件类型
						String fileName = fileItem.getName();//得到文件名称
						String name = fileItem.getFieldName();
						log.info("name:" + name);
						String path = this.getServletContext().getRealPath("/upload");
						//String path = this.getServletContext().getRealPath("/sys/style/images");
						File file = new File(path, fileName);
						log.info(file.getPath());
						fileItem.write(file);
						fileItem.delete();
						map.put(name, fileName);
						
						
					}
				}
				Food food = CommonUtils.toBean(map, Food.class);
				foodService.addFood(food);
				log.info("添加菜品: " + food.toString());
				
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("不是上传文件类型");
		}
		return findAllFood(request, response);
	}
	/**
	 * 查找所有的菜品
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Map<String, Object>> maps = foodService.findAll();
		List<Food> foodsList = new ArrayList<Food>();
		for (Map<String, Object> map : maps) {
			Food food = CommonUtils.toBean(map, Food.class);
			FoodType foodType = CommonUtils.toBean(map, FoodType.class);
			food.setFoodType(foodType);
			foodsList.add(food);
		}
		
		
		request.setAttribute("foodsList", foodsList);
		return "f:/sys/food/foodList.jsp";
		 
	}
	/**
	 * 添加菜品前之查找所有的菜系
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addFood_findAllFoodType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FoodType> foodTypeList = foodTypeService.findAll();
		request.setAttribute("foodtypeList", foodTypeList);
		
		return "f:/sys/food/saveFood.jsp";
	}
	/**
	 * 更新菜品
	 * 依然使用上传文件
	 * 使用第三方库common-fileupload
	 * 上传三步走
	 * 1、解析工厂
	 * 2.解析器
	 * 3、解析request
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String updateFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		if(sfu.isMultipartContent(request)){
			try {
				List<FileItem> fileItems = sfu.parseRequest(request);
				Map<String, Object> map = new HashMap<String, Object>();
				for (FileItem fileItem : fileItems) {
					if(fileItem.isFormField()) {
						//普通表单文件
						String name = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");
						map.put(name, value);
					} else {
						//文件表单
						String fileName = fileItem.getName();
						String name = fileItem.getFieldName();
						String path = this.getServletContext().getRealPath("/upload");
						//String path = this.getServletContext().getRealPath("/sys/style/images");

						File file = new File(path, fileName);
						log.info("更新菜品图片路径" + file.getPath());
						fileItem.write(file);
						fileItem.delete();
						map.put(name, fileName);
						//log.info("name" + name);
					}
				}
				Food food = CommonUtils.toBean(map, Food.class);
				log.info(food.toString());
				foodService.updateFood(food);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("不是表单文件");
		}
		
		return findAllFood(request, response);
	}
	/**
	 * 更新菜品之前查找根据id查找菜品
	 * 根据id查找对于的菜品及所在的菜系
	 * 以及查找所以的菜系
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String updateFood_findFoodById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 查找菜品和菜系
		 */
		String fId = request.getParameter("fId");
		//log.info(fId + "----");
		Map<String, Object> map = foodService.findFoodById(Integer.parseInt(fId));
		Food food = CommonUtils.toBean(map, Food.class);
		FoodType foodType = CommonUtils.toBean(map, FoodType.class);
		food.setFoodType(foodType);
		request.setAttribute("food", food);
		/**
		 * 查找所以菜系
		 */
		List<FoodType> foodTypeList = foodTypeService.findAll();
		request.setAttribute("foodtypeList", foodTypeList);
		
		
		return "f:/sys/food/updateFood.jsp";
	}
	/**
	 * 删除菜品
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fId = request.getParameter("fId");
		
		foodService.deleteFood(Integer.parseInt(fId));
		
		
		return findAllFood(request, response);
	}
	/**
	 * 前台页面，查找所有的菜品，分页呈现到呈现到前台
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllFoodByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m = request.getParameter("m");
		String n = request.getParameter("n");
		log.info("m:" + m + "n:" + n);
		List<Food> foods = foodService.findAllFoodByPage(Integer.parseInt(m), Integer.parseInt(n));
		int count = foodService.findAllFoodCount();
		int num = count / 6 + 1;
		request.setAttribute("num", num);
		request.setAttribute("foods", foods);
		log.info("num:" + num);
		for (Food food : foods) {
			log.info("分页菜品" + food.toString());
		}
		
		return "f:/app/menu.jsp";
		 
	}
	
	

}
