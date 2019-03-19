package com.baizhi.entity;

import java.util.List;

public class Category {
	private String id;
	private String name;
	private String parent_id;
	private String levels;
	private Category first;
	private List<Category> seconds;
	
	
	public List<Category> getSeconds() {
		return seconds;
	}
	public void setSeconds(List<Category> seconds) {
		this.seconds = seconds;
	}
	public Category getFirst() {
		return first;
	}
	public void setFirst(Category first) {
		this.first = first;
	}
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
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String id, String name, String parent_id, String levels,
			Category first, List<Category> seconds) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.levels = levels;
		this.first = first;
		this.seconds = seconds;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parent_id="
				+ parent_id + ", levels=" + levels + ", first=" + first
				+ ", seconds=" + seconds + "]";
	}	
}
