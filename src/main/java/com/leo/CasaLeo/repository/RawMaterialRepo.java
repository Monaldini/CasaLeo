package com.leo.CasaLeo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.CasaLeo.model.RawMaterials;

@Repository
public interface RawMaterialRepo extends JpaRepository<RawMaterials, Long> {
	
	
	 Optional<RawMaterials>  findByName(String name);
   
}
