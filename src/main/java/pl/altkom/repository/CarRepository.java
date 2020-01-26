package pl.altkom.repository;

import pl.altkom.model.Car;

import java.util.List;

public interface CarRepository {

    void addCar(Car car);

    void editCar(Car car);

    void deleteCar(int car);

    List<Car> showAll();
}
