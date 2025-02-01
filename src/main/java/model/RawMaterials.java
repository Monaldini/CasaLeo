package model;

import enums.Measures;
import enums.RawMaterialsCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "raw_materials")
public class RawMaterials {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_RawMaterial;
	
	@Column(nullable = false, unique = true)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Measures unit;
	
	public RawMaterials() {}
	
	@Column
	private double quantity;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RawMaterialsCategory category;

	public RawMaterials(String name, double quantity, Measures unit, RawMaterialsCategory category) {
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.category = category;
	}

	public long getId_RawMaterial() {
		return id_RawMaterial;
	}

	public void setId(long id) {
		this.id_RawMaterial = id;
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

}
