package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
	private String id;
	  private String name;
	  private String author;
	  private String cover;
	  private String press;
	  private Date pressDate;
	  private String edition;
	  private Date printDate;
	  private String impression;
	  private String isbn;
	  private Integer wordNum;
	  private Integer pageNum;
	  private String sizes;
	  private String paper;
	  private String pack;
	  private Double price;
	  private Double dprice;
	  private Date createDate;
	  private String editorRecommend;
	  private String contentAbstract;
	  private String authorAbstract;
	  private String director;
	  private String mediaCommentary;
	  private String categoryId;
	  private Integer sale;
	  private Integer stock;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPressDate() {
		return pressDate;
	}
	public void setPressDate(Date pressDate) {
		this.pressDate = pressDate;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPrintDate() {
		return printDate;
	}
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getWordNum() {
		return wordNum;
	}
	public void setWordNum(Integer wordNum) {
		this.wordNum = wordNum;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getEditorRecommend() {
		return editorRecommend;
	}
	public void setEditorRecommend(String editorRecommend) {
		this.editorRecommend = editorRecommend;
	}
	public String getContentAbstract() {
		return contentAbstract;
	}
	public void setContentAbstract(String contentAbstract) {
		this.contentAbstract = contentAbstract;
	}
	public String getAuthorAbstract() {
		return authorAbstract;
	}
	public void setAuthorAbstract(String authorAbstract) {
		this.authorAbstract = authorAbstract;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMediaCommentary() {
		return mediaCommentary;
	}
	public void setMediaCommentary(String mediaCommentary) {
		this.mediaCommentary = mediaCommentary;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Book(String id, String name, String author, String cover,
			String press, Date pressDate, String edition, Date printDate,
			String impression, String isbn, Integer wordNum, Integer pageNum,
			String sizes, String paper, String pack, Double price,
			Double dprice, Date createDate, String editorRecommend,
			String contentAbstract, String authorAbstract, String director,
			String mediaCommentary, String categoryId, Integer sale,
			Integer stock) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.pressDate = pressDate;
		this.edition = edition;
		this.printDate = printDate;
		this.impression = impression;
		this.isbn = isbn;
		this.wordNum = wordNum;
		this.pageNum = pageNum;
		this.sizes = sizes;
		this.paper = paper;
		this.pack = pack;
		this.price = price;
		this.dprice = dprice;
		this.createDate = createDate;
		this.editorRecommend = editorRecommend;
		this.contentAbstract = contentAbstract;
		this.authorAbstract = authorAbstract;
		this.director = director;
		this.mediaCommentary = mediaCommentary;
		this.categoryId = categoryId;
		this.sale = sale;
		this.stock = stock;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", cover=" + cover + ", press=" + press + ", pressDate="
				+ pressDate + ", edition=" + edition + ", printDate="
				+ printDate + ", impression=" + impression + ", isbn=" + isbn
				+ ", wordNum=" + wordNum + ", pageNum=" + pageNum + ", sizes="
				+ sizes + ", paper=" + paper + ", pack=" + pack + ", price="
				+ price + ", dprice=" + dprice + ", createDate=" + createDate
				+ ", editorRecommend=" + editorRecommend + ", contentAbstract="
				+ contentAbstract + ", authorAbstract=" + authorAbstract
				+ ", director=" + director + ", mediaCommentary="
				+ mediaCommentary + ", categoryId=" + categoryId + ", sale="
				+ sale + ", stock=" + stock + "]";
	}
	 
}
