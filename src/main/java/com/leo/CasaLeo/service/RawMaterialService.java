package com.leo.CasaLeo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.CasaLeo.dto.RawMaterialsDto;
import com.leo.CasaLeo.enums.Measures;
import com.leo.CasaLeo.enums.RawMaterialsCategory;
import com.leo.CasaLeo.model.RawMaterials;
import com.leo.CasaLeo.repository.RawMaterialRepo;

@Service
public class RawMaterialService {
	@Autowired
	private RawMaterialRepo repository ;
	
	
	public RawMaterialsDto addRawMaterial(String name, RawMaterialsCategory category, double quantity, Measures unit) {
	    // Creazione del modello e popolamento con i dati ricevuti
	    RawMaterials model = new RawMaterials();
	    model.setName(name);
	    model.setCategory(category);
	    model.setQuantity(quantity);
	    model.setUnit(unit);

	    // Salvataggio nel database
	    RawMaterials saved = repository.save(model);

	    // Creazione del DTO con i dati effettivamente salvati
	    return new RawMaterialsDto(saved.getName(), saved.getCategory(), saved.getQuantity(), saved.getUnit());
	}


	
	}
	
	
	


