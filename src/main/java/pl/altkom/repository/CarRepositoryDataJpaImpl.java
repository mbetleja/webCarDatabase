package pl.altkom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.altkom.model.Car;


@Repository
public interface CarRepositoryDataJpaImpl extends JpaRepository<Car, Long> {

}
