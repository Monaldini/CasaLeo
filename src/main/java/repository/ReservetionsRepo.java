package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Reservations;

public interface ReservetionsRepo extends JpaRepository<Reservations, Integer> {

}
