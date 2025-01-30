package repository;


import model.RawMaterials;
import model.RawMaterials.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialRepo extends JpaRepository<RawMaterials, Long> {
	
	List<RawMaterials> findByCategory();
}
