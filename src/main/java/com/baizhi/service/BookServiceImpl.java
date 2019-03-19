package com.baizhi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.util.MybatisUtils;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> selectAllBook() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao bookDao = sqlSession.getMapper(BookDao.class);
		List<Book> list = bookDao.selectAllBook();
		MybatisUtils.close();
		return list;
	}

	@Override
	public void addBook(Book book) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    book.setId(UUID.randomUUID().toString());
	    book.setCreateDate(new Date());
	    book.setSale(0);
	    try{
	      bookDao.addBook(book);
	      MybatisUtils.commit();
	    }catch (Exception e){
	      MybatisUtils.rollback();
	      e.printStackTrace();
	    }
	}

	@Override
	public void updateBook(Book book) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    try{
	      bookDao.updateBook(book);
	      MybatisUtils.commit();
	    }catch (Exception e){
	      MybatisUtils.rollback();
	      e.printStackTrace();
	    }

	}

	@Override
	public void deleteBook(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    try{
	      bookDao.deleteBook(id);
	      MybatisUtils.commit();
	    }catch (Exception e){
	      MybatisUtils.rollback();
	      e.printStackTrace();
	    }
	}

	@Override
	public Book selectBookById(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao bookDao = sqlSession.getMapper(BookDao.class);
		Book book = bookDao.selectBookById(id);
		MybatisUtils.close();
		return book;
	}

	@Override
	public List<Book> selectBookByKey(String key, String content) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao bookDao = sqlSession.getMapper(BookDao.class);
		List<Book> list = bookDao.selectBookByKey(key, content);
		MybatisUtils.close();
		return list;
	}

	@Override
	public Integer selectBookNumBySid(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao bookDao = sqlSession.getMapper(BookDao.class);
		Integer count = bookDao.selectBookNumBySid(id);
		MybatisUtils.close();
		return count;
	}

	public List<Book> selectRecommends(){
	    SqlSession sqlSession = MybatisUtils.getSqlSession();
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    List<Book> list = bookDao.selectAllBook();
	    MybatisUtils.close();
	    
	    Integer a = Integer.valueOf(new Random().nextInt(list.size()));
	    Integer b = Integer.valueOf(new Random().nextInt(list.size()));
	    while (b == a) {
	      b = Integer.valueOf(new Random().nextInt(list.size()));
	    }
	    List<Book> books = new ArrayList();
	    books.add((Book)list.get(a.intValue()));
	    books.add((Book)list.get(b.intValue()));
	    return books;
	  }
	  
	  public List<Book> selectSales(){
	    SqlSession sqlSession = MybatisUtils.getSqlSession();
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    List<Book> list = bookDao.selectSales();
	    MybatisUtils.close();
	    return list;
	  }
	  
	  public List<Book> selectNews(){
	    SqlSession sqlSession = MybatisUtils.getSqlSession();
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    List<Book> list = bookDao.selectNews();
	    MybatisUtils.close();
	    return list;
	  }
	  
	  public List<Book> selectNewBoards(){
	    SqlSession sqlSession = MybatisUtils.getSqlSession();
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    List<Book> list = bookDao.selectNewBoards();
	    MybatisUtils.close();
	    return list;
	  }

	@Override
	public List<Book> selectBook(String fid, String sid) {
	 	SqlSession sqlSession = MybatisUtils.getSqlSession();
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    List<Book> list = bookDao.selectBook(fid, sid);
	    return list;
	 }

}
