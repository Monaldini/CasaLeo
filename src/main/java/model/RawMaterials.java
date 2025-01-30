package model;



import java.util.Locale.Category;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "raw_material")
public class RawMaterials {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;


@Column(nullable = false)
private String name;

@Column
private double quantity;

@Enumerated(EnumType.STRING)
@Column(nullable = false)
private Category category;

public RawMaterials() {}



public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getQuantity() {
	return quantity;
}

public void setQuantity(double quantity) {
	this.quantity = quantity;
}



public RawMaterials( String name, double quantity, Category category) {
	super();
	this.id = id;
	this.name = name;
	this.quantity = quantity;
	this.category = category;
}



}


