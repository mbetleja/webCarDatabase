package pl.altkom.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.altkom.model.Car;
import java.util.List;

@Repository
public class CarRepositoryJdbcImpl implements CarRepository {

    @Autowired
    private JdbcTemplate jdbc;
    public static String tableName = "carDatabase";

    @Override
    public void addCar(Car car) {
        jdbc.update("INSERT INTO " + tableName + "(brand, model, colour, yearOfProduction, vin) VALUES (?,?,?,?,?)",
                car.getBrand(),
                car.getModel(),
                car.getColour(),
                car.getYearOfProduction(),
                car.getVin());

    }
    @Override
    public List<Car> showAll(){
        return jdbc.query("select * from " + tableName + "", new BeanPropertyRowMapper<>(Car.class));
            }

    @Override
    public void deleteCar(int id) {
        final String DELETE_CAR =String.format("DELETE FROM " + tableName + " WHERE id=%d", id);
        jdbc.update(DELETE_CAR);

    }

    @Override
    public void editCar(Car newCar) {
        jdbc.update("update " + tableName + " set brand = ?, model = ?, colour = ?, yearOfProduction = ?, vin = ? where id =?",
                newCar.getBrand(),
                newCar.getModel(),
                newCar.getColour(),
                newCar.getYearOfProduction(),
                newCar.getVin(),
                newCar.getId());
        return;
    }


}
