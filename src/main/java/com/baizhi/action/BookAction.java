package com.baizhi.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;


public class BookAction {
	private List<Book> list;
	private Book book;
	//在查一个的时候调用查询所有二级标签的方法
	private String id;
	private File cover;
	private String coverFileName;
    private String coverContentType;
    //模糊查询
    private String key;
    private String content;
    //前台一级页面
    private List<Category> seconds;
    private List<Category> firsts;
    private List<Book> recommends;
    private List<Book> sales;
    private List<Book> news;
    private List<Book> newBoards;
    //前台二级页面
    private String fid;
    private String sid;
    private Category category;


    
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getFirsts() {
		return firsts;
	}
	public void setFirsts(List<Category> firsts) {
		this.firsts = firsts;
	}
	public List<Book> getRecommends() {
		return recommends;
	}
	public void setRecommends(List<Book> recommends) {
		this.recommends = recommends;
	}
	public List<Book> getSales() {
		return sales;
	}
	public void setSales(List<Book> sales) {
		this.sales = sales;
	}
	public List<Book> getNews() {
		return news;
	}
	public void setNews(List<Book> news) {
		this.news = news;
	}
	public List<Book> getNewBoards() {
		return newBoards;
	}
	public void setNewBoards(List<Book> newBoards) {
		this.newBoards = newBoards;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Category> getSeconds() {
		return seconds;
	}
	public void setSeconds(List<Category> seconds) {
		this.seconds = seconds;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public File getCover() {
		return cover;
	}
	public void setCover(File cover) {
		this.cover = cover;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public String getCoverContentType() {
		return coverContentType;
	}
	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}

	//查询所有图书
	public String selectAllBook(){
	    BookService bookService = new BookServiceImpl();
	    this.list = bookService.selectAllBook();
	    return "success";
	}
	//添加图书
	public String addBook() throws IOException{
		System.out.println("cover:"+cover);
		if(cover == null || "".equals(cover)){
			File file1 = new File("D://Java//Web//apache-tomcat-6.0.44//webapps//dangdang_whz//back//img//default.jpg");
			cover=file1;
		}else{
		
		//获取文件输入流
		FileInputStream is = new FileInputStream(cover);		
		//根据文件相对路径获取绝对路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/back/img");		
		//获取文件输出流
		FileOutputStream os = new FileOutputStream(new File(realPath,coverFileName));
		//获取文件大小
		
		//文件拷贝   调用工具类			
		IOUtils.copy(is, os);
		//关流
		IOUtils.closeQuietly(is);
		IOUtils.closeQuietly(os);
		}
		//判断是否添加图片
		if(coverFileName == null || "".equals(coverFileName)){
			book.setCover("default.jpg");
		}else{
			book.setCover(coverFileName);
		}
		//调  添加业务
		BookService bookService = new BookServiceImpl();
		bookService.addBook(book);
		return "success";
	}


	
	//查一个
	public String selectBookById(){   
		//调查询所有二级标签的方法
		CategoryService cs = new CategoryServiceImpl();
		seconds = cs.selectAllSecondCategory();
		BookService bs = new BookServiceImpl();
	    this.book = bs.selectBookById(this.id);
	    return "success";
	}
	//更新图书
	public String updateBook(){
		BookService bookService = new BookServiceImpl();  
	    if (this.coverFileName == null) {
	      try{
	        bookService.updateBook(this.book);
	        return "success";
	      }catch (Exception e){
	        e.printStackTrace();
	        return "error";
	      }
	    }
	    String realPath = ServletActionContext.getServletContext().getRealPath("/back/img");
	    try{
	      FileUtils.copyFile(this.cover, new File(realPath, this.coverFileName));
	      this.book.setCover(this.coverFileName);
	      bookService.updateBook(this.book);
	      return "success";
	    }catch (IOException e){
	      e.printStackTrace();
	    }
	    return "error";
	  }
	//删除
	public String deleteBook(){
	    BookService bookService = new BookServiceImpl();
	    try{
	      bookService.deleteBook(this.id);
	      return "success";
	    }catch (Exception e){
	      e.printStackTrace();
	    }
	    return "error";
	  }
	//模糊查询
	public String selectBookByKey(){
	    BookService bookService = new BookServiceImpl();
	    this.list = bookService.selectBookByKey(key, content);
	    return "success";
	 }
	//前台一级页面
	public String main(){
	    CategoryService categoryService = new CategoryServiceImpl();
	    this.firsts = categoryService.selectAll();
	    BookService bookService = new BookServiceImpl();
	    this.recommends = bookService.selectRecommends();
	    this.sales = bookService.selectSales();
	    this.news = bookService.selectNews();
	    this.newBoards = bookService.selectNewBoards();
	    return "success";
	 }
	//前台二级页面
	 public String second(){
		 CategoryService categoryService = new CategoryServiceImpl();
		 BookService bookService = new BookServiceImpl();
		 this.category = categoryService.selectCategoryByFid(fid);
		 this.list = bookService.selectBook(fid, sid);
		 return "success";
	 }
	 //图书详情
	 public String selectOne(){
		 BookService bookService = new BookServiceImpl();
		 this.book = bookService.selectBookById(id);
		 return "success";	
	 }
	 
}
