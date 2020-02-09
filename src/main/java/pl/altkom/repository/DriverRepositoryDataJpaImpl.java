package pl.altkom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.altkom.model.Driver;

@Repository
public interface DriverRepositoryDataJpaImpl extends JpaRepository<Driver, Long> {


}
