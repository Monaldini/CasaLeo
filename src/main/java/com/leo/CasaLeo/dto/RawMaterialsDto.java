package com.leo.CasaLeo.dto;

import com.leo.CasaLeo.enums.Measures;
import com.leo.CasaLeo.enums.RawMaterialsCategory;

public class RawMaterialsDto {
	private long id_RawMaterial;
	private String name;
	private Measures unit;
	private double quantity;
	private RawMaterialsCategory category;
	public long getId_RawMaterial() {
		return id_RawMaterial;
	}
	public void setId_RawMaterial(long id_RawMaterial) {
		this.id_RawMaterial = id_RawMaterial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Measures getUnit() {
		return unit;
	}
	public void setUnit(Measures unit) {
		this.unit = unit;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public RawMaterialsCategory getCategory() {
		return category;
	}
	public void setCategory(RawMaterialsCategory category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "RawMaterialsDto [name=" + name + ", unit=" + unit + ", quantity=" + quantity + ", category=" + category
				+ "]";
	}
	
	public RawMaterialsDto(String name,RawMaterialsCategory category , double quantity, Measures unit) {
		super();
		this.name = name;
		this.unit = unit;
		this.quantity = quantity;
		this.category = category;
	}
	
	

}
