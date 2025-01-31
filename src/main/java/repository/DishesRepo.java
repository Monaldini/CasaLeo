package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Dishes;

public interface DishesRepo extends JpaRepository<Dishes, Long>{
	

}
