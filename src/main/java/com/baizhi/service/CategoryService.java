package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Category;

public interface CategoryService {
	/** 后台:查询所有分类
	 * @return
	 */
	public List<Category> selectAllCategory();
	/** 后台：添加分类
	 * @param category
	 */
	public void addCategory(Category category);
	/** 后台：删除某一分类
	 * 	删除时需要先判断该分类为一级分类或者为二级分类 如果是一级分类 则查询该一级分类下是否有二级分类
	 * 	如果删除的分类为二级分类，则直接根据该二级分类的id判断有没有对应的图书 没有图书时可以删除，否则不能删除
	 * @param category
	 */
	public void deleteCategoryById(Category category);
	 /** 后台：查询所有一级类别
	 * @return
	 */
	public List<Category> selectAllFirstCategory();	
	/** 后台：查询所有二级类别——添加图书时使用
	 * @return
	 */
	public List<Category> selectAllSecondCategory();
	/** 前台：查询所有的一级分类
	 * @return
	 */
	public List<Category> selectAll();
	/** 前台：通过一级分类查询旗下所有的二级分类——二级页面使用
	 * @return
	 */
	public Category selectCategoryByFid(String fid);
}
