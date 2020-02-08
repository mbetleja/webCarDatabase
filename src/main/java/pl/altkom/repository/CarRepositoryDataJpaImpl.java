package pl.altkom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.altkom.model.Car;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface CarRepositoryDataJpaImpl extends JpaRepository<Car, Long> {

    List<Car> getAllByBrand(String brand); // opcja 1
    List<Car> getAllByYearOfProductionBefore(LocalDate dateOfProductionParam); // opcja 2
    List<Car> getAllByBrandIsNotAndBrandIsNotAndBrandIsNotAndBrandIsNot(String brand1, String brand2, String brand3, String brand4); //opcja 3
    List<Car> getAllByBrandAndColour(String brand, String colour); //opcja 4
    List<Car> getAllByBrandOrderByYearOfProductionDesc(String brand); //opcja 5
    List<Car> getAllByBrandAndColourIsNot(String brand, String colour); //opcja 6
    List<Car> getAllByBrandAndModelAndColour(String brand, String model, String colour); //opcja 7


}
