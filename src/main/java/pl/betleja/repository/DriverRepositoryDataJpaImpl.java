package pl.betleja.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.betleja.model.Driver;

@Repository
public interface DriverRepositoryDataJpaImpl extends JpaRepository<Driver, Long> {


}
