package com.baizhi.dao;

import com.baizhi.entity.Category;
import java.util.List;

public interface CategoryDao{
	
	/** 后台：展示所有分类
	 * @return
	 */
	public List<Category> selectAllCategory();
	/** 后台：添加分类
	 * @param category
	 */
	public void addCategory(Category category);
	/** 后台：根据id删除某一分类
	 * @param id
	 */
	public void deleteCategoryById(String id);
	/** 后台：查询所有一级类别——添加二级类别时使用
	 * @return
	 */
	public List<Category> selectAllFirstCategory();	
	/** 后台：查询所有二级类别——添加图书时使用
	 * @return
	 */
	public List<Category> selectAllSecondCategory();
	/** 后台: 查询某个一级分类下的所有二级分类——删除分类时使用
	 * @return
	 */
	public List<Category> selectAllSecondCategoryByFid(String id);
	
	/** 前台：查询所有的分类 用来在category.jsp中展示
	 * @return
	 */
	public List<Category> selectAll();
	/** 前台：通过一级分类查询旗下所有的二级分类——二级页面使用
	 * @return
	 */
	public Category selectCategoryByFid(String fid);
	
	
	
	
}
