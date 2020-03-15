package pl.betleja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.betleja.model.Car;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface CarRepositoryDataJpaImpl extends JpaRepository<Car, Long> {

    List<Car> getAllByBrand(String brand); // opcja 1
    List<Car> getAllByYearOfProductionBefore(LocalDate dateOfProductionParam); // opcja 2
    List<Car> getAllByBrandIsNotAndBrandIsNotAndBrandIsNotAndBrandIsNot(String brand1, String brand2, String brand3, String brand4); //opcja 3
    List<Car> getAllByBrandAndColor(String brand, String color); //opcja 4
    List<Car> getAllByBrandOrderByYearOfProductionDesc(String brand); //opcja 5
    List<Car> getAllByBrandAndColorIsNot(String brand, String color); //opcja 6
    List<Car> getAllByBrandAndModelAndColor(String brand, String model, String color); //opcja 7


}
