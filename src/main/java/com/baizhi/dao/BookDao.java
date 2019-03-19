package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookDao {
	/** 后台：查询所有图书
	 * @return
	 */
	public List<Book> selectAllBook();
	
	/**后台：添加图书
	 * @param book
	 */
	public void addBook(Book book);
	
	/** 后台：根据id查图书——更新时使用
	 * 	前台：查询图书详情
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
	public List<Book> selectBookByKey(@Param("key") String key, @Param("content") String content);
	/** 后台：根据二级分类查询旗下图书的数量——删除分类时使用
	 * @param id
	 * @return
	 */
	public Integer selectBookNumBySid(String id);
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
    /** 前台：根据所点击的分类查询图书——二级页面
     * @param fid
     * @param sid
     * @return
     */
    public List<Book> selectBook(@Param("fid") String fid, @Param("sid") String sid);
    /** 修改图书库存、销量——（创建订单后使用）
     * @param id
     * @param count
     */
    public void updateBookSaleAndStock(@Param("id") String id, @Param("count") Integer count);
 
}
