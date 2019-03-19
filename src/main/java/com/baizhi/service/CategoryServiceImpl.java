package com.baizhi.service;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.util.MybatisUtils;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> selectAllCategory() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
	    List<Category> list = dao.selectAllCategory();
	    MybatisUtils.close();
	    return list;
	}

	@Override
	public void addCategory(Category category){
	    SqlSession sqlSession = MybatisUtils.getSqlSession();
	    CategoryDao dao = (CategoryDao)sqlSession.getMapper(CategoryDao.class);
	    category.setId(UUID.randomUUID().toString());
	    try{
	      dao.addCategory(category);
	      MybatisUtils.commit();
	    }catch (Exception e){
	      MybatisUtils.rollback();
	      throw new RuntimeException("添加失败");
	    }
	 }

	@Override
	public List<Category> selectAllFirstCategory() {
		 SqlSession sqlSession = MybatisUtils.getSqlSession();
	     CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
	     List<Category> list = categoryDao.selectAllFirstCategory();
	     MybatisUtils.close();
	     return list;
	}

	@Override
	public List<Category> selectAllSecondCategory() {
		 SqlSession sqlSession = MybatisUtils.getSqlSession();
	     CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
	     List<Category> list = categoryDao.selectAllSecondCategory();
	     MybatisUtils.close();
	     return list;
	}

	@Override
	public void deleteCategoryById(Category category) {
		try {
			if(category.getLevels().equals("1")){//该分类是一级分类
				SqlSession sqlSession = MybatisUtils.getSqlSession();
			    CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
				//1.判断该一级分类下是否有二级分类
				List<Category> list = categoryDao.selectAllSecondCategoryByFid(category.getId());
				if(list == null || list.size() == 0){
					categoryDao.deleteCategoryById(category.getId());
				}else{
					//不删除
					throw new RuntimeException("该一级分类无法删除");
				}
			}else{//该分类是二级分类
				SqlSession sqlSession = MybatisUtils.getSqlSession();
			    CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
			    BookDao bookDao = sqlSession.getMapper(BookDao.class);
				//1.判断该二级分类下是否有图书（调用“根据二级类别查询图书的数量方法”）
			    Integer count = bookDao.selectBookNumBySid(category.getId());	   
				if(count == 0){
					categoryDao.deleteCategoryById(category.getId());
				}else{
					throw new RuntimeException("该二级分类无法删除");
				}
			}
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
			e.printStackTrace();
		}	
	}

	@Override
	public List<Category> selectAll() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
		List<Category> list = categoryDao.selectAll();
		MybatisUtils.close();
		return list;
	}

	@Override
	public Category selectCategoryByFid(String fid) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
		Category category =  categoryDao.selectCategoryByFid(fid);
		MybatisUtils.close();
		return category;
		
	}

	
}
