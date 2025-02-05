package com.leo.CasaLeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.CasaLeo.model.Dishes;

public interface DishesRepo extends JpaRepository<Dishes, Long>{
	

}
