package model;

import enums.DishCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dishes")
public class Dishes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_dish;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private double price;
	@Enumerated(EnumType.STRING)
	private DishCategory category;
	@Column(columnDefinition = "TEXT")
	private String description;
	
	public Dishes() {}

	public Dishes( String name, double price, DishCategory category, String description) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}

	

	public long getId_dish() {
		return id_dish;
	}

	public void setId_dish(long id_dish) {
		this.id_dish = id_dish;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DishCategory getCategory() {
		return category;
	}

	public void setCategory(DishCategory category) {
		this.category = category;
	}


	
	
	

}
