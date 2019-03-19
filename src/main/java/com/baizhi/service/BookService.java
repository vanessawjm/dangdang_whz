package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;

public interface BookService {
	/** 后台：查询所有图书
	 * @return
	 */
	public List<Book> selectAllBook();
	/**后台：添加图书
	 * @param book
	 */
	public void addBook(Book book);
	/** 后台：根据id查图书——更新时使用
	 * @param id
	 * @return
	 */
	public Book selectBookById(String id);
	/** 后台：更新图书
	 * @param book
	 */
	public void updateBook(Book book);
	/** 后台：删除图书
	 * @param id
	 */
	public void deleteBook(String id);
	/** 后台：模糊查询
	 * @param key   第一个参数为模糊查询的条件
	 * @param content 第二个参数为模糊查询的内容
	 * @return
	 */
	public List<Book> selectBookByKey(String key, String content);
	/** 后台：根据二级分类查询旗下图书的数量——删除分类时使用
	 * @param id
	 * @return
	 */
	public Integer selectBookNumBySid(String id);
	/** 前台：编辑推荐
	 * @return
	 */
	public List<Book> selectRecommends();
	/** 前台：热销图书
	 * @return
	 */
	public List<Book> selectSales();
	/** 前台：最新上架
	 * @return
	 */
	public List<Book> selectNews();
	/** 前台：新书热卖
	 * @return
	 */
	public List<Book> selectNewBoards();
	/** 前台：根据所点击的类别查找图书
	 * @param fid
	 * @param sid
	 * @return
	 */
	public List<Book> selectBook(String fid, String sid);
}
