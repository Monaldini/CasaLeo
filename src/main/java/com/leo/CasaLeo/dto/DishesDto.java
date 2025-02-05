package com.leo.CasaLeo.dto;

import com.leo.CasaLeo.enums.DishCategory;

public class DishesDto {
	private long id_dish;
	private String name_dish;
	private DishCategory category;
	private String description;
	public long getId_dish() {
		return id_dish;
	}
	public void setId_dish(long id_dish) {
		this.id_dish = id_dish;
	}
	public String getName_dish() {
		return name_dish;
	}
	public void setName_dish(String name_dish) {
		this.name_dish = name_dish;
	}
	public DishCategory getCategory() {
		return category;
	}
	public void setCategory(DishCategory category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
