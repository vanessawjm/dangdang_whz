package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;

public class CategoryAction {
	private List<Category> list;
	private Category category;
	private String message;

	public List<Category> getList() {
		return list;
	}
	public void setList(List<Category> list) {
		this.list = list;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/** 后台：查询所有分类
	 * @return
	 */
	public String selectAllCategory(){
	    CategoryService cs = new CategoryServiceImpl();
	    this.list = cs.selectAllCategory();
	    return "success";	
	}
	/** 后台：添加分类
	 * @return
	 */
	public String addCategory(){
	    CategoryService cs = new CategoryServiceImpl();
	    try{
	      cs.addCategory(category);
	      return "success";
	    }catch (Exception e){
    	  this.message = e.getMessage();
    	  return "error";
	    }
	   
    }
	/** 后台：查询所有一级类别——添加二级标签时使用
	 * @return
	 */
	public String selectAllFirstCategory(){
	    CategoryService categoryService = new CategoryServiceImpl();
	    this.list = categoryService.selectAllFirstCategory();
	    return "success";
	}
	
	/** 后台：查询所有二级类别——添加图书时使用：跳转到添加图书页面
	 * @return
	 */
	public String selectAllSecondCategory(){
	    CategoryService categoryService = new CategoryServiceImpl();
	    this.list = categoryService.selectAllSecondCategory();
	    return "success";
	}
	
	/** 后台：删除某一分类
	 * @return
	 */
	public String deleteCategoryById(){
	    CategoryService categoryService = new CategoryServiceImpl();
	    try{
	      categoryService.deleteCategoryById(this.category);
	      return "success";
	    }catch (Exception e){
	      this.message = e.getMessage();
	      return "error";
	    }
	  }
	
}
